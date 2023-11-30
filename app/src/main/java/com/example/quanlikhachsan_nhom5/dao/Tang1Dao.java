package com.example.quanlikhachsan_nhom5.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlikhachsan_nhom5.database.Dbhelper;
import com.example.quanlikhachsan_nhom5.model.Tang1;

import java.util.ArrayList;

public class Tang1Dao {
    public Dbhelper dbhelper;

    public Tang1Dao(Context context) {
        dbhelper = new Dbhelper(context);
    }

    public ArrayList<Tang1> getDSTang1() {
        ArrayList<Tang1> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM TANG1", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                list.add(new Tang1(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)));

            } while (cursor.moveToNext());
        }
        return list;
    }
}
