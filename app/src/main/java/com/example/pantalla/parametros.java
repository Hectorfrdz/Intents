package com.example.pantalla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class parametros extends AppCompatActivity {

    public TextView tv1;
    public TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametros);
        tv1 = (TextView)findViewById(R.id.param);
        tv2 = (TextView)findViewById(R.id.paramEdad);

        String dato = getIntent().getStringExtra("dato");
        tv1.setText(dato);
        String edad = getIntent().getStringExtra("edad");
        tv2.setText(edad);
    }

}