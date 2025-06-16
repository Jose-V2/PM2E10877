package com.example.examencontactos.Configuracion;

public class Personas {

    private int id;
    private String nombre;
    private String pais;
    private String telefono;
    private String nota;

    public Personas() {
    }

    public Personas(int id, String nombre, String pais, String telefono, String nota) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.telefono = telefono;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
