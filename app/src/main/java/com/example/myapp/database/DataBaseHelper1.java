package com.example.myapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper1 extends SQLiteOpenHelper {
    public static final String DB_Name="QLNH";
    public DataBaseHelper1(Context context) {
        super(context, DB_Name, null, 3);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng menu
        db.execSQL("CREATE TABLE menu (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tenmon TEXT NOT NULL, " +
                "dongia INTEGER NOT NULL)");

        // Tạo bảng hoadon
        db.execSQL("CREATE TABLE hoadon (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tenkh TEXT NOT NULL, " +
                "soban INTEGER NOT NULL,"+
                "tongtien INTEGER NOT NULL," +
                "ngay TEXT NOT NULL)");

        // Tạo bảng chitiethoadon
        db.execSQL("CREATE TABLE chitiethoadon (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "idmon INTEGER NOT NULL, " +
                "idhd INTEGER NOT NULL, " +

                "soluong INTEGER NOT NULL, " +
                "FOREIGN KEY(idmon) REFERENCES menu(id), " +
                "FOREIGN KEY(idhd) REFERENCES hoadon(id) ON DELETE CASCADE)");
        db.execSQL("INSERT INTO menu (tenmon, dongia) VALUES ('Bún bò', 40000);");
        db.execSQL("INSERT INTO hoadon (tenkh, tongtien, soban, ngay) VALUES ('Nguyen Van A', 120000, 1, '2024-10-15');");
        db.execSQL("INSERT INTO chitiethoadon (idmon, idhd, soluong) VALUES (1, 1, 3);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS chitiethoadon");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS hoadon");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS menu");
        onCreate(sqLiteDatabase);
    }
}
