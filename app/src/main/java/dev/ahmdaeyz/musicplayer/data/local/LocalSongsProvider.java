package dev.ahmdaeyz.musicplayer.data.local;

import android.app.Activity;

import java.util.List;

import dev.ahmdaeyz.musicplayer.data.SongsProvider;
import dev.ahmdaeyz.musicplayer.model.Song;
import io.reactivex.Single;

class LocalSongsProvider implements SongsProvider {

    private final Activity activity;

    LocalSongsProvider(Activity activity) {
        this.activity = activity;
    }

    @Override
    public Single<List<Song>> getSongs() {
        return null;
    }
}
