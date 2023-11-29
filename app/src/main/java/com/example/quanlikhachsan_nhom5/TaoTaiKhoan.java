package com.example.quanlikhachsan_nhom5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlikhachsan_nhom5.dao.NguoiDungDao;
import com.example.quanlikhachsan_nhom5.model.NguoiDung;

public class TaoTaiKhoan extends AppCompatActivity {
    NguoiDungDao nguoiDungDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tao_tai_khoan);

        EditText User = findViewById(R.id.tuserdk);
        EditText Pass = findViewById(R.id.tpassdk);
        EditText Passnl = findViewById(R.id.tpassnhaplai);
        EditText Tendk = findViewById(R.id.ttendk);
        EditText Phone = findViewById(R.id.tsdtdk);

        EditText Que = findViewById(R.id.tdiatri);
        EditText linkAvata = findViewById(R.id.linkAvata);

        Button btnDK = findViewById(R.id.tbtndk);
        nguoiDungDao = new NguoiDungDao(this);

        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pass = Pass.getText().toString();
                String passnl = Passnl.getText().toString();
                if (!pass.equals(passnl)){
                    Toast.makeText(TaoTaiKhoan.this, "mật khâu không chùng nhau", Toast.LENGTH_SHORT).show();

                }else {

                    String user = User.getText().toString();
                    String tendk = Tendk.getText().toString();
                    String phone = Phone.getText().toString();
                    String que = Que.getText().toString();
                    String linkAVT = linkAvata.getText().toString();

                    NguoiDung nguoiDung = new NguoiDung(tendk,phone,que,user,pass, linkAVT);

                    boolean check = nguoiDungDao.TaoTaikhoan(nguoiDung);
                    if (check){
                        Toast.makeText(TaoTaiKhoan.this, "dang ki thanh cong", Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(TaoTaiKhoan.this, "dang ki that bai", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


    }
}