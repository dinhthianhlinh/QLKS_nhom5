package com.example.quanlikhachsan_nhom5.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.quanlikhachsan_nhom5.database.Dbhelper;
import com.example.quanlikhachsan_nhom5.model.QuanLyP;
import java.util.ArrayList;

public class QuanLyPDAO {

    private Dbhelper dbHelper;

    public QuanLyPDAO(Context context) {
        this.dbHelper = new Dbhelper(context);
    }

    public void addQuanLyP(QuanLyP quanLyP) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", quanLyP.getName());
        values.put("phone", quanLyP.getPhone());
        values.put("email", quanLyP.getEmail());
        values.put("numPeople", quanLyP.getNumPeople());
        values.put("checkIn", quanLyP.getCheckIn());
        values.put("checkOut", quanLyP.getCheckOut());
        values.put("totalPrice", quanLyP.getTotalPrice());
        values.put("roomNumber", quanLyP.getRoomNumber());
        values.put("paymentInfo", quanLyP.getPaymentInfo());
        db.insert("QLP", null, values);
        db.close();
    }

    public ArrayList<QuanLyP> getAllQuanLyP() {
        ArrayList<QuanLyP> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM QLP", null);
        if (cursor.moveToFirst()) {
            do {
                QuanLyP quanLyP = new QuanLyP(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9)
                );
                list.add(quanLyP);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }
}
