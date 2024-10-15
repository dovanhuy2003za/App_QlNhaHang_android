package com.example.myapp.dao;

import android.content.Context;

import com.example.myapp.database.DataBaseHelper1;

public class chiTietHoaDonDao {
    private static final String TAG=menuDao.class.getSimpleName();
    private final DataBaseHelper1 dataBaseHelper1;


    public chiTietHoaDonDao(Context context) {
        dataBaseHelper1=new DataBaseHelper1(context);
    }
}
