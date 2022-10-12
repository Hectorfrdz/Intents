package com.example.pantalla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText parametro;
    public EditText edad;
    int request_code = 200;
    public EditText tel;
    int p = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFacebook = findViewById(R.id.facebook);
        Button btnCamara = findViewById(R.id.camara);
        Button btnInicio = findViewById(R.id.inicio);
        Button btnGoogle = findViewById(R.id.google);
        Button btnYoutube = findViewById(R.id.youtube);

        parametro = (EditText)findViewById(R.id.parametro);
        edad = (EditText)findViewById(R.id.parametroEdad);
        Button btnEnviar = findViewById(R.id.enviarParametros);

        tel = (EditText)findViewById(R.id.phone);
        Button btnLlamada = findViewById(R.id.llamada);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,parametros.class);
                i.putExtra("dato",parametro.getText().toString());
                i.putExtra("edad",edad.getText().toString());
                startActivity(i);
            }
        });

        btnLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llamada();
            }
        });

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("https://www.facebook.com");
                Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
                startActivity(intent);
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("https://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
                startActivity(intent);
            }
        });

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,splash.class);
                startActivity(intent);
            }
        });

        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("https://www.youtube.com/watch?v=FK7x3kZZud4");
                Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
                startActivity(intent);
            }
        });
    }

    public void llamada()
    {
        String phone = "tel:" + tel.getText().toString();
        if(phone.trim().length() > 0)
        {
            if(ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE},request_code);
            }
            else
            {
                String dial = phone;
                startActivity(new Intent(Intent.ACTION_CALL,Uri.parse(dial)));
            }
        }
        else
        {
            Toast.makeText(MainActivity.this,"Ingresa un numero de telefono",Toast.LENGTH_LONG).show();
        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == request_code)
        {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                llamada();
            }else{
                Toast.makeText(this, "Permiso denegado",Toast.LENGTH_LONG);
            }
        }
    }
}