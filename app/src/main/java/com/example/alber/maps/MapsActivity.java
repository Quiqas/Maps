package com.example.alber.maps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

public class MapsActivity extends AppCompatActivity implements GoogleMap.OnMarkerDragListener, OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker Marcador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).draggable(true).title("Marker in Sydney").snippet("La ciudad de Sydney").icon(BitmapDescriptorFactory.fromResource(R.drawable.mexico)));

        LatLng House = new LatLng(31.61574466419145, -106.37131250535413);
        mMap.addMarker(new MarkerOptions().position(House).title("Marker in my House").snippet("Esta es mi casa").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Puebla = new LatLng(19.0412967, -98.206199599999);
        Marcador = googleMap.addMarker(new MarkerOptions()
            .position(Puebla)
            .title("Puebla")
                .draggable(true)
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(House,2));

        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnMarkerDragListener(this);

        mMap.getUiSettings().setZoomControlsEnabled(true);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if(marker.equals(Marcador)){
            Toast.makeText(this,"Evento",Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        if(marker.equals(Marcador)){
            Toast.makeText(this,"Inicio",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        if(marker.equals(Marcador)){
            String Titulo = String.format(Locale.getDefault(),
                    getString(R.string.marker_detail_latlng),
                    marker.getPosition().latitude,
                    marker.getPosition().longitude);

            setTitle(Titulo);
        }
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        if(marker.equals(Marcador)){
            Toast.makeText(this,"Terminaste",Toast.LENGTH_SHORT).show();
            setTitle(R.string.app_name);
        }
    }
}
