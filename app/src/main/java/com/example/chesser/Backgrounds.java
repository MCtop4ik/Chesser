package com.example.chesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Backgrounds extends AppCompatActivity {
    public static final String APP_PREFERENCES_BG = "Background";
    public static final String APP_PREFERENCES = "data";
    SharedPreferences mSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_backgrounds);

        Button bg1, bg2, bg3, bg4, bg5, bg6, bg7,
                bg8, bg9, bg10, bg11, bg12, bg13, bg14,
                bg15, bg16, bg17, bg18, bg19, bg20, bg21;

        bg1 = findViewById(R.id.bg1);
        bg2 = findViewById(R.id.bg2);
        bg3 = findViewById(R.id.bg3);
        bg4 = findViewById(R.id.bg4);
        bg5 = findViewById(R.id.bg5);
        bg6 = findViewById(R.id.bg6);
        bg7 = findViewById(R.id.bg7);
        bg8 = findViewById(R.id.bg8);
        bg9 = findViewById(R.id.bg9);
        bg10 = findViewById(R.id.bg10);
        bg11 = findViewById(R.id.bg11);
        bg12 = findViewById(R.id.bg12);
        bg13 = findViewById(R.id.bg13);
        bg14 = findViewById(R.id.bg14);
        bg15 = findViewById(R.id.bg15);
        bg16 = findViewById(R.id.bg16);
        bg17 = findViewById(R.id.bg17);
        bg18 = findViewById(R.id.bg18);
        bg19 = findViewById(R.id.bg19);
        bg20 = findViewById(R.id.bg20);
        bg21 = findViewById(R.id.rnd_bg);

        bg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "1");
                editor.apply();
            }
        });
        bg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "2");
                editor.apply();
            }
        });
        bg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "3");
                editor.apply();
            }
        });
        bg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "4");
                editor.apply();
            }
        });
        bg5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "5");
                editor.apply();
            }
        });
        bg6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "6");
                editor.apply();
            }
        });
        bg7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "7");
                editor.apply();
            }
        });
        bg8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "8");
                editor.apply();
            }
        });
        bg21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "21");
                editor.apply();
            }
        });
        bg9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "9");
                editor.apply();
            }
        });
        bg10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "10");
                editor.apply();
            }
        });
        bg11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "11");
                editor.apply();
            }
        });
        bg12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "12");
                editor.apply();
            }
        });
        bg13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "13");
                editor.apply();
            }
        });
        bg14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "14");
                editor.apply();
            }
        });
        bg15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "15");
                editor.apply();
            }
        });
        bg16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "16");
                editor.apply();
            }
        });
        bg17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "17");
                editor.apply();
            }
        });
        bg18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "18");
                editor.apply();
            }
        });
        bg19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "19");
                editor.apply();
            }
        });
        bg20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BG, "20");
                editor.apply();
            }
        });

        bg21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min = 1;
                int max = 21;
                Random rnd = new Random(System.currentTimeMillis());
                int number = min + rnd.nextInt(max - min + 1);
                SharedPreferences.Editor editor = mSettings.edit();
                String num = Integer.toString(number);
                editor.putString(APP_PREFERENCES_BG, num);
                editor.apply();
            }
        });


    }
}