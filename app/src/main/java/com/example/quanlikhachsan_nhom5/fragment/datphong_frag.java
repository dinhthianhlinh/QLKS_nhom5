package com.example.quanlikhachsan_nhom5.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlikhachsan_nhom5.Adapter.DatPhongAdapter;
import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.dao.DatPhongDao;
import com.example.quanlikhachsan_nhom5.model.DatPhong;

import java.util.ArrayList;

public class datphong_frag extends AppCompatActivity {
    private DatPhongAdapter datPhongAdapter;
    private DatPhongDao datPhongDao;
    private ArrayList<DatPhong> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datphong_frag);

        RecyclerView recyclerView = findViewById(R.id.Rcvdp);
        datPhongDao = new DatPhongDao(this);
        list = datPhongDao.getDSDatPhong();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        datPhongAdapter = new DatPhongAdapter(this, list);

        datPhongAdapter.setOnItemClickedListener(datPhong -> {
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_qlp);
            EditText editTextRoomNumber = dialog.findViewById(R.id.editTextRoomNumber);
            editTextRoomNumber.setText(datPhong.getSophong());

            // Điều chỉnh kích thước dialog
            Window window = dialog.getWindow();
            if (window != null) {
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT; // Đặt chiều rộng tối đa
                layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT; // Chiều cao tự điều chỉnh
                window.setAttributes(layoutParams);
            }

            dialog.show();
        });

        recyclerView.setAdapter(datPhongAdapter);
    }
}
