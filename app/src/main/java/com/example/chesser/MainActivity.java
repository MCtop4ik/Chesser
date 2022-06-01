package com.example.chesser;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;

import javax.xml.transform.Source;

public class MainActivity extends AppCompatActivity implements Runnable{
    public SharedPreferences mSettings;
    String APP_PREFERENCES_BOARD = MyConstants.APP_PREFERENCES_BOARD;
    String APP_PREFERENCES_PIECE = MyConstants.APP_PREFERENCES_PIECE;
    String APP_PREFERENCES_SWITCH = MyConstants.APP_PREFERENCES_SWITCH;
    String APP_PREFERENCES_BG = MyConstants.APP_PREFERENCES_BG;
    String APP_PREFERENCES_PGN = MyConstants.APP_PREFERENCES_BG;
    String APP_PREFERENCES = "data";
    public static String colorful_palette;
    public static String colors;
    public static String switcher;
    public static String backgrounds_font;
    public static String startGame;
    public static String name = " ";
    public static String eco = " ";
    public static String pass;
    public static String game;
    public String pgn;
    private SQLiteDatabase mDb;
    //EditText openingI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        //openingI = findViewById(R.id.infoOpening);
        super.onCreate(savedInstanceState);
        if (mSettings.contains(APP_PREFERENCES_BOARD) && mSettings.contains(APP_PREFERENCES_PIECE)
                && mSettings.contains(APP_PREFERENCES_SWITCH) && mSettings.contains(APP_PREFERENCES_BG)) {
            colorful_palette = mSettings.getString(APP_PREFERENCES_PIECE, "");
            colors = mSettings.getString(APP_PREFERENCES_BOARD, "");
            switcher = mSettings.getString(APP_PREFERENCES_SWITCH, "");
            backgrounds_font = mSettings.getString(APP_PREFERENCES_BG, "");
            game = mSettings.getString("game", "");

        }else {
            SharedPreferences.Editor editor = mSettings.edit();
            editor.putString(APP_PREFERENCES_PIECE, "first");
            colorful_palette = mSettings.getString(APP_PREFERENCES_PIECE, "");
            editor.putString(APP_PREFERENCES_BOARD, "sea");
            colors = mSettings.getString(APP_PREFERENCES_BOARD, "");
            editor.putString(APP_PREFERENCES_SWITCH, "WHITE");
            switcher = mSettings.getString(APP_PREFERENCES_SWITCH, "");
            editor.putString(APP_PREFERENCES_BG, "1");
            backgrounds_font = mSettings.getString(APP_PREFERENCES_BG, "");
            editor.putString(APP_PREFERENCES_PGN, " ");
            startGame = mSettings.getString(APP_PREFERENCES_PGN, "");
            editor.putString("game", "normal");
            game = mSettings.getString("game", "");
            editor.apply();
        }
        getSupportActionBar().hide();
        initDB();
        setContentView(new TestSurfaceView(this));
        new Thread(this).start();
    }


    private void testOpening(){
        pgn = NotationHelper.pgn;
        for (int k = 1; k < 3404 ; k++){
            String req = "SELECT * FROM a where `id` = " + k;
            Cursor cursor = mDb.rawQuery(req,null);
            cursor.moveToFirst();
            if(cursor.moveToFirst()){
                pass = cursor.getString(3);}
            String new_pass = pass + " ";
            if (pgn.equals(new_pass)){
                eco = cursor.getString(1);
                name = cursor.getString(2);
            }
            cursor.close();
        }
    }

    public String removeLastChar(String s) {
        return (s == null || s.length() == 0)
                ? null
                : (s.substring(0, s.length() - 1));
    }

    @Override
    public void run() {
        while(true){
            testOpening();
            System.out.println(NotationHelper.pgn);
        }
    }
    private void initDB() {
        //Переменная для работы с БД
        DatabaseHelper mDBHelper = new DatabaseHelper(this);
        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        mDb = mDBHelper.getWritableDatabase();
    }
}
