package com.example.myapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.dao.hoadonDao;
import com.example.myapp.model.dsHoaDon;
import com.example.myapp.model.dsmenu;

import java.util.List;

public class hoadonAdapter extends RecyclerView.Adapter<hoadonAdapter.viewHolder> {
    hoadonDao hdd;
    private final Context context;
    private final List<dsHoaDon> list;

    public hoadonAdapter( Context context, List<dsHoaDon> list) {
        hdd=new hoadonDao(context);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public hoadonAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_hoadon,null);
        return new hoadonAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull hoadonAdapter.viewHolder holder, int position) {
            dsHoaDon hd=list.get(position);
            holder.txttenkh.setText(list.get(position).getTenkh());
            holder.txttt.setText(Integer.toString(list.get(position).getTongtien()));
            holder.txtsb.setText(Integer.toString(list.get(position).getSoban()));
            holder.txtngay.setText(list.get(position).getNgay());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class viewHolder extends RecyclerView.ViewHolder {
        public TextView txttenkh, txttt, txtsb, txtngay;

        public CardView crdv;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            txttenkh = itemView.findViewById(R.id.tenkh);
            txttt = itemView.findViewById(R.id.tongtien);
            txtsb=itemView.findViewById(R.id.soban);
            txtngay=itemView.findViewById(R.id.ngaytt);
            crdv = itemView.findViewById(R.id.crdvhoadon);
        }
    }

}

