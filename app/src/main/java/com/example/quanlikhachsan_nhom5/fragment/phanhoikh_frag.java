package com.example.quanlikhachsan_nhom5.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.quanlikhachsan_nhom5.R;

public class phanhoikh_frag extends Fragment {
    EditText edtmass, edtcall;
    Button btnmass, btncall;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.phanhoikh_frag,container,false);

        btnmass = view.findViewById(R.id.btnmess);
        edtmass = view.findViewById(R.id.edtmess);
        btncall = view.findViewById(R.id.btncall);
        edtcall = view.findViewById(R.id.edtcall);

        btnmass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent messintent = new Intent(Intent.ACTION_SENDTO,
                        Uri.parse("smsto:"+edtmass.getText().toString()));
                startActivity(messintent);
            }
        });
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callintent = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:"+edtcall.getText().toString()));
// Yêu cầu người dùng đồng ý quyền truy cập vào tính năng gọi điện
                if (ActivityCompat.checkSelfPermission(phanhoikh_frag.this.getContext(),
                        android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(phanhoikh_frag.this.getActivity(), new
                            String[]{android.Manifest.permission.CALL_PHONE},1);
                    return;
                }
                startActivity(callintent);
            }
        });
        return view;

    }

}
