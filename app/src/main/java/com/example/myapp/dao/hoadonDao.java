package com.example.myapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myapp.database.DataBaseHelper1;
import com.example.myapp.model.dsHoaDon;
import com.example.myapp.model.dsmenu;

import java.util.ArrayList;

public class hoadonDao {
    private static final String TAG=menuDao.class.getSimpleName();
    private final DataBaseHelper1 dataBaseHelper1;

    public hoadonDao(Context context) {
        dataBaseHelper1=new DataBaseHelper1(context);
    }
    public int getTenkh(int hoadonId) {
        int tenkh = 0;
        SQLiteDatabase db=dataBaseHelper1.getReadableDatabase();
        String query = "SELECT tenkh FROM hoadon WHERE id = ?";

        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(hoadonId)});

        if (cursor.moveToFirst()) {
            tenkh = cursor.getInt(0);
        }

        cursor.close();
        return tenkh;
    }
    public int getTongTien(int hoadonId) {
        int tongtien = 0;
        SQLiteDatabase db=dataBaseHelper1.getReadableDatabase();
        String query = "SELECT tongtien FROM hoadon WHERE id = ?";

        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(hoadonId)});

        if (cursor.moveToFirst()) {
            tongtien = cursor.getInt(0);
        }

        cursor.close();
        return tongtien;
    }
    public ArrayList<dsHoaDon> sellectAll(){
        ArrayList<dsHoaDon> list=new ArrayList<>();
        SQLiteDatabase db=dataBaseHelper1.getReadableDatabase();
        db.beginTransaction();
        try {
            //tạo câu lệnh truy vấn
            Cursor cs = db.rawQuery("select * from hoadon", null);//rawquery để truy vấn dữ liệu
            if (cs.getCount() > 0) {
                cs.moveToFirst();//di chuyển con trỏ về lên đầu
                while (!cs.isAfterLast()) {
                    dsHoaDon mn = new dsHoaDon();
                    mn.setId(cs.getInt(0));
                    mn.setTenkh(cs.getString(1));
                    mn.setTongtien(cs.getInt(2));

                    mn.setNgay(cs.getString(3));
                    list.add(mn);
                    cs.moveToNext();
                }
                db.setTransactionSuccessful();
            }

        } catch (Exception e) {
            Log.e(TAG, "Lỗi" + e);
        } finally {
            db.endTransaction();//kết thúc lệnh chạy
        }
        return list;
    }
    public int createHoadon() {
        int hoadonId = -1; // Default value in case insertion fails
        SQLiteDatabase db=dataBaseHelper1.getReadableDatabase();

        ContentValues values = new ContentValues();

        try {
            // Insert a new record into hoadon and get the ID of the inserted row
            hoadonId = (int) db.insert("hoadon", null, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }

        return hoadonId;
    }
    public boolean update(dsHoaDon mn){
        SQLiteDatabase db =dataBaseHelper1.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("tenkh",mn.getTenkh());
        long row= db.update("hoadon",values,"id=?",new String[]{String.valueOf(mn.getId())});
        return (row>0);
    }
    public boolean delete(int id){
        SQLiteDatabase db=dataBaseHelper1.getWritableDatabase();
        long row=db.delete("hoadon","id=?",new String[]{String.valueOf(id)});
        return (row>0);
    }
}
