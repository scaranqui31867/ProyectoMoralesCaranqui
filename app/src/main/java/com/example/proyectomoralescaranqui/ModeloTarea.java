package com.example.proyectomoralescaranqui;

public class ModeloTarea
{
    private int idTarea;
    private String nombre;
    private String fecha;
    private String desc;

    public ModeloTarea( )
    {

    }
    public ModeloTarea(int id,String nom, String fec, String des )
    {
        this.idTarea= id;
        this.nombre= nom;
        this.fecha= fec;
        this.desc= des;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
