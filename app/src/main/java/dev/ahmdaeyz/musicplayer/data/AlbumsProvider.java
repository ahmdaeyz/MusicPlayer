package dev.ahmdaeyz.musicplayer.data;

import java.util.List;

import dev.ahmdaeyz.musicplayer.model.Album;
import io.reactivex.Single;

public interface AlbumsProvider {
    Single<List<Album>> getAlbums();
}
