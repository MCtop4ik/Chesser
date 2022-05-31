package com.example.chesser;

import android.app.ListActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDB();
        fenList.clear();
        Codes.gameList.clear();
        if (!actForSave.labelGame.equals(""))savePosition();
        fillAllGames();
        ArrayAdapter<String> gameAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                        Codes.gameList.toArray(new String[0]));
        setListAdapter(gameAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(this, fenList.get(position), Toast.LENGTH_SHORT).show();
    }

    public void fillAllGames(){
        Cursor cursor1 = myDb.rawQuery("SELECT * FROM games",null);
        cursor1.moveToFirst();
        String nameGame = cursor1.getString(1);
        String fen = cursor1.getString(2);
        fenList.add(fen);
        Codes.gameList.add(nameGame);
        while (cursor1.moveToNext())
        {
            nameGame = cursor1.getString(1);
            Codes.gameList.add(nameGame);
            fen = cursor1.getString(2);
            fenList.add(fen);
        }
    }

    public void savePosition(){
        Desk d = new Desk();
        String fen = d.makeFEN(Desk.boardArray);
        myDb.execSQL("INSERT INTO games (name, fen) " +
                "VALUES ('" + actForSave.labelGame + "','" + fen + "')");
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