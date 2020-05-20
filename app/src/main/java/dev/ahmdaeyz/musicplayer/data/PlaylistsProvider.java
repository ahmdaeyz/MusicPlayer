package dev.ahmdaeyz.musicplayer.data;

import java.util.List;

import dev.ahmdaeyz.musicplayer.model.Playlist;
import io.reactivex.Single;

public interface PlaylistsProvider {
    Single<List<Playlist>> getPlaylists();
}
