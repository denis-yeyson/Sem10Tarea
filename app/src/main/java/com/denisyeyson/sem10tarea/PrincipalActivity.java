package com.denisyeyson.sem10tarea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.denisyeyson.sem10tarea.adaptadores.LitaInquilinosAdapter;
import com.denisyeyson.sem10tarea.db.DbInquilinos;
import com.denisyeyson.sem10tarea.entidades.Inquilinos;

import java.util.ArrayList;

public class PrincipalActivity extends AppCompatActivity {

    RecyclerView listaInquilinos;
    ArrayList<Inquilinos> listaArrayInquilinos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        listaInquilinos=findViewById(R.id.listaInquilinos);
        listaInquilinos.setLayoutManager(new LinearLayoutManager(this));

        DbInquilinos dbInquilinos =  new DbInquilinos(PrincipalActivity.this);
        listaArrayInquilinos =  new ArrayList<>();

        LitaInquilinosAdapter adapter=new LitaInquilinosAdapter(dbInquilinos.mostrarInquilinos());
        listaInquilinos.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.itemAgregar:
                nuevoRegistro();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void nuevoRegistro() {
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }
}