package dev.ahmdaeyz.musicplayer.ui.musiclibrary.songs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.stream.Collectors;

import dev.ahmdaeyz.musicplayer.data.SongsProvider;
import dev.ahmdaeyz.musicplayer.model.Song;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class SongsViewModel extends ViewModel {
    private SongsProvider songsProvider;
    private CompositeDisposable disposables = new CompositeDisposable();
    private MutableLiveData<List<Song>> liveSongs = new MutableLiveData<>();

    public LiveData<List<SongItem>> songItems = Transformations.map(liveSongs,(songs)->{
        return songs.stream().map(Song.class::cast).map((SongItem::new)).collect(Collectors.toList());
    });

    public SongsViewModel(SongsProvider songsProvider) {
        this.songsProvider = songsProvider;
        initSongs();
    }

    private void initSongs() {
        disposables.add(
        songsProvider.getSongs()
                .subscribe(new Consumer<List<Song>>() {
                    @Override
                    public void accept(List<Song> songs) throws Exception {
                        liveSongs.postValue(songs);
                    }
                }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
