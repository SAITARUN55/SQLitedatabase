package com.example.saitarun.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sai Tarun on 10-03-2018.
 */

public class DatabaseHelper1 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="gitamdb";
    public static String TABLE_NAME="students";
    public static String COLUMN_0="id";
    public static String COLUMN_1="name";
    public static String COLUMN_2="age";

    private static final String QUERY_STRING=" create table "+TABLE_NAME+"("+COLUMN_0+" integer primary key autoincrement,"+COLUMN_1+" text,"+COLUMN_2+" integer);";

    public DatabaseHelper1(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUERY_STRING);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }
    public long insertData(ContentValues values){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.insert(TABLE_NAME,null,values);

    }
    public Cursor retreiveData(){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select * from "+TABLE_NAME,null);
    }
}
