package com.prostoproga.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void add(View view) {
        //Add task to DB
        DBHelper dbHelper;
        dbHelper = new DBHelper(this);
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        EditText etName = (EditText) findViewById(R.id.editTextTaskName);
        cv.put("name",etName.getText().toString());
        cv.put("expanded",1);
        cv.put("completed",0);
        long rowId = db.insert("task", null, cv);
        dbHelper.close();

        finish();

    }


}