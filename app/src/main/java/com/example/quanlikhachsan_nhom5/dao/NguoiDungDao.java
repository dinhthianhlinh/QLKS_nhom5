package com.example.quanlikhachsan_nhom5.dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.quanlikhachsan_nhom5.database.Dbhelper;
import com.example.quanlikhachsan_nhom5.model.NguoiDung;

import java.util.ArrayList;

public class NguoiDungDao {

    private Dbhelper dbHelper;



    SharedPreferences sharedPreferences;

    public NguoiDungDao(Context context) {
        dbHelper = new Dbhelper(context);
        sharedPreferences = context.getSharedPreferences("dataUser", Context.MODE_PRIVATE);


    }

    //kiem tra dang nhap
    //neu co gia trij dung ==>true
    // nguoc lai ==>false
    public boolean KiemTraDangNhap(String usrename, String password) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE tendn = ? AND matkhau = ?", new String[]{usrename, password});

        /*  if (cursor.getCount()>0)
            return true;
        else return false;*/
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("role", cursor.getInt(7));
            editor.apply();
        }

        return cursor.getCount() > 0;


    }

    //dk
    public boolean dangkyTaikhoan(NguoiDung nguoiDung) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tennd", nguoiDung.getTennd());
        contentValues.put("sdt", nguoiDung.getSdt());
        contentValues.put("diachi", nguoiDung.getDiachi());
        contentValues.put("tendn", nguoiDung.getTendn());
        contentValues.put("matkhau", nguoiDung.getMatkhau());
        contentValues.put("role", 1);


        long check = sqLiteDatabase.insert("NGUOIDUNG", null, contentValues);

        return check != -1;


    }

    public boolean TaoTaikhoan(@NonNull NguoiDung nguoiDung) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tennd", nguoiDung.getTennd());
        contentValues.put("sdt", nguoiDung.getSdt());
        contentValues.put("diachi", nguoiDung.getDiachi());
        contentValues.put("tendn", nguoiDung.getTendn());
        contentValues.put("matkhau", nguoiDung.getMatkhau());
        contentValues.put("linkAvata", nguoiDung.getLinkAvata());
        contentValues.put("role", 2);


        long check = sqLiteDatabase.insert("NGUOIDUNG", null, contentValues);

        return check != -1;


    }

    public boolean CapNhatThongTin(NguoiDung nguoiDung) {
//        int userRole = sharedPreferences.getInt("role", 7);
//        // Kiểm tra role
//        if (userRole != 3) { // nhung thang user khong phai admin
//            // Không có quyền cập nhật thông tin
//            return false;
//        }

        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mand", nguoiDung.getMand());
        contentValues.put("tennd", nguoiDung.getTennd());
        contentValues.put("sdt", nguoiDung.getSdt());
        contentValues.put("diachi", nguoiDung.getDiachi());
        contentValues.put("tendn", nguoiDung.getTendn());
        contentValues.put("matkhau", nguoiDung.getMatkhau());
        contentValues.put("linkAvata", nguoiDung.getLinkAvata());
        contentValues.put("role", 2);

        int result = sqLiteDatabase.update(
                "NGUOIDUNG",
                contentValues,
                "mand=?",
                new String[]{String.valueOf(nguoiDung.getMand())}
        );


        // Kiểm tra xem có bản ghi nào được cập nhật không
        return result > 0;
    }

    public int Delete(NguoiDung nd) {
//        int userRole = sharedPreferences.getInt("role", 0);
//        // Kiểm tra role
//        if (userRole != 2) {
//            // Không có quyền xóa
//            return -1;
//        }

        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        return sqLiteDatabase.delete("NGUOIDUNG", "mand=?", new String[]{nd.getMand()+""});


    }


    public ArrayList<NguoiDung> getAllData() {
        ArrayList<NguoiDung> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Thêm điều kiện WHERE role = 2 vào truy vấn SQL
        Cursor cursor = db.rawQuery("SELECT * FROM NGUOIDUNG WHERE role =2", null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                NguoiDung nguoiDung = new NguoiDung();
                nguoiDung.setMand(cursor.getInt(0));
                nguoiDung.setTennd(cursor.getString(1));
                nguoiDung.setSdt(cursor.getString(2));
                nguoiDung.setDiachi(cursor.getString(3));
                nguoiDung.setTendn(cursor.getString(4));
                nguoiDung.setMatkhau(cursor.getString(5));
                nguoiDung.setLinkAvata(cursor.getString(6));
                list.add(nguoiDung);
            } while (cursor.moveToNext());
        }

        // Đóng cursor
        cursor.close();

        return list;
    }

}
