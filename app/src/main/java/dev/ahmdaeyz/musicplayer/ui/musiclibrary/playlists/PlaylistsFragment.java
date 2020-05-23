package dev.ahmdaeyz.musicplayer.ui.musiclibrary.playlists;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.xwray.groupie.GroupAdapter;

import java.util.List;

import dev.ahmdaeyz.musicplayer.data.PlaylistsProvider;
import dev.ahmdaeyz.musicplayer.data.inapp.InAppPlaylistsProvider;
import dev.ahmdaeyz.musicplayer.databinding.FragmentPlaylistsBinding;

public class PlaylistsFragment extends Fragment {
    public static final String PLAYLIST_ARG = "PLAYLIST";
    private FragmentPlaylistsBinding binding;
    private PlaylistsViewModel playlistsViewModel;
    public PlaylistsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PlaylistsProvider provider = new InAppPlaylistsProvider();
        PlaylistsViewModelFactory factory = new PlaylistsViewModelFactory(provider);
        playlistsViewModel = new ViewModelProvider(this,factory).get(PlaylistsViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentPlaylistsBinding.inflate(inflater,container,false);
        GroupAdapter adapter = new GroupAdapter();
        binding.playlistsList.setAdapter(adapter);
        playlistsViewModel.playlistsItems.observe(getViewLifecycleOwner(), new Observer<List<PlaylistItem>>() {
            @Override
            public void onChanged(List<PlaylistItem> playlistItems) {
                adapter.addAll(playlistItems);
            }
        });
        return binding.getRoot();
    }
}
