package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        //Flecha atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        b=findViewById(R.id.btnToledo);
        b.setOnClickListener(this);
    }

    //Metodo para flecha atras
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,ToledoActivity.class);
        startActivity(intent);
    }
}
