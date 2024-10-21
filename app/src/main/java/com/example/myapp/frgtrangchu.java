package com.example.myapp;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class frgtrangchu extends Fragment {
    private ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;

    private TabLayout tb;
    public frgtrangchu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frgtrangchu, container, false);
        viewPager2=view.findViewById(R.id.view_page2_home);
        tb=view.findViewById(R.id.tabtc);
        Myviewpager2Adapter adapter=new Myviewpager2Adapter(this);
        viewPager2.setAdapter(adapter);
        new TabLayoutMediator(tb, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                switch (i){
                    case 0:tab.setText("Tầng 1");break;
                    case 1:tab.setText("Tầng 2");break;

                }
            }
        }).attach();
        return view;
    }

}