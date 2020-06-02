package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;

import java.util.Locale;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    double c1,c2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Intent intent=getIntent();
        c1= intent.getDoubleExtra(DetailPuebloActivity.EXTRA_MESSAGE2,0);
        c2= intent.getDoubleExtra(DetailPuebloActivity.EXTRA_MESSAGE3,0);



        //Flecha atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //Metodo para flecha atras
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        float zoom =10;

        LatLng lugar = new LatLng(c1, c2);
        CameraUpdate cam = CameraUpdateFactory.newLatLngZoom(lugar,zoom);
        mMap.moveCamera(cam);
        mMap.addMarker(new MarkerOptions().position(lugar).title("Parada de bus de "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lugar));
        setMapaLongClick(mMap);
        setPoiClick(mMap);
    }

    private void setMapaLongClick(final GoogleMap map) {
        map.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener()
        {
            @Override
            public void onMapLongClick(LatLng latLng) {
                MarkerOptions marca = new MarkerOptions();
                marca.position(latLng);
                marca.title("Marca en casa");
                String texto =
                        String.format(Locale.getDefault(), "Latitud: %1$.2f", latLng);
                marca.snippet(texto);
                map.addMarker(marca);
            }
        });


    }

    private void setPoiClick(final GoogleMap mapa) {
        mapa.setOnPoiClickListener(poi -> {
            Marker POImarca=mapa.addMarker((new MarkerOptions()
                    .position(poi.latLng)
                    .title(poi.name)));
            POImarca.showInfoWindow();

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opciones_mapa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.normal_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case R.id.hibrido_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            case R.id.satelite_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

                return true;
            case R.id.terreno_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
