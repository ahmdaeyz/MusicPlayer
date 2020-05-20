package dev.ahmdaeyz.musicplayer.ui.player;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.skydoves.transformationlayout.TransformationAppCompatActivity;

import dev.ahmdaeyz.musicplayer.R;
import dev.ahmdaeyz.musicplayer.databinding.ActivityPlayerBinding;
import dev.ahmdaeyz.musicplayer.model.Song;
import jp.wasabeef.glide.transformations.CropCircleWithBorderTransformation;

import static dev.ahmdaeyz.musicplayer.ui.utils.Binding.bindCircleImageView;

public class PlayerActivity extends TransformationAppCompatActivity {
    private ActivityPlayerBinding binding;
    private PlayerActivityViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayerBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(PlayerActivityViewModel.class);
        bindPlayer();
    }

    private void bindPlayer() {
        viewModel.nowPlaying.observe(this, new Observer<Song>() {
            @Override
            public void onChanged(Song song) {
                binding.songDurationSeekBar.setMax(song.getDuration());
                binding.songDurationSeekBar.setProgress((int)(song.getDuration()*0.25));
                binding.songArtist.setText(song.getArtist());
                binding.songTitle.setText(song.getTitle());
                bindCircleImageView(binding.songCover,song.getArt(),getResources().getColor(R.color.colorGradientStart,getResources().newTheme()),4);

            }
        });
    }
}
