package dev.ahmdaeyz.musicplayer.ui.playlistdetails;

import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.stream.Collectors;

import dev.ahmdaeyz.musicplayer.model.Playlist;
import dev.ahmdaeyz.musicplayer.model.Song;
import dev.ahmdaeyz.musicplayer.ui.musiclibrary.playlists.PlaylistItem;
import dev.ahmdaeyz.musicplayer.ui.musiclibrary.songs.SongItem;

public class PlaylistDetailsViewModel extends ViewModel {

    public List<SongItem> songItemsFrom(List<Song> songs){
        return songs.stream().map(Song.class::cast).map((SongItem::new)).collect(Collectors.toList());
    }

}
