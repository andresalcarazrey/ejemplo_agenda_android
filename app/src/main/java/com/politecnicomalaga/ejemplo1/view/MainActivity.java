package com.politecnicomalaga.ejemplo1.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.politecnicomalaga.ejemplo1.R;
import com.politecnicomalaga.ejemplo1.controller.Controlador;

public class MainActivity extends AppCompatActivity {

    private Controlador c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        /*
        Aquí añadimos cosas si las necesitamos
         */
        c = Controlador.getSingleton();
    }

    public void addPersonaToModel(View v) {
        //Esto se cambiará a "añadir" una persona nueva a la agenda
        String nombre, apellidos, telefono, direccion;
        EditText etNombre = (EditText)findViewById(R.id.etTexto1);
        EditText etApellidos = (EditText)findViewById(R.id.etTexto2);
        EditText etTelefono = (EditText)findViewById(R.id.etTexto3);
        EditText etDireccion = (EditText)findViewById(R.id.etTexto4);

        //Convertir la zona con escritura de la pantalla en Strings
        Editable editNombre = etNombre.getText();
        nombre = editNombre.toString();

        apellidos = etApellidos.getText().toString();
        telefono = etTelefono.getText().toString();
        direccion = etDireccion.getText().toString();

        c.addPersona(nombre,apellidos,telefono,direccion);

    }


    //Método para pasar a la lista de personas
    public void irAgenda(View v) {
        Intent i = new Intent(this, ListActivity.class);
        startActivity(i);
    }


    public void irMapa(View v) {
        // Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988");

// Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
// Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

// Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }
}