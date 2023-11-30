package com.example.quanlikhachsan_nhom5.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.dao.QuanLyPDAO;
import com.example.quanlikhachsan_nhom5.model.QuanLyP;
import com.example.quanlikhachsan_nhom5.Adapter.QuanLyPAdapter;

import java.util.ArrayList;

public class qlphong_frag extends Fragment {

    private RecyclerView recyclerView;
    private QuanLyPAdapter adapter;
    private ArrayList<QuanLyP> quanLyPList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_qlphong_frag,container,false);

        quanLyPList = new ArrayList<>();
        setupRecyclerView(view);

        QuanLyPDAO dao = new QuanLyPDAO(this.getContext());
        ArrayList<QuanLyP> dataFromDb = dao.getAllQuanLyP(); // Lấy dữ liệu
        if (dataFromDb != null) {
            quanLyPList.addAll(dataFromDb); // Thêm vào quanLyPList
            Log.d("DEBUG", "Số lượng bản ghi: " + quanLyPList.size());
        }
        adapter.notifyDataSetChanged();
        return view;
    }

    private void setupRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyclerqlp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new QuanLyPAdapter(this.getContext(), quanLyPList);
        recyclerView.setAdapter(adapter);
    }
}
