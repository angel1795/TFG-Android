package com.example.proyecto;

import android.graphics.Bitmap;

import androidx.appcompat.app.AppCompatActivity;


import com.example.proyecto.model.Pueblo;
import com.example.proyecto.model.Rutas;


import java.util.ArrayList;

import io.realm.DynamicRealmObject;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class DatosRealm extends AppCompatActivity {


        public ArrayList<String> rellenarSpinnerRutas(Realm realm) {
        ArrayList<String> resultados = new ArrayList<>();
        RealmResults<Rutas> results = realm.where(Rutas.class).findAll();
        for (Rutas s : results) {
            resultados.add(s.getDestino());
        }
        return resultados;

    }

        public ArrayList<String> rellenarSpinnerHoras(Realm realm) {
        ArrayList<String> resultados = new ArrayList<>();
        RealmResults<Pueblo> results = realm.where(Pueblo.class).findAll();
        for (Pueblo p : results) {
            resultados.add(p.getNombrePueblo());
        }
        return resultados;
    }

        public RealmList<Pueblo> rellenarLinearRutas (Realm realm, String s){
            Rutas r = realm.where(Rutas.class).equalTo("destino", s).findFirst();
            RealmList<Pueblo> listapueblos = r.getPueblos();
            return listapueblos;
        }

        public Pueblo rellenarpueblo (Realm realm, String s){
            Pueblo p = realm.where(Pueblo.class).equalTo("nombrePueblo", s).findFirst();
            return p;
        }

        public void meterdatos (Realm realm){
            realm.executeTransaction(r -> {


                //Introducir pueblos
                Pueblo madrid = r.createObject(Pueblo.class, 1);
                madrid.setNombrePueblo("Madrid");
                madrid.setCoordenadas(40.384654);
                madrid.setCoordenadas2(-3.718116);
                madrid.setEmpresa("ALSA");
                madrid.getTelefonos().add("925223641");
                madrid.setAndenes("27-31");
                madrid.setPrecio("5.47");
                madrid.setDuración(90);
                madrid.setDistancia(71);


                Pueblo cabañas = r.createObject(Pueblo.class, 2);
                cabañas.setNombrePueblo("Cabañas de la Sagra");
                cabañas.setCoordenadas(40.007916);
                cabañas.setCoordenadas2(-3.947465);
                cabañas.setEmpresa("ALSA");
                cabañas.getTelefonos().add("925223641");
                cabañas.setAndenes("27-31");
                cabañas.setPrecio("1.4");
                cabañas.setDuración(20);
                cabañas.setDistancia(18);

                Pueblo yuncos = r.createObject(Pueblo.class, 3);
                yuncos.setNombrePueblo("Yuncos");
                yuncos.setCoordenadas(40.087873);
                yuncos.setCoordenadas2(-3.873181);
                yuncos.setEmpresa("ALSA");
                yuncos.getTelefonos().add("925223641");
                yuncos.setAndenes("27-31");
                yuncos.setPrecio("2.26");
                yuncos.setDuración(25);
                yuncos.setDistancia(25);

                Pueblo illescas = r.createObject(Pueblo.class, 4);
                illescas.setNombrePueblo("Illescas");
                illescas.setCoordenadas(40.124969);
                illescas.setCoordenadas2(-3.849406);
                illescas.setEmpresa("ALSA");
                illescas.getTelefonos().add("925223641");
                illescas.setAndenes("27-31");
                illescas.setPrecio("2.65");
                illescas.setDuración(40);
                illescas.setDistancia(33);

                Pueblo parla = r.createObject(Pueblo.class, 5);
                parla.setNombrePueblo("Parla");
                parla.setCoordenadas(40.234441);
                parla.setCoordenadas2(-3.772780);
                parla.setEmpresa("ALSA");
                parla.getTelefonos().add("925223641");
                parla.setAndenes("27-31");
                parla.setPrecio("3.75");
                parla.setDuración(65);
                parla.setDistancia(55);

                Pueblo getafe = r.createObject(Pueblo.class, 6);
                getafe.setNombrePueblo("Getafe");
                getafe.setCoordenadas(40.308125);
                getafe.setCoordenadas2(-3.734746);
                getafe.setEmpresa("ALSA");
                getafe.getTelefonos().add("925223641");
                getafe.setAndenes("27-31");
                getafe.setPrecio("4.38");
                getafe.setDuración(75);
                getafe.setDistancia(60);

                Pueblo olias = r.createObject(Pueblo.class, 7);
                olias.setNombrePueblo("Olías del rey");
                olias.setCoordenadas(39.945359);
                olias.setCoordenadas2(-3.992751);
                olias.setEmpresa("ALSA");
                olias.getTelefonos().add("925223641");
                olias.setAndenes("27-31");
                olias.setPrecio("1.32");
                olias.setDuración(15);
                olias.setDistancia(7);

                Pueblo cuenca = r.createObject(Pueblo.class, 8);
                cuenca.setNombrePueblo("Cuenca");
                cuenca.setCoordenadas(40.066781);
                cuenca.setCoordenadas2(-2.134920);
                cuenca.setEmpresa("AISA");
                cuenca.getTelefonos().add("902198788");
                cuenca.setAndenes("3-4");
                cuenca.setPrecio("13.1");
                cuenca.setDuración(120);
                cuenca.setDistancia(187);

                Pueblo albacete = r.createObject(Pueblo.class, 9);
                albacete.setNombrePueblo("Albacete");
                albacete.setCoordenadas(38.999947);
                albacete.setCoordenadas2(-1.848404);
                albacete.setEmpresa("AISA");
                albacete.getTelefonos().add("902198788");
                albacete.setAndenes("3-4");
                albacete.setPrecio("16.61");
                albacete.setDuración(165);
                albacete.setDistancia(240);

                Pueblo guadalajara = r.createObject(Pueblo.class, 10);
                guadalajara.setNombrePueblo("Guadalajara");
                guadalajara.setCoordenadas(40.636462);
                guadalajara.setCoordenadas2(-3.173254);
                guadalajara.setEmpresa("AISA");
                guadalajara.getTelefonos().add("902198788");
                guadalajara.setAndenes("27");
                guadalajara.setPrecio("10");
                guadalajara.setDuración(100);
                guadalajara.setDistancia(140);

                Pueblo creal = r.createObject(Pueblo.class, 11);
                creal.setNombrePueblo("Ciudad Real");
                creal.setCoordenadas(38.979414);
                creal.setCoordenadas2(-3.929971);
                creal.setEmpresa("INTERBUS");
                creal.getTelefonos().add("916520011");
                creal.setAndenes("2--6");
                creal.setPrecio("9.73");
                creal.setDuración(90);
                creal.setDistancia(120);

                Pueblo talavera = r.createObject(Pueblo.class, 12);
                talavera.setNombrePueblo("Talavera de la reina");
                talavera.setCoordenadas(39.964147);
                talavera.setCoordenadas2(-4.824719);
                talavera.setEmpresa("TOLETUM");
                talavera.getTelefonos().add("902393132");
                talavera.setAndenes("20-21");
                talavera.setPrecio("7.15");
                talavera.setDuración(80);
                talavera.setDistancia(81);

                Pueblo rielves = r.createObject(Pueblo.class, 13);
                rielves.setNombrePueblo("Rielves");
                rielves.setCoordenadas(39.959372);
                rielves.setCoordenadas2(-4.194178);
                rielves.setEmpresa("TOLETUM");
                rielves.getTelefonos().add("902393132");
                rielves.setAndenes("20-21");
                rielves.setPrecio("1.7");
                rielves.setDuración(20);
                rielves.setDistancia(20);

                Pueblo torrijos = r.createObject(Pueblo.class, 14);
                torrijos.setNombrePueblo("Torrijos");
                torrijos.setCoordenadas(39.979505);
                torrijos.setCoordenadas2(-4.286149);
                torrijos.setEmpresa("TOLETUM");
                torrijos.getTelefonos().add("9023931324");
                torrijos.setAndenes("20-21");
                torrijos.setPrecio("2.5");
                torrijos.setDuración(20);
                torrijos.setDistancia(30);

                Pueblo maqueda = r.createObject(Pueblo.class, 15);
                maqueda.setNombrePueblo("Maqueda");
                maqueda.setCoordenadas(40.065323);
                maqueda.setCoordenadas2(-4.372386);
                maqueda.setEmpresa("ÁLVAREZ");
                maqueda.getTelefonos().add("618451719");
                maqueda.setAndenes("19");
                maqueda.setPrecio("3.3");
                maqueda.setDuración(50);
                maqueda.setDistancia(41);

                Pueblo solalla = r.createObject(Pueblo.class, 16);
                solalla.setNombrePueblo("Santa Olalla");
                solalla.setCoordenadas(40.024054);
                solalla.setCoordenadas2(-4.431636);
                solalla.setEmpresa("TOLETUM");
                solalla.getTelefonos().add("902393132");
                solalla.setAndenes("20-21");
                solalla.setPrecio("3.8");
                solalla.setDuración(45);
                solalla.setDistancia(44);

                Pueblo arges = r.createObject(Pueblo.class, 17);
                arges.setNombrePueblo("Argés");
                arges.setCoordenadas(39.801619);
                arges.setCoordenadas2(-4.056575);
                arges.setEmpresa("SAMAR");
                arges.getTelefonos().add("925221217");
                arges.setAndenes("7-14");
                arges.setPrecio("1.3");
                arges.setDuración(15);
                arges.setDistancia(9);

                Pueblo layos = r.createObject(Pueblo.class, 18);
                layos.setNombrePueblo("Layos");
                layos.setCoordenadas(39.777436);
                layos.setCoordenadas2(-4.065021);
                layos.setEmpresa("SAMAR");
                layos.getTelefonos().add("925221217");
                layos.setAndenes("7-14");
                layos.setPrecio("1.3");
                layos.setDuración(20);
                layos.setDistancia(13);

                Pueblo pulgar = r.createObject(Pueblo.class, 19);
                pulgar.setNombrePueblo("Pulgar");
                pulgar.setCoordenadas(39.694377);
                pulgar.setCoordenadas2(-4.153479);
                pulgar.setEmpresa("SAMAR");
                pulgar.getTelefonos().add("925221217");
                pulgar.setAndenes("7-14");
                pulgar.setPrecio("1.93");
                pulgar.setDuración(30);
                pulgar.setDistancia(26);

                Pueblo cobisa = r.createObject(Pueblo.class, 20);
                cobisa.setNombrePueblo("Cobisa");
                cobisa.setCoordenadas(39.806477);
                cobisa.setCoordenadas2(-4.028838);
                cobisa.setEmpresa("SAMAR");
                cobisa.getTelefonos().add("925221217");
                cobisa.setAndenes("7-14");
                cobisa.setPrecio("1.3");
                cobisa.setDuración(15);
                cobisa.setDistancia(9);

                Pueblo burguillos = r.createObject(Pueblo.class, 21);
                burguillos.setNombrePueblo("Burguillos de Toledo");
                burguillos.setCoordenadas(39.799878);
                burguillos.setCoordenadas2(-3.991568);
                burguillos.setEmpresa("SAMAR");
                burguillos.getTelefonos().add("925221217");
                burguillos.setAndenes("7-14");
                burguillos.setPrecio("1.3");
                burguillos.setDuración(15);
                burguillos.setDistancia(11);

                Pueblo ajofrin = r.createObject(Pueblo.class, 22);
                ajofrin.setNombrePueblo("Ajofrín");
                ajofrin.setCoordenadas(39.712406);
                ajofrin.setCoordenadas2(-3.981998);
                ajofrin.setEmpresa("SAMAR");
                ajofrin.getTelefonos().add("925221217");
                ajofrin.setAndenes("7-14");
                ajofrin.setPrecio("1.65");
                ajofrin.setDuración(20);
                ajofrin.setDistancia(18);

                Pueblo sonseca = r.createObject(Pueblo.class, 23);
                sonseca.setNombrePueblo("Sonseca");
                sonseca.setCoordenadas(39.679439);
                sonseca.setCoordenadas2(-3.970935);
                sonseca.setEmpresa("SAMAR");
                sonseca.getTelefonos().add("925221217");
                sonseca.setAndenes("7-14");
                sonseca.setPrecio("1.9");
                sonseca.setDuración(30);
                sonseca.setDistancia(24);

                Pueblo guadamur = r.createObject(Pueblo.class, 24);
                guadamur.setNombrePueblo("Guadamur");
                guadamur.setCoordenadas(39.811608);
                guadamur.setCoordenadas2(-4.149193);
                guadamur.setEmpresa("SAMAR");
                guadamur.getTelefonos().add("925221217");
                guadamur.setAndenes("7-14");
                guadamur.setPrecio("1.3");
                guadamur.setDuración(20);
                guadamur.setDistancia(16);

                Pueblo polan = r.createObject(Pueblo.class, 25);
                polan.setNombrePueblo("Polán");
                polan.setCoordenadas(39.787560);
                polan.setCoordenadas2(-4.169729);
                polan.setEmpresa("SAMAR");
                polan.getTelefonos().add("925221217");
                polan.setAndenes("7-14");
                polan.setPrecio("1.49");
                polan.setDuración(25);
                polan.setDistancia(16);

                Pueblo galvez = r.createObject(Pueblo.class, 26);
                galvez.setNombrePueblo("Gálvez");
                galvez.setCoordenadas(39.702012);
                galvez.setCoordenadas2(-4.274874);
                galvez.setEmpresa("SAMAR");
                galvez.getTelefonos().add("925221217");
                galvez.setAndenes("7-14");
                galvez.setPrecio("2.9");
                galvez.setDuración(45);
                galvez.setDistancia(30);


                //Introducir rutas

                Rutas madriddirecto = r.createObject(Rutas.class, 1);
                madriddirecto.setDestino("Madrid directo");
                madriddirecto.getPueblos().add(madrid);
                //getString(R.string.madridpp)
                //getString(R.string.madridd)
                Rutas madridpueblos = r.createObject(Rutas.class, 2);
                madridpueblos.setDestino("Madrid por pueblos");
                madridpueblos.getPueblos().add(olias);
                madridpueblos.getPueblos().add(cabañas);
                madridpueblos.getPueblos().add(yuncos);
                madridpueblos.getPueblos().add(illescas);
                madridpueblos.getPueblos().add(parla);
                madridpueblos.getPueblos().add(getafe);
                madridpueblos.getPueblos().add(madrid);

                Rutas oliasr = r.createObject(Rutas.class, 3);
                oliasr.setDestino("Olías del rey");
                oliasr.getPueblos().add(olias);

                Rutas cuencar = r.createObject(Rutas.class, 4);
                cuencar.setDestino("Cuenca");
                cuencar.getPueblos().add(cuenca);

                Rutas albaceter = r.createObject(Rutas.class, 5);
                albaceter.setDestino("Albacete");
                albaceter.getPueblos().add(albacete);

                Rutas guadalajarar = r.createObject(Rutas.class, 6);
                guadalajarar.setDestino("Guadalajara");
                guadalajarar.getPueblos().add(guadalajara);

                Rutas crealr = r.createObject(Rutas.class, 7);
                crealr.setDestino("Ciudad Real");
                crealr.getPueblos().add(creal);

                Rutas talaverad = r.createObject(Rutas.class, 8);
                talaverad.setDestino("Talavera directo");
                talaverad.getPueblos().add(talavera);

                Rutas talaverapp = r.createObject(Rutas.class, 9);
                talaverapp.setDestino("Talavera por pueblos");
                talaverapp.getPueblos().add(rielves);
                talaverapp.getPueblos().add(torrijos);
                talaverapp.getPueblos().add(solalla);
                talaverapp.getPueblos().add(talavera);

                Rutas maquedar = r.createObject(Rutas.class, 10);
                maquedar.setDestino("Maqueda");
                maquedar.getPueblos().add(maqueda);

                Rutas pulgarr = r.createObject(Rutas.class, 11);
                pulgarr.setDestino("Púlgar");
                pulgarr.getPueblos().add(arges);
                pulgarr.getPueblos().add(layos);
                pulgarr.getPueblos().add(pulgar);


                Rutas sonsecar = r.createObject(Rutas.class, 12);
                sonsecar.setDestino("Sonseca");
                sonsecar.getPueblos().add(cobisa);
                sonsecar.getPueblos().add(burguillos);
                sonsecar.getPueblos().add(ajofrin);
                sonsecar.getPueblos().add(sonseca);


                Rutas galvezr = r.createObject(Rutas.class, 13);
                galvezr.setDestino("Gálvez");
                galvezr.getPueblos().add(guadamur);
                galvezr.getPueblos().add(polan);
                galvezr.getPueblos().add(galvez);
            });
        }

}
