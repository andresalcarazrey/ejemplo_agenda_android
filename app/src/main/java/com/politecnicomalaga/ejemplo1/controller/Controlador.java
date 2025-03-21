package com.politecnicomalaga.ejemplo1.controller;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.politecnicomalaga.ejemplo1.R;
import com.politecnicomalaga.ejemplo1.model.Agenda;
import com.politecnicomalaga.ejemplo1.model.Persona;
import com.politecnicomalaga.ejemplo1.view.ListActivity;

import java.util.List;
import java.util.function.Function;

public class Controlador {

    //Refactorizado a Singleton
    private static Controlador miSingleton;
    //Conecto el mundo del modelo con la Activity (View)

    //Atributos los del modelo
    private Agenda a;

    private Controlador() {
        this.a = new Agenda(1);
    }

    //Método de implementación del patrón singleton
    public static Controlador getSingleton() {
        if (miSingleton==null) miSingleton = new Controlador();
        return miSingleton;
    }


    //Métodos de conexión con el modelo
    public void addPersona(String n, String ap, String tl, String dire) {
        Persona nueva = new Persona(n,ap,tl,dire);
        a.addPersona(nueva);
    }


    public void loadRV(RecyclerView rv, ListActivity la) {
        //Aquí tenemos que enganchar el recyclerview con su ViewModel
        PersonaViewModel vmodel = new ViewModelProvider(la).get(PersonaViewModel.class);

        //RecyclerView (es una lista de resultados) contendrá los trending movies o series
        //Para ello usamos el patrón Observer (Implementado por todas las clases que heredan de
        //ViewModel
        //Estructura: viewmodelobject.getResults().observe(activity, listadecosasamostrar -> {
        //    proceso de actualización del RecyclerView (Lambda function/method)
        // });
        vmodel.getResults().observe(la, (List<Persona> data) -> {
            // update UI
            // Cogemos el RV (RecyclerView)
            RecyclerView mRecyclerView = la.findViewById(R.id.rvListaPersonas);
            // Creamos un adapter con un enlace a la activity y a los datos a usar
            PersonaAdapter mAdapter = new PersonaAdapter(la,data);
            // Conectamos el adapter y el RV
            mRecyclerView.setAdapter(mAdapter);
            // Asignamos al RV un tipo de layout manager por defecto: típicamente el LinearLayoutManager
            mRecyclerView.setLayoutManager(new LinearLayoutManager(la));

        });


        //Lambda (param1,param2,...) -> (proceso donde se usan param1, param2...)
        //Equivalente: public void nombre(param1, param2,...) { proceso de uso de param1...}

        //Ahora toca programar los botones
        //Pelis
        vmodel.loadData();


    }

    public List<Persona> getPersonas() {
        return a.getAgenda();
    }




}
