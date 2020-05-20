package dev.ahmdaeyz.musicplayer.data;

import java.util.List;

import dev.ahmdaeyz.musicplayer.model.Song;
import io.reactivex.Single;

public interface SongsProvider {
    Single<List<Song>> getSongs();
}
