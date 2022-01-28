package com.example.city;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    ImageView image;
    TextInputEditText userName,password;
    Button login;
    TextView userNameError,passwordError;
    String userNameString, passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        userNameError = findViewById(R.id.userNameError);
        passwordError = findViewById(R.id.passwordError);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        image = findViewById(R.id.login_back_btn);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login.super.onBackPressed();
            }
        });



        getTextFromField();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateUserName() || !validatePassword()){
                    return ;


                }
                else {
                    Toast.makeText(getApplicationContext(), "login clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    private boolean validatePassword() {
        if (password.getText().toString().equals("")){
            passwordError.setVisibility(View.VISIBLE);
            return false;
        }
        else {
            passwordError.setVisibility(View.INVISIBLE);
            return true;
        }
    }

    private boolean validateUserName() {
        if (userName.getText().toString().equals("")){
            userNameError.setVisibility(View.VISIBLE);
            return false;
        }
        else {
            userNameError.setVisibility(View.INVISIBLE);
            return true;
        }

    }

    private void getTextFromField() {
        userNameString = userName.getText().toString();
        passwordString =  password.getText().toString();
    }
}