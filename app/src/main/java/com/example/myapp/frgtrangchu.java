package com.example.myapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class frgtrangchu extends Fragment {
    private ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;


    public frgtrangchu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frgtrangchu, container, false);
        viewPager2=view.findViewById(R.id.view_page2_home);
        bottomNavigationView=view.findViewById(R.id.bottomfrghome);
        Myviewpager2Adapter adapter=new Myviewpager2Adapter(this);
        viewPager2.setAdapter(adapter);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.tang1);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.tang2);
                        break;

                }
            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemid= menuItem.getItemId();
                if (itemid==R.id.tang1){
                    viewPager2.setCurrentItem(0);
                } else if (itemid==R.id.tang2) {
                    viewPager2.setCurrentItem(1);
                }

                return true;
            }
        });
        return view;
    }
}