package com.manan.dev.paperbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=new Intent(SplashScreenActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
        setContentView(R.layout.activity_splash_screen);
    }
}
