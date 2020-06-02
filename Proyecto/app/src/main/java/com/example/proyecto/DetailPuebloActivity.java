package com.example.proyecto;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.proyecto.model.Pueblo;


import io.realm.Realm;

public class DetailPuebloActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_MESSAGE2="com.example.proyecto.MESSAGE2";
    public static final String EXTRA_MESSAGE3="com.example.proyecto.MESSAGE3";

    TextView destino,empresa,telefono,duracion,distancia,precio,andenes;
Pueblo pue;
Realm realm;
double coord1,coord2;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pueblo);
        //Flecha atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DatosRealm dr=new DatosRealm();
        realm=Realm.getDefaultInstance();
        Intent intent=getIntent();
        String mensaje= intent.getStringExtra(RutasActivity.EXTRA_MESSAGE1);
        b=findViewById(R.id.btnMaps);
    destino=findViewById(R.id.txtNombre);
    empresa=findViewById(R.id.txtEmpresa);
    telefono=findViewById(R.id.txtTelef);
    duracion=findViewById(R.id.txtDurac);
    distancia=findViewById(R.id.txtDist);
    precio=findViewById(R.id.txtPrecio);
    andenes=findViewById(R.id.txtAnden);
    destino.setText(mensaje);
    pue=dr.rellenarpueblo(realm,mensaje);
    coord1=pue.getCoordenadas();
    coord2=pue.getCoordenadas2();
        empresa.setText(pue.getEmpresa());
        telefono.setText(pue.getTelefonos().get(0));
        duracion.setText(String.valueOf(pue.getDuración()));
        distancia.setText(String.valueOf(pue.getDistancia()));
        precio.setText(pue.getPrecio());
        andenes.setText(pue.getAndenes());

        b.setOnClickListener(this);
    }

    //Metodo para flecha atras
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    @Override
    public void onClick(View v) {
    Intent intent =new Intent(this,MapsActivity.class);
    intent.putExtra(EXTRA_MESSAGE2,coord1);
    intent.putExtra(EXTRA_MESSAGE3,coord2);
    startActivity(intent);
    }


}
