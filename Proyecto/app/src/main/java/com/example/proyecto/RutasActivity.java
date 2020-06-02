package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.proyecto.model.Pueblo;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmList;

public class RutasActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
public static final String EXTRA_MESSAGE1="com.example.proyecto.MESSAGE1";
ArrayList<String> tot;
Spinner spinerrutas;
Realm realm;
ArrayAdapter adapter;
LinearLayout lin;
RealmList<Pueblo>lpueblos;
String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rutas);
        spinerrutas=findViewById(R.id.spnRutas);
        //Flecha atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DatosRealm dr=new DatosRealm();
        realm=Realm.getDefaultInstance();
        tot=dr.rellenarSpinnerRutas(realm);
        adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,tot);
        spinerrutas.setAdapter(adapter);
        spinerrutas.setBackgroundColor(Color.parseColor("#FFDE07"));
        spinerrutas.setOnItemSelectedListener(this);
    }

    //Metodo para flecha atras
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    spinerrutas=findViewById(R.id.spnRutas);
    String t=spinerrutas.getSelectedItem().toString();

    lin=findViewById(R.id.linparadas);
    lin.removeAllViews();
        DatosRealm dr=new DatosRealm();
      lpueblos= dr.rellenarLinearRutas(realm,t);

        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT );
        for(int i=0;i<lpueblos.size();i++){
            Button button=new Button(this);
            button.setLayoutParams(lp);
            button.setText(lpueblos.get(i).getNombrePueblo());
            button.setOnClickListener(new ButtonsOnClickListener(this));
            lin.addView(button);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    class ButtonsOnClickListener implements View.OnClickListener {


        public ButtonsOnClickListener(RutasActivity rutasActivity) {
        }

        @Override
        public void onClick(View v) {
            Button b=(Button) v;
           texto= String.valueOf(b.getText());
            Intent intent=new Intent(getBaseContext(),DetailPuebloActivity.class);
            intent.putExtra(EXTRA_MESSAGE1,texto);
            startActivity(intent);
        }
    }
}
