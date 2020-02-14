package com.example.proyectomoralescaranqui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityNuevaTarea extends AppCompatActivity {
    ImageView atras;
    EditText nombre,dia,mes,anio,descripcion;
    ArrayList<String> tarea,fecha,descripciont;
    Button btnGuardar;
    ModeloTarea work;
    DataBaseTareas dataBaseTareas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_tarea);
        atras= (ImageView) findViewById(R.id.atras);
        tarea = new ArrayList<String>();
        fecha = new ArrayList<String>();
        descripciont = new ArrayList<String>();
        dataBaseTareas= new DataBaseTareas(this);
        nombre= (EditText)findViewById(R.id.etNombre);
        dia= (EditText)findViewById(R.id.etDia);
        mes= (EditText)findViewById(R.id.etMes);
        anio= (EditText)findViewById(R.id.etanio);
        descripcion= (EditText)findViewById(R.id.etDescripcion);
        btnGuardar= (Button) findViewById(R.id.btnGuardar);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos();

            }
        });


    }

    public void guardarDatos()
    {
        String nombres;
        String fechas;
        String descr;
        nombres= nombre.getText().toString();
        fechas= dia.getText().toString()+"/"+mes.getText().toString()+"/"+anio.getText().toString();
        descr = descripcion.getText().toString();
        dataBaseTareas.guardarDatos(nombres,fechas,descr);
        Toast.makeText(this,"La tarea se agrego correctamente", Toast.LENGTH_SHORT).show();
        finish();
    }



}
