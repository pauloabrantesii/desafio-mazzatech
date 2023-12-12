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

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView button = findViewById(R.id.textViewN);
        TextView forgotButton = findViewById(R.id.textForgot);
        EditText emailText = findViewById(R.id.TextTextEmailAddress);
        EditText passwordText = findViewById(R.id.TextPassword);
        Button loginButton = findViewById(R.id.buttonAcessar);

        loginButton.setEnabled(false);


        emailText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkFieldsForEmptyValues(emailText, passwordText, loginButton);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        passwordText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkFieldsForEmptyValues(emailText, passwordText, loginButton);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        Context context = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SignUpActivity.class);
                startActivity(intent);
            }
        });

        forgotButton.setOnClickListener(new View.OnClickListener() {
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

                Intent intent = new Intent(context, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void checkFieldsForEmptyValues(EditText emailText, EditText passwordText, Button loginButton) {
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();


        if (!email.isEmpty() && !password.isEmpty()) {
            loginButton.setEnabled(true);
        } else {
            loginButton.setEnabled(false);
        }
    }
}
