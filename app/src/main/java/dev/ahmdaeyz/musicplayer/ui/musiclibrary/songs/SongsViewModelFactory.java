package dev.ahmdaeyz.musicplayer.ui.musiclibrary.songs;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dev.ahmdaeyz.musicplayer.data.SongsProvider;

public class SongsViewModelFactory implements ViewModelProvider.Factory {

    private final SongsProvider provider;

    public SongsViewModelFactory(SongsProvider provider) {
        this.provider = provider;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SongsViewModel(provider);
    }
}
