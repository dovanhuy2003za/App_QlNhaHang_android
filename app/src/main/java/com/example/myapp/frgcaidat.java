package com.example.myapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.adapter.hoadonAdapter;
import com.example.myapp.dao.hoadonDao;
import com.example.myapp.model.dsHoaDon;

import java.util.ArrayList;


public class frgcaidat extends Fragment {

    RecyclerView rcv;
    ArrayList<dsHoaDon> list=new ArrayList<>();
    hoadonDao hdd;
    hoadonAdapter hda;
    public frgcaidat() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_frgcaidat, container, false);
        rcv=view.findViewById(R.id.rcvhoadon);
        hdd=new hoadonDao(getContext());
        list=hdd.sellectAll();
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        hda=new hoadonAdapter(getContext(),list);
        rcv.setAdapter(hda);

        return view;
    }
}