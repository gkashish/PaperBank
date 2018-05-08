package com.manan.dev.paperbank;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    EditText instituteName;
    Button btnSubmit;
    String strInstituteName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        instituteName = findViewById(R.id.et_institute);
        btnSubmit = findViewById(R.id.submit_button);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strInstituteName = String.valueOf(instituteName.getText());
                SharedPreferences.Editor editor = getSharedPreferences("Institute", MODE_PRIVATE).edit();
                editor.putString("name", strInstituteName);
                editor.apply();
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SettingsActivity.this,BatchActivity.class);
        startActivity(intent);
        finish();
    }


}
