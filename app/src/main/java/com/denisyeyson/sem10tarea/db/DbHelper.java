package com.denisyeyson.sem10tarea.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "semama10_inquilinos";
    public static final String TABLE_INQUILINOS = "tbl_inquilinos";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_INQUILINOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "dni TEXT NOT NULL," +
                "nombres TEXT NOT NULL," +
                "paterno TEXT NOT NULL," +
                "materno TEXT NOT NULL," +
                "telefono TEXT," +
                "correo TEXT," +
                "deuda TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_INQUILINOS);
        onCreate(sqLiteDatabase);
    }
}
