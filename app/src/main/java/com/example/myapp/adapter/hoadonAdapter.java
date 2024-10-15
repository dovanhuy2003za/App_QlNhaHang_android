package com.example.myapp.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.dao.hoadonDao;
import com.example.myapp.model.dsHoaDon;
import com.example.myapp.model.dsmenu;

import java.util.List;

public class hoadonAdapter extends RecyclerView.Adapter<hoadonAdapter.viewHolder> {
    hoadonDao hdd;
    private final Context context;
    private final List<dsHoaDon> list;

    public hoadonAdapter(hoadonDao hdd, Context context, List<dsHoaDon> list) {
        hhd=new hoadonDao(context;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public hoadonAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull hoadonAdapter.viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
