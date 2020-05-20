package dev.ahmdaeyz.musicplayer.ui.musiclibrary.albums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.xwray.groupie.viewbinding.BindableItem;

import java.util.Optional;

import dev.ahmdaeyz.musicplayer.R;
import dev.ahmdaeyz.musicplayer.databinding.AlbumItemBinding;
import dev.ahmdaeyz.musicplayer.model.Album;
import dev.ahmdaeyz.musicplayer.ui.utils.Binding;

import static dev.ahmdaeyz.musicplayer.ui.utils.Binding.bindImageViewWithRoundedCorners;

public class AlbumItem extends BindableItem<AlbumItemBinding> {

    private Album album;

    public AlbumItem(Album album){
        this.album = album;
    }

    @NonNull
    @Override
    protected AlbumItemBinding initializeViewBinding(@NonNull View view) {
        return AlbumItemBinding.bind(view);
    }

    @Override
    public void bind(@NonNull AlbumItemBinding viewBinding, int position) {
        viewBinding.albumTitle.setText(album.getTitle());
        viewBinding.artistName.setText(album.getArtist());
        bindImageViewWithRoundedCorners(
                viewBinding.albumArt,
                album.getArt(),
                Optional.of(30)
        );
    }

    @Override
    public int getLayout() {
        return R.layout.album_item;
    }

    public Album getAlbum() {
        return album;
    }
}
