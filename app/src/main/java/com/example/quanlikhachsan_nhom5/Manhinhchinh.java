package com.example.quanlikhachsan_nhom5;

import static com.example.quanlikhachsan_nhom5.R.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.quanlikhachsan_nhom5.fragment.QuanLiPhanHoi;
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
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class Manhinhchinh extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;
    ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(layout.activity_manhinhchinh);

        Toolbar toolbar = findViewById(id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        bottomNavigationView = findViewById(id.navigationbottom);


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
                FragmentManager fragmentManager = getSupportFragmentManager();
                if (item.getItemId() == id.qltk) {
                    toolbar.setTitle("QUẢN LÍ TÀI KHOẢN");
                    Fragment fragment = new qltk_frag();
                    fragmentManager.beginTransaction().replace(id.fragmentlayout, fragment).commit();

                } else if (item.getItemId() == id.qlkh) {
                    toolbar.setTitle("QUẢN LÍ Khách hang");
                    Fragment fragment = new qlkh_frag();
                    fragmentManager.beginTransaction().replace(id.fragmentlayout, fragment).commit();

                } else if (item.getItemId() == id.qlphong) {
                    toolbar.setTitle("QUẢN LÍ PHÒNG");
                    Fragment fragment = new qlphong_frag();
                    fragmentManager.beginTransaction().replace(id.fragmentlayout, fragment).commit();

                } else if (item.getItemId() == id.qlttang) {
                    toolbar.setTitle("QUẢN LÍ TẦNG");
                    Fragment fragment = new qltang_frag();
                    fragmentManager.beginTransaction().replace(id.fragmentlayout, fragment).commit();
                } else if (item.getItemId() == id.checkin) {
                    toolbar.setTitle("CHECK-IN");
                    Fragment fragment = new check_in_frag();
                    fragmentManager.beginTransaction().replace(id.fragmentlayout, fragment).commit();
                } else if (item.getItemId() == id.checkout) {
                    toolbar.setTitle("CHECK-OUT");
                    Fragment fragment = new check_out_frag();
                    fragmentManager.beginTransaction().replace(id.fragmentlayout, fragment).commit();
                } else if (item.getItemId() == id.dichvuphong) {
                    toolbar.setTitle("DỊCH VỤ PHÒNG");
                    Fragment fragment = new dichvuphong_frag();
                    fragmentManager.beginTransaction().replace(id.fragmentlayout, fragment).commit();
                } else if (item.getItemId() == id.datphong) {
                    toolbar.setTitle("ĐẶT PHÒNG");
                    Fragment fragment = new datphong_frag();
                    fragmentManager.beginTransaction().replace(id.fragmentlayout, fragment).commit();

                } else if (item.getItemId() == id.phanhoikh) {
                    toolbar.setTitle("PHẢN HỒI CỦA KHÁCH HÀNG");
                    Fragment fragment = new phanhoikh_frag();
                    fragmentManager.beginTransaction().replace(id.fragmentlayout, fragment).commit();

                } else if (item.getItemId() == id.phanhoinv) {
                    toolbar.setTitle("PHẢN HỒI CỦA NHÂN VIÊN");
                    Fragment fragment = new phanhoinv_frag();
                    fragmentManager.beginTransaction().replace(id.fragmentlayout, fragment).commit();

                } else if (item.getItemId() == id.qlphoi) {
                    toolbar.setTitle("QUẢN LÍ PHẢN HỒI");
                    startActivity(new Intent(Manhinhchinh.this, QuanLiPhanHoi.class));

                } else if (item.getItemId() == id.thongke) {
                    toolbar.setTitle("THỐNG KÊ");
                    Fragment fragment = new thongke_frag();
                    fragmentManager.beginTransaction().replace(id.fragmentlayout, fragment).commit();
                } else {
                    toolbar.setTitle("BÁO CÁO ");
                    Fragment fragment = new baocao_frag();
                    fragmentManager.beginTransaction().replace(id.fragmentlayout, fragment).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                setTitle(item.getTitle());
                return false;
            }
        });
        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                if (item.getItemId() == id.chat) {
                    startActivity(new Intent(Manhinhchinh.this, Login.class));

                } else if (item.getItemId() == id.map) {
                    startActivity(new Intent(Manhinhchinh.this, Manhinhchinh.class));

                } else {
                    startActivity(new Intent(Manhinhchinh.this, ThongTinCaNhan.class));
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                setTitle(item.getTitle());
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
                menu.findItem(id.qlphoi).setVisible(false);
                menu.findItem(id.checkin).setVisible(false);
                menu.findItem(id.checkout).setVisible(false);
                menu.findItem(id.qlphong).setVisible(false);
                break;
            case 2:
                Menu menu2 = navigationView.getMenu();
                menu2.findItem(id.qltk).setVisible(false);
                menu2.findItem(id.qlkh).setVisible(false);
                menu2.findItem(id.phanhoikh).setVisible(false);
                menu2.findItem(id.dichvuphong).setVisible(false);
                menu2.findItem(id.thongke).setVisible(false);
                menu2.findItem(id.baocao).setVisible(false);
                menu2.findItem(id.qlphoi).setVisible(false);
                break;
            case 3:
                Menu menu3 = navigationView.getMenu();
                menu3.findItem(id.dichvuphong).setVisible(false);
                menu3.findItem(id.phanhoinv).setVisible(false);
                menu3.findItem(id.phanhoikh).setVisible(false);
                menu3.findItem(id.qlttang).setVisible(false);
                menu3.findItem(id.datphong).setVisible(false);
                menu3.findItem(id.checkout).setVisible(false);
                menu3.findItem(id.checkin).setVisible(false);
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
                menu4.findItem(id.qlphoi).setVisible(false);
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