package com.example.proyectomoralescaranqui;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseTareas extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="Tareas.db";

    public  DataBaseTareas(Context context)
    {
    super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("CREATE TABLE Tarea ("+
                    "id_tarea INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    "nombre VARCHAR NOT NULL, "+
                    "fecha VARACHAR NOT NULL,"+
                    "descripcion VARCHAR NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void guardarDatos(String nombre, String fecha, String descrip)
    {
        getReadableDatabase().execSQL("INSERT INTO Tarea VALUES ("+null+",'"+nombre+"','"+fecha+"','"+descrip+"');");
    }

    public Cursor getTareas()
    {
        return getReadableDatabase().query("Tarea",null,null,null,null,null,null);
    }

    public Cursor getWorkById(String id){
        return getReadableDatabase().rawQuery("SELECT * "+
                                                   "FROM Tarea " +
                                                    "WHERE id_tarea = " + id + ";",null);
    }

    public void editarTarea (String id, String nombre, String fecha, String desc ){
        getReadableDatabase().execSQL("UPDATE Tarea SET nombre = '"+nombre+"', fecha = '"+fecha+"', descripcion= '"+desc+"'WHERE id_tarea=" +id+";");
    }
}
