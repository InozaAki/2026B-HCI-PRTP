package com.blank.template.operations;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.blank.template.DbRepository;
import com.blank.template.R;

/**
 * Activity to add a new song to the database.
 * Users can input the title and subtitle of the song.
 */
public class AddSong extends AppCompatActivity {

    // Toast messages
    private final String TOAST_MESSAGE = "Canción agregada correctamente";
    private final String TOAST_ERROR_MESSAGE = "Por favor, ingresa tanto el título como el subtítulo";

    private DbRepository dbRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_song);

        dbRepository = DbRepository.getInstance(this);

        EditText titleEditText = findViewById(R.id.titleEditText);
        EditText subtitleEditText = findViewById(R.id.subtitleEditText);
        Button submitButton = findViewById(R.id.button);

        submitButton.setOnClickListener(v -> {
            String title = titleEditText.getText().toString();
            String subtitle = subtitleEditText.getText().toString();

            if (!title.isEmpty() && !subtitle.isEmpty()) {
                dbRepository.write(title, subtitle);
                Toast.makeText(AddSong.this, TOAST_MESSAGE, Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(AddSong.this, TOAST_ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onDestroy() {
        dbRepository.onDestroy();
        super.onDestroy();
    }

}
