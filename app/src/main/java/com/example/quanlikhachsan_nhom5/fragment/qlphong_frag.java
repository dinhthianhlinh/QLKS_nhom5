package com.example.quanlikhachsan_nhom5.fragment;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.dao.QuanLyPDAO;
import com.example.quanlikhachsan_nhom5.model.QuanLyP;
import com.example.quanlikhachsan_nhom5.Adapter.QuanLyPAdapter;

import java.util.ArrayList;

public class qlphong_frag extends AppCompatActivity {

    private RecyclerView recyclerView;
    private QuanLyPAdapter adapter;
    private ArrayList<QuanLyP> quanLyPList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlphong_frag);
        quanLyPList = new ArrayList<>();
        setupRecyclerView();

        QuanLyPDAO dao = new QuanLyPDAO(this);
        ArrayList<QuanLyP> dataFromDb = dao.getAllQuanLyP(); // Lấy dữ liệu
        if (dataFromDb != null) {
            quanLyPList.addAll(dataFromDb); // Thêm vào quanLyPList
            Log.d("DEBUG", "Số lượng bản ghi: " + quanLyPList.size());
        }
        adapter.notifyDataSetChanged();
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerqlp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new QuanLyPAdapter(this, quanLyPList);
        recyclerView.setAdapter(adapter);
    }
}
