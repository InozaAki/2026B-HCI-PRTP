package com.blank.template;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final String TOAST_TEXT = "Esto es un ejemplo de Toast :D";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setButton();
    }

    public void setButton(){
        View button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Toast.makeText(this, TOAST_TEXT, Toast.LENGTH_SHORT).show();
        });
    }
}