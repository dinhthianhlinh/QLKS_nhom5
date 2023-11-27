package com.example.quanlikhachsan_nhom5.dao;

import android.content.ContentValues;
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
                int SOPHONG = cursor.getInt(0);
                String TEN_QLP = cursor.getString(1);
                int SOGIO_QLP = cursor.getInt(2);
                int DONGIA_QLP = cursor.getInt(3);
                int DICHVUK_QLP = cursor.getInt(4);
                int DATCOC_QLP = cursor.getInt(5);
                String INHOAD_QLP = cursor.getString(6);



                QuanLyP qlp = new QuanLyP(SOPHONG , TEN_QLP, SOGIO_QLP,DONGIA_QLP, DICHVUK_QLP, DATCOC_QLP,INHOAD_QLP);
                list.add(qlp);
            } while (cursor.moveToNext());
        }
        return list;
    }
    public long insertP(QuanLyP QLP){
        ContentValues values = new ContentValues();
        values.put("SOPHONG", QLP.getSophongQLP());
        values.put("TEN_QLP", QLP.getTenQLP());
        values.put("SOGIO_QLP", QLP.getSogioQLP());
        values.put("DONGIA_QLP", QLP.getDongiaQLP());
        values.put("DICHVUK_QLP", QLP.getDichvukhQLP());
        values.put("DATCOC_QLP", QLP.getDatcocQLP());
        values.put("INHOAD_QLP", QLP.getInhoadonQLP());

        long result = db.insert("QLP", null, values);
        return result;
    }
}
