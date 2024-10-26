package com.example.myapp.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myapp.database.DataBaseHelper1;
import com.example.myapp.model.dsHoaDon;
import com.example.myapp.model.dscthoadon;

import java.util.ArrayList;

public class chiTietHoaDonDao {
    private static final String TAG=menuDao.class.getSimpleName();
    private final DataBaseHelper1 dataBaseHelper1;


    public chiTietHoaDonDao(Context context) {
        dataBaseHelper1=new DataBaseHelper1(context);
    }
    public ArrayList<dscthoadon> selectAll(int idhd) {
        ArrayList<dscthoadon> list = new ArrayList<>();
        SQLiteDatabase db = dataBaseHelper1.getReadableDatabase();
        db.beginTransaction();
        try {
            // Query with JOIN to get tenmon, soluong, and dongia where idhd matches
            String query = "SELECT menu.tenmon, chitiethoadon.soluong, menu.dongia " +
                    "FROM chitiethoadon " +
                    "JOIN menu ON chitiethoadon.idmon = menu.id " +
                    "WHERE chitiethoadon.idhd = ?";

            Cursor cs = db.rawQuery(query, new String[]{String.valueOf(idhd)});

            if (cs.getCount() > 0) {
                cs.moveToFirst();
                while (!cs.isAfterLast()) {
                    dscthoadon mn = new dscthoadon();
                    mn.setTenmon(cs.getString(0));  // assuming dscthoadon has a setTenmon method
                    mn.setSoluong(cs.getInt(1));    // soluong
                    mn.setDongia(cs.getInt(2));     // dongia
                    list.add(mn);
                    cs.moveToNext();
                }
                db.setTransactionSuccessful();
            }
            cs.close();
        } catch (Exception e) {
            Log.e(TAG, "Lỗi" + e);
        } finally {
            db.endTransaction();
        }
        return list;
    }
    @SuppressLint("Range")
    public boolean insert(dscthoadon mn){
        SQLiteDatabase db=dataBaseHelper1.getWritableDatabase();
        int idmon = -1; // Default to -1 if not found
        String query = "SELECT id FROM menu WHERE tenmon = ?";
        Cursor cursor = db.rawQuery(query, new String[]{mn.getTenmon()});

        if (cursor.moveToFirst()) {
            idmon = cursor.getInt(cursor.getColumnIndex("id"));
        }
        cursor.close();

        // Check if idmon was found
        if (idmon == -1) {
            return false; // idmon not found for the given tenmon
        }
        //sử dụng contentvalue để đưa dữ liệu vào database
        ContentValues values=new ContentValues();
        values.put("idmon",idmon);
        values.put("idhd",mn.getIdhd());
        values.put("soluong",mn.getSoluong());

        //nếu add thành công sẽ trả về giá trị tương ứng số hàng mà dữ liệu được add trong bảng
        long row=db.insert("chitiethoadon",null,values);
        return (row>0);
    }
}
