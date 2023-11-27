package com.example.quanlikhachsan_nhom5.fragment;

import android.content.Intent;
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

public class phanhoikh_frag extends AppCompatActivity {
    EditText edtmass;
    Button btnmass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phanhoikh_frag);
        btnmass = findViewById(R.id.btnmess);
        edtmass = findViewById(R.id.edtmess);


        btnmass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callintent = new Intent(Intent.ACTION_SENDTO,
                        Uri.parse("smsto:"+edtmass.getText().toString()));
                startActivity(callintent);
            }
        });

    }

}
