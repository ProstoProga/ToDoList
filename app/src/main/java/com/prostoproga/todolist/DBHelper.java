package com.prostoproga.todolist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alexander on 21.10.2015.
 */
class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "ToDoList", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table task ("
                + "_id integer primary key autoincrement,"
                + "parent_id integer,"
                + "name text,"
                + "description text,"
                + "expanded integer,"
                + "completed integer,"
                + "create_date_time real default current_timestamp" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getAllData() {
        SQLiteDatabase db = getWritableDatabase();
        return db.query("task", null, null, null, null, null, null);
    }

    public boolean deleteTask(long id)
    {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete("task", "_id=" + id, null) > 0;
    }
}