package dev.ahmdaeyz.musicplayer.ui.playlistdetails;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.skydoves.transformationlayout.TransformationAppCompatActivity;
import com.xwray.groupie.GroupAdapter;

import org.parceler.Parcels;

import dev.ahmdaeyz.musicplayer.R;
import dev.ahmdaeyz.musicplayer.databinding.ActivityPlaylistDetailsBinding;
import dev.ahmdaeyz.musicplayer.model.Playlist;
import dev.ahmdaeyz.musicplayer.ui.player.embeddedplayer.PlayerFragment;

import static dev.ahmdaeyz.musicplayer.ui.musiclibrary.playlists.PlaylistsFragment.PLAYLIST_ARG;

public class PlaylistDetailsActivity extends TransformationAppCompatActivity {
    private Playlist playlist;
    ActivityPlaylistDetailsBinding binding;
    private PlaylistDetailsViewModel viewModel;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlaylistDetailsBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            playlist = Parcels.unwrap(bundle.getParcelable(PLAYLIST_ARG));
        }
        fragmentManager = getSupportFragmentManager();
        viewModel = new ViewModelProvider(this).get(PlaylistDetailsViewModel.class);
        bindDetails();
    }

    private void bindDetails() {
        GroupAdapter adapter = new GroupAdapter();
        binding.playlistSongs.setAdapter(adapter);
        binding.playlistName.setText(playlist.getName());
        adapter.addAll(viewModel.songItemsFrom(playlist.getSongs()));
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container,new PlayerFragment())
                .commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
