package com.example.examencontactos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.examencontactos.Configuracion.SQLiteConexion;
import com.example.examencontactos.Configuracion.Transacciones;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText nombre,telefono,nota;

    Button btnsave, btnlista;

    Spinner spinner;

    private String paisSeleccionado = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.listpais);
        nombre = (EditText) findViewById(R.id.nombre);
        telefono = (EditText) findViewById(R.id.telefono);
        nota = (EditText) findViewById(R.id.nota);

        btnsave = (Button) findViewById(R.id.btnsave);
        btnlista = (Button) findViewById(R.id.btnview);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Honduras (+504)");
        arrayList.add("Costa Rica (+506)");
        arrayList.add("Guatemala (+502)");
        arrayList.add("El Salvador (+503)");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                paisSeleccionado = adapterView.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                agregarPersona();
            }
        });

        btnlista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewList.class);
                startActivity(intent);
            }
        });

    }

    private void agregarPersona() {

        if (nombre.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Ingrese un Nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        if (telefono.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Ingrese Telefono", Toast.LENGTH_SHORT).show();
            return;
        }
        if (nota.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Ingrese una nota", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.nameDB, null, 2);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Transacciones.nombre, nombre.getText().toString());
        values.put(Transacciones.pais, paisSeleccionado);
        values.put(Transacciones.telefono, telefono.getText().toString());
        values.put(Transacciones.nota, nota.getText().toString());

        Long resultado = db.insert(Transacciones.tablaPersonas, Transacciones.id, values);

        Toast.makeText(getApplicationContext(),
                "Persona Ingresada con exito" + resultado.toString(), Toast.LENGTH_LONG).show();

        db.close();

    }
}