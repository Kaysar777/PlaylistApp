package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Kaisar on 12/30/16.
 */
public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        return this.songs.stream().filter(checkedSong -> checkedSong.getTitle().equals(title)).findFirst().orElse(null);
    }


    //I think this (addToPlaylist) should be playlist's method, and not album's

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if (index > 0 && index <= this.songs.size()) {
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("this album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("the song " + title + " is not in this album");
        return false;
    }
}
