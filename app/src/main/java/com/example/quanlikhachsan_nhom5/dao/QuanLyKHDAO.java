package com.example.quanlikhachsan_nhom5.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlikhachsan_nhom5.database.Dbhelper;
import com.example.quanlikhachsan_nhom5.fragment.qlkh_frag;
import com.example.quanlikhachsan_nhom5.model.QuanLyKH;

import java.util.ArrayList;

public class QuanLyKHDAO {
    private Dbhelper helper;
    private Context context;
    private SQLiteDatabase db;

    public QuanLyKHDAO(Context context) {
        this.context = context;
        helper = new Dbhelper(context);
        db = helper.getWritableDatabase();
    }

    public ArrayList<QuanLyKH> getAllData() {
        ArrayList<QuanLyKH> list = new ArrayList<>();
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM QLKH", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                int stt = cursor.getInt(0);
                String ten = cursor.getString(1);
                int tuoi = cursor.getInt(2);
                String gioit = cursor.getString(3);
                int sdt = cursor.getInt(4);
                String quequan = cursor.getString(5);
                int cancuoc = cursor.getInt(6);
                int solandp = cursor.getInt(7);


                QuanLyKH qlkh = new QuanLyKH(stt , ten, tuoi,gioit, sdt, quequan,cancuoc,solandp);
                list.add(qlkh);
            } while (cursor.moveToNext());
        }
        return list;
    }

    public long insertKH(QuanLyKH QL){
        ContentValues values = new ContentValues();
        values.put("STT", QL.getId());
        values.put("TEN", QL.getTenQLKH());
        values.put("TUOI", QL.getTuoiQLKH());
        values.put("GIOITINH", QL.getGioitinhQLKH());
        values.put("SODT", QL.getSodtQLKH());
        values.put("QUEQUAN", QL.getQuequanQLKH());
        values.put("CANCUOC", QL.getCancuocQLKH());
        values.put("SOLANDP", QL.getSolandatphongQLKH());
        long result = db.insert("QLKH", null, values);
        return result;
    }

}

