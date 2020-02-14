package com.example.proyectomoralescaranqui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ActivityTareas extends AppCompatActivity {
    TextView tvnombre,tvfecha,tvdesc;
    String id;
    DataBaseTareas dataBaseTareas;
    ImageButton editar;
    ImageView btnAtras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);
        tvnombre=(TextView) findViewById(R.id.tvTareaNombre);
        tvfecha=(TextView) findViewById(R.id.tvTareaFecha);
        tvdesc=(TextView) findViewById(R.id.tvTareaDesc);
        editar= (ImageButton) findViewById(R.id.btn_mas);
        btnAtras= (ImageView) findViewById(R.id.atras);
        id= getIntent().getExtras().get("ID_TAREA").toString();
        dataBaseTareas= new DataBaseTareas(this);
       // Toast.makeText(getApplicationContext(),"ID"+id,Toast.LENGTH_SHORT).show();
        obtenDatoMuestra();
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityTareas.this,ActividadEditar.class);
                intent.putExtra("ID",id);
                startActivity(intent);
                finish();
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void obtenDatoMuestra()
    {
        Cursor datos=   dataBaseTareas.getWorkById(id);
        int idq;
        String nom,fec,des;
        while (datos.moveToNext())
        {
            idq=datos.getInt(datos.getColumnIndex("id_tarea"));
            nom= datos.getString(datos.getColumnIndex("nombre"));
            fec= datos.getString(datos.getColumnIndex("fecha"));
            des= datos.getString(datos.getColumnIndex("descripcion"));
            tvnombre.setText(nom);
            tvfecha.setText(fec);
            tvdesc.setText(des);
        }


    }
}
