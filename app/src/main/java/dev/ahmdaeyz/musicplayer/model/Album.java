package dev.ahmdaeyz.musicplayer.model;

import java.util.List;

public class Album {
    private final Long ID;
    private final String title;
    private final String artist;
    private final int numOfSongs;
    private final List<Song> songs;
    private final String art;

    public Album(Long ID, String title, String artist, int numOfSongs, String art, List<Song> songs) {
        this.ID = ID;
        this.title = title;
        this.artist = artist;
        this.numOfSongs = numOfSongs;
        this.songs = songs;
        this.art = art;
    }

    public Long getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public String getArt() { return art; }

    public List<Song> getSongs() {
        return songs;
    }
}


