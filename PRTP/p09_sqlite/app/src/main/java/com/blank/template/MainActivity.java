package com.blank.template;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.blank.template.operations.AddSong;
import com.blank.template.operations.ReadDb;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setNavButton(R.id.button2, AddSong.class);
        setNavButton(R.id.button3, ReadDb.class);
    }

    /**
     * Sets up a navigation button to start a new activity when clicked.
     * @param id     The ID of the button view.
     * @param target The target activity class to navigate to.
     */
    public void setNavButton(int id, Class<?> target){
        View button = findViewById(id);
        button.setOnClickListener( v -> {
            startActivity(new Intent(this, target));
        });
    }
}