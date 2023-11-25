package com.example.quanlikhachsan_nhom5.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {

    public Dbhelper( Context context) {
        super(context, "QLKS",null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tNguoiDung = "CREATE TABLE NGUOIDUNG (mand integer primary key autoincrement, tennd text, sdt text, diachi text,  tendn text, matkhau text, role integer)";
        db.execSQL(tNguoiDung);
        db.execSQL("INSERT INTO NGUOIDUNG VALUES (1,'dinhlinh','0357103658','namdinh','linh29','12345',1)," +
                "(2,'nguyendang','123456789','vinhphuc','nguyen12','1290',2)," +
                "(3,'nguyenhoc','987654321','hanam','hoc34','12347',3)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1){
            db.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");

            onCreate(db);
        }

    }
}
