package com.example.myapp;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class frgban extends Fragment {
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



    public frgban() {
        // Required empty public constructor
    }



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ban, container, false);
        btn1=view.findViewById(R.id.t1b1);
        btn2=view.findViewById(R.id.t1b2);
        btn3=view.findViewById(R.id.t1b3);
        btn4=view.findViewById(R.id.t1b4);
        btn5=view.findViewById(R.id.t1b5);
        btn6=view.findViewById(R.id.t1b6);
        btn7=view.findViewById(R.id.t1b7);
        btn8=view.findViewById(R.id.t1b8);
        btn9=view.findViewById(R.id.t1b9);
        btn10=view.findViewById(R.id.t1b10);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =11;
                openDialog("dialog_key_" + dialogKey);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =21;
                openDialog("dialog_key_" + dialogKey);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =31;
                openDialog("dialog_key_" + dialogKey);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =41;
                openDialog("dialog_key_" + dialogKey);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn5.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =51;
                openDialog("dialog_key_" + dialogKey);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn6.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =61;
                openDialog("dialog_key_" + dialogKey);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn7.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =71;
                openDialog("dialog_key_" + dialogKey);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn8.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =81;
                openDialog("dialog_key_" + dialogKey);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn9.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =91;
                openDialog("dialog_key_" + dialogKey);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn10.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                int dialogKey =101;
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