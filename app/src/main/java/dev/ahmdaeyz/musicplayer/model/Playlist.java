package dev.ahmdaeyz.musicplayer.model;

import org.parceler.Parcel;
import org.parceler.ParcelClass;
import org.parceler.ParcelConstructor;

import java.util.List;
@Parcel
public class Playlist {
    private final Long ID;
    private final String name;
    private List<Song> songs;

    @ParcelConstructor
    public Playlist(Long ID, String name, List<Song> songs) {
        this.ID = ID;
        this.name = name;
        this.songs = songs;
    }

    public Playlist(Long ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }


    public List<Song> getSongs() {
        return songs;
    }

}
