package com.example.quanlikhachsan_nhom5.dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.example.quanlikhachsan_nhom5.database.Dbhelper;
import com.example.quanlikhachsan_nhom5.model.NguoiDung;

import java.util.ArrayList;

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
    public boolean TaoTaikhoan(@NonNull NguoiDung nguoiDung){
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
    public ArrayList<NguoiDung> getAllData() {
        ArrayList<NguoiDung> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM NGUOIDUNG", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {

                String tennd = cursor.getString(0);
                String sdt = cursor.getString(1);
                String diachi = cursor.getString(2);
                String tendn = cursor.getString(3);
                String matkhau = cursor.getString(4);

                 NguoiDung nd  = new NguoiDung( tennd, sdt, diachi, tendn, matkhau);
                list.add(nd);
            } while (cursor.moveToNext());
        }
        return list;
    }
}
