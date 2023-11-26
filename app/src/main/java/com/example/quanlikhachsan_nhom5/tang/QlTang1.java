package com.example.quanlikhachsan_nhom5.tang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quanlikhachsan_nhom5.Adapter.Tang1Adapter;
import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.dao.Tang1Dao;
import com.example.quanlikhachsan_nhom5.model.Tang1;

import java.util.ArrayList;

public class QlTang1 extends AppCompatActivity {
    private Tang1Dao tang1Dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ql_tang1);

        RecyclerView recyclerViewTang1 = findViewById(R.id.rcvTang1);


        tang1Dao = new Tang1Dao(this);


        ArrayList<Tang1> list = tang1Dao.getDSTang1();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewTang1.setLayoutManager(linearLayoutManager);
        Tang1Adapter tang1Adapter = new Tang1Adapter(this,list);
        recyclerViewTang1.setAdapter(tang1Adapter);




    }
}