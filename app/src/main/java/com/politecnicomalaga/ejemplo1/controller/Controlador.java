package com.politecnicomalaga.ejemplo1.controller;

import androidx.recyclerview.widget.RecyclerView;

import com.politecnicomalaga.ejemplo1.model.Agenda;
import com.politecnicomalaga.ejemplo1.model.Persona;

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


    public void loadRV(RecyclerView rv) {

    }




}
