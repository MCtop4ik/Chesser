package com.example.chesser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_credits);
    }
}