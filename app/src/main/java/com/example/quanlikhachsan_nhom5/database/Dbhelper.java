package com.example.quanlikhachsan_nhom5.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {

    public Dbhelper( Context context) {
        super(context, "QLKS",null, 19);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tNguoiDung = "CREATE TABLE NGUOIDUNG (mand integer primary key autoincrement, tennd text, sdt text, diachi text,  tendn text, matkhau text, role integer)";
        db.execSQL(tNguoiDung);
        db.execSQL("INSERT INTO NGUOIDUNG VALUES (1,'dinhlinh','0357103658','namdinh','linh29','12345',1)," +
                "(2,'nguyendang','123456789','vinhphuc','nguyen12','1290',2)," +
                "(3,'nguyenhoc','987654321','hanam','hoc34','12347',3)");



        String Tang1 = "CREATE TABLE TANG1 (id integer primary key autoincrement, sophong text, sotang text, giaphing text, hangphong text)";
        db.execSQL(Tang1);
        db.execSQL("INSERT INTO TANG1 VALUES (1,'101','1','200000d','Phong doi')," +
                "(2,'102','1','100000d','Phong don')," +
                "(3,'103','1','100000d','Phong don')," +
                "(4,'104','1','100000d','Phong don')," +
                "(5,'105','1','200000d','Phong doi')," +
                "(6,'106','1','200000d','Phong doi')," +
                "(7,'107','1','100000d','Phong don')," +
                "(8,'108','1','200000d','Phong doi')," +
                "(9,'108','1','200000d','Phong doi')," +
                "(10,'110','1','200000d','Phong doi')");

        String Tang2 = "CREATE TABLE TANG2 (id integer primary key autoincrement, sophong text, sotang text, giaphing text, hangphong text)";
        db.execSQL(Tang2);
        db.execSQL("INSERT INTO TANG2 VALUES (1,'201','2','200000d','Phong doi')," +
                "(2,'202','2','100000d','Phong don')," +
                "(3,'203','2','200000d','Phong doi')," +
                "(4,'204','2','100000d','Phong don')," +
                "(5,'205','2','200000d','Phong doi')," +
                "(6,'206','2','200000d','Phong doi')," +
                "(7,'207','2','100000d','Phong don')," +
                "(8,'208','2','200000d','Phong doi')," +
                "(9,'209','2','100000d','Phong don')," +
                "(10,'210','2','200000d','Phong doi')");

        String Tang3 = "CREATE TABLE TANG3 (id integer primary key autoincrement, sophong text, sotang text, giaphing text, hangphong text)";
        db.execSQL(Tang3);
        db.execSQL("INSERT INTO TANG3 VALUES (1,'301','3','200000d','Phong doi')," +
                "(2,'302','3','100000d','Phong don')," +
                "(3,'303','3','200000d','Phong doi')," +
                "(4,'304','3','100000d','Phong don')," +
                "(5,'305','3','200000d','Phong doi')," +
                "(6,'306','3','200000d','Phong doi')," +
                "(7,'307','3','100000d','Phong don')," +
                "(8,'308','3','200000d','Phong doi')," +
                "(9,'309','3','100000d','Phong don')," +
                "(10,'310','3','200000d','Phong doi')");

        String Tang4 = "CREATE TABLE TANG4 (id integer primary key autoincrement, sophong text, sotang text, giaphing text, hangphong text)";
        db.execSQL(Tang4);
        db.execSQL("INSERT INTO TANG4 VALUES (1,'301','4','200000d','Phong doi')," +
                "(2,'402','4','100000d','Phong don')," +
                "(3,'403','4','200000d','Phong doi')," +
                "(4,'404','4','100000d','Phong don')," +
                "(5,'405','4','200000d','Phong doi')," +
                "(6,'406','4','200000d','Phong doi')," +
                "(7,'407','4','100000d','Phong don')," +
                "(8,'408','4','200000d','Phong doi')," +
                "(9,'409','4','100000d','Phong don')," +
                "(10,'410','4','200000d','Phong doi')");



        String DatPhong = "CREATE TABLE DATPHONG (id integer primary key autoincrement, sophong text, sotang text, giaphing text, hangphong text)";
        db.execSQL(DatPhong);
        db.execSQL("INSERT INTO DATPHONG VALUES (1,'301','4','200000d','Phong doi')," +
                "(2,'402','4','100000d','Phong don')," +
                "(3,'403','4','200000d','Phong doi')," +
                "(4,'404','4','100000d','Phong don')," +
                "(5,'405','4','200000d','Phong doi')," +
                "(6,'406','4','200000d','Phong doi')," +
                "(7,'407','4','100000d','Phong don')," +
                "(8,'408','4','200000d','Phong doi')," +
                "(9,'409','4','100000d','Phong don')," +
                "(10,'301','4','200000d','Phong doi')," +
                "(11,'302','3','100000d','Phong don')," +
                "(12,'303','3','200000d','Phong doi')," +
                "(13,'304','3','100000d','Phong don')," +
                "(14,'305','3','200000d','Phong doi')," +
                "(15,'306','3','200000d','Phong doi')," +
                "(16,'307','3','100000d','Phong don')," +
                "(17,'308','3','200000d','Phong doi')," +
                "(18,'309','3','100000d','Phong don')," +
                "(19,'202','2','100000d','Phong don')," +
                "(20,'203','2','200000d','Phong doi')," +
                "(21,'204','2','100000d','Phong don')," +
                "(22,'205','2','200000d','Phong doi')," +
                "(23,'206','2','200000d','Phong doi')," +
                "(24,'207','2','100000d','Phong don')," +
                "(25,'208','2','200000d','Phong doi')," +
                "(26,'209','2','100000d','Phong don')," +
                "(27,'210','2','200000d','Phong doi'),"+
                "(28,'102','1','100000d','Phong don')," +
                "(29,'103','1','100000d','Phong don')," +
                "(30,'410','4','200000d','Phong doi')");




        String quanlykhachhang = "CREATE TABLE QLKH (STT integer primary key autoincrement, TEN text, TUOI integer, GIOITINH text,  SODT integer," +
                " QUEQUAN text, CANCUOC integer,SOLANDP integer)";
        db.execSQL(quanlykhachhang);
        db.execSQL("INSERT INTO QLKH VALUES (1,'dinhlinh',19,'nam',0971222222,'hà nam',12345, 2)" );


        String quanlyphong = "CREATE TABLE QLP (SOPHONG integer primary key autoincrement, TEN_QLP text, SOGIO_QLP integer, DONGIA_QLP integer,  DICHVUK_QLP integer," +
                " DATCOC_QLP integer, INHOAD_QLP text)";
        db.execSQL(quanlyphong);
        db.execSQL("INSERT INTO QLP VALUES (101,'dinhlinh',8,1000000,100000,300000, 'Đây là hóa đơn')" );




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1){
            db.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
            db.execSQL("DROP TABLE IF EXISTS QLKH");
            db.execSQL("DROP TABLE IF EXISTS QLP");
            db.execSQL("DROP TABLE IF EXISTS TANG1");
            db.execSQL("DROP TABLE IF EXISTS TANG2");
            db.execSQL("DROP TABLE IF EXISTS TANG3");
            db.execSQL("DROP TABLE IF EXISTS TANG4");
            db.execSQL("DROP TABLE IF EXISTS DATPHONG");

            onCreate(db);
        }

    }
}
