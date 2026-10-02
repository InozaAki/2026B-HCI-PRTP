package com.blank.template.model;

import androidx.annotation.NonNull;

/**
 * Represents a Song entity with an ID, title, and subtitle.
 */
public class Song {
    private final Long id;
    private final String title;
    private final String subtitle;

    public Song(Long id, String title, String subtitle) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    @NonNull
    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                '}';
    }
}