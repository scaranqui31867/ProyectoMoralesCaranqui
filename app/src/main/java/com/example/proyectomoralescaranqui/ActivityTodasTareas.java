package com.example.proyectomoralescaranqui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActivityTodasTareas extends AppCompatActivity {
    ListView listaTareas;
    ArrayAdapter<String> adapter;
    ArrayList<String>nombre_tareas;
    ImageView atras;
    ImageButton btnagregar;
    DataBaseTareas dataBaseTareas;
    ArrayList<ModeloTarea> tareasBD;
    Map<String,Integer>mapaTareas;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todas_tareas);
        dataBaseTareas= new DataBaseTareas(this);
        tareasBD= new ArrayList<ModeloTarea>();
        nombre_tareas= new ArrayList<String>();
        mapaTareas = new HashMap<String,Integer>();
        tareasBD= obtenDatos();
        llenarArreglo();
        llenarMapa();
        listaTareas = (ListView) findViewById(R.id.ListaTareas);

        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, nombre_tareas);

        listaTareas.setAdapter(adapter);
        listaTareas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nombre= adapter.getItem(position);

                Intent intent = new Intent(ActivityTodasTareas.this,ActivityTareas.class);
                intent.putExtra("ID_TAREA",mapaTareas.get(nombre));
                startActivity(intent);

            }
        });

        atras= (ImageView) findViewById(R.id.atras);
        btnagregar= (ImageButton) findViewById(R.id.btn_mas);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityNuevaTarea.class);
                startActivity(intent);
            }
        });
    }

    public ArrayList<ModeloTarea> obtenDatos()
    {
        Cursor datos=   dataBaseTareas.getTareas();
        ArrayList<ModeloTarea> tareas = new ArrayList<ModeloTarea>();
        int id;
        String nom,fec,des;
        while (datos.moveToNext())
        {
            id=datos.getInt(datos.getColumnIndex("id_tarea"));
            nom= datos.getString(datos.getColumnIndex("nombre"));
            fec= datos.getString(datos.getColumnIndex("fecha"));
            des= datos.getString(datos.getColumnIndex("descripcion"));
            ModeloTarea modeloTarea = new ModeloTarea(id,nom, fec,des);
            tareas.add(modeloTarea);
        }
        return  tareas;
    }
    public void llenarArreglo()
    {

        for(int i = 0; i< tareasBD.size();i++)
        {
            nombre_tareas.add(tareasBD.get(i).getNombre());
        }
    }
    public void llenarMapa(){
        String llave;
        int valor;
        for(int i = 0; i< tareasBD.size();i++)
        {
            llave= tareasBD.get(i).getNombre();
            valor= tareasBD.get(i).getIdTarea();
            mapaTareas.put(llave,valor);
        }
    }



}
