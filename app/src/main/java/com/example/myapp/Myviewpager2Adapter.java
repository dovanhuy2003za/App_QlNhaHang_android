package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Myviewpager2Adapter extends FragmentStateAdapter {
    public Myviewpager2Adapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new frgban();
            case 1:
                return new frgban1();
            default:
                return new frgban();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
