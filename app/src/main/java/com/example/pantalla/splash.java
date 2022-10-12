package com.example.pantalla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class splash extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        findViewById(R.id.textView);
        TextView vista = findViewById(R.id.lbl1);

        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int d = (int) millisUntilFinished;
                vista.setText("" + d / 1000);
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(splash.this,MainActivity.class);
                startActivity(intent);
            }
        }.start();

    }
}