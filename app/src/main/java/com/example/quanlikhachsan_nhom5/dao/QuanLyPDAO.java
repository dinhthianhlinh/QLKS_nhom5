package com.example.quanlikhachsan_nhom5.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlikhachsan_nhom5.database.Dbhelper;
import com.example.quanlikhachsan_nhom5.model.QuanLyKH;
import com.example.quanlikhachsan_nhom5.model.QuanLyP;

import java.util.ArrayList;

public class QuanLyPDAO {
    private Dbhelper helper;
    private Context context;
    private SQLiteDatabase db;

    public QuanLyPDAO(Context context) {
        this.context = context;
        helper = new Dbhelper(context);
        db = helper.getWritableDatabase();
    }

    public ArrayList<QuanLyP> getAllData() {
        ArrayList<QuanLyP> list = new ArrayList<>();
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM QLP", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                int sophong = cursor.getInt(0);
                String ten_qlp = cursor.getString(1);
                int sogio_qlp = cursor.getInt(2);
                int dongia_qlp = cursor.getInt(3);
                String dichvuk_qlp = cursor.getString(4);
                int datcoc_qlp = cursor.getInt(5);
                String inhoadon_qlp = cursor.getString(6);



                QuanLyP qlp = new QuanLyP(sophong , ten_qlp, sogio_qlp,dongia_qlp, dichvuk_qlp, datcoc_qlp,inhoadon_qlp);
                list.add(qlp);
            } while (cursor.moveToNext());
        }
        return list;
    }
}
