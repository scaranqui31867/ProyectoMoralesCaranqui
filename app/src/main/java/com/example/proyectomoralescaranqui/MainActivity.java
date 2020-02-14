package com.example.proyectomoralescaranqui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 Button todasTareas,nuevaTarea;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todasTareas = findViewById(R.id.btnTodasTareas);
        nuevaTarea= findViewById(R.id.btnNuevaTarea);

    }

    public void EntrarTodasTareas(View v)
    {

        Intent intent = new Intent(getApplicationContext(), ActivityTodasTareas.class);
        startActivity(intent);
    }

    public void EntrarNuevaActividad(View v)
    {

        Intent intent = new Intent(getApplicationContext(), ActivityNuevaTarea.class);
        startActivity(intent);
    }

}
