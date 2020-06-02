package com.example.proyecto.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class Rutas extends RealmObject {

    @PrimaryKey
    private long idruta;

    @Index
    private String destino;

    private RealmList<Pueblo> pueblos;

    public long getIdruta() {
        return idruta;
    }

    public void setIdruta(long idruta) {
        this.idruta = idruta;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public RealmList<Pueblo> getPueblos() {
        return pueblos;
    }

    public void setPueblos(RealmList<Pueblo> pueblos) {
        this.pueblos = pueblos;
    }
}
