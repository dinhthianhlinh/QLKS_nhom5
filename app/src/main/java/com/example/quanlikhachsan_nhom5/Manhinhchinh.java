package com.example.quanlikhachsan_nhom5;

import static com.example.quanlikhachsan_nhom5.R.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.quanlikhachsan_nhom5.fragment.baocao_frag;
import com.example.quanlikhachsan_nhom5.fragment.check_in_frag;
import com.example.quanlikhachsan_nhom5.fragment.check_out_frag;
import com.example.quanlikhachsan_nhom5.fragment.datphong_frag;
import com.example.quanlikhachsan_nhom5.fragment.dichvuphong_frag;
import com.example.quanlikhachsan_nhom5.fragment.phanhoikh_frag;
import com.example.quanlikhachsan_nhom5.fragment.phanhoinv_frag;
import com.example.quanlikhachsan_nhom5.fragment.qlkh_frag;
import com.example.quanlikhachsan_nhom5.fragment.qlphong_frag;
import com.example.quanlikhachsan_nhom5.fragment.qltang_frag;
import com.example.quanlikhachsan_nhom5.fragment.qltk_frag;
import com.example.quanlikhachsan_nhom5.fragment.thongke_frag;
import com.google.android.material.navigation.NavigationView;

public class Manhinhchinh extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_manhinhchinh);

        Toolbar toolbar = findViewById(id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = findViewById(id.drawerlayout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(id.navigation);
//        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open, string.close);
//        drawerLayout.addDrawerListener(drawerToggle);
//        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                if (item.getItemId() == id.qltk) {
                    toolbar.setTitle("QUẢN LÍ TÀI KHOẢN");
                    fragment = new qltk_frag();

                } else if (item.getItemId() == id.qlkh) {
                    toolbar.setTitle("QUẢN LÍ KHÁCH HÀNG");
                    fragment = new qlkh_frag();

                } else if (item.getItemId() == id.qlphong) {
                    toolbar.setTitle("QUẢN LÍ PHÒNG");
                    fragment = new qlphong_frag();

                } else if (item.getItemId() == id.qlttang) {
                    toolbar.setTitle("QUẢN LÍ TẦNG");
                    fragment = new qltang_frag();

                } else if (item.getItemId() == id.phanhoikh) {
                    toolbar.setTitle("PHẢN HỒI CỦA KHÁCH HÀNG");
                    fragment = new phanhoikh_frag();

                } else if (item.getItemId() == id.phanhoinv) {
                    toolbar.setTitle("PHẢN HỒI CỦA NHÂN VIÊN");
                    fragment = new phanhoinv_frag();


                } else if (item.getItemId() == id.checkin) {
                    toolbar.setTitle("CHECK-IN");
                    fragment = new check_in_frag();

                } else if (item.getItemId() == id.checkout) {
                    toolbar.setTitle("CHECK-OUT");
                    fragment = new check_out_frag();

                } else if (item.getItemId() == id.dichvuphong) {
                    toolbar.setTitle("DỊCH VỤ PHÒNG");
                    fragment = new dichvuphong_frag();

                } else if (item.getItemId() == id.datphong) {
                    toolbar.setTitle("ĐẶT PHÒNG");
                    fragment = new datphong_frag();

                } else if (item.getItemId() == id.thongke) {
                    toolbar.setTitle("THỐNG KÊ");
                    fragment = new thongke_frag();

                } else {
                    toolbar.setTitle("BÁO CÁO ");
                    fragment = new baocao_frag();

                }
                getSupportFragmentManager().beginTransaction().replace(id.fragmentlayout, fragment).commit();
                drawerLayout.close();

                return true;
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("dataUser", MODE_PRIVATE);
        int role = sharedPreferences.getInt("role", -1);
        switch (role) {
            case 1:
                Menu menu = navigationView.getMenu();
                menu.findItem(id.qltk).setVisible(false);
                menu.findItem(id.qlkh).setVisible(false);
                menu.findItem(id.qlttang).setVisible(false);
                menu.findItem(id.thongke).setVisible(false);
                menu.findItem(id.baocao).setVisible(false);
                menu.findItem(id.phanhoinv).setVisible(false);
                break;
            case 2:
                Menu menu2 = navigationView.getMenu();
                menu2.findItem(id.qltk).setVisible(false);
                menu2.findItem(id.qlkh).setVisible(false);
                menu2.findItem(id.phanhoikh).setVisible(false);
                menu2.findItem(id.dichvuphong).setVisible(false);
                menu2.findItem(id.thongke).setVisible(false);
                menu2.findItem(id.baocao).setVisible(false);
                break;
            case 3:
                Menu menu3 = navigationView.getMenu();
                menu3.findItem(id.dichvuphong).setVisible(false);
                break;

            default:
                Menu menu4 = navigationView.getMenu();
                menu4.findItem(id.qltk).setVisible(false);
                menu4.findItem(id.qlkh).setVisible(false);
                menu4.findItem(id.qlttang).setVisible(false);
                menu4.findItem(id.thongke).setVisible(false);
                menu4.findItem(id.baocao).setVisible(false);
                menu4.findItem(id.phanhoinv).setVisible(false);
                menu4.findItem(id.dichvuphong).setVisible(false);
                break;
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}