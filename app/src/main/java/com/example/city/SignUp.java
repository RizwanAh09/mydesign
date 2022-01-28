package com.example.city;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class SignUp extends AppCompatActivity {
    ImageView imageView;
    Button next;
    TextInputEditText fullName, userName,email,phoneNumber,enterPassword;
    String fullNameString,userNameString,emailString,phoneNumberString,enterPasswordString;
    TextView fullNameError,userErrorText,emailError,phoneNumberError,passError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        imageView = findViewById(R.id.back_signUp2nd);
        next = findViewById(R.id.nextbtn);
        fullNameError = findViewById(R.id.fullNameError);
        userErrorText = findViewById(R.id.userErrorText);
        emailError = findViewById(R.id.emailError);
        phoneNumberError = findViewById(R.id.phoneNumberError);
        passError = findViewById(R.id.passError);
        fullName  = findViewById(R.id.fullName);
        userName  = findViewById(R.id.userName);
        email  = findViewById(R.id.email);
        phoneNumber  = findViewById(R.id.phoneNumber);
        enterPassword  = findViewById(R.id.enterPassword);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp.super.onBackPressed();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignUP2ndActivity.class);
                startActivity(intent);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateName() || !validateUserName() || !validatePhoneNumber() || !validatePassword()){
                    return;
                }
                else {
                    Intent intent = new Intent(getApplicationContext(),SignUP2ndActivity.class);
                    startActivity(intent);
                }
            }
        });

       getTextFromField();

    }

    private boolean validatePassword() {
        if (enterPassword.getText().toString().equals("")){
            passError.setVisibility(View.VISIBLE);
            return false;
        }
        else {
            passError.setVisibility(View.GONE);
            return true;
        }
    }

    private boolean validatePhoneNumber() {
        if (phoneNumber.getText().toString().equals("")){
            phoneNumberError.setVisibility(View.VISIBLE);
            return false;
        }
        else phoneNumberError.setVisibility(View.GONE);
        return true;
    }

    private boolean validateUserName() {
        if (userName.getText().toString().equals("")){
            userErrorText.setVisibility(View.VISIBLE);
            return false;
        }
        else {
            userErrorText.setVisibility(View.GONE);
            return true;
        }
    }

    private boolean validateName() {
        if (fullName.getText().toString().equals("")){
            fullNameError.setVisibility(View.VISIBLE);
            return false;
        }
        else fullNameError.setVisibility(View.GONE);
        return true;
    }

    private void getTextFromField() {

        fullNameString = fullName.getText().toString();
        userNameString = userName.getText().toString();
        emailString = email.getText().toString();
        phoneNumberString = phoneNumber.getText().toString();
        enterPasswordString = enterPassword.getText().toString();

    }

}
