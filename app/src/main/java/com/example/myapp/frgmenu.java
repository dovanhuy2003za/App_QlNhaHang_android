package com.example.myapp;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import com.example.myapp.model.dsmenu;
import com.example.myapp.dao.menuDao;
import com.example.myapp.adapter.menuAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class frgmenu extends Fragment {

    RecyclerView rcv;
    ArrayList<dsmenu>list=new ArrayList<>();
    menuDao mnd;
    menuAdapter mna;
    FloatingActionButton fbtn;

    public frgmenu() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_themmenu, container, false);
        rcv=view.findViewById(R.id.rcvmenu);
        fbtn=view.findViewById(R.id.fltadd);
        mnd=new menuDao(getContext());
        list=mnd.sellectAll();
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        mna = new menuAdapter(getContext(),list);
        rcv.setAdapter(mna);
        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                digthem();
            }
        });
        return view;

    }
    private void digthem(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setTitle("Add New Menu Item");
        LayoutInflater inflater=getLayoutInflater();
        View view=inflater.inflate(R.layout.diglog_menu,null);
        builder.setView(view);
        Dialog dialog=builder.create();
        dialog.show();
        EditText ettemon=view.findViewById(R.id.editTextTenMon);
        EditText etdongia=view.findViewById(R.id.editTextDonGia);
        Button btnupdate1=view.findViewById(R.id.buttonMenu);
        try {
            btnupdate1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String tenmon=ettemon.getText().toString();
                    int dongia= Integer.parseInt(etdongia.getText().toString());
                    dsmenu mn=new dsmenu(tenmon,dongia);
                    if (mnd.insert(mn)){
                        list.clear();
                        list.addAll(mnd.sellectAll());
                        mna.notifyDataSetChanged();
                        dialog.dismiss();
                        Toast.makeText(getContext(),"Đã cập nhật",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getContext(),"Cập nhật thất bại",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }catch (Exception e){
            Toast.makeText(getContext(),"Loi"+ e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }
}
