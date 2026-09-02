package com.blank.template;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setNavButton(R.id.button1, HomeMenu.class);
        setNavButton(R.id.button2, GreetActivity.class);
        setNavButton(R.id.button3, HelloWorldActivity.class);
    }

    public void setNavButton(int id, Class<?> target){
        View button = findViewById(id);
        button.setTag(target);
        button.setOnClickListener( v -> {
            Class<?> destination = (Class<?>) v.getTag();
            startActivity(new Intent(this, destination));
        });
    }
}