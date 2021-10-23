package com.denisyeyson.sem10tarea.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.denisyeyson.sem10tarea.R;
import com.denisyeyson.sem10tarea.entidades.Inquilinos;

import java.util.ArrayList;

public class LitaInquilinosAdapter extends RecyclerView.Adapter<LitaInquilinosAdapter.InquilinoViewHolder> {

    ArrayList<Inquilinos> listaInquilinos;

    public LitaInquilinosAdapter(ArrayList<Inquilinos> listaInquilinos){
        this.listaInquilinos = listaInquilinos;
    }

    @NonNull
    @Override
    public InquilinoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_inquilino,null,false);
        return new InquilinoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InquilinoViewHolder holder, int position) {
        holder.dni.setText("DNI: "+listaInquilinos.get(position).getDni());
        holder.nombres.setText("Nombres: "+listaInquilinos.get(position).getApPaterno()+" "+listaInquilinos.get(position).getApMaterno()+" "+listaInquilinos.get(position).getNombres());
        holder.telefono.setText("Telefono: "+listaInquilinos.get(position).getTelefono());
        holder.correo.setText("Correo: "+listaInquilinos.get(position).getCorreo());
        holder.deuda.setText("Deuda: "+listaInquilinos.get(position).getDeuda());
    }

    @Override
    public int getItemCount() {
        return listaInquilinos.size();
    }

    public class InquilinoViewHolder extends RecyclerView.ViewHolder {
        TextView dni,nombres,telefono,correo,deuda;
        public InquilinoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombres = itemView.findViewById(R.id.txtViewNombres);
            dni = itemView.findViewById(R.id.txtViewDni);
            telefono = itemView.findViewById(R.id.txtViewTelefono);
            correo = itemView.findViewById(R.id.txtViewCorreo);
            deuda = itemView.findViewById(R.id.txtViewDeuda);
        }
    }
}
