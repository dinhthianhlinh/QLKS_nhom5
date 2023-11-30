package com.example.quanlikhachsan_nhom5.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.quanlidichvu.BaoThuc;
import com.example.quanlikhachsan_nhom5.quanlidichvu.DatDoAn;
import com.example.quanlikhachsan_nhom5.quanlidichvu.GiatUi;

public class dichvuphong_frag extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dichvuphong_frag,container,false);


        LinearLayout lineardda = view.findViewById(R.id.dichvudoan);
        LinearLayout linearbaothuc =  view.findViewById(R.id.dichvubaothuc);
        LinearLayout lineargiatdo = view.findViewById(R.id.dichvudatui);

        lineardda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dichvuphong_frag.this.getContext(), DatDoAn.class));
            }
        });
        linearbaothuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dichvuphong_frag.this.getContext(), BaoThuc.class));
            }
        });
        lineargiatdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dichvuphong_frag.this.getContext(), GiatUi.class));
            }
        });
    return view;

    }

}
