package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class VivoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vivo);
        //Flecha atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //Metodo para flecha atras
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}
