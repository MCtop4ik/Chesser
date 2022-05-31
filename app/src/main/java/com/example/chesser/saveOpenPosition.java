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

public class saveOpenPosition extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> gameAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                        Codes.gameList.toArray(new String[0]));
        setListAdapter(gameAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String game = (String) getListAdapter().getItem(position);
        Toast.makeText(this, game, Toast.LENGTH_SHORT).show();
    }
}