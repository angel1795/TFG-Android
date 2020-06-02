package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.zxing.WriterException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;


public class GenerateQrActivity extends AppCompatActivity implements View.OnClickListener {
    QRGEncoder qrgEncoder;
    String TAG = "GenerateQRCode";
     static String nombrep="", date="",payed="", inputValue="";
    TextView txnom;
    TextView txnif;
    Bitmap bitmap;
    ImageView qrImage;
    RequestQueue rq;
    Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_generate_qr);
        txnom=findViewById(R.id.txtName);
        txnif=findViewById(R.id.txtdni);
        btn=findViewById(R.id.btnqr);
        btn.setOnClickListener(this);
        qrImage=findViewById(R.id.imVQr);


        if(getIntent().getExtras()!=null){
            nombrep=getIntent().getExtras().getString("destino");
            date=getIntent().getExtras().getString("fecha");
            payed=getIntent().getExtras().getString("pagado");
            buscarUsuario("http://192.168.0.15:8080/proyectoticketbus/buscar_usuario.php");

        }




    }

    private void buscarUsuario(String URL){
        JsonArrayRequest jsr=new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jo = null;
                if(response==null){

                }else {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            jo = response.getJSONObject(i);

                            txnom.setText(jo.getString("nombre")+" "+jo.getString("apellidos"));
                            txnif.setText(jo.getString("dni" +
                                    ""));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Guarda tu configuración de usuario",Toast.LENGTH_SHORT).show();;
            }
        });
        rq= Volley.newRequestQueue(this);
        rq.add(jsr);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    @Override
    public void onClick(View v) {
        StringBuilder newContents = new StringBuilder(100);
        newContents.append("Nombre: "+txnom.getText()+".\n");
        newContents.append("Dni: "+txnif.getText()+"\n");
        newContents.append("Destino: "+nombrep+".\n");
        newContents.append("Fecha: "+date+".\n");
        newContents.append("Pagado: "+payed+".\n");
        inputValue=newContents.toString();
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;
        int smallerDimension = width < height ? width : height;
        smallerDimension = smallerDimension * 3 / 4;

        qrgEncoder = new QRGEncoder(
                inputValue, null,
                QRGContents.Type.TEXT,
                smallerDimension);

        try {
            bitmap = qrgEncoder.encodeAsBitmap();
            qrImage.setImageBitmap(bitmap);
        } catch (WriterException e) {
            Log.v(TAG, e.toString());
        }
    }
}


