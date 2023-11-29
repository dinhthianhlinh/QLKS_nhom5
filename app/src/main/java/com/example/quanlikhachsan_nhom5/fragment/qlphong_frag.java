package com.example.quanlikhachsan_nhom5.fragment;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlikhachsan_nhom5.R;

public class qlphong_frag extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_qlp);

        // Tìm kiếm các TextView trong layout
        TextView txttenkhnv = findViewById(R.id.txttenkhnv);
        TextView txtsodienthoaikhnv = findViewById(R.id.txtsodienthoaikhnv);
        TextView txtemailkhnv = findViewById(R.id.txtemailkhnv);
        TextView txtsoluongnguoikhnv = findViewById(R.id.txtsoluongnguoikhnv);
        TextView txtcheckinkhnv = findViewById(R.id.txtcheckinkhnv);
        TextView txtcheckoutkhnv = findViewById(R.id.txtcheckoutkhnv);
        TextView txttongtienkhnv = findViewById(R.id.txttongtienkhnv);
        TextView txtthongtinthanhtoankhnv = findViewById(R.id.txtthongtinthanhtoankhnv);

        // Nhận dữ liệu từ Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("NAME", "");
            String phone = extras.getString("PHONE", "");
            String email = extras.getString("EMAIL", "");
            String numPeople = extras.getString("NUM_PEOPLE", "");
            String checkIn = extras.getString("CHECK_IN", "");
            String checkOut = extras.getString("CHECK_OUT", "");
            String totalAmount = extras.getString("TOTAL_AMOUNT", "");
            String paymentInfo = extras.getString("PAYMENT_INFO", "");

            // Cập nhật giao diện với dữ liệu nhận được
            txttenkhnv.setText(name);
            txtsodienthoaikhnv.setText(phone);
            txtemailkhnv.setText(email);
            txtsoluongnguoikhnv.setText(numPeople);
            txtcheckinkhnv.setText(checkIn);
            txtcheckoutkhnv.setText(checkOut);
            txttongtienkhnv.setText(totalAmount);
            txtthongtinthanhtoankhnv.setText(paymentInfo);
        }
    }
}
