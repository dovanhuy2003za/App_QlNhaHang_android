package com.example.myapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper1 extends SQLiteOpenHelper {
    public static final String DB_Name="QLNH";
    public DataBaseHelper1(Context context) {
        super(context, DB_Name, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tb_menu="create table "+"menu"+
                "( " +"ID"+" integer primary key autoincrement,"+ "tenmon  text,dongia int); ";
        sqLiteDatabase.execSQL(tb_menu);
        String data="insert into menu values(1,'chó hấp',150000)";
        sqLiteDatabase.execSQL(data);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");
        onCreate(sqLiteDatabase);
    }
}
