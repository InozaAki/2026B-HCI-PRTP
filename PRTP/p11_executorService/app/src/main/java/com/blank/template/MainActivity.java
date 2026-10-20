package com.blank.template;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layoutTemporizadores;
    private ExecutorService executorService;
    private final Handler handler = new Handler();
    private int contadorTemporizadores = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutTemporizadores = findViewById(R.id.temporizadores);
        executorService = Executors.newFixedThreadPool(4); // Máximo 4 hilos concurrentes

        Button btnAgregarTemporizador = findViewById(R.id.addTemporizador);
        btnAgregarTemporizador.setOnClickListener(v -> agregarTemporizador());
    }

    private void agregarTemporizador() {
        contadorTemporizadores++;
        int duracionSegundos = 10 + (contadorTemporizadores * 5); // Incrementa duración en 5 segs

        // Crear nuevo TextView para el temporizador
        TextView tvTemporizador = new TextView(this);
        tvTemporizador.setText("Temporizador " + contadorTemporizadores + ": " + duracionSegundos + "s");
        layoutTemporizadores.addView(tvTemporizador);

        // Ejecutar temporizador en un hilo separado
        executorService.execute(() -> iniciarTemporizador(tvTemporizador, duracionSegundos));
    }

    private void iniciarTemporizador(TextView textView, int segundos) {
        for (int i = segundos; i >= 0; i--) {
            int finalI = i;
            handler.post(() -> textView.setText("Temporizador " + contadorTemporizadores + ": " + finalI + "s"));

            try {
                Thread.sleep(1000); // Espera 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        handler.post(() -> textView.setText("¡Tiempo finalizado!"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executorService.shutdown(); // Finaliza todos los hilos al cerrar la app
    }
}