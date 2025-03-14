package com.politecnicomalaga.ejemplo1.model;

import com.google.android.material.animation.ImageMatrixProperty;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Agenda {
    private int codigo;
    private Map<String,Persona> mapaAgenda;


    public Agenda(int codigo) {
        this.codigo = codigo;
    }

    //Getter
    public int getCodigo() {
        return codigo;
    }

    //CRUD Persona
    //Add persona
    public boolean addPersona(Persona p) {
        mapaAgenda.put(p.getsTelefono(),p);
        return true;
    }

    //Eliminar persona
    public boolean erasePersona(String telefono) {
        return !(mapaAgenda.remove(telefono)==null);
    }

   //Buscar persona
   public Persona searchPersona(String telefono) {
        return mapaAgenda.get(telefono);
   }

   //Toda la agenda ordenada por Apellidos
   public List<Persona> getAgenda() {
       LinkedList<Persona> resultado = new LinkedList<>(mapaAgenda.values());
       //Collections.sort(resultado);
       resultado.sort(new Comparator<Persona>() {
           @Override
           public int compare(Persona o1, Persona o2) {
               return o1.getsTelefono().compareTo(o2.getsTelefono());
           }
       });

       return resultado;
   }


}
