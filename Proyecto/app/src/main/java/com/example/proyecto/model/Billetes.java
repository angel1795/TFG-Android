package com.example.proyecto.model;

public class Billetes {

    private int id;
    private String s;
    private String fecha;
    private int pagado;


    public Billetes(int id, String s, String fecha, int pagado) {
        this.id = id;
        this.s = s;
        this.fecha = fecha;
        this.pagado = pagado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPagado() {
        return pagado;
    }

    public void setPagado(int pagado) {
        this.pagado = pagado;
    }
}
