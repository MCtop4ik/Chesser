package com.example.chesser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class db extends AppCompatActivity {

    private MyDbManager myDbManager;
    private EditText edTitle, edDesc;
    private TextView tester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        edTitle = findViewById(R.id.titler);
        edDesc = findViewById(R.id.saver);
        myDbManager = new MyDbManager(this);
        tester = findViewById(R.id.info);
        setContentView(R.layout.activity_db);
    }
    @Override
    protected void onResume() {
        super.onResume();
        myDbManager.openDb();
        for (String title :myDbManager.getFromDb()){
            tester.append(title);
            tester.append("\n");
        }
    }

    public void onClickSave(View view){
        tester.setText("");
        myDbManager.insertToDb(edTitle.getText().toString(), edDesc.getText().toString());
        for (String title :myDbManager.getFromDb()){
            tester.append(title);
            tester.append("\n");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDbManager.closeDb();
    }

}