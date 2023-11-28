package com.example.quanlikhachsan_nhom5.fragment;

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
import com.example.quanlikhachsan_nhom5.Adapter.QuanLyPAdapter;
import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.dao.QuanLyKHDAO;
import com.example.quanlikhachsan_nhom5.dao.QuanLyPDAO;
import com.example.quanlikhachsan_nhom5.model.QuanLyP;

import java.util.ArrayList;

public class qlphong_frag extends Fragment {

    RecyclerView rcqlp;
    QuanLyP quanLyP;
    QuanLyPDAO quanLyPDAO;

    QuanLyPAdapter quanLyPAdapter;

    private ArrayList<QuanLyP> list = new ArrayList<QuanLyP>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.qlphong_frag,container,false);


        return view;

    }

}
