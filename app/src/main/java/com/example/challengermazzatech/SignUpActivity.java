package com.example.challengermazzatech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.santalu.maskara.widget.MaskEditText;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
public class SignUpActivity extends AppCompatActivity {
    UserDAO dao;

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageButton imageButton;
    private boolean isImageSelected = false;
    private List<EditText> editTextList;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText nomeEditText = findViewById(R.id.TextNome);
        ImageButton imageButtonUser = findViewById(R.id.imageButton);
        EditText usernameEditText = findViewById(R.id.editTextUsername);
        EditText emailEditText = findViewById(R.id.editTextEmail);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        EditText addressText = findViewById(R.id.Address);
        MaskEditText cpfEditText = findViewById(R.id.CPF);
        cpfEditText.setHint("Digite seu CPF");
        EditText dataEditText = findViewById(R.id.DATA);
        EditText sexoEditText = findViewById(R.id.Sexo);
        signupButton = findViewById(R.id.signupButton);
        ImageView goBackButton = findViewById(R.id.goback);

        signupButton.setEnabled(false);

        editTextList = new ArrayList<>();
        editTextList.add(nomeEditText);
        editTextList.add(usernameEditText);
        editTextList.add(emailEditText);
        editTextList.add(passwordEditText);
        editTextList.add(addressText);
        editTextList.add(cpfEditText);
        editTextList.add(dataEditText);
        editTextList.add(sexoEditText);


        imageButton = findViewById(R.id.imageButton);


        imageButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, PICK_IMAGE_REQUEST);
        });

        dao = new UserDAO(this
        );

        goBackButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                onDestroy();
                return false;
            }
        });



        for (EditText editText : editTextList) {
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    checkFieldsForEmptyValues(editTextList, signupButton);
                }

                @Override
                public void afterTextChanged(Editable editable) {}
            });
        }

        nomeEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 30) {
                    signupButton.setEnabled(true);
                    nomeEditText.setError(null);
                } else {
                    signupButton.setEnabled(false);
                    nomeEditText.setError("O nome deve ter mais de 30 caracteres");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (isValidEmail(s.toString())) {
                    signupButton.setEnabled(true);
                    emailEditText.setError(null);
                } else {
                    signupButton.setEnabled(false);
                    emailEditText.setError("Email inválido");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (isValidPassword(s.toString())) {
                    signupButton.setEnabled(true);
                    passwordEditText.setError(null);
                } else {
                    signupButton.setEnabled(false);
                    passwordEditText.setError(" Senha deve conter pelo menos 8 caracteres, pelo menos um número e uma letra maiúscula. ");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        dataEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 10 && s.toString().matches("\\d{2}/\\d{2}/\\d{4}")) {
                    String[] parts = s.toString().split("/");
                    int dia = Integer.parseInt(parts[0]);
                    int mes = Integer.parseInt(parts[1]);
                    int ano = Integer.parseInt(parts[2]);

                    Calendar cal = Calendar.getInstance();
                    int anoAtual = cal.get(Calendar.YEAR);
                    int mesAtual = cal.get(Calendar.MONTH) + 1;

                    int idade = anoAtual - ano;
                    if (mes < mesAtual || (mes == mesAtual && dia <= cal.get(Calendar.DAY_OF_MONTH))) {
                        idade--;
                    }

                    if (idade < 18) {
                        Toast.makeText(SignUpActivity.this, "É necessário ter mais de 18 anos para se cadastrar.", Toast.LENGTH_SHORT).show();
                        signupButton.setEnabled(false);
                    } else {
                        signupButton.setEnabled(true);
                    }
                } else {
                    signupButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });




        signupButton.setOnClickListener(v -> {
            String dataNascimento = dataEditText.getText().toString();
            if (!dataNascimento.isEmpty()) {
                String[] parts = dataNascimento.split("/");
                int dia = Integer.parseInt(parts[0]);
                int mes = Integer.parseInt(parts[1]);
                int ano = Integer.parseInt(parts[2]);

                Calendar cal = Calendar.getInstance();
                int anoAtual = cal.get(Calendar.YEAR);

                int idade = anoAtual - ano;

                if (idade < 18) {
                    Toast.makeText(SignUpActivity.this, "É necessário ter mais de 18 anos para se cadastrar.", Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User(
                            nomeEditText.getText().toString(),
                            emailEditText.getText().toString(),
                            passwordEditText.getText().toString(),
                            usernameEditText.getText().toString(),
                            addressText.getText().toString(),
                            dataNascimento, sexoEditText.getText().toString(),
                            "",
                            cpfEditText.getText().toString(),
                            false,
                            ""
                    );
                    registerUser(user);
                }
            } else {
                Toast.makeText(SignUpActivity.this, "Por favor, insira sua data de nascimento.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void registerUser(User user) {
        long result = dao.registerUser(this, user);
        int alreadyRegistered = -1;

        if (result != alreadyRegistered) {
            ApiService apiService = HttpClient.service();
            Call<ResponseBody> call = apiService.registerUserRequest(user);
            call.enqueue(new retrofit2.Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    Log.i("Paulo:", "MSG: " + response.body());
                    if (response.isSuccessful()) {
                        Log.i("STATUS", "MSG: " + response);
                        System.out.println("MSG: " + response.body());
                        Log.i("STATUSBB", "MSG: " + response.body());
                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(SignUpActivity.this, "Usuário cadastrado", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignUpActivity.this, "Erro ao cadastrar usuário na API:" + response.body(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                }
            });

        } else {
            Toast.makeText(SignUpActivity.this, "Erro ao cadastrar usuário", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri selectedImage = data.getData();
            imageButton.setImageURI(selectedImage);
            isImageSelected = true;
            if (checkFieldsForEmptyValues(editTextList, signupButton) && isImageSelected) {
                signupButton.setEnabled(true);
            }
        }
    }

    private boolean checkFieldsForEmptyValues(List<EditText> editTextList, Button signupButton) {
        boolean allFieldsFilled = true;

        for (EditText editText : editTextList) {
            if (editText.getText().toString().trim().isEmpty()) {
                allFieldsFilled = false;
                break;
            }
        }

        if (allFieldsFilled && isImageSelected) {
            signupButton.setEnabled(true);
        } else {
            signupButton.setEnabled(false);
        }

        return allFieldsFilled;
    }

    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}