package com.example.examencontactos;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityResult extends AppCompatActivity {

    TextView txtnombre, txttelefono, txtnota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        txtnombre = (TextView) findViewById(R.id.txtnombre);
        txttelefono = (TextView) findViewById(R.id.txttelefono);
        txtnota = (TextView) findViewById(R.id.txtnota);

        txtnombre.setText(getIntent().getStringExtra("nombre"));
        txttelefono.setText(getIntent().getStringExtra("telefono"));
        txtnota.setText(getIntent().getStringExtra("nota"));

    }
}