package com.politecnicomalaga.ejemplo1.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.politecnicomalaga.ejemplo1.R;
import com.politecnicomalaga.ejemplo1.controller.Controlador;

public class ListActivity extends AppCompatActivity {

    //Referencia al controlador
    private Controlador c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        /*
        Aquí mis cosas para iniciar la activity
         */

        c = Controlador.getSingleton();

        //Activamos el RecyclerView con los datos

        c.loadRV((RecyclerView)findViewById(R.id.rvListaPersonas),this);
    }


}