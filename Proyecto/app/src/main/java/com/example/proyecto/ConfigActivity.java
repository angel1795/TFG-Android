package com.example.proyecto;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;



public class ConfigActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView foto;
    Uri imageUri;
    TextView txtnom,txtap,txtdni;
    private static final int PICK_IMAGE = 100;
    Button imagen,guardar;
    Bitmap bitmap;
    RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        //Flecha atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtnom=findViewById(R.id.txtNombre);
        txtap=findViewById(R.id.txtApell);
        txtdni=findViewById(R.id.txtDni);
        imagen=findViewById(R.id.btnCambiarImg);
        foto=findViewById(R.id.imgFoto);
        guardar=findViewById(R.id.btnGuardar);
        imagen.setOnClickListener(this);
        guardar.setOnClickListener(this);
        bitmap=null;

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

    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);

    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            //path=getContentResolver().getType(imageUri);
            foto.setImageURI(imageUri);
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            SharedPreferences nombre= getPreferences(getApplicationContext().MODE_PRIVATE);
            SharedPreferences.Editor miEdit=nombre.edit();
            miEdit.putString("imagen", encodeTobase64(bitmap));
            miEdit.commit();
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnCambiarImg:
                openGallery();
                break;
            case R.id.btnGuardar:
                //guardatos();
                eliminarUsuario("http://192.168.0.15:8080/proyectoticketbus/borrar_usuarios.php");
//Emulador
                //eliminarUsuario("http://10.0.2.2:8080/proyectoticketbus/borrar_usuarios.php");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                añadirUsuario("http://192.168.0.15:8080/proyectoticketbus/insertar_usuario.php");
                //Emulador añadirUsuario("http://10.0.2.2:8080/proyectoticketbus/insertar_usuario.php");
                break;
        }
    }

    public static String encodeTobase64(Bitmap image) {
            String imageEncoded;
            Bitmap bitmap_image = image;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap_image.compress(Bitmap.CompressFormat.PNG, 100, baos);
            byte[] b = baos.toByteArray();
            imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        return imageEncoded;
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences shar=getPreferences(getApplicationContext().MODE_PRIVATE);
        String imagen=shar.getString("imagen", "");
        byte[] b = Base64.decode(imagen, Base64.DEFAULT);
        InputStream is = new ByteArrayInputStream(b);
        Bitmap bitmap = BitmapFactory.decodeStream(is);
        foto.setImageBitmap(bitmap);
        //Emulador buscarUsuario("http://10.0.2.2:8080/proyectoticketbus/buscar_usuario.php");
        buscarUsuario("http://192.168.0.15:8080/proyectoticketbus/buscar_usuario.php");
    }

    private void añadirUsuario(String URL){
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
                parametros.put("nombreUs",txtnom.getText().toString());
                parametros.put("apellUs",txtap.getText().toString());
                parametros.put("dniUs",txtdni.getText().toString());
                return parametros;
            }
        };
        rq= Volley.newRequestQueue(this);
        rq.add(sr);
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
                            txtnom.setText(jo.getString("nombre"));
                            txtap.setText(jo.getString("apellidos"));
                            txtdni.setText(jo.getString("dni"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"ERROR DE CONEXION",Toast.LENGTH_SHORT).show();;
            }
        });
        rq=Volley.newRequestQueue(this);
        rq.add(jsr);
    }

    private void eliminarUsuario(String URL){
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
}
