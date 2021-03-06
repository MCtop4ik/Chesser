package com.example.chesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class Codes extends AppCompatActivity {
    SharedPreferences mSettings;
    Intent open;
    private SQLiteDatabase myDb;
    public static ArrayList<String> gameList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSettings = getSharedPreferences(MyConstants.APP_PREFERENCES, Context.MODE_PRIVATE);
        EditText promo;
        Button submit;
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        initDB();
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
                }else if(promo.getText().toString().equals(">>>authGet<User>")){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            mSettings.getString("Name", ""), Toast.LENGTH_SHORT);
                    toast.show();
                }else if(promo.getText().toString().equals(">>>authGet<Password>")){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            mSettings.getString("Password", ""), Toast.LENGTH_SHORT);
                    toast.show();
                }else if(promo.getText().toString().equals(">>>authGet<Email>")){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            mSettings.getString("email", ""), Toast.LENGTH_SHORT);
                    toast.show();
                }else if(promo.getText().toString().equals(">>>opening")){
                    open = new Intent(Codes.this, Openings.class);
                    startActivity(open);
                }else if(promo.getText().toString().equals(">>>clearPGN")){
                    NotationHelper.pgn = "";
                    Desk.color = 1;
                    NotationHelper.numberOfMove = 1;
                }else if(promo.getText().toString().equals(">>>add")){
                    savePosition();
                }
            }
        });

    }
    public void savePosition(){
        myDb.execSQL("INSERT INTO games (name, fen) " +
                "VALUES ('Russian Defence', 'rnb1kb1r/ppp1qppp/3p4/8/4n3/5N2/PPPPQPPP/RNB1KB1R')",null);
        Cursor cursor1 = myDb.rawQuery("SELECT * FROM games where `id` = '2'",null);
        cursor1.moveToFirst();
        String user = cursor1.getString(1);
        String pass = cursor1.getString(2);
        cursor1.close();
        Toast toast = Toast.makeText(getApplicationContext(), user + ":" + pass, Toast.LENGTH_LONG);
        toast.show();
    }

    private void initDB() {
        //???????????????????? ?????? ???????????? ?? ????
        DatabaseHelper mDBHelper = new DatabaseHelper(this);
        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        myDb = mDBHelper.getWritableDatabase();
    }


}