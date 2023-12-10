package com.example.challengermazzatech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

        EditText emailText = (EditText) findViewById(R.id.TextTextEmailAddress);

        EditText passwordText = (EditText) findViewById(R.id.TextPassword);

        Button loginButton = (Button) findViewById(R.id.buttonAcessar);




        Context context = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SignUpActivity.class );
                startActivity(intent);
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailText.getText().toString();
                String password = passwordText.getText().toString();

                Log.d("LoginActivity",email);

                Log.d("LoginActivity",password);

                Intent intent = new Intent(context, HomeActivity.class);
                startActivity(intent);
            }
        });

    }


}