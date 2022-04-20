package com.example.chesser;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    Intent i;
    Intent j;
    Intent credit;
    Intent k;
    Intent coders;
    Intent open;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.main_act);

        Button b1, b2, credits, bg, forPromocodes, opening;

        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        credits = (Button)findViewById(R.id.credits);
        bg = (Button)findViewById(R.id.bg);
        forPromocodes = (Button)findViewById(R.id.forPromocodes);
        opening = (Button)findViewById(R.id.openingB);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(Main.this, MainActivity.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                j = new Intent(Main.this, Settings.class);
                startActivity(j);
            }
        });

        credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                credit = new Intent(Main.this, Credits.class);
                startActivity(credit);
            }
        });

        bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coders = new Intent(Main.this, Backgrounds.class);
                startActivity(coders);
            }
        });

        forPromocodes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                k = new Intent(Main.this, Codes.class);
                startActivity(k);
            }
        });

        opening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open = new Intent(Main.this, Openings.class);
                startActivity(open);
            }
        });
    }

}
