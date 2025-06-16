package com.example.examencontactos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.examencontactos.Configuracion.Personas;
import com.example.examencontactos.Configuracion.SQLiteConexion;
import com.example.examencontactos.Configuracion.Transacciones;

import java.util.ArrayList;

public class ViewList extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listapersonas;
    ArrayList<Personas> lista;
    ArrayList<String> Arreglolist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_list);

        listapersonas = (ListView) findViewById(R.id.listaper);
        conexion = new SQLiteConexion(this, Transacciones.nameDB, null, 2);

        ObtenerDatos();

        ArrayAdapter<String> adp = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Arreglolist
        );
        listapersonas.setAdapter(adp);

    }

    private void ObtenerDatos() {

        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas person = null;
        lista = new ArrayList<Personas>();

        Cursor cursor = db.rawQuery(Transacciones.SelectPersonas, null);

        while (cursor.moveToNext())
        {
            person = new Personas();
            person.setId(cursor.getInt(0));
            person.setNombre(cursor.getString(1));
            person.setPais(cursor.getString(2));
            person.setTelefono(cursor.getString(3));
            person.setNota(cursor.getString(4));
            
            lista.add(person);
        }
        cursor.close();
        
        FillData();
    }

    private void FillData() {

        Arreglolist = new ArrayList<String>();

        for (int i=0; i< lista.size(); i++)
        {
            Arreglolist.add(
                    lista.get(i).getNombre() + " - " +
                            lista.get(i).getPais() + " - " +
                            lista.get(i).getTelefono()
            );
        }

        ArrayAdapter<String> adp = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Arreglolist
        );
        listapersonas.setAdapter(adp);
    }
}