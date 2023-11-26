package com.example.quanlikhachsan_nhom5.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.quanlikhachsan_nhom5.Adapter.DatPhongAdapter;
import com.example.quanlikhachsan_nhom5.Adapter.Tang1Adapter;
import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.dao.DatPhongDao;
import com.example.quanlikhachsan_nhom5.dao.Tang1Dao;
import com.example.quanlikhachsan_nhom5.model.DatPhong;
import com.example.quanlikhachsan_nhom5.model.Tang1;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class datphong_frag extends AppCompatActivity {
    private DatPhongAdapter datPhongAdapter;
    private DatPhongDao datPhongDao;
    private ArrayList<DatPhong> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datphong_frag);

        RecyclerView recyclerViewQLTK = findViewById(R.id.Rcvdp);

        datPhongDao = new DatPhongDao(this);
        list = datPhongDao.getDSDatPhong();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerViewQLTK.setLayoutManager(gridLayoutManager);
        datPhongAdapter = new DatPhongAdapter(this, list,this);
        recyclerViewQLTK.setAdapter(datPhongAdapter);

    }
}
