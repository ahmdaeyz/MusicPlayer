package dev.ahmdaeyz.musicplayer.ui.musiclibrary.albums;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.stream.Collectors;

import dev.ahmdaeyz.musicplayer.data.AlbumsProvider;
import dev.ahmdaeyz.musicplayer.data.DataStore;
import dev.ahmdaeyz.musicplayer.model.Album;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

import static dev.ahmdaeyz.musicplayer.data.DataStore.*;

public class AlbumsViewModel extends ViewModel {


    private AlbumsProvider albumsProvider;
    private CompositeDisposable disposables = new CompositeDisposable();
    private MutableLiveData<List<Album>> liveAlbums  = new MutableLiveData<>();

    public LiveData<List<AlbumItem>> AlbumsItems = Transformations.map(liveAlbums,(albums)->{
        return albums.stream().map(Album.class::cast).map((AlbumItem::new)).collect(Collectors.toList());
    });

    public AlbumsViewModel(dev.ahmdaeyz.musicplayer.data.AlbumsProvider AlbumsProvider) {
        this.albumsProvider = AlbumsProvider;
        initAlbums();
    }

    private void initAlbums() {
        disposables.add(
                albumsProvider.getAlbums()
                        .subscribe(new Consumer<List<Album>>() {
                            @Override
                            public void accept(List<Album> Albums) throws Exception {
                                liveAlbums.postValue(Albums);
                            }
                        }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
