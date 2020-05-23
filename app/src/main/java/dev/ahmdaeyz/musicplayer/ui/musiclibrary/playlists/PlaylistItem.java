package dev.ahmdaeyz.musicplayer.ui.musiclibrary.playlists;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.skydoves.transformationlayout.TransformationCompat;
import com.xwray.groupie.viewbinding.BindableItem;

import org.parceler.Parcels;

import dev.ahmdaeyz.musicplayer.R;
import dev.ahmdaeyz.musicplayer.databinding.PlaylistItemBinding;
import dev.ahmdaeyz.musicplayer.model.Playlist;
import dev.ahmdaeyz.musicplayer.ui.playlistdetails.PlaylistDetailsActivity;

import static dev.ahmdaeyz.musicplayer.ui.musiclibrary.playlists.PlaylistsFragment.PLAYLIST_ARG;

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
        viewBinding.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewBinding.getRoot().getContext(), PlaylistDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(PLAYLIST_ARG, Parcels.wrap(playlist));
                intent.putExtras(bundle);
                TransformationCompat.INSTANCE.startActivity(viewBinding.transformationLayout, intent);
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
