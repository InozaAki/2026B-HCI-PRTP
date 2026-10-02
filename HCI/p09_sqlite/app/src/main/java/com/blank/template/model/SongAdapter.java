package com.blank.template.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blank.template.R;

import java.util.List;

/**
 * Custom adapter for displaying Song objects in a ListView.
 */
public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(@NonNull Context context, @NonNull List<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Song song = getItem(position);

        TextView idTextView = convertView.findViewById(R.id.textView2);
        TextView titleTextView = convertView.findViewById(R.id.textView3);
        TextView subtitleTextView = convertView.findViewById(R.id.textView4);

        if (song != null) {
            idTextView.setText(String.valueOf(song.getId()));
            titleTextView.setText(song.getTitle());
            subtitleTextView.setText(String.format("by %s", song.getSubtitle()));
        }

        return convertView;
    }
}