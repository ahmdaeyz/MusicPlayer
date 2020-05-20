package dev.ahmdaeyz.musicplayer.ui.musiclibrary.songs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.xwray.groupie.viewbinding.BindableItem;

import java.util.Optional;

import dev.ahmdaeyz.musicplayer.R;
import dev.ahmdaeyz.musicplayer.databinding.SongItemBinding;
import dev.ahmdaeyz.musicplayer.model.Song;
import dev.ahmdaeyz.musicplayer.ui.utils.Binding;

public class SongItem extends BindableItem<SongItemBinding> {

    private Song song;

    public SongItem(Song song) {
        this.song = song;
    }

    @NonNull
    @Override
    protected SongItemBinding initializeViewBinding(@NonNull View view) {

        return SongItemBinding.bind(view);
    }

    @Override
    public void bind(@NonNull SongItemBinding viewBinding, int position) {
        viewBinding.songTitle.setText(song.getTitle());
        viewBinding.songArtist.setText(song.getArtist());
        Binding.bindImageViewWithRoundedCorners(
                viewBinding.songCover,
                song.getArt(),
                Optional.empty()
        );
    }


    @Override
    public int getLayout() {
        return R.layout.song_item;
    }
}
