package dev.ahmdaeyz.musicplayer.data.local;

import android.app.Activity;

import java.util.List;

import dev.ahmdaeyz.musicplayer.data.PlaylistsProvider;
import dev.ahmdaeyz.musicplayer.model.Playlist;
import io.reactivex.Single;

class LocalPlaylistsProvider implements PlaylistsProvider {

    private final Activity activity;

    public LocalPlaylistsProvider(Activity activity) {
        this.activity = activity;
    }

    @Override
    public Single<List<Playlist>> getPlaylists() {
        return null;
    }
}
