package com.example.alber.maps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button btnTipos,btnLocation,btnSitios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSitios = (Button) findViewById(R.id.btn_sitios);
        btnTipos = (Button) findViewById(R.id.btn_tipos);
        btnLocation = (Button) findViewById(R.id.btn_location);

        btnSitios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
            }
        });

        btnTipos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MapsActivityTipos.class);
                startActivity(intent);
            }
        });

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MapsActivityUbicacion.class);
                startActivity(intent);
            }
        });
    }
}
