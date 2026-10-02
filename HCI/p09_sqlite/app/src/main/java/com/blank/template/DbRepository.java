package com.blank.template;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.blank.template.model.Song;
import com.blank.template.utils.FeedReaderContract;
import com.blank.template.utils.FeedReaderDbHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for managing database operations related to songs.
 * The actual implementation of the database is handled by the FeedReaderDbHelper class.
 * This class provides methods for inserting, reading, updating, and deleting.
 */
public class DbRepository {

    private final FeedReaderDbHelper dbHelper;
    private static DbRepository instance;

    private DbRepository(Context context) {
        dbHelper = new FeedReaderDbHelper(context.getApplicationContext());
    }

    /**
     * Returns the singleton instance of DbRepository.
     * If the instance does not exist, it creates a new one.
     *
     * @param context The context to use for database operations.
     * @return The singleton instance of DbRepository.
     */
    public static synchronized DbRepository getInstance(Context context) {
        if (instance == null) {
            instance = new DbRepository(context);
        }
        return instance;
    }

    /**
     * Inserts a new song into the database.
     *
     * @param title    The title of the song.
     * @param subtitle The subtitle of the song.
     */
    public void write(String title, String subtitle) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, title);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, subtitle);

        db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);

    }

    /**
     * Reads all songs from the database.
     * @return A list of Song objects representing the songs in the database.
     */
    public List<Song> read() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String [] projection = {
                FeedReaderContract.FeedEntry._ID,
                FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE,
                FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE
        };

        String sortOrder = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE + " DESC";

        Cursor cursor = db.query(
                FeedReaderContract.FeedEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        List<Song> songs = new ArrayList<>();

        while (cursor.moveToNext()) {
            Long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry._ID));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE));
            String subtitle = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE));

            songs.add(new Song(itemId, title, subtitle));
        }
        cursor.close();

        return songs;
    }

    /**
     * Updates an existing song in the database.
     *
     * @param id       The ID of the song to update.
     * @param title    The new title of the song.
     * @param subtitle The new subtitle of the song.
     */
    public void update(int id, String title, String subtitle) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, title);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, subtitle);

        String selection = FeedReaderContract.FeedEntry._ID + " = ?";
        String[] selectionArgs = { String.valueOf(id) };

        db.update(FeedReaderContract.FeedEntry.TABLE_NAME, values, selection, selectionArgs);
    }

    /**
     * Deletes a song from the database.
     * @param id The ID of the song to delete.
     */
    public void delete(Long id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selection = FeedReaderContract.FeedEntry._ID + " = ?";
        String[] selectionArgs = { String.valueOf(id) };

        db.delete(FeedReaderContract.FeedEntry.TABLE_NAME, selection, selectionArgs);

    }

    public void onDestroy() {
        dbHelper.close();
    }
}