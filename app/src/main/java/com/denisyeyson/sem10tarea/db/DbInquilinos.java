package com.denisyeyson.sem10tarea.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.denisyeyson.sem10tarea.entidades.Inquilinos;

import java.util.ArrayList;

public class DbInquilinos extends DbHelper{

    Context context;

    public DbInquilinos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarInquilino(String dni,String nombres, String paterno,String materno, String telefono,String correo,String deuda){

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("dni", dni);
            values.put("nombres", nombres);
            values.put("paterno", paterno);
            values.put("materno", materno);
            values.put("telefono", telefono);
            values.put("correo", correo);
            values.put("deuda", deuda);

            id = db.insert(TABLE_INQUILINOS, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList<Inquilinos> mostrarInquilinos(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<Inquilinos> lista = new ArrayList<>();
        Inquilinos inq = null;
        Cursor cursorInquilinos = null;

        cursorInquilinos = db.rawQuery("SELECT * FROM "+TABLE_INQUILINOS,null);
        if(cursorInquilinos.moveToFirst()){
            do{
                 inq = new Inquilinos();
                 inq.setId(cursorInquilinos.getInt(0));
                inq.setDni(cursorInquilinos.getString(1));
                inq.setNombres(cursorInquilinos.getString(2));
                inq.setApPaterno(cursorInquilinos.getString(3));
                inq.setApMaterno(cursorInquilinos.getString(4));
                inq.setTelefono(cursorInquilinos.getString(5));
                inq.setCorreo(cursorInquilinos.getString(6));
                inq.setDeuda(cursorInquilinos.getString(7));
                lista.add(inq);
            }while (cursorInquilinos.moveToNext());
        }
        cursorInquilinos.close();
        return lista;
    }
}
