package dev.ahmdaeyz.musicplayer.ui.search;

import androidx.lifecycle.ViewModel;

import java.util.List;

import dev.ahmdaeyz.musicplayer.data.SongsProvider;
import dev.ahmdaeyz.musicplayer.model.Song;
import io.reactivex.Observable;
import io.reactivex.Single;

public class SearchLibraryViewModel extends ViewModel {
    private final SongsProvider provider;

    public SearchLibraryViewModel(SongsProvider provider) {
        this.provider = provider;
    }

    public Single<List<Song>> searchSongsLibrary(String searchKeyword){
        return provider.getSongs()
                .toObservable()
                .flatMap(Observable::fromIterable)
                .filter((song -> song.getTitle().toLowerCase().contains(searchKeyword)))
                .toList();
    }

}
