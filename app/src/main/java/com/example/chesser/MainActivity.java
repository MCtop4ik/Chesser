package com.example.chesser;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public SharedPreferences mSettings;
    String APP_PREFERENCES_BOARD = MyConstants.APP_PREFERENCES_BOARD;
    String APP_PREFERENCES_PIECE = MyConstants.APP_PREFERENCES_PIECE;
    String APP_PREFERENCES_SWITCH = MyConstants.APP_PREFERENCES_SWITCH;
    String APP_PREFERENCES_BG = MyConstants.APP_PREFERENCES_BG;
    String APP_PREFERENCES = "data";
    public static String colorful_palette;
    public static String colors;
    public static String switcher;
    public static String backgrounds_font;
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
        }else{
            SharedPreferences.Editor editor = mSettings.edit();
            editor.putString(APP_PREFERENCES_PIECE, "first");
            editor.apply();
            colorful_palette = mSettings.getString(APP_PREFERENCES_PIECE, "");
            editor.putString(APP_PREFERENCES_BOARD, "sea");
            editor.apply();
            colors = mSettings.getString(APP_PREFERENCES_BOARD, "");
            editor.putString(APP_PREFERENCES_SWITCH, "WHITE");
            editor.apply();
            switcher = mSettings.getString(APP_PREFERENCES_SWITCH, "");
            editor.putString(APP_PREFERENCES_BG, "1");
            editor.apply();
            backgrounds_font = mSettings.getString(APP_PREFERENCES_BG, "");
        }

        getSupportActionBar().hide();
        setContentView(new TestSurfaceView(this));
    }
}
