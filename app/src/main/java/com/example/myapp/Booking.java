package com.example.myapp;

import static android.R.layout.simple_spinner_item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapp.adapter.hoadonAdapter;
import com.example.myapp.dao.hoadonDao;
import com.example.myapp.dao.menuDao;
import com.example.myapp.database.DataBaseHelper1;
import com.example.myapp.model.dscthoadon;
import com.example.myapp.dao.chiTietHoaDonDao;
import com.example.myapp.adapter.chiTietHoaDonAdapter;
import com.example.myapp.model.dsmenu;

import java.util.ArrayList;
import java.util.List;


public class Booking extends DialogFragment {
    private static final String PREFS_NAME = "MyPrefs";
    private String userInputKey;
    private TextView textView;
    RecyclerView rcv;
    private Spinner menuSpinner;
    private ArrayList<dsmenu> menuList;
    private ArrayAdapter<String> adapter;
    dsmenu dm;
    menuDao md;
    ArrayList<dscthoadon> list=new ArrayList<>();
    chiTietHoaDonDao ctd;
    chiTietHoaDonAdapter cta;

    public Booking(String userInputKey) {
        // Required empty public constructor
        this.userInputKey = userInputKey;
    }



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_booking, container, false);
        EditText dialogInput = view.findViewById(R.id.txttenkh);
        rcv=view.findViewById(R.id.rcvmonan);
        ctd=new chiTietHoaDonDao(getContext());
        list=ctd.selectAll(1);
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
        restoreInputData(dialogInput);

        // Set up a TextWatcher to auto-save input
        dialogInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No action needed here
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Save data to SharedPreferences as user types
                saveData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // No action needed here
            }
        });
        return view;
    }
    private void saveData(String data) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(userInputKey, data); // Save data using the unique key
        editor.apply();
    }

    private void restoreInputData(EditText dialogInput) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String savedInput = sharedPreferences.getString(userInputKey, "");
        dialogInput.setText(savedInput); // Populate the EditText with the saved data
    }
}