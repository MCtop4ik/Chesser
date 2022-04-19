package com.example.chesser;

public class MyConstants {
    public static final String TABLE_NAME = "openings";
    public static final String _ID = "_id";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String DB_NAME = "open.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_STRUCTURE = "CREATE TABLE IF NOT EXISTS" +
            TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY," + TITLE + " TEXT," +
            DESCRIPTION + " TEXT)";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " +
            TABLE_NAME;
    public static final String APP_PREFERENCES_PIECE = "Piece";
    public static final String APP_PREFERENCES_SWITCH = "Switch";
    public static final String APP_PREFERENCES_BOARD = "Board";
    public static final String APP_PREFERENCES = "data";
    public static final String APP_PREFERENCES_BG = "Background";

}
