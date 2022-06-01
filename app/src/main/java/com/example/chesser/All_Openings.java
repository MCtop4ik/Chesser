package com.example.chesser;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class All_Openings extends ListActivity {

    private SQLiteDatabase myDb;
    public ArrayList<String> fenList = new ArrayList<>();
    public ArrayList<String> pgnList = new ArrayList<>();
    public ArrayList<String> openingList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDB();
        fenList.clear();
        pgnList.clear();
        openingList.clear();
        fillAllOpenings();
        ArrayAdapter<String> gameAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                        openingList.toArray(new String[0]));
        setListAdapter(gameAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Desk d = new Desk();
        String fen = fenList.get(position);
        d.convertFen(fen);
        MainActivity.name = openingList.get(position);
        NotationHelper.pgn = pgnList.get(position);
        Intent open;
        open = new Intent(All_Openings.this, MainActivity.class);
        startActivity(open);
    }

    public void fillAllOpenings(){
        Cursor cursor = myDb.rawQuery("SELECT * FROM a",null);
        cursor.moveToFirst();
        fenList.add(cursor.getString(4));
        pgnList.add(cursor.getString(3));
        openingList.add(cursor.getString(1) + cursor.getString(2));
        while (cursor.moveToNext()){
           fenList.add(cursor.getString(4));
           pgnList.add(cursor.getString(3));
           openingList.add(cursor.getString(1) + " " + cursor.getString(2));
        }
        cursor.close();
    }

    private void initDB() {
        //Переменная для работы с БД
        DatabaseHelper mDBHelper = new DatabaseHelper(this);
        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        myDb = mDBHelper.getWritableDatabase();
    }
}