package com.politecnicomalaga.ejemplo1.controller;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.politecnicomalaga.ejemplo1.R;
import com.politecnicomalaga.ejemplo1.model.Persona;

public class PersonaHolder extends RecyclerView.ViewHolder {
    private TextView nombre;
    private TextView apellidos;
    private TextView telefono;
    //private WebView image;  //Si las imágenes están en la nube (internet), mejor un webview, no usar ImageView
    public PersonaHolder(@NonNull View itemView, PersonaAdapter adapter) {
        super(itemView);

        //El constructor lo que hace es "buscar" los elementos "views" que se necesiten para cada row
        nombre = (TextView) itemView.findViewById(R.id.tvNombre);
        apellidos = (TextView) itemView.findViewById(R.id.tvApellidos);
        telefono = (TextView) itemView.findViewById(R.id.tvTelefono);


    }

    public TextView getNombre() {
        return nombre;
    }

    public TextView getApellidos() {
        return apellidos;
    }

    public TextView getTelefono() {
        return telefono;
    }


}
