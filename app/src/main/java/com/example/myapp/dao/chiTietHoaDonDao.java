package com.example.myapp.dao;

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
    public ArrayList<dscthoadon> sellectAll(){
        ArrayList<dscthoadon> list=new ArrayList<>();
        SQLiteDatabase db=dataBaseHelper1.getReadableDatabase();
        db.beginTransaction();
        try {
            //tạo câu lệnh truy vấn
            Cursor cs = db.rawQuery("select * from chitiethoadon", null);//rawquery để truy vấn dữ liệu
            if (cs.getCount() > 0) {
                cs.moveToFirst();//di chuyển con trỏ về lên đầu
                while (!cs.isAfterLast()) {
                    dscthoadon mn = new dscthoadon();
                    mn.setId(cs.getInt(0));
                    mn.setIdmon(cs.getInt(1));
                    mn.setIdhd(cs.getInt(2));
                    mn.setSoluong(cs.getInt(3));
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
    public boolean insert(dscthoadon mn){
        SQLiteDatabase db=dataBaseHelper1.getWritableDatabase();
        //sử dụng contentvalue để đưa dữ liệu vào database
        ContentValues values=new ContentValues();
        values.put("idmon",mn.getIdmon());
        values.put("idhd",mn.getIdhd());
        values.put("soluong",mn.getSoluong());

        //nếu add thành công sẽ trả về giá trị tương ứng số hàng mà dữ liệu được add trong bảng
        long row=db.insert("chitiethoadon",null,values);
        return (row>0);
    }
}
