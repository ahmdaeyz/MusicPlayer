package dev.ahmdaeyz.musicplayer.data.inapp;

import java.util.List;

import dev.ahmdaeyz.musicplayer.data.DataStore;
import dev.ahmdaeyz.musicplayer.data.PlaylistsProvider;
import dev.ahmdaeyz.musicplayer.model.Playlist;
import io.reactivex.Single;

public class InAppPlaylistsProvider implements PlaylistsProvider {
    @Override
    public Single<List<Playlist>> getPlaylists() {
        return Single.just(DataStore.playlists());
    }
}
