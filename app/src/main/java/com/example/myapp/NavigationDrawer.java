package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class NavigationDrawer extends AppCompatActivity {
    DrawerLayout drawlayout;
    Toolbar toolbar;
    private Fragment currentFrag;
    private Fragment fraghome;
    private Fragment fragsetting;
    private Fragment fragmenu;

    private NavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nav = findViewById(R.id.nav_view);
        //nav.setItemIconTintList(null);
        drawlayout = findViewById(R.id.drawerlayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this, drawlayout, toolbar, R.string.open,
                        R.string.close);
        drawlayout.addDrawerListener(toggle);
        toggle.syncState();//dược sử dụng để đồng bộ hóa trạng thái của Drawer với ActionBar.


        //khi click vao item
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                FragmentManager fragmentManager = getSupportFragmentManager();

                switch (itemId) {
                    case R.id.home:
                        if (currentFrag != fraghome) {
                            if (fraghome == null) {
                                fraghome = new frgtrangchu();  // Khởi tạo Fragment Trang chủ một lần
                                fragmentManager.beginTransaction().add(R.id.layouthome, fraghome, "HOME").commit();
                            }
                            showFragment(fraghome);
                            toolbar.setTitle("Trang chủ");
                        }
                        break;

                    case R.id.setting:
                        if (currentFrag != fragsetting) {
                            if (fragsetting == null) {
                                fragsetting = new frgcaidat();  // Khởi tạo Fragment Cài đặt một lần
                                fragmentManager.beginTransaction().add(R.id.layouthome, fragsetting, "SETTING").commit();
                            }
                            showFragment(fragsetting);
                            toolbar.setTitle("Danh sách hóa đơn");
                        }
                        break;

                    case R.id.menu:
                        if (currentFrag != fragmenu) {
                            if (fragmenu == null) {
                                fragmenu = new frgmenu();  // Khởi tạo Fragment Menu một lần
                                fragmentManager.beginTransaction().add(R.id.layouthome, fragmenu, "MENU").commit();
                            }
                            showFragment(fragmenu);
                            toolbar.setTitle("Menu");
                        }
                        break;

                    case R.id.logout:
                        Intent intenthome = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intenthome);
                        break;

                }

                drawlayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


        fraghome=new frgtrangchu();
        getSupportFragmentManager().beginTransaction().add(R.id.layouthome, fraghome, "HOME").commit();
        showFragment(fraghome);
        toolbar.setTitle("Trang chủ");
        nav.setCheckedItem(R.id.home);
    }

    @Override
    public void onBackPressed() {
        if ((drawlayout.isDrawerOpen(GravityCompat.START))){
            drawlayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }
    private void showFragment(Fragment fragmentToShow) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (currentFrag!= null) {
            transaction.hide(currentFrag);  // Ẩn Fragment hiện tại
        }
        transaction.show(fragmentToShow);  // Hiển thị Fragment mới
        transaction.commit();

        currentFrag = fragmentToShow;  // Cập nhật Fragment hiện tại
    }
    //replace

}