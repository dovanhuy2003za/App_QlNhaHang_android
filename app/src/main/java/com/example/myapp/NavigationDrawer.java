package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

public class NavigationDrawer extends AppCompatActivity {
    DrawerLayout drawlayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView nav = findViewById(R.id.nav_view);
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

                int itemid= item.getItemId();
                if (itemid==R.id.home){
                    frgtrangchu frgtc=new frgtrangchu();
                    replaceFrg(frgtc);
                    toolbar.setTitle("Trang chu");
                } else if (itemid==R.id.setting) {
                    frgcaidat frgcd=new frgcaidat();
                    replaceFrg(frgcd);
                } else if (itemid==R.id.logout) {
                    Intent intenthome=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intenthome);
                }

                return true;
            }
        });

    }
    //replace
    private void replaceFrg(Fragment frg) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.layouthome, frg).commit();
    }
}