package dev.ahmdaeyz.musicplayer.ui.player.embeddedplayer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import dev.ahmdaeyz.musicplayer.data.DataStore;
import dev.ahmdaeyz.musicplayer.model.Song;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class PlayerFragmentViewModel extends ViewModel {
    private CompositeDisposable disposables = new CompositeDisposable();
    private MutableLiveData<Song> liveSong = new  MutableLiveData<Song>();
    public LiveData<Song> nowPlaying = liveSong;
    public PlayerFragmentViewModel(){
        initPlayer();
    }

    private void initPlayer() {
        disposables.add(
        DataStore.nowPlaying
                .subscribe(new Consumer<Song>() {
                    @Override
                    public void accept(Song song) throws Exception {
                        liveSong.postValue(song);
                    }
                }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
