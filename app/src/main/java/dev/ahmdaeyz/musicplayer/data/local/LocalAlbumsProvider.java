package dev.ahmdaeyz.musicplayer.data.local;

import android.app.Activity;

import java.util.List;

import dev.ahmdaeyz.musicplayer.data.AlbumsProvider;
import dev.ahmdaeyz.musicplayer.model.Album;
import io.reactivex.Single;

class LocalAlbumsProvider implements AlbumsProvider {

    private final Activity activity;

    public LocalAlbumsProvider(Activity activity) {
        this.activity = activity;
    }

    @Override
    public Single<List<Album>> getAlbums() {
        return null;
    }

}
