package com.company;

/**
 * Created by Kaisar on 12/30/16.
 */
public class Song {
    private String title;
    private double duration;

    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }

    public String getTitle() {
        return title;
    }

    public Song(String title, double duration) {

        this.title = title;
        this.duration = duration;
    }
}
