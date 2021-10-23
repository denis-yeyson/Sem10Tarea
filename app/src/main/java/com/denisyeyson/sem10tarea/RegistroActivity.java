package com.denisyeyson.sem10tarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.denisyeyson.sem10tarea.db.DbInquilinos;

public class RegistroActivity extends AppCompatActivity {

    EditText txtDni,txtNombres,txtApPaterno,txtApMaterno,txtTelefono,txtCorreo,txtDeuda;
    Button btnAgregarInquilino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtDni = findViewById(R.id.txtDni);
        txtNombres = findViewById(R.id.txtNombres);
        txtApPaterno = findViewById(R.id.txtApPaterno);
        txtApMaterno = findViewById(R.id.txtApMaterno);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtDeuda = findViewById(R.id.txtDeuda);
        btnAgregarInquilino = findViewById(R.id.btnAgregarInquilino);

        btnAgregarInquilino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbInquilinos dbInquilinos = new DbInquilinos(RegistroActivity.this);
                long id = dbInquilinos.insertarInquilino(txtDni.getText().toString(), txtNombres.getText().toString(),
                        txtApPaterno.getText().toString(),txtApMaterno.getText().toString(),txtTelefono.getText().toString(),
                        txtCorreo.getText().toString(),txtDeuda.getText().toString());
                if (id > 0){
                    limpiar();
                    Toast.makeText(RegistroActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_SHORT).show();
                    startActivity( new Intent(RegistroActivity.this,PrincipalActivity.class));
                }else{
                    Toast.makeText(RegistroActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void limpiar(){
        txtDni.setText("");
        txtNombres.setText("");
        txtApPaterno.setText("");
        txtApMaterno.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDeuda.setText("");
    }
}