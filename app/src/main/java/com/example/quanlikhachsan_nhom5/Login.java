package com.example.quanlikhachsan_nhom5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.quanlikhachsan_nhom5.dao.NguoiDungDao;

public class Login extends AppCompatActivity {
    private NguoiDungDao nguoiDungDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        EditText edtUser = findViewById(R.id.edtUser);
        EditText edtPass = findViewById(R.id.edtPass);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnDangki = findViewById(R.id.btnDangKi);

        nguoiDungDao = new NguoiDungDao(this);


        btnDangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();


                boolean check = nguoiDungDao.KiemTraDangNhap(user, pass);
                if (check) {
                    startActivity(new Intent(Login.this, Manhinhchinh.class));

                } else {
                    Toast.makeText(Login.this, "ten dang nhap hoac mat khau sai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}