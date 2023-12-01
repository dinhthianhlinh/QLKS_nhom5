package com.example.quanlikhachsan_nhom5.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
    private SharedPreferences sharedPreferences;
    private QuanLyPDAO quanLyPDAO;

    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_qlphong_frag, container, false);

        quanLyPList = new ArrayList<>();
        setupRecyclerView(view);

        QuanLyPDAO dao = new QuanLyPDAO(this.getContext());
        ArrayList<QuanLyP> dataFromDb = dao.getAllQuanLyP(); // Lấy dữ liệu
        if (dataFromDb != null) {
            quanLyPList.addAll(dataFromDb); // Thêm vào quanLyPList
            Log.d("DEBUG", "Số lượng bản ghi: " + quanLyPList.size());
        }
        adapter.notifyDataSetChanged();

        // Khôi phục trạng thái ẩn từ SharedPreferences
        restoreHiddenStates();

        return view;
    }

    private void setupRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyclerqlp);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new QuanLyPAdapter(getContext(), quanLyPList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListner(new QuanLyPAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (position >= 0 && position < quanLyPList.size()) {
                    QuanLyP quanLyP = quanLyPList.get(position);
                    quanLyPList.remove(position); // Loại bỏ mục khỏi danh sách

                    // Cập nhật lại RecyclerView sau khi loại bỏ mục
                    adapter.notifyItemRemoved(position);
                    adapter.notifyItemRangeChanged(position, quanLyPList.size());

                    // Lưu trạng thái ẩn mới vào SharedPreferences
                    saveHiddenState(position, true);

                }
            }
        });
    }

    private void restoreHiddenStates() {
        SharedPreferences preferences = getContext().getSharedPreferences("hidden_states", Context.MODE_PRIVATE);
        for (int i = 0; i < quanLyPList.size(); i++) {
            boolean isHidden = preferences.getBoolean("item_" + i, false);
            quanLyPList.get(i).setVisible(!isHidden);
        }
    }

    private void saveHiddenState(int position, boolean isHidden) {
        SharedPreferences preferences = getContext().getSharedPreferences("hidden_states", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("item_" + position, isHidden);
        editor.apply();
    }
}
