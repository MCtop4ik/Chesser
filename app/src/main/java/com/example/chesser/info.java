package com.example.chesser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class info extends AppCompatActivity{
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_info);
        t = findViewById(R.id.accountName);
        t.setText(Login.infoLogin);
    }
}