package com.example.kinglm.a355app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Antonyms.db";
    public static final String TABLE_NAME = "Antonyms";
    private static final String COLUMN_ID = "ID";
    public static final String COL1 = "com.example.kinglm.a355_androidapp.Word";
    public static final String COL2 = "Antonym";
    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE " + TABLE_NAME + "(id integer primary key autoincrement, " +
                "Word text not null, Antonym text not null)";
        db.execSQL(createTable);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL( "drop table if EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    public void addData(Word word) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, word.getFirst());
        contentValues.put(COL2, word.getSecond());

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public String findWord(String str) {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);
        String uno;
        String dos = " word not found";
        if(cursor.moveToFirst()) {
            do {
                uno = cursor.getString(1);
                if(uno.equals(str)) {
                    dos = cursor.getString(2);
                    break;
                }
            } while(cursor.moveToNext());
        }
        return dos;
    }
}
