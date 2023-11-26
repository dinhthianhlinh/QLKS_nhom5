package com.example.quanlikhachsan_nhom5.tang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quanlikhachsan_nhom5.Adapter.Tang4Adapter;
import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.dao.Tang4Dao;

import java.util.ArrayList;

public class Tang4 extends AppCompatActivity {
    private Tang4Dao tang4Dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tang4);


        RecyclerView recyclerViewTang4 = findViewById(R.id.rcvTang4);

        tang4Dao = new Tang4Dao(this);


        ArrayList<com.example.quanlikhachsan_nhom5.model.Tang4> list = tang4Dao.getDSTang4s();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewTang4.setLayoutManager(linearLayoutManager);
        Tang4Adapter tang4Adapter = new Tang4Adapter(this,list);
        recyclerViewTang4.setAdapter(tang4Adapter);





    }
}