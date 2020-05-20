package dev.ahmdaeyz.musicplayer.data.inapp;

import java.util.List;

import dev.ahmdaeyz.musicplayer.data.AlbumsProvider;
import dev.ahmdaeyz.musicplayer.data.DataStore;
import dev.ahmdaeyz.musicplayer.model.Album;
import io.reactivex.Single;

public class InAppAlbumsProvider implements AlbumsProvider {
    @Override
    public Single<List<Album>> getAlbums() {
        return Single.just(DataStore.albums());
    }
}
