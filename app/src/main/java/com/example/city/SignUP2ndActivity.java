package com.example.city;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class SignUP2ndActivity extends AppCompatActivity {
    ImageView back2nd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2nd);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        back2nd = findViewById(R.id.back_signUp2nd);
        back2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUP2ndActivity.super.onBackPressed();
            }
        });
    }
}