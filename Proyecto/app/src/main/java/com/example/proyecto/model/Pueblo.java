package com.example.proyecto.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.Index;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class Pueblo extends RealmObject {

    @PrimaryKey
    private long idPueblo;

    @Index
    private String nombrePueblo;
    private int distancia;
    private String empresa;
    private int duración;
    private RealmList<String> telefonos;
    private String precio;
    private String andenes;
    private double coordenadas;
    private double coordenadas2;

    public Pueblo(long idPueblo, String nombrePueblo, int distancia, String empresa, int duración, RealmList<String> telefonos, String precio, String andenes, double coordenadas,double coordenadas2) {
        this.idPueblo = idPueblo;
        this.nombrePueblo = nombrePueblo;
        this.distancia = distancia;
        this.empresa = empresa;
        this.duración = duración;
        this.telefonos = telefonos;
        this.precio = precio;
        this.andenes = andenes;
        this.coordenadas = coordenadas;
        this.coordenadas2=coordenadas2;
    }

    public double getCoordenadas2() {
        return coordenadas2;
    }

    public void setCoordenadas2(double coordenadas2) {
        this.coordenadas2 = coordenadas2;
    }

    public double getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(double coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Pueblo() {
    }

    public long getIdPueblo() {
        return idPueblo;
    }

    public void setIdPueblo(long idPueblo) {
        this.idPueblo = idPueblo;
    }

    public String getNombrePueblo() {
        return nombrePueblo;
    }

    public void setNombrePueblo(String nombrePueblo) {
        this.nombrePueblo = nombrePueblo;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getDuración() {
        return duración;
    }

    public void setDuración(int duración) {
        this.duración = duración;
    }

    public RealmList<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(RealmList<String> telefonos) {
        this.telefonos = telefonos;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getAndenes() {
        return andenes;
    }

    public void setAndenes(String andenes) {
        this.andenes = andenes;
    }
}
