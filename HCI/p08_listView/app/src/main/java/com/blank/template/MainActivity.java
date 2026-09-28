package com.blank.template;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //1.
    private final ArrayList<String> items = new ArrayList<>(){
        {
            add("Ouro Kronii");
            add("Mori Calliope");
            add("Ina'nis Ninomae");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2.
        ListView list = findViewById(R.id.list);

        //3.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        list.setAdapter(adapter);

        //4.
        list.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = items.get(position);

            switch (selectedItem) {
                case "Ouro Kronii":
                    Toast.makeText(MainActivity.this, "The Warden of Time", Toast.LENGTH_SHORT).show();
                    break;
                case "Mori Calliope":
                    Toast.makeText(MainActivity.this, "First Apprentice of the Grim Reaper", Toast.LENGTH_SHORT).show();
                    break;
                case "Ina'nis Ninomae":
                    Toast.makeText(MainActivity.this, "Priestess of the Ancient Ones", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(MainActivity.this, "You clicked: " + selectedItem, Toast.LENGTH_SHORT).show();
                    break;
            }
        });
    }
}