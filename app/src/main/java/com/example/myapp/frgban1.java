package com.example.myapp;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class frgban1 extends Fragment {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn10;


    public frgban1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ban1, container, false);
        btn1=view.findViewById(R.id.t2b1);
        btn2=view.findViewById(R.id.t2b2);
        btn3=view.findViewById(R.id.t2b3);
        btn4=view.findViewById(R.id.t2b4);
        btn5=view.findViewById(R.id.t2b5);
        btn6=view.findViewById(R.id.t2b6);
        btn7=view.findViewById(R.id.t2b7);
        btn8=view.findViewById(R.id.t2b8);
        btn9=view.findViewById(R.id.t2b9);
        btn10=view.findViewById(R.id.t2b10);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =1;
                openDialog("dialog_key_" + dialogKey);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =2;
                openDialog("dialog_key_" + dialogKey);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =3;
                openDialog("dialog_key_" + dialogKey);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =4;
                openDialog("dialog_key_" + dialogKey);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn5.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =5;
                openDialog("dialog_key_" + dialogKey);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn6.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =6;
                openDialog("dialog_key_" + dialogKey);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn7.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =7;
                openDialog("dialog_key_" + dialogKey);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn8.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =8;
                openDialog("dialog_key_" + dialogKey);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn9.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =9;
                openDialog("dialog_key_" + dialogKey);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn10.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =10;
                openDialog("dialog_key_" + dialogKey);
            }
        });

        return view;
    }
    private void openDialog(String dialogKey) {
        Booking dialogFragment = new Booking(dialogKey);
        dialogFragment.show(getChildFragmentManager(), "dialog"); // Show dialog fragment
    }
}