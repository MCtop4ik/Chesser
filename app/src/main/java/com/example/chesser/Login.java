package com.example.chesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    Button b1;
    EditText login;
    EditText password;
    Intent started;
    SharedPreferences mSettings;
    public static String infoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mSettings = getSharedPreferences(MyConstants.APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSettings.edit();
        b1 = findViewById(R.id.enterInSystem);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        if (mSettings.contains("Name")){

        }else{
            editor.putString("Name", "");
            editor.putString("Password", "");
            editor.apply();
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login.getText().toString().equals("admin")
                        && password.getText().toString().equals("root") ){
                started = new Intent(Login.this, Main.class);
                startActivity(started);
                }else if(!mSettings.getString("Name", "").equals("")){
                    if (mSettings.getString("Name", "").equals(login.getText().toString())
                    && mSettings.getString("Password", "").equals(password.getText().toString())){
                        infoLogin = login.getText().toString();
                        started = new Intent(Login.this, MainUser.class);
                        startActivity(started);
                    }
                }else{
                    started = new Intent(Login.this, register.class);
                    startActivity(started);
                }
            }
        });
    }
}