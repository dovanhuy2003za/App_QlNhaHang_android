package com.example.myapp;

import static android.R.layout.simple_spinner_item;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.example.myapp.database.DataBaseHelper1;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.adapter.hoadonAdapter;
import com.example.myapp.dao.hoadonDao;
import com.example.myapp.dao.menuDao;
import com.example.myapp.database.DataBaseHelper1;
import com.example.myapp.model.dsHoaDon;
import com.example.myapp.model.dscthoadon;
import com.example.myapp.dao.chiTietHoaDonDao;
import com.example.myapp.adapter.chiTietHoaDonAdapter;
import com.example.myapp.model.dsmenu;

import java.util.ArrayList;
import java.util.List;


public class Booking extends DialogFragment {



    private int idhd;
    private TextView textView;
    private int tongtien = 0;
    RecyclerView rcv;
    private Spinner menuSpinner;
    private ArrayList<dsmenu> menuList;
    private ArrayAdapter<String> adapter;
    private String name;
    dsmenu dm;
    menuDao md;
    ArrayList<dscthoadon> list=new ArrayList<>();
    chiTietHoaDonDao ctd;
    chiTietHoaDonAdapter cta;

    Button btnthem;


    public Booking( int idhd ) {
        // Required empty public constructor

        this.idhd=idhd;
    }



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_booking, container, false);
        EditText dialogInput = view.findViewById(R.id.txttenkh);
        btnthem=view.findViewById(R.id.btnthemmon);
        rcv=view.findViewById(R.id.rcvmonan);
        ctd=new chiTietHoaDonDao(getContext());
        list=ctd.selectAll(idhd);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        cta=new chiTietHoaDonAdapter(getContext(),list);
        rcv.setAdapter(cta);
        menuSpinner = view.findViewById(R.id.menuSpinner); // replace with your Spinner ID

        // Initialize DatabaseHelper and get menu items
        md=new menuDao(getContext());
        menuList =md.sellectAll();

        // Extract names for Spinner
        List<String> menuNames = new ArrayList<>();
        for (dsmenu item : menuList) {
            menuNames.add(item.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getActivity(),  // Use getActivity() in Fragment to get the context
                android.R.layout.simple_spinner_item,
                menuNames
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        menuSpinner.setAdapter(adapter);
        menuSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 name=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getContext(),"Chọn món trước",Toast.LENGTH_SHORT).show();
            }
        });

        EditText sl=view.findViewById(R.id.txtsoluong);
        TextView tt=view.findViewById(R.id.tvtt);
        hoadonDao hd=new hoadonDao(getContext());
        dialogInput.setText(hd.getTenkh(idhd));
        tongtien=hd.getTongTien(idhd);
        tt.setText("Tổng tiền: "+tongtien);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String tenkh=dialogInput.getText().toString();
                    dsHoaDon a=new dsHoaDon(tenkh);
                    int soluong=Integer.parseInt(sl.getText().toString());
                    dscthoadon cthd=new dscthoadon(soluong,name,idhd);
                    if (ctd.insert(cthd)&hd.update(a)){
                        list.clear();
                        list.addAll(ctd.selectAll(idhd));
                        cta.notifyDataSetChanged();
                        tongtien=hd.getTongTien(idhd);
                        tt.setText("Tổng tiền: "+tongtien);
                        sl.setText("");
                        Toast.makeText(getContext(),"Đã cập nhật",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getContext(),"Cập nhật thất bại",Toast.LENGTH_SHORT).show();
                    }


            }
        });

        Button btntt=view.findViewById(R.id.dialog_save_button);
        btntt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(getContext());
                dialog.setContentView(R.layout.diglog_booking);
                dialog.show();
            }
        });

        return view;

    }


}