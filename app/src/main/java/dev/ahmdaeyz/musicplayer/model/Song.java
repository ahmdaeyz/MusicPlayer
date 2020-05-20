package dev.ahmdaeyz.musicplayer.model;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class Song {
    private final Long ID;
    private final String title;
    private final String artist;
    private final int duration;

    private final String art;
    @ParcelConstructor
    public Song(Long ID, String title, String artist, int duration, String art) {
        this.ID = ID;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
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

    public int getDuration() {
        return duration;
    }

    public String getArt() {
        return art;
    }

}
