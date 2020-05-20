package dev.ahmdaeyz.musicplayer.ui.musiclibrary.albums;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dev.ahmdaeyz.musicplayer.data.AlbumsProvider;

public class AlbumsViewModelFactory implements ViewModelProvider.Factory {
    private AlbumsProvider provider;

    public AlbumsViewModelFactory(AlbumsProvider provider){
        this.provider = provider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new AlbumsViewModel(provider);
    }
}
