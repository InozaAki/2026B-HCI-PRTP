package com.blank.template;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final String DEFAULT_TOAST_MESSAGE = "El campo de texto no puede estar vacío";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setButton();
    }

    public void setButton(){
        View button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            EditText editText = findViewById(R.id.editTextText);
            String text = editText.getText().toString();
            if (text.isEmpty()) {
                Toast.makeText(this, DEFAULT_TOAST_MESSAGE, Toast.LENGTH_SHORT).show();
            } else {
                String greet = String.format("Hola %s, bienvenido!", text);
                Toast.makeText(this, greet, Toast.LENGTH_SHORT).show();
            }
        });
    }
}