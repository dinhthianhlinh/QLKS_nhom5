package com.example.quanlikhachsan_nhom5.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.model.DatPhong;
import com.google.gson.Gson;

public class ChiTietActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        String datPhongJson = getIntent().getStringExtra("datPhongJson");
        Gson gson = new Gson();
        DatPhong datPhong = gson.fromJson(datPhongJson, DatPhong.class);

        if (datPhong != null) {
            TextView txtSoPhongChiTiet = findViewById(R.id.txtSoPhongChiTiet);
            TextView txtSoTangChiTiet = findViewById(R.id.txtSoTangChiTiet);
            TextView txtThanhToanChiTiet = findViewById(R.id.txtThanhToanChiTiet);

            txtSoPhongChiTiet.setText(datPhong.getSophong());
            txtSoTangChiTiet.setText(datPhong.getSotang());
            txtThanhToanChiTiet.setText(datPhong.getGiaphong());
        }

        Button btnDatPhongChiTiet = findViewById(R.id.btnDatphongChiTiet);
        btnDatPhongChiTiet.setOnClickListener(new View.OnClickListener() {
            FragmentManager fragmentManager = getSupportFragmentManager();
            @Override
            public void onClick(View v) {

                Fragment fragment = new datphong_frag();

                fragmentManager.beginTransaction().replace(R.id.fragmentlayout, fragment).commit();

            }
        });
    }


}
