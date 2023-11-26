package com.example.quanlikhachsan_nhom5.tang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quanlikhachsan_nhom5.Adapter.Tang2Adapter;
import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.dao.Tang2Dao;

import java.util.ArrayList;

public class Tang2 extends AppCompatActivity {
    private Tang2Dao tang2Dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tang2);


        RecyclerView recyclerViewTang2 = findViewById(R.id.rcvTang2);

        tang2Dao = new Tang2Dao(this);


        ArrayList<com.example.quanlikhachsan_nhom5.model.Tang2> list = tang2Dao.getDSTang2s();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewTang2.setLayoutManager(linearLayoutManager);
        Tang2Adapter tang2Adapter = new Tang2Adapter(this,list);
        recyclerViewTang2.setAdapter(tang2Adapter);



    }
}