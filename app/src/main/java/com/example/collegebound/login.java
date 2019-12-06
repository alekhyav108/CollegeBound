package com.example.collegebound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class login extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;
    private TextView incorrect1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        incorrect1 = (TextView) findViewById(R.id.incorrect);

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
            //incorrect1.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(login.this, SecondActivity.class);
            startActivity(intent);
        } else {


            incorrect1.setVisibility(View.VISIBLE);
        }
    }

}
