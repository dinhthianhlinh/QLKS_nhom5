package com.example.quanlikhachsan_nhom5.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.tang.QlTang1;
import com.example.quanlikhachsan_nhom5.tang.Tang2;
import com.example.quanlikhachsan_nhom5.tang.Tang3;
import com.example.quanlikhachsan_nhom5.tang.Tang4;

public class qltang_frag extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.qltang_frag, container, false);

        // Ánh xạ các nút từ layout
        Button btnTang1 = view.findViewById(R.id.btnTang1);
        Button btnTang2 = view.findViewById(R.id.btnTang2);
        Button btnTang3 = view.findViewById(R.id.btnTang3);
        Button btnTang4 = view.findViewById(R.id.btnTang4);

        // Thiết lập sự kiện onClick cho từng nút
        btnTang1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), QlTang1.class);

                // Kiểm tra và gọi startActivity chỉ nếu activity QlTang1 tồn tại
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }

            }
        });

        btnTang2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Tang2.class);

                // Kiểm tra và gọi startActivity chỉ nếu activity QlTang1 tồn tại
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        btnTang3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Tang3.class);

                // Kiểm tra và gọi startActivity chỉ nếu activity QlTang1 tồn tại
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        btnTang4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Tang4.class);

                // Kiểm tra và gọi startActivity chỉ nếu activity QlTang1 tồn tại
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        return view;
    }
}
