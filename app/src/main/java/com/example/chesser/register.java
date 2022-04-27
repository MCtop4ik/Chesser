package com.example.chesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class register extends AppCompatActivity {

    Button b1;
    EditText login;
    EditText password;
    Intent goToMain;
    SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSettings = getSharedPreferences(MyConstants.APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSettings.edit();

        setContentView(R.layout.activity_register);
        b1 = findViewById(R.id.regButton);
        login = findViewById(R.id.nameEnter);
        password = findViewById(R.id.passwordEnter);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!login.getText().toString().equals("")
                        && !password.getText().toString().equals("") ){
                    editor.putString("Name", login.getText().toString());
                    editor.putString("Password", password.getText().toString());
                    editor.apply();
                    goToMain = new Intent(register.this, Login.class);
                    startActivity(goToMain);
                }else{

                }
            }
        });
    }
}