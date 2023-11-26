package com.example.quanlikhachsan_nhom5.tang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quanlikhachsan_nhom5.Adapter.Tang3Adapter;
import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.dao.Tang3Dao;

import java.util.ArrayList;

public class Tang3 extends AppCompatActivity {
    private Tang3Dao tang3Dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tang3);



        RecyclerView recyclerViewTang3 = findViewById(R.id.rcvTang3);

        tang3Dao = new Tang3Dao(this);


        ArrayList<com.example.quanlikhachsan_nhom5.model.Tang3> list = tang3Dao.getDSTang3s();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewTang3.setLayoutManager(linearLayoutManager);
        Tang3Adapter tang3Adapter = new Tang3Adapter(this,list);
        recyclerViewTang3.setAdapter(tang3Adapter);




    }
}