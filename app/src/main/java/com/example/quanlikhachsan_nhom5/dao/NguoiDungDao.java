package com.example.quanlikhachsan_nhom5.dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlikhachsan_nhom5.database.Dbhelper;
import com.example.quanlikhachsan_nhom5.model.NguoiDung;

public class NguoiDungDao {

    private Dbhelper dbHelper;
    SharedPreferences sharedPreferences;

    public  NguoiDungDao(Context context){
        dbHelper = new Dbhelper(context);
        sharedPreferences = context.getSharedPreferences("dataUser",Context.MODE_PRIVATE);


    }
    //kiem tra dang nhap
    //neu co gia trij dung ==>true
    // nguoc lai ==>false
    public boolean KiemTraDangNhap(String usrename , String password){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE tendn = ? AND matkhau = ?", new  String[]{usrename,password});

        /*  if (cursor.getCount()>0)
            return true;
        else return false;*/
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("role",cursor.getInt(6));
            editor.apply();
        }

        return cursor.getCount() >0;


    }

    //dk
    public boolean dangkyTaikhoan(NguoiDung nguoiDung){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tennd",nguoiDung.getTennd());
        contentValues.put("sdt",nguoiDung.getSdt());
        contentValues.put("diachi",nguoiDung.getDiachi());
        contentValues.put("tendn",nguoiDung.getTendn());
        contentValues.put("matkhau",nguoiDung.getMatkhau());
        contentValues.put("role",1);


        long check = sqLiteDatabase.insert("NGUOIDUNG",null,contentValues);

        return check != -1;


    }
    public boolean TaoTaikhoan(NguoiDung nguoiDung){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tennd",nguoiDung.getTennd());
        contentValues.put("sdt",nguoiDung.getSdt());
        contentValues.put("diachi",nguoiDung.getDiachi());
        contentValues.put("tendn",nguoiDung.getTendn());
        contentValues.put("matkhau",nguoiDung.getMatkhau());
        contentValues.put("role",2);


        long check = sqLiteDatabase.insert("NGUOIDUNG",null,contentValues);

        return check != -1;


    }
}
