package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;


import io.realm.Realm;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imagensp,imagenclover,botonrutas,botonhoras,botonbilletes,botoninfo,botondirecto,botonconfig;
    Animation animbot;
    LinearLayout splastxt,menu;
    public Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonbilletes=findViewById(R.id.imgBill);
        botonrutas=findViewById(R.id.imgRutas);
        botonhoras=findViewById(R.id.imgHora);
        botoninfo=findViewById(R.id.imgInfo);
        botondirecto=findViewById(R.id.imgDirecto);
        botonconfig=findViewById(R.id.imgConfig);

        animarSplas();
        //Realm



        realm=Realm.getDefaultInstance();
        DatosRealm real=new DatosRealm();
        real.meterdatos(realm);
        botonbilletes.setOnClickListener(this);
        botonconfig.setOnClickListener(this);
        //botondirecto.setOnClickListener(this);
        botoninfo.setOnClickListener(this);
        botonhoras.setOnClickListener(this);
        botonrutas.setOnClickListener(this);

    }

    //Inflar menu de la derecha
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menuherr,menu);
        return true;
    }

    //Boton informacion dentro del menu derecho
    public void showInfo(MenuItem item){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(R.string.texto_info)
                .setTitle(R.string.app_name)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // El usuario pulsa OK.
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    //Salir en el menu derecho
    public void salirApp(MenuItem item){
        Intent intent=new Intent((Intent.ACTION_MAIN));
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    //Animaciones del splash
    public void animarSplas(){
        //Imports de xml
        menu=findViewById(R.id.menus);
        splastxt=findViewById(R.id.txtexplora);
        imagensp=findViewById(R.id.imgsplas);
        imagenclover=findViewById(R.id.imgclover);
        animbot=AnimationUtils.loadAnimation(this,R.anim.frombot);
        //Movimiento del splash
        imagensp.animate().translationY(-2330).setDuration(800).setStartDelay(300);
        imagenclover.animate().translationX(-1000).setDuration(800).setStartDelay(300);
        splastxt.startAnimation(animbot);
        menu.startAnimation(animbot);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,RutasActivity.class);
        Intent intent2=new Intent(this,InfoActivity.class);
        Intent intent3=new Intent(this,HorasActivity.class);
        Intent intent4=new Intent(this,VivoActivity.class);
        Intent intent5=new Intent(this,ConfigActivity.class);
        Intent intent6=new Intent(this,BilleteActivity.class);


        switch (v.getId()){
            case R.id.imgBill:
                startActivity(intent6);
                break;
            case R.id.imgConfig:
                startActivity(intent5);
                break;
          /*  case R.id.imgDirecto:
                startActivity(intent4);
                break;*/
            case R.id.imgHora:
                startActivity(intent3);
                break;
            case R.id.imgInfo:
                startActivity(intent2);
                break;
            case R.id.imgRutas:
                startActivity(intent);
                break;
            default:
                break;
        }
    }


}
