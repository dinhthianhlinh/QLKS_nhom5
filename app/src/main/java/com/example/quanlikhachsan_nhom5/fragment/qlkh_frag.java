package com.example.quanlikhachsan_nhom5.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlikhachsan_nhom5.Adapter.QuanLyKHAdapter;
import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.dao.QuanLyKHDAO;
import com.example.quanlikhachsan_nhom5.model.QuanLyKH;

import java.util.ArrayList;

public class qlkh_frag extends Fragment {
    RecyclerView rcQLKH;
    QuanLyKHAdapter adapter;
    QuanLyKHDAO quanLyKHDAO;

    private ArrayList<QuanLyKH> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.qlkh_frag, container, false);

        rcQLKH = view.findViewById(R.id.rcqlKH);
        quanLyKHDAO = new QuanLyKHDAO(requireContext()); // Sử dụng requireContext() thay vì this
        list = quanLyKHDAO.getAllData();

        // Sử dụng requireContext() thay vì this
        GridLayoutManager layout = new GridLayoutManager(requireContext(), 1);
        rcQLKH.setLayoutManager(layout);

        // Sử dụng requireContext() thay vì this
        adapter = new QuanLyKHAdapter(requireContext(), list);
        rcQLKH.setAdapter(adapter);

        return view;
    }
}
