package com.example.chesser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainUser extends AppCompatActivity {

    Intent i;
    Intent j;
    Intent credit;
    Intent coders;
    Intent open;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.main_act_user);

        Button b1, b2, credits, bg, variants;

        b1 = findViewById(R.id.b1User);
        b2 = findViewById(R.id.b2User);
        credits = findViewById(R.id.creditsUser);
        bg = findViewById(R.id.bgUser);
        variants = findViewById(R.id.varChessUser);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(MainUser.this, MainActivity.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                j = new Intent(MainUser.this, Settings.class);
                startActivity(j);
            }
        });

        credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                credit = new Intent(MainUser.this, actForSave.class);
                startActivity(credit);
            }
        });

        bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coders = new Intent(MainUser.this, Backgrounds.class);
                startActivity(coders);
            }
        });

        variants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open = new Intent(MainUser.this, VariantsOfChess.class);
                startActivity(open);
            }
        });

    }
}
