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
                    mn.setSoban(cs.getInt(3));
                    mn.setNgay(cs.getString(4));
                    list.add(mn);
                    cs.moveToNext();
                }
                db.setTransactionSuccessful();//bd chạy thành công
            }

        } catch (Exception e) {
            Log.e(TAG, "Lỗi" + e);
        } finally {
            db.endTransaction();//kết thúc lệnh chạy
        }
        return list;
    }
    public boolean insert(dsHoaDon mn){
        SQLiteDatabase db=dataBaseHelper1.getWritableDatabase();
        //sử dụng contentvalue để đưa dữ liệu vào database
        ContentValues values=new ContentValues();
        values.put("tenkh",mn.getTenkh());
        values.put("tongtien",mn.getTongtien());
        values.put("soban",mn.getSoban());
        values.put("ngay",mn.getNgay());
        //nếu add thành công sẽ trả về giá trị tương ứng số hàng mà dữ liệu được add trong bảng
        long row=db.insert("hoadon",null,values);
        return (row>0);
    }
    public boolean delete(int id){
        SQLiteDatabase db=dataBaseHelper1.getWritableDatabase();
        long row=db.delete("hoadon","id=?",new String[]{String.valueOf(id)});
        return (row>0);
    }
}
