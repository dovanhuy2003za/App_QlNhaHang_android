package com.example.myapp.adapter;

import static java.security.AccessController.getContext;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.R;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapp.model.dsmenu;
import java.util.List;
import com.example.myapp.dao.menuDao;
public class menuAdapter extends RecyclerView.Adapter<menuAdapter.viewHolder> {

    private final Context context;
    private final List<dsmenu>list;
    menuDao mnd;

    public menuAdapter(Context context, List<dsmenu> list) {
        this.context = context;
        this.list = list;
        mnd=new menuDao(context);
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_menu,null);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        dsmenu dm=list.get(position);
        holder.txtten.setText(list.get(position).getName());
        holder.txtdongia.setText(Integer.toString(list.get(position).getDongia()));
        holder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mnd.delete(dm.getId())){
                    list.clear();
                    list.addAll(mnd.sellectAll());
                    notifyDataSetChanged();
                    Toast.makeText(context,"Đã xóa",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context,"Xóa thất bại",Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiglog(dm);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public  void openDiglog(dsmenu mn){

        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.diglog_menu,null);
        builder.setView(view);
        Dialog dialog=builder.create();
        dialog.show();
        EditText ettemon=view.findViewById(R.id.editTextTenMon);
        EditText etdongia=view.findViewById(R.id.editTextDonGia);
        Button btnupdate1=view.findViewById(R.id.buttonMenu);
        ettemon.setText(mn.getName());
        etdongia.setText(Integer.toString(mn.getDongia()));
        btnupdate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mn.setName(ettemon.getText().toString());
                mn.setDongia(Integer.parseInt(etdongia.getText().toString()));
                if (mnd.update(mn)){
                    list.clear();
                    list.addAll(mnd.sellectAll());
                    notifyDataSetChanged();
                    dialog.dismiss();
                    Toast.makeText(context,"Đã cập nhật",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context,"Cập nhật thất bại",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        public TextView txtten,txtdongia;
        public ImageButton btnupdate,btndelete;
        public CardView crdv;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            txtten=itemView.findViewById(R.id.tenm);
            txtdongia=itemView.findViewById(R.id.dongia);
            btnupdate=itemView.findViewById(R.id.menuupdate);
            btndelete=itemView.findViewById(R.id.menudelete);
            crdv=itemView.findViewById(R.id.crdvmenu);
        }

    }
}
