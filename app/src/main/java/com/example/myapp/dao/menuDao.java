package com.example.myapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.util.Log;

import com.example.myapp.database.DataBaseHelper1;
import com.example.myapp.model.dsmenu;
import java.util.ArrayList;

public class menuDao {
    private static final String TAG=menuDao.class.getSimpleName();
    private final DataBaseHelper1 dataBaseHelper1;


    public menuDao(Context context) {dataBaseHelper1=new DataBaseHelper1(context);
    }
    public ArrayList<dsmenu> sellectAll(){
        ArrayList<dsmenu> list=new ArrayList<>();
        SQLiteDatabase db=dataBaseHelper1.getReadableDatabase();
        db.beginTransaction();
        try {
            //tạo câu lệnh truy vấn
            Cursor cs = db.rawQuery("select * from menu", null);//rawquery để truy vấn dữ liệu
            if (cs.getCount() > 0) {
                cs.moveToFirst();//di chuyển con trỏ về lên đầu
                while (!cs.isAfterLast()) {
                    dsmenu mn = new dsmenu();
                    mn.setId(cs.getInt(0));
                    mn.setName(cs.getString(1));
                    mn.setDongia(cs.getInt(2));
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
    public boolean insert(dsmenu mn){
        SQLiteDatabase db=dataBaseHelper1.getWritableDatabase();
        //sử dụng contentvalue để đưa dữ liệu vào database
        ContentValues values=new ContentValues();
        values.put("tenmon",mn.getName());
        values.put("dongia",mn.getDongia());

        //nếu add thành công sẽ trả về giá trị tương ứng số hàng mà dữ liệu được add trong bảng
        long row=db.insert("menu",null,values);
        return (row>0);
    }
    public boolean update(dsmenu mn){
        SQLiteDatabase db =dataBaseHelper1.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("tenmon",mn.getName());
        values.put("dongia",mn.getDongia());
        long row= db.update("menu",values,"id=?",new String[]{String.valueOf(mn.getId())});
        return (row>0);
    }
    public boolean delete(int id){
        SQLiteDatabase db=dataBaseHelper1.getWritableDatabase();
        long row=db.delete("menu","id=?",new String[]{String.valueOf(id)});
        return (row>0);
    }
}
