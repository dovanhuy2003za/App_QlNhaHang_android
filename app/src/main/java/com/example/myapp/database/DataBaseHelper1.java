package com.example.myapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper1 extends SQLiteOpenHelper {
    public static final String DB_Name="QLNH";
    public DataBaseHelper1(Context context) {
        super(context, DB_Name, null, 5);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng menu
        // Tạo bảng menu
        db.execSQL("CREATE TABLE menu (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tenmon TEXT NOT NULL, " +
                "dongia INTEGER NOT NULL)");

// Tạo bảng hoadon
        db.execSQL("CREATE TABLE hoadon (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tenkh TEXT, " +
                "tongtien INTEGER DEFAULT 0, " +
                "ngay DATE)");

// Tạo bảng chitiethoadon
        db.execSQL("CREATE TABLE chitiethoadon (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "idmon INTEGER NOT NULL, " +
                "idhd INTEGER NOT NULL, " +
                "soluong INTEGER NOT NULL, " +
                "FOREIGN KEY(idmon) REFERENCES menu(id), " +
                "FOREIGN KEY(idhd) REFERENCES hoadon(id) ON DELETE CASCADE)");

// Trigger to update tongtien and ngay after INSERT
        String createTriggerInsert = "CREATE TRIGGER update_tongtien_insert " +
                "AFTER INSERT ON chitiethoadon " +
                "FOR EACH ROW " +
                "BEGIN " +
                "    UPDATE hoadon SET " +
                "        tongtien = (SELECT SUM(menu.dongia * chitiethoadon.soluong) " +
                "                     FROM chitiethoadon " +
                "                     JOIN menu ON chitiethoadon.idmon = menu.id " +
                "                     WHERE chitiethoadon.idhd = NEW.idhd), " +
                "        ngay = CURRENT_DATE " +
                "    WHERE id = NEW.idhd; " +
                "END;";
        db.execSQL(createTriggerInsert);

// Trigger to update tongtien and ngay after UPDATE
        String createTriggerUpdate = "CREATE TRIGGER update_tongtien_update " +
                "AFTER UPDATE ON chitiethoadon " +
                "FOR EACH ROW " +
                "BEGIN " +
                "    UPDATE hoadon SET " +
                "        tongtien = (SELECT SUM(menu.dongia * chitiethoadon.soluong) " +
                "                     FROM chitiethoadon " +
                "                     JOIN menu ON chitiethoadon.idmon = menu.id " +
                "                     WHERE chitiethoadon.idhd = NEW.idhd), " +
                "        ngay = CURRENT_DATE " +
                "    WHERE id = NEW.idhd; " +
                "END;";
        db.execSQL(createTriggerUpdate);

// Trigger to update tongtien and ngay after DELETE
        String createTriggerDelete = "CREATE TRIGGER update_tongtien_delete " +
                "AFTER DELETE ON chitiethoadon " +
                "FOR EACH ROW " +
                "BEGIN " +
                "    UPDATE hoadon SET " +
                "        tongtien = (SELECT SUM(menu.dongia * chitiethoadon.soluong) " +
                "                     FROM chitiethoadon " +
                "                     JOIN menu ON chitiethoadon.idmon = menu.id " +
                "                     WHERE chitiethoadon.idhd = OLD.idhd), " +
                "        ngay = CURRENT_DATE " +
                "    WHERE id = OLD.idhd; " +
                "END;";
        db.execSQL(createTriggerDelete);

// Sample data
        db.execSQL("INSERT INTO menu (tenmon, dongia) VALUES ('Bún bò', 40000);");
        db.execSQL("INSERT INTO hoadon (tenkh) VALUES ('Nguyen Van A');");
        db.execSQL("INSERT INTO chitiethoadon (idmon, idhd, soluong) VALUES (1, 1, 4);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS chitiethoadon");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS hoadon");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS menu");
        onCreate(sqLiteDatabase);
    }
}
