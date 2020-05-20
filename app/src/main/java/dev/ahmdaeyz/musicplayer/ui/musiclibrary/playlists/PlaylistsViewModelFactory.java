package dev.ahmdaeyz.musicplayer.ui.musiclibrary.playlists;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dev.ahmdaeyz.musicplayer.data.PlaylistsProvider;

public class PlaylistsViewModelFactory implements ViewModelProvider.Factory {
    private final PlaylistsProvider provider;

    public PlaylistsViewModelFactory(PlaylistsProvider provider) {
        this.provider = provider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PlaylistsViewModel(provider);
    }
}
