package com.example.quanlikhachsan_nhom5.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.quanlikhachsan_nhom5.database.Dbhelper;
import com.example.quanlikhachsan_nhom5.model.DatPhong;
import java.util.ArrayList;

public class DatPhongDao {
    public Dbhelper dbhelper;

    public DatPhongDao(Context context){
        dbhelper = new Dbhelper(context);
    }

    public ArrayList<DatPhong> getDSDatPhong(){
        ArrayList<DatPhong> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM DATPHONG", null);
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                // Làm sạch chuỗi giá phòng
                String rawGiaphong = cursor.getString(3);
                String cleanedGiaphong = rawGiaphong.replaceAll("[^\\d]", ""); // Loại bỏ tất cả ký tự không phải số
                int giaPhongValue;
                try {
                    giaPhongValue = Integer.parseInt(cleanedGiaphong); // Chuyển đổi sang số nguyên
                } catch (NumberFormatException e) {
                    giaPhongValue = 0; // Trường hợp lỗi, đặt giá trị mặc định
                    e.printStackTrace();
                }

                list.add(new DatPhong(cursor.getInt(0), cursor.getString(1), cursor.getString(2), String.valueOf(giaPhongValue), cursor.getString(4)));
            } while (cursor.moveToNext());
        }
        return list;
    }
}
