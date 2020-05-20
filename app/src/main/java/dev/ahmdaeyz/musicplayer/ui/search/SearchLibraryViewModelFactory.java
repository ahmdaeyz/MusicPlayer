package dev.ahmdaeyz.musicplayer.ui.search;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dev.ahmdaeyz.musicplayer.data.SongsProvider;

public class SearchLibraryViewModelFactory implements ViewModelProvider.Factory {
    private final SongsProvider provider;

    public SearchLibraryViewModelFactory(SongsProvider provider1){
        this.provider = provider1;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SearchLibraryViewModel(provider);
    }
}
