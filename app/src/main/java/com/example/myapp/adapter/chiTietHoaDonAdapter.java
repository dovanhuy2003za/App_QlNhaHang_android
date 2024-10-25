package com.example.myapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.dao.chiTietHoaDonDao;
import com.example.myapp.model.dscthoadon;

import java.util.List;

public class chiTietHoaDonAdapter extends RecyclerView.Adapter<chiTietHoaDonAdapter.viewHolder> {
    private final Context context;
    private final List<dscthoadon> list;
    chiTietHoaDonDao cthd;

    public chiTietHoaDonAdapter(Context context, List<dscthoadon> list) {
        cthd=new chiTietHoaDonDao(context);
        this.context = context;
        this.list = list;
    }




    @NonNull
    @Override
    public chiTietHoaDonAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_roomdatabase,null);
        return new chiTietHoaDonAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
            dscthoadon hd=list.get(position);
            holder.tvtm.setText(list.get(position).getTenmon());
            holder.tvsl.setText(Integer.toString(list.get(position).getSoluong()));
            holder.tvdg.setText(Integer.toString(list.get(position).getDongia()));
    }

    @Override
    public int getItemCount() {

       return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView tvtm;
        TextView tvsl;
        TextView tvdg;
        public viewHolder(@NonNull View itemView) {

            super(itemView);
            tvtm=itemView.findViewById(R.id.tvmonan);
            tvsl=itemView.findViewById(R.id.tvsoluong);
            tvdg=itemView.findViewById(R.id.tvdongia);
        }
    }
}
