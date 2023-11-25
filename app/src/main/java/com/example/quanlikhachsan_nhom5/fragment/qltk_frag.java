package com.example.quanlikhachsan_nhom5.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.quanlikhachsan_nhom5.DanhSachtk;
import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.TaoTaiKhoan;

public class qltk_frag extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_qltk_frag,container,false);


        LinearLayout lineartaotaikhoan = view.findViewById(R.id.lineartaotaikhoan);
        LinearLayout lineardanhsach = view.findViewById(R.id.lineardanhsach);


        lineartaotaikhoan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getContext(), TaoTaiKhoan.class);
                startActivity(intent);
            }
        });
        lineardanhsach.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getContext(), DanhSachtk.class);
                startActivity(intent);
            }
        });


        return view;
    }

}