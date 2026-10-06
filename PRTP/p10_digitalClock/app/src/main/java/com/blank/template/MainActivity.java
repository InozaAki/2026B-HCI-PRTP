package com.blank.template;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private boolean isClockRunning = false;
    private Thread clockThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startClock();
    }

    /*
     * Starts the clock thread that updates the display every second.
    */
    private void startClock() {
        isClockRunning = true;
        clockThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isClockRunning) {
                    try {
                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
                        final String currentTime = sdf.format(calendar.getTime());

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                display.setText(currentTime);
                            }
                        });

                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }

                }
            }
        });
        clockThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopClock();
    }

    private void stopClock() {
        isClockRunning = false;
        if (clockThread != null) {
            clockThread.interrupt();
        }
    }

}