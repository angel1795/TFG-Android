package com.example.proyecto;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyecto.model.Pueblo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import io.realm.Realm;

public class CompraActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

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

Realm realm;
ArrayList<String> listaPueblos;
ArrayAdapter adapter3,adapter4;
Spinner selecPueblo, selechora;
String puebloselect="Madrid",fecha="";
Button bfecha,bcompra,bgpay;
Calendar c;
DatePickerDialog dtpFecha;
TextView precio,anden,edtFecha, prueba;
Pueblo p;
int dia=8;
RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //realm
        realm=Realm.getDefaultInstance();
        DatosRealm dr=new DatosRealm();
        //rellenar spinner pueblos
        listaPueblos=dr.rellenarSpinnerHoras(realm);
        adapter3=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,listaPueblos);
        selecPueblo=findViewById(R.id.spnBillete);
        selecPueblo.setAdapter(adapter3);
        selecPueblo.setOnItemSelectedListener(this);
        bfecha=findViewById(R.id.btnFecha);
        bcompra=findViewById(R.id.btnCompM);
        bgpay=findViewById(R.id.btncompGP);
        bcompra.setOnClickListener(this);
        bgpay.setOnClickListener(this);
        bfecha.setOnClickListener(this);
        edtFecha=findViewById(R.id.edtFecha);
        selechora=findViewById(R.id.spnHoraBill);
        precio=findViewById(R.id.txtPrecio);
        anden=findViewById(R.id.txtAnden);
        prueba=findViewById(R.id.txtmsg);
        p=dr.rellenarpueblo(realm,puebloselect);
    }

    @Override
    protected void onResume() {
        super.onResume();


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
        puebloselect=selecPueblo.getSelectedItem().toString();
        DatosRealm dr=new DatosRealm();
        p=dr.rellenarpueblo(realm,puebloselect);
        precio.setText(p.getPrecio());
        anden.setText(p.getAndenes());
        if(dia==8){
        }else {
            rellenarhoraB();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnFecha:
                showDatePickerDialog();
                break;
            case R.id.btncompGP:
                pago(true);
                break;
            case R.id.btnCompM:
                pago(false);

                break;
        }
    }

//enseñar dialogo para escoger fecha
    private void showDatePickerDialog() {
        c=Calendar.getInstance();
        int day=c.get(Calendar.DAY_OF_MONTH);
        int month=c.get(Calendar.MONTH);
        int year=c.get(Calendar.YEAR);
        dtpFecha=new DatePickerDialog(CompraActivity.this, (view, myear, mmonth, ddayOfMonth) -> {
            edtFecha.setText(ddayOfMonth+"/"+(mmonth+1)+"/"+myear);
            TimeZone timezone = TimeZone.getDefault();
            Calendar calendar = new GregorianCalendar(timezone);
            calendar.set(myear, mmonth, ddayOfMonth);
            int nD=calendar.get(Calendar.DAY_OF_WEEK);
            switch (nD){
                case 1:
                    dia=6;
                    break;
                case 2:
                    dia=0;
                    break;
                case 3:
                    dia=1;
                    break;
                case 4:
                    dia=2;
                    break;
                case 5:
                    dia=3;
                    break;
                case 6:
                    dia=4;
                    break;
                case 7:
                    dia=5;
                    break;
            }
            rellenarhoraB();
        },year,month,day);
        dtpFecha.show();
    }

    //Seleccionar el array de horas
    public void rellenarhoraB(){
            if (puebloselect.contains(getString(R.string.madrid))) {
                datoshoras(madriddirecto);
            } else if (puebloselect.contains("Polán") || puebloselect.contains("Gálvez") || puebloselect.contains("Guadamur")) {
                datoshoras(polangalvezguadamur);
            } else if (puebloselect.contains("Sonseca") || puebloselect.contains("Ajofrín") || puebloselect.contains("Burguillos")) {
                datoshoras(sonsecaajofrinburguillos);
            } else if (puebloselect.contains("Cobisa") || puebloselect.contains("Pulgar") || puebloselect.contains("Layos") || puebloselect.contains("Argés")) {
                datoshoras(cobisapulgarlayosarges);
            } else if (puebloselect.contains("Maqueda")) {
                datoshoras(maqueda);
            } else if (puebloselect.contains("Santa Olalla") || puebloselect.contains("Torrijos") || puebloselect.contains("Rielves")) {
                datoshoras(solallatorrijosrielv);
            } else if (puebloselect.contains("Talavera")) {
                datoshoras(talavera);
            } else if (puebloselect.contains("Ciudad Real")) {
                datoshoras(creal);
            } else if (puebloselect.contains("Guadalajara")) {
                datoshoras(guadalajara);
            } else if (puebloselect.contains("Albacete")) {
                datoshoras(albacete);
            } else if (puebloselect.contains("Cuenca")) {
                datoshoras(cuenca);
            } else if (puebloselect.contains("Cabañas") || puebloselect.contains("Yuncos") || puebloselect.contains("Illescas") || puebloselect.contains("Parla") || puebloselect.contains("Getafe") || puebloselect.contains("Olías")) {
                datoshoras(madridpueblos);
            } else {

            }
    }

    //Rellenar spiner con las horas correspondientes
    public void datoshoras(String[][] as){
        ArrayList<String> listHoras= new ArrayList<String>();
        selechora=findViewById(R.id.spnHoraBill);
        if(selechora.getChildCount()>0) {
            selechora.removeAllViewsInLayout();
        }

    if(dia>=7){

    }else {
        for (int i = 0; i < as.length; i++) {
        listHoras.add(String.valueOf(as[i][dia]));
    }
    adapter4 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listHoras);
    selechora.setAdapter(adapter4);
}
    }

//Añadir a la base de datos el nuevo billete
    public void pago(boolean pagado){
        String opcion="0";
        if(pagado==true) opcion = "1";

        puebloselect=selecPueblo.getSelectedItem().toString();
        fecha= edtFecha.getText() +"  "+ String.valueOf(selechora.getSelectedItem());
        if(!fecha.contains("/")){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage(R.string.selecfecha)
                    .setTitle(R.string.error)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // El usuario pulsa OK.
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        }else {

                añadirBillete("http://192.168.0.15:8080/proyectoticketbus/insertar_billete.php",opcion);

            onBackPressed();
        }

    }

    private void añadirBillete(String URL,String i){
        StringRequest sr=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Operacion realizada con éxito", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros=new HashMap<String, String>();
                parametros.put("nombreDestino",puebloselect);
                parametros.put("fecha",fecha);
                parametros.put("pagado",i);
                return parametros;
            }
        };
        rq= Volley.newRequestQueue(this);
        rq.add(sr);
    }


}
