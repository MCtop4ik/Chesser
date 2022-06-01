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
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class saveOpenPosition extends ListActivity {

    private SQLiteDatabase myDb;
    public ArrayList<String> fenList = new ArrayList<>();
    public ArrayList<String> pgnList = new ArrayList<>();
    public ArrayList<String> openingList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDB();
        fenList.clear();
        Codes.gameList.clear();
        pgnList.clear();
        openingList.clear();
        if (!actForSave.labelGame.equals(""))savePosition();
        System.out.println(actForSave.labelGame);
        fillAllGames();
        ArrayAdapter<String> gameAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                        Codes.gameList.toArray(new String[0]));
        setListAdapter(gameAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Desk d = new Desk();
        d.convertFen(fenList.get(position));
        MainActivity.name = openingList.get(position);
        NotationHelper.pgn = pgnList.get(position);
        Intent open;
        open = new Intent(saveOpenPosition.this, MainActivity.class);
        startActivity(open);
    }

    public void fillAllGames(){
        Cursor cursor1 = myDb.rawQuery("SELECT * FROM games",null);
        cursor1.moveToFirst();
        String nameGame = cursor1.getString(1);
        String fen = cursor1.getString(2);
        String pgnGame = cursor1.getString(3);
        String opening = cursor1.getString(4);
        fenList.add(fen);
        pgnList.add(pgnGame);
        openingList.add(opening);
        Codes.gameList.add(nameGame);
        while (cursor1.moveToNext()){
            nameGame = cursor1.getString(1);
            fen = cursor1.getString(2);
            pgnGame = cursor1.getString(3);
            opening = cursor1.getString(4);
            fenList.add(fen);
            pgnList.add(pgnGame);
            openingList.add(opening);
            Codes.gameList.add(nameGame);
        }
        cursor1.close();
    }

    public void savePosition(){
        Desk d = new Desk();
        String fen = d.makeFEN(Desk.boardArray);
        myDb.execSQL("INSERT INTO games (name, fen, pgn, opening) " +
                "VALUES ('" + actForSave.labelGame + "','" + fen + "','" + NotationHelper.pgn +
                "','" + MainActivity.name + "')");
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