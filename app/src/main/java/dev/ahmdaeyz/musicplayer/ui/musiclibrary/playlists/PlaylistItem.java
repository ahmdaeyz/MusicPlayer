package dev.ahmdaeyz.musicplayer.ui.musiclibrary.playlists;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.xwray.groupie.viewbinding.BindableItem;

import dev.ahmdaeyz.musicplayer.R;
import dev.ahmdaeyz.musicplayer.databinding.PlaylistItemBinding;
import dev.ahmdaeyz.musicplayer.model.Playlist;

public class PlaylistItem extends BindableItem<PlaylistItemBinding> {

    private Playlist playlist;

    public PlaylistItem(Playlist playlist){
        this.playlist = playlist;
    }

    @NonNull
    @Override
    protected PlaylistItemBinding initializeViewBinding(@NonNull View view) {
        return PlaylistItemBinding.bind(view);
    }

    @Override
    public void bind(@NonNull PlaylistItemBinding viewBinding, int position) {
        viewBinding.playlistName.setText(playlist.getName());
        // TODO: create a simple college of the first 4 songs of the playlist
        viewBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.playlist_item;
    }

    public Playlist getPlaylist() {
        return playlist;
    }
}
