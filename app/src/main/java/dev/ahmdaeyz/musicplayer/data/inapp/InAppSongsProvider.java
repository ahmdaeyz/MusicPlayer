package dev.ahmdaeyz.musicplayer.data.inapp;

import java.util.List;

import dev.ahmdaeyz.musicplayer.data.DataStore;
import dev.ahmdaeyz.musicplayer.data.SongsProvider;
import dev.ahmdaeyz.musicplayer.model.Song;
import io.reactivex.Single;

public class InAppSongsProvider implements SongsProvider {
    @Override
    public Single<List<Song>> getSongs() {
        return Single.just(DataStore.songs());
    }
}
