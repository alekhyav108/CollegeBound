package com.example.collegebound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText)findViewById(R.id.emailText);
        password = (EditText)findViewById(R.id.passwordText);
        login = (Button)findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                System.out.println("working");
                validate(email.getText().toString(), password.getText().toString());
            }
        });

    }
    private void validate(String userName, String userPassword) {
        if ( (userName.equals("Admin")) && (userPassword.equals("1234")) ) {
            Intent intent = new Intent(login.this, SecondActivity.class);
            startActivity(intent);
        }
    }

}
