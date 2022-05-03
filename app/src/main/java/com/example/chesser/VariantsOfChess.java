package com.example.chesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VariantsOfChess extends AppCompatActivity {
    Button horde, classic;
    public SharedPreferences mSettings;
    String APP_PREFERENCES = "data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variants_of_chess);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        horde = findViewById(R.id.hordeButton);
        classic = findViewById(R.id.classical);
        SharedPreferences.Editor editor = mSettings.edit();
        horde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("game", "horde");
                editor.apply();

            }
        });
        classic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("game", "normal");
                editor.apply();

            }
        });
    }
}