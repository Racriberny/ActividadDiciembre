package com.cristobalbernal.actividaddiciembre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final int MAX = 100;
    private final int I = 0;
    private ProgressBar pbProceso;
    private Button btSumple;
    private Button btTocho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pbProceso = findViewById(R.id.barraProgreso);
        //Poner el maximo de la barra... El minimo es 0
        pbProceso.setMax(100);
        btSumple = findViewById(R.id.bSimple);
        btTocho = findViewById(R.id.button2);
        TextView textView = findViewById(R.id.tvTexto);
        btSumple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i <MAX ; i++) {
                    tareaLarga();
                    pbProceso.incrementProgressBy(1);
                }
            }
        });
        btTocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Hilo(pbProceso,textView)).start();
                /*new Thread(new Runnable() {
                    @Override
                    public void run() {

                    }
                }).start();

                 */
            }
        });

    }

    private void tareaLarga() {
        try {
            Thread.sleep(50);
        }catch (InterruptedException ie){}
    }
}