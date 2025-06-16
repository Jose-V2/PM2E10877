package com.example.examencontactos.Configuracion;

public class Transacciones {

    public static final String nameDB = "MovilE1";

    public static final String tablaPersonas = "Personas";

    public static final String id = "id";
    public static final String nombre = "nombre";
    public static final String pais = "pais";
    public static final String telefono = "telefono";
    public static final String nota = "nota";

    public static final String CreateTablePersonas = "CREATE TABLE " + tablaPersonas + "( " +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            nombre + " TEXT, "+
            pais + " TEXT, "+
            telefono + " TEXT, "+
            nota + " TEXT )";

    public static final String DROPTablePersonas = "DROP TABLE IF EXISTS " + tablaPersonas;

    public static final String SelectPersonas = "SELECT * FROM " + tablaPersonas;

}
