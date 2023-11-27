package com.example.quanlikhachsan_nhom5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quanlikhachsan_nhom5.Adapter.DanhSachTKAdapter;
import com.example.quanlikhachsan_nhom5.dao.NguoiDungDao;
import com.example.quanlikhachsan_nhom5.model.NguoiDung;

import java.util.ArrayList;

public class DanhSachtk extends AppCompatActivity {

    RecyclerView rcDSTK;
    DanhSachTKAdapter adapter;
    NguoiDungDao nguoiDungDao;

    private ArrayList<NguoiDung> list = new ArrayList<NguoiDung>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sachtk);

        rcDSTK = findViewById(R.id.rc_DSTK);
        nguoiDungDao = new NguoiDungDao(this);
        list = nguoiDungDao.getAllData();
        GridLayoutManager layout = new GridLayoutManager(this, 1);
        rcDSTK.setLayoutManager(layout);
        adapter = new DanhSachTKAdapter(this, list);
        rcDSTK.setAdapter(adapter);

    }
}