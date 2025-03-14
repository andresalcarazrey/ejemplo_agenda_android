package com.politecnicomalaga.ejemplo1.model;

public class Persona implements Comparable<Persona>{

    private static int autoID = 0;

    private String sNombre;
    private String sApellidos;
    private String sTelefono;
    private String direccion;

    public Persona(String sNombre, String sApellidos, String sTelefono, String direccion) {
        this.sNombre = sNombre;
        this.sApellidos = sApellidos;
        this.sTelefono = sTelefono;
        this.direccion=direccion;
        autoID++;


    }

    public static int getAutoID() {
        return autoID;
    }

    public String getsNombre() {
        return sNombre;
    }

    public String getsApellidos() {
        return sApellidos;
    }

    public String getsTelefono() {
        return sTelefono;
    }


    public String getDireccion() {
        return direccion;
    }

    @Override
    public int compareTo(Persona o) {
        return (this.sApellidos.compareTo(o.getsApellidos()));
    }
}
