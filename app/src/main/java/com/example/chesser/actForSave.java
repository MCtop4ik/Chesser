package com.example.chesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class actForSave extends AppCompatActivity {

    public static String labelGame = "";
    Intent g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_for_save);
        EditText save;
        save = findViewById(R.id.nameOfSave);
        Button saveName;
        saveName = findViewById(R.id.saveLabel);
        Button go, clear, opening;
        go = findViewById(R.id.go);
        clear = findViewById(R.id.ClearPNG);
        opening = findViewById(R.id.infoAboutOpening);
        saveName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                labelGame = save.getText().toString();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Desk d = new Desk();
                NotationHelper.pgn = "";
                Desk.color = 1;
                NotationHelper.numberOfMove = 1;
                d.convertFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                g = new Intent(actForSave.this, saveOpenPosition.class);
                startActivity(g);
            }
        });
        opening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                g = new Intent(actForSave.this, All_Openings.class);
                startActivity(g);
            }
        });
    }
}