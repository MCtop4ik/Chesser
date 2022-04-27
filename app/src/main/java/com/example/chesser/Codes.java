package com.example.chesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Codes extends AppCompatActivity {
    SharedPreferences mSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSettings = getSharedPreferences(MyConstants.APP_PREFERENCES, Context.MODE_PRIVATE);
        EditText promo;
        Button submit;
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_codes);
        submit = findViewById(R.id.send);
        promo = findViewById(R.id.promocodeInput);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (promo.getText().toString().equals(">>>reset")){
                    System.out.println("ok");
                    SharedPreferences.Editor editor = mSettings.edit();
                    editor.putString(MyConstants.APP_PREFERENCES_PIECE, "second");
                    editor.putString(MyConstants.APP_PREFERENCES_BOARD, "sea");
                    editor.putString(MyConstants.APP_PREFERENCES_SWITCH, "WHITE");
                    editor.putString(MyConstants.APP_PREFERENCES_BG, "1");
                    editor.apply();
                }else if(promo.getText().toString().equals(">>>destroyUser")){
                    SharedPreferences.Editor editor = mSettings.edit();
                    editor.putString("Name", "");
                    editor.putString("Password", "");
                    editor.apply();
                }
            }
        });

    }


}