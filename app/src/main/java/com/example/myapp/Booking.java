package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class Booking extends DialogFragment {
    private static final String PREFS_NAME = "MyPrefs";
    private String userInputKey;
    private TextView textView;


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
        EditText dialogInput = view.findViewById(R.id.dialog_input);
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