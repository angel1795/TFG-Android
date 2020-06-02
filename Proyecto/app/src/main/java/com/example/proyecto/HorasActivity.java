package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import io.realm.Realm;

public class HorasActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {



    String[][] polangalvezguadamur= new String[][]{{"9:15", "9:15", "9:15", "9:15", "9:15", "12:15", "10:30"},
            {"12:15", "12:15", "12:15", "12:15", "12:15", "14:30", "16:30"},
            {"14:30", "14:30", "14:30", "14:30", "14:30", "17:30", "21:30"},
            {"17:30", "17:30", "17:30", "17:30", "17:30", "21:30", ""},
            {"20:15", "20:15", "20:15", "20:15", "20:15", "", ""}};

    String[][] sonsecaajofrinburguillos = new String[][]{{"9:15", "9:15", "9:15", "9:15", "9:15", "12:15", "10:30"},
            {"12:15", "12:15", "12:15", "12:15", "12:15", "14:30", "16:30"},
            {"14:30", "14:30", "14:30", "14:30", "14:30", "17:30", "21:30"},
            {"16:00", "16:00", "16:00", "16:00", "16:00", "21:30", ""},
            {"17:30", "17:30", "17:30", "17:30", "17:30", "", ""},
            {"20:15", "20:15", "20:15", "20:15", "20:15", "", ""},
            {"21:00", "21:00", "21:00", "21:00", "21:00", "", ""}};

    String[][] cobisapulgarlayosarges= new String[][]{     {"12:15", "12:15", "12:15", "12:15", "12:15", "12:15", "10:30"},
            {"14:30", "14:30", "14:30", "14:30", "14:30", "14:30", "16:30"},
            {"17:30", "17:30", "17:30", "17:30", "17:30", "17:30", "21:30"},
            {"20:15", "20:15", "20:15", "20:15", "20:15", "21:30", ""}};

    String[][] maqueda= new String[][]{     {"12:30", "12:30", "12:30", "12:30", "12:30", "13:30", ""},
            {"13:30", "13:30", "13:30", "13:30", "13:30", "", ""},
            {"18:00", "18:00", "18:00", "18:00", "18:00", "", ""}};

    String[][] solallatorrijosrielv= new String[][]{     {"6:45", "6:45", "6:45", "6:45", "6:45", "8:00", "8:00"},
            {"8:00", "8:00", "8:00", "8:00", "8:00", "12:30", "12:30"},
            {"10:00", "10:00", "10:00", "10:00", "10:00", "15:15", "15:15"},
            {"13:30", "13:30", "13:30", "13:30", "13:30", "22:00", "20:00"},
            {"17:00", "17:00", "17:00", "17:00", "17:00", "", "22:00"},
            {"18:30", "18:30", "18:30", "18:30", "18:30", "", ""},
            {"22:00", "22:00", "22:00", "22:00", "22:00", "", ""}};

    String[][] talavera= new String[][]{     {"6:45", "6:45", "6:45", "6:45", "6:45", "8:00", "8:00"},
            {"8:00", "8:00", "8:00", "8:00", "8:00", "12:30", "12:30"},
            {"10:00", "10:00", "10:00", "10:00", "10:00", "15:15", "15:15"},
            {"13:30", "13:30", "13:30", "13:30", "13:30", "22:00", "28:00"},
            {"15:15", "15:15", "15:15", "15:15", "15:15", "", "20:00"},
            {"17:00", "17:00", "17:00", "17:00", "17:00", "", "22:00"},
            {"18:30", "18:30", "18:30", "18:30", "18:30", "", ""},
            {"22:00", "22:00", "22:00", "22:00", "22:00", "", ""}};

    String[][] creal= new String[][]{     {"7:00", "7:00", "7:00", "7:00", "7:00", "10:30", "10:30"},
            {"8:00", "16:00", "16:00", "16:00", "8:00", "17:30", "20:00"},
            {"16:00","","","","16:00", "", ""}};

    String[][] guadalajara= new String[][]{ {"9:00", "9:00", "9:00", "9:00", "9:00", "", "20:00"},
            {"17:00", "17:00", "17:00", "17:00", "17:00", "", ""}};

    String[][] albacete= new String[][]{ {"16:15", "16:15", "16:15", "16:15", "16:15", "", "19:30"},
            {"", "", "", "", "19:30", "", ""}};

    String[][] cuenca= new String[][]{ {"16:15", "16:15", "16:15", "16:15", "16:15", "", "19:30"},
            {"", "", "", "", "18:30", "", ""}};

    String[][] madridpueblos= new String[][]{ {"6:00", "6:00", "6:00", "6:00", "6:00", "8:00", "8:00"},
            {"6:30", "6:30", "6:30", "6:30", "6:30", "8:30", "9:00"},
            {"7:00", "7:00", "7:00", "7:00", "7:00", "9:00", "10:00"},
            {"7:30", "7:30", "7:30", "7:30", "7:30", "9:30", "10:30"},
            {"8:00", "8:00", "8:00", "8:00", "8:00", "10:00", "11:00"},
            {"8:30", "8:30", "8:30", "8:30", "8:30", "10:30", "11:30"},
            {"9:00", "9:00", "9:00", "9:00", "9:00", "11:00", "12:00"},
            {"9:30", "9:30", "9:30", "9:30", "9:30", "11:30", "12:30"},
            {"10:00", "10:00", "10:00", "10:00", "10:00", "12:00", "13:00"},
            {"10:30", "10:30", "10:30", "10:30", "10:30", "12:30", "13:30"},
            {"11:00", "11:00", "11:00", "11:00", "11:00", "13:00", "14:00"},
            {"11:30", "11:30", "11:30", "11:30", "11:30", "13:30", "14:30"},
            {"12:00", "12:00", "12:00", "12:00", "12:00", "14:00", "15:00"},
            {"12:30", "12:30", "12:30", "12:30", "12:30", "14:30", "15:30"},
            {"13:00", "13:00", "13:00", "13:00", "13:00", "15:00", "16:00"},
            {"13:30", "13:30", "13:30", "13:30", "13:30", "15:30", "16:30"},
            {"14:00", "14:00", "14:00", "14:00", "14:00", "16:00", "17:00"},
            {"14:30", "14:30", "14:30", "14:30", "14:30", "16:30", "17:30"},
            {"15:00", "15:00", "15:00", "15:00", "15:00", "17:00", "18:00"},
            {"15:30", "15:30", "15:30", "15:30", "15:30", "17:30", "18:30"},
            {"16:00", "16:00", "16:00", "16:00", "16:00", "18:00", "19:00"},
            {"16:30", "16:30", "16:30", "16:30", "16:30", "18:30", "19:30"},
            {"17:00", "17:00", "17:00", "17:00", "17:00", "19:00", "20:00"},
            {"17:30", "17:30", "17:30", "17:30", "17:30", "19:30", "20:30"},
            {"18:00", "18:00", "18:00", "18:00", "18:00", "20:00", "21:00"},
            {"18:30", "18:30", "18:30", "18:30", "18:30", "20:30", "21:30"},
            {"19:00", "19:00", "19:00", "19:00", "19:00", "21:00", "22:00"},
            {"19:30", "19:30", "19:30", "19:30", "19:30", "21:30", "22:30"},
            {"20:00", "20:00", "20:00", "20:00", "20:00", "22:00", "23:00"},
            {"20:30", "20:30", "20:30", "20:30", "20:30", "22:30", "23:30"},
            {"21:00", "21:00", "21:00", "21:00", "21:00", "7:30", ""},
            {"22:00", "22:00", "22:00", "22:00", "22:00", "7:00", ""},
            {"22:30", "22:30", "22:30", "22:30", "22:30", "6:30", ""}};

    String[][] madriddirecto= new String[][]{ {"6:00", "6:00", "6:00", "6:00", "6:00", "8:00", "8:00"},
            {"6:30", "6:30", "6:30", "6:30", "6:30", "8:30", "9:00"},
            {"7:00", "7:00", "7:00", "7:00", "7:00", "9:00", "10:00"},
            {"7:30", "7:30", "7:30", "7:30", "7:30", "9:30", "10:30"},
            {"8:00", "8:00", "8:00", "8:00", "8:00", "10:00", "11:00"},
            {"8:30", "8:30", "8:30", "8:30", "8:30", "10:30", "11:30"},
            {"9:00", "9:00", "9:00", "9:00", "9:00", "11:00", "12:00"},
            {"9:30", "9:30", "9:30", "9:30", "9:30", "11:30", "12:30"},
            {"10:00", "10:00", "10:00", "10:00", "10:00", "12:00", "13:00"},
            {"10:30", "10:30", "10:30", "10:30", "10:30", "12:30", "13:30"},
            {"11:00", "11:00", "11:00", "11:00", "11:00", "13:00", "14:00"},
            {"11:30", "11:30", "11:30", "11:30", "11:30", "13:30", "14:30"},
            {"12:00", "12:00", "12:00", "12:00", "12:00", "14:00", "15:00"},
            {"12:30", "12:30", "12:30", "12:30", "12:30", "14:30", "15:30"},
            {"13:00", "13:00", "13:00", "13:00", "13:00", "15:00", "16:00"},
            {"13:30", "13:30", "13:30", "13:30", "13:30", "15:30", "16:30"},
            {"14:00", "14:00", "14:00", "14:00", "14:00", "16:00", "17:00"},
            {"14:30", "14:30", "14:30", "14:30", "14:30", "16:30", "17:30"},
            {"15:00", "15:00", "15:00", "15:00", "15:00", "17:00", "18:00"},
            {"15:30", "15:30", "15:30", "15:30", "15:30", "17:30", "18:30"},
            {"16:00", "16:00", "16:00", "16:00", "16:00", "18:00", "19:00"},
            {"16:30", "16:30", "16:30", "16:30", "16:30", "18:30", "19:30"},
            {"17:00", "17:00", "17:00", "17:00", "17:00", "19:00", "20:00"},
            {"17:30", "17:30", "17:30", "17:30", "17:30", "19:30", "20:30"},
            {"18:00", "18:00", "18:00", "18:00", "18:00", "20:00", "21:00"},
            {"18:30", "18:30", "18:30", "18:30", "18:30", "20:30", ""},
            {"19:00", "19:00", "19:00", "19:00", "19:00", "21:00", ""},
            {"22:00", "22:00", "22:00", "22:00", "22:00", "", ""}};

    Spinner spinerhoras;
    Realm realm;
    ArrayList<String> tot2;
    ArrayAdapter adapter2;
    TableLayout tablaH2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horas);
        //Flecha atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spinerhoras=findViewById(R.id.spnhoras);
        DatosRealm dr=new DatosRealm();
        realm= Realm.getDefaultInstance();
        tot2=dr.rellenarSpinnerHoras(realm);

        adapter2=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,tot2);
        spinerhoras.setAdapter(adapter2);
        spinerhoras.setBackgroundColor(Color.parseColor("#FFDE07"));
        spinerhoras.setOnItemSelectedListener(this);


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
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spn=findViewById(R.id.spnhoras);
        tablaH2=findViewById(R.id.tableHoras);
        String s=spn.getSelectedItem().toString();
       if(s.contains(getString(R.string.madrid))){
            rellenartabla(madriddirecto,tablaH2);

       }else if(s.contains("Polán") || s.contains("Gálvez") || s.contains("Guadamur")){
           rellenartabla(polangalvezguadamur,tablaH2);
       }else if(s.contains("Sonseca") || s.contains("Ajofrín") || s.contains("Burguillos")){
           rellenartabla(sonsecaajofrinburguillos,tablaH2);
       }else if(s.contains("Cobisa") || s.contains("Pulgar") || s.contains("Layos") || s.contains("Argés")){
           rellenartabla(cobisapulgarlayosarges,tablaH2);
        }else if(s.contains("Maqueda")){
           rellenartabla(maqueda,tablaH2);
       }else if(s.contains("Santa Olalla") || s.contains("Torrijos") || s.contains("Rielves")){
           rellenartabla(solallatorrijosrielv,tablaH2);
       }else if(s.contains("Talavera")){
           rellenartabla(talavera,tablaH2);
       }else if(s.contains("Ciudad Real")){
           rellenartabla(creal,tablaH2);
       }else if(s.contains("Guadalajara")){
           rellenartabla(guadalajara,tablaH2);
       }else if(s.contains("Albacete")){
           rellenartabla(albacete,tablaH2);
       }else if(s.contains("Cuenca")){
           rellenartabla(cuenca,tablaH2);
       }else if(s.contains("Cabañas")||s.contains("Yuncos")||s.contains("Illescas")||s.contains("Parla")||s.contains("Getafe")||s.contains("Olías")){
           rellenartabla(madridpueblos,tablaH2);
       }else{

       }

     }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void rellenartabla(String[][] s,TableLayout tablaH){

        if(tablaH.getChildCount()>1){
            int filas=tablaH.getChildCount();
            tablaH.removeViews(1,filas-1);
        }

        for(int i=0;i<s.length;i++){
            TableRow fila=new TableRow(this);

            fila.setBackgroundColor(Color.parseColor("#0D54A5"));
            TextView t1=new TextView(this);
            TextView t2=new TextView(this);
            TextView t3=new TextView(this);
            TextView t4=new TextView(this);
            TextView t5=new TextView(this);
            TextView t6=new TextView(this);
            TextView t7=new TextView(this);

            t1.setTextColor(Color.parseColor("#FFDE07"));
            t2.setTextColor(Color.parseColor("#FFDE07"));
            t3.setTextColor(Color.parseColor("#FFDE07"));
            t4.setTextColor(Color.parseColor("#FFDE07"));
            t5.setTextColor(Color.parseColor("#FFDE07"));
            t6.setTextColor(Color.parseColor("#FFDE07"));
            t7.setTextColor(Color.parseColor("#FFDE07"));

            t1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            t2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            t3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            t4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            t5.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            t6.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            t7.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            t1.setText(s[i][0]);
            t2.setText(s[i][1]);
            t3.setText(s[i][2]);
            t4.setText(s[i][3]);
            t5.setText(s[i][4]);
            t6.setText(s[i][5]);
            t7.setText(s[i][6]);
            fila.addView(t1);
            fila.addView(t2);
            fila.addView(t3);
            fila.addView(t4);
            fila.addView(t5);
            fila.addView(t6);
            fila.addView(t7);
            tablaH.addView(fila);

        }

    }
}
