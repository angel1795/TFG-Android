package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyecto.model.Billetes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import io.realm.Realm;

public class BilleteActivity extends AppCompatActivity implements Adapter.OnItemClickListener,View.OnClickListener {
Button comprar,borrar;
List<Billetes> listbill;
RecyclerView contenedor;
RequestQueue rq;

private static final String URLbills="http://192.168.0.15:8080/proyectoticketbus/buscar_billetes.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billete);
        //Flecha atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        comprar=findViewById(R.id.btnCompra);
        comprar.setOnClickListener(this);
        borrar=findViewById(R.id.btnBorrar);
        borrar.setOnClickListener(this);
        contenedor=findViewById(R.id.rcv);
        contenedor.setHasFixedSize(true);
        contenedor.setLayoutManager(new LinearLayoutManager(this));
    }

       //Metodo para flecha atras
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        contenedor.removeAllViewsInLayout();
        buscarBilletes();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCompra:
                Intent intent=new Intent(this, CompraActivity.class);
                startActivity(intent);
                break;
            case R.id.btnBorrar:
                borrarBilletes(v);
                break;
        }

    }


    private void buscarBilletes(){
       listbill=new ArrayList<>();
        StringRequest sr=new StringRequest(Request.Method.GET, URLbills,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject player = array.getJSONObject(i);
                                listbill.add(new Billetes(
                                        player.getInt("idbillete"),
                                        player.getString("nombreDestino"),
                                        player.getString("fecha"),
                                        player.getInt("pagado")
                                ));
                            }
                            Adapter adapter = new Adapter(BilleteActivity.this, listbill);
                            contenedor.setAdapter(adapter);
                            adapter.setOnItemClickListener(BilleteActivity.this);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        Volley.newRequestQueue(this).add(sr);
    }

    public void borrarBilletes(View v) {

        eliminarBills("http://192.168.0.15:8080/proyectoticketbus/borrar_billetes.php");
        onBackPressed();
    }

    private void eliminarBills(String URL){
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
                return null;
            }
        };
        rq= Volley.newRequestQueue(this);
        rq.add(sr);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent=new Intent(this,GenerateQrActivity.class);
        Billetes bil=listbill.get(position);
        intent.putExtra("destino",bil.getS());
        intent.putExtra("fecha",bil.getFecha());
        if(bil.getPagado()==0){
            intent.putExtra("pagado","Pagar en el bus");
        }else{
            intent.putExtra("pagado","Pagado con GPay");

        }
        startActivity(intent);

    }
}
