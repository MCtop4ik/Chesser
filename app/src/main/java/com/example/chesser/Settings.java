package com.example.chesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Settings extends AppCompatActivity {
    String APP_PREFERENCES_PIECE = MyConstants.APP_PREFERENCES_PIECE;
    String APP_PREFERENCES_SWITCH = MyConstants.APP_PREFERENCES_SWITCH;
    String APP_PREFERENCES_BOARD = MyConstants.APP_PREFERENCES_BOARD;
    String APP_PREFERENCES = MyConstants.APP_PREFERENCES;
    SharedPreferences mSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_settings);

        Button b1, b2, b3, b4, b5, b6;

        Button p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12;

        Button switcher, sw_bl;

        Button volume;

        b2 = findViewById(R.id.first);
        b1 = findViewById(R.id.second);
        b3 = findViewById(R.id.third);
        b4 = findViewById(R.id.forth);
        b5 = findViewById(R.id.fifth);
        b6 = findViewById(R.id.sixth);

        p1 = findViewById(R.id.paint1);
        p2 = findViewById(R.id.paint2);
        p3 = findViewById(R.id.paint3);
        p4 = findViewById(R.id.paint4);
        p5 = findViewById(R.id.paint5);
        p6 = findViewById(R.id.paint6);
        p7 = findViewById(R.id.paint7);
        p8 = findViewById(R.id.paint8);
        p9 = findViewById(R.id.paint9);
        p10 = findViewById(R.id.paint10);
        p11 = findViewById(R.id.paint11);
        p12 = findViewById(R.id.paint12);
        volume = findViewById(R.id.volume);

        switcher = findViewById(R.id.switcher);
        sw_bl = findViewById(R.id.switcher_black);
        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_SWITCH, "WHITE");
                editor.apply();
            }
        });

        sw_bl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_SWITCH, "BLACK");
                editor.apply();
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_PIECE, "first");
                editor.apply();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_PIECE, "second");
                editor.apply();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_PIECE, "third");
                editor.apply();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_PIECE, "forth");
                editor.apply();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_PIECE, "fifth");
                editor.apply();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_PIECE, "sixth");
                editor.apply();
            }
        });

        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BOARD, "hibiscus");
                editor.apply();
            }
        });

        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BOARD, "thistle");
                editor.apply();
            }
        });

        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BOARD, "orchid");
                editor.apply();
            }
        });

        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BOARD, "african");
                editor.apply();
            }
        });

        p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BOARD, "salmon");
                editor.apply();
            }
        });
        p6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BOARD, "raspberry");
                editor.apply();
            }
        });

        p7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BOARD, "cornflower");
                editor.apply();
            }
        });

        p8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BOARD, "turkish");
                editor.apply();
            }
        });

        p9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BOARD, "flax");
                editor.apply();
            }
        });

        p10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BOARD, "lemon");
                editor.apply();
            }
        });

        p11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BOARD, "sea");
                editor.apply();
            }
        });
        p12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_BOARD, "tea");
                editor.apply();
            }
        });

        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_PIECE, "3d");
                editor.apply();
            }
        });
    }
}