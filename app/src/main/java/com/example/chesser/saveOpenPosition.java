package com.example.chesser;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class saveOpenPosition extends ListActivity {
    String[] myArr = { "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август",
            "Сентябрь", "Октябрь", "Ноябрь", "Декабрь", "jytf", "rtyuytre", "htdg",
    "ggfdd", "hgfd", "hgfjkdlfkg", "hgjfkdl;flgkhj", "hgfjkdl", "fndmmcv", "gnfmcxkgj", "hgfjkdl"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> monthAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myArr);

        setListAdapter(monthAdapter);
    }
}