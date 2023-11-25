package com.example.quanlikhachsan_nhom5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlikhachsan_nhom5.dao.NguoiDungDao;
import com.example.quanlikhachsan_nhom5.model.NguoiDung;

public class Register extends AppCompatActivity {
    private NguoiDungDao nguoiDungDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText User = findViewById(R.id.userdk);
        EditText Pass = findViewById(R.id.passdk);
        EditText Passnl = findViewById(R.id.passnhaplai);
        EditText Tendk = findViewById(R.id.tendk);
        EditText Phone = findViewById(R.id.sdtdk);

        EditText Que = findViewById(R.id.diatri);

        Button btnDK = findViewById(R.id.btndk);
        nguoiDungDao = new NguoiDungDao(this);

        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pass = Pass.getText().toString();
                String passnl = Passnl.getText().toString();
                if (!pass.equals(passnl)){
                    Toast.makeText(Register.this, "mật khâu không chùng nhau", Toast.LENGTH_SHORT).show();

                }else {
                    String user = User.getText().toString();
                    String tendk = Tendk.getText().toString();
                    String phone = Phone.getText().toString();

                    String que = Que.getText().toString();

                    NguoiDung nguoiDung = new NguoiDung(tendk,phone,que,user,pass);

                    boolean check = nguoiDungDao.dangkyTaikhoan(nguoiDung);
                    if (check){
                        Toast.makeText(Register.this, "dang ki thanh cong", Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(Register.this, "dang ki that bai", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }
}