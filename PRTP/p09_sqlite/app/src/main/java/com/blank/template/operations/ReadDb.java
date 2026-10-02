package com.blank.template.operations;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.blank.template.DbRepository;
import com.blank.template.R;
import com.blank.template.model.Song;
import com.blank.template.model.SongAdapter;

import java.util.List;

/**
 * Activity to read and display songs from the database.
 * Allows users to delete songs with a confirmation dialog.
 */
public class ReadDb extends AppCompatActivity {

    // Dialog constants
    private final String DIALOG_TITLE = "Borrar canción";
    private final String DIALOG_MESSAGE = "¿Estás seguro de que quieres borrar esta canción?";
    private final String DIALOG_POSITIVE_BUTTON = "Sí";
    private final String DIALOG_NEGATIVE_BUTTON = "No";

    private DbRepository dbRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        dbRepository = DbRepository.getInstance(this);

        ListView view = findViewById(R.id.list);
        List<Song> songs = dbRepository.read();

        SongAdapter adapter = new SongAdapter(this, songs);
        view.setAdapter(adapter);

        view.setOnItemClickListener((parent, view1, position, id) -> {
            Song song = songs.get(position);
            showDialog(song.getId(), position, songs, adapter);
        });
    }

    /**
     * Displays a confirmation dialog to delete a song.
     * @param id       The ID of the song to be deleted.
     * @param position The position of the song in the list.
     * @param songs    The list of songs.
     * @param adapter  The adapter for the ListView.
     */
    private void showDialog(Long id, int position, List<Song> songs, SongAdapter adapter) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(DIALOG_TITLE);
        builder.setMessage(DIALOG_MESSAGE);

        builder.setPositiveButton(DIALOG_POSITIVE_BUTTON, (dialog, which) -> {
            dbRepository.delete(id);

            songs.remove(position);
            adapter.notifyDataSetChanged();

            dialog.dismiss();
        });

        builder.setNegativeButton(DIALOG_NEGATIVE_BUTTON, (dialog, which) -> {
            dialog.dismiss();
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onDestroy() {
        dbRepository.onDestroy();
        super.onDestroy();
    }

}
