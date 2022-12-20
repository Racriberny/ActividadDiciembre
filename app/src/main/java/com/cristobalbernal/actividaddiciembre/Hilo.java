package com.cristobalbernal.actividaddiciembre;

import android.widget.ProgressBar;
import android.widget.TextView;

public class Hilo implements Runnable{
    private ProgressBar progressBar;
    private TextView textView;
    public Hilo(ProgressBar progressBar, TextView textView){
        this.progressBar = progressBar;
        this.textView =textView;
    }

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            tareaLarga();
            textView.setText(String.valueOf(i));
            progressBar.incrementProgressBy(1);
        }
    }

    private void tareaLarga() {
        try {
            Thread.sleep(50);
        }catch (InterruptedException ie){}
    }
}
