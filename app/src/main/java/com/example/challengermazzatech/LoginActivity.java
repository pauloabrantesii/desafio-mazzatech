package com.example.challengermazzatech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText emailText = findViewById(R.id.TextTextEmailAddress);
        EditText passwordText = findViewById(R.id.TextPassword);
        Button loginButton = findViewById(R.id.buttonAcessar);


        loginButton.setEnabled(false);


        emailText.addTextChangedListener(textWatcher);
        passwordText.addTextChangedListener(textWatcher);

        Context context = this;

        TextView button = findViewById(R.id.textViewN);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SignUpActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailText.getText().toString();
                String password = passwordText.getText().toString();

                Log.d("LoginActivity", email);
                Log.d("LoginActivity", password);

                UserDAO dao = new UserDAO(LoginActivity.this);
                boolean login = dao.checkUserLogged(email, password);
                if (
                        login
                ){
                    Intent intent = new Intent(context, HomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "email ou senha inválido", Toast.LENGTH_SHORT).show();
                };
            }
        });
    }
    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            EditText emailText = findViewById(R.id.TextTextEmailAddress);
            EditText passwordText = findViewById(R.id.TextPassword);
            Button loginButton = findViewById(R.id.buttonAcessar);


            String email = emailText.getText().toString().trim();
            String password = passwordText.getText().toString().trim();


            loginButton.setEnabled(!email.isEmpty() && !password.isEmpty());
        }
    };
}
