package com.example.proyectomoralescaranqui;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ActividadEditar extends AppCompatActivity {

    EditText nombre, dia, mes, anio, descripcion;
    String id;
    DataBaseTareas dataBaseTareas;
    Button actualizar;
    ImageView btnAtras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_editar);
        dataBaseTareas = new DataBaseTareas(this);
        nombre = (EditText) findViewById(R.id.etNombre);
        dia = (EditText) findViewById(R.id.etDia);
        mes = (EditText) findViewById(R.id.etMes);
        anio = (EditText) findViewById(R.id.etanio);
        descripcion = (EditText) findViewById(R.id.etDescripcion);
        actualizar = (Button) findViewById(R.id.btnGuardar);
        btnAtras= (ImageView) findViewById(R.id.atras);
        id = getIntent().getExtras().get("ID").toString();
        obtenDatoMuestra();

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fecha;
                fecha= dia.getText().toString()+"/"+mes.getText().toString()+"/"+anio.getText().toString();
                dataBaseTareas.editarTarea(id,nombre.getText().toString(),fecha,descripcion.getText().toString());
                finish();
                Toast.makeText(ActividadEditar.this, "Tarea actualizada correctamente", Toast.LENGTH_SHORT).show();
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
        Cursor datos = dataBaseTareas.getWorkById(id);
        int idq;
        String nom, fec, des;
        while (datos.moveToNext()) {
            idq = datos.getInt(datos.getColumnIndex("id_tarea"));
            nom = datos.getString(datos.getColumnIndex("nombre"));
            fec = datos.getString(datos.getColumnIndex("fecha"));
            des = datos.getString(datos.getColumnIndex("descripcion"));
            nombre.setText(nom);
            dia.setText(fec.substring(0,2));
            mes.setText(fec.substring(3,6));
            anio.setText(fec.substring(7));
            descripcion.setText(des);

        }
    }
}
