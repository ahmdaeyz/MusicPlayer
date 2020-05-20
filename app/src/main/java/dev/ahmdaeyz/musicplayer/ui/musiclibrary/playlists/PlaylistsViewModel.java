package dev.ahmdaeyz.musicplayer.ui.musiclibrary.playlists;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.stream.Collectors;

import dev.ahmdaeyz.musicplayer.data.PlaylistsProvider;
import dev.ahmdaeyz.musicplayer.model.Playlist;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;


public class PlaylistsViewModel extends ViewModel {

    private PlaylistsProvider playlistsProvider;
    private CompositeDisposable disposables = new CompositeDisposable();
    private MutableLiveData<List<Playlist>> livePlaylists = new MutableLiveData<>();

    public LiveData<List<PlaylistItem>> playlistsItems = Transformations.map(livePlaylists,(playlists)->{
        return playlists.stream().map(Playlist.class::cast).map((PlaylistItem::new)).collect(Collectors.toList());
    });

    public PlaylistsViewModel(PlaylistsProvider playlistsProvider) {
        this.playlistsProvider = playlistsProvider;
        initPlaylists();
    }

    private void initPlaylists() {
        disposables.add(
                playlistsProvider.getPlaylists()
                        .subscribe(new Consumer<List<Playlist>>() {
                            @Override
                            public void accept(List<Playlist> playlists) throws Exception {
                                livePlaylists.postValue(playlists);
                            }
                        }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
