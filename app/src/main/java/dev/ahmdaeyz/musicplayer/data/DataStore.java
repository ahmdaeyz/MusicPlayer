package dev.ahmdaeyz.musicplayer.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import dev.ahmdaeyz.musicplayer.model.Album;
import dev.ahmdaeyz.musicplayer.model.Playlist;
import dev.ahmdaeyz.musicplayer.model.Song;
import io.reactivex.subjects.BehaviorSubject;

public class DataStore {

    public static BehaviorSubject<Song> nowPlaying =  BehaviorSubject.createDefault(songs().get(new Random().nextInt(songs().size()-1)));
    public static List<Song> songs(){
        List<Song> songs = new ArrayList<Song>();

        songs.add(
                new Song(
                        UUID.randomUUID().getLeastSignificantBits(),
                        "Future Nostalgia",
                        "Dua Lipa",
                        3*60+8,
                        "https://m.media-amazon.com/images/I/91K0pKe8cHL._SS500_.jpg"
                )
        );

        songs.add(
                new Song(
                        UUID.randomUUID().getLeastSignificantBits(),
                        "Don't Start Now",
                        "Dua Lipa",
                        3*60+4,
                        "https://www.dualipa.com/wp-content/uploads/2019/10/DONT_START_NOW.jpg"
                )
        );

        songs.add(
                new Song(
                        UUID.randomUUID().getLeastSignificantBits(),
                        "Cool",
                        "Dua Lipa",
                        3*60+30,
                        "https://t2.genius.com/unsafe/300x0/https%3A%2F%2Fimages.genius.com%2Fd2304429bd6b0f492325f1151bd21825.1000x1000x1.jpg"
                )
        );

        songs.add(
                new Song(
                        UUID.randomUUID().getLeastSignificantBits(),
                        "Baby Pluto",
                        "Lil Uzi Vert",
                        3*60+31,
                        "https://m.media-amazon.com/images/I/815PIO4svzL._SS500_.jpg"
                )
        );

        songs.add(
                new Song(
                        UUID.randomUUID().getLeastSignificantBits(),
                        "Lo Mein",
                        "Lil Uzi Vert",
                        3*60+16,
                        "https://m.media-amazon.com/images/I/815PIO4svzL._SS500_.jpg"
                )
        );

        return songs;
    }

    public static List<Album> albums(){
        List<Album> albums = new ArrayList<>();

        albums.add(
                new Album(
                        UUID.randomUUID().getLeastSignificantBits(),
                        "Future Nostalgia",
                        "Dua Lipa",
                        11,
                        "https://t2.genius.com/unsafe/300x0/https%3A%2F%2Fimages.genius.com%2Fd2304429bd6b0f492325f1151bd21825.1000x1000x1.jpg",
                        songs().subList(0,2)
                )
        );
        albums.add(
                new Album(
                        UUID.randomUUID().getLeastSignificantBits(),
                        "Eternal Atake",
                        "Lil Uzi Vert",
                        11,
                        "https://m.media-amazon.com/images/I/815PIO4svzL._SS500_.jpg",
                        songs().subList(3,songs().size()-1)
                )
        );


        return albums;
    }

    public static List<Playlist> playlists(){
        List<Playlist> playlists = new ArrayList<>();

        playlists.add(
                new Playlist(
                        UUID.randomUUID().getLeastSignificantBits(),
                        "Chilly",
                        songs().subList(0,2)
                )
        );
        return playlists;
    }


}


