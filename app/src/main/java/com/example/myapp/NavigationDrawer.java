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

import com.google.android.material.navigation.NavigationView;

public class NavigationDrawer extends AppCompatActivity {
    DrawerLayout drawlayout;
    Toolbar toolbar;
    private static  final int fraghome=1;
    private static  final int fragmenu=2;
    private static  final int fragsetting=3;
    private int currentFrag=fraghome;

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

                int itemid= item.getItemId();
                if (itemid==R.id.home){
                    if (currentFrag!=fraghome){
                        frgtrangchu frgtc=new frgtrangchu();
                        replaceFrg(frgtc);
                        currentFrag=fraghome;

                        toolbar.setTitle("Trang chu");
                    }

                } else if (itemid==R.id.setting) {
                    if (currentFrag!=fragsetting){
                        frgcaidat frgcd=new frgcaidat();
                        replaceFrg(frgcd);
                        toolbar.setTitle("Dang sách hóa đơn");
                        currentFrag=fragsetting;
                    }
                } else if (itemid==R.id.logout) {
                    Intent intenthome=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intenthome);
                } else if (itemid==R.id.menu) {
                    if (currentFrag!=fragmenu){
                        frgmenu frgmn=new frgmenu();
                        replaceFrg(frgmn);
                        currentFrag=fragmenu;

                        toolbar.setTitle("Menu");
                    }

                }
                drawlayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        frgtrangchu frgtc=new frgtrangchu();
        replaceFrg(frgtc);
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

    //replace
    private void replaceFrg(Fragment frg) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.layouthome, frg).commit();
    }
}