package com.example.chesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Openings extends AppCompatActivity {
    private SQLiteDatabase mDb;
    public static String name;
    public static final String APP_PREFERENCES = "data";
    SharedPreferences mSettings;
    TextView openI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        setContentView(R.layout.activity_openings);
        initDB();
        openI = findViewById(R.id.infoOpeningIs);
        final Button buttonOK = findViewById(R.id.openingButton);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min = 1;
                int max = 3403;
                Random rnd = new Random(System.currentTimeMillis());
                int number = min + rnd.nextInt(max - min + 1);
                String num = Integer.toString(number);
                String req = "SELECT * FROM a where `id` = '" + num + "'";
                ArrayList<String> words = new ArrayList<>();
                Cursor cursor = mDb.rawQuery(req,null);
                cursor.moveToFirst();
                String eco = cursor.getString(1);
                name = cursor.getString(2);
                String pass = cursor.getString(3);
                cursor.close();
                Toast toast = Toast.makeText(getApplicationContext(), eco + " : " + name +" >>> " + pass, Toast.LENGTH_LONG);
                toast.show();
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString("opening", "name");
                editor.apply();
                String[] word = name.split(":");
                String txt = eco + ": " + word[0] + ":\n" + word[1] + "\n" + pass + "\n" +
                        "Сcылки на видео:" + "\n" + "Книги:";
                openI.setText(txt);
            }
        });
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