package dev.ahmdaeyz.musicplayer.ui.musiclibrary.songs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.xwray.groupie.GroupAdapter;

import java.util.List;

import dev.ahmdaeyz.musicplayer.data.SongsProvider;
import dev.ahmdaeyz.musicplayer.data.inapp.InAppSongsProvider;
import dev.ahmdaeyz.musicplayer.databinding.FragmentSongsBinding;

public class SongsFragment extends Fragment {

    private FragmentSongsBinding binding;
    private SongsViewModel songsViewModel;
    public SongsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SongsProvider provider = new InAppSongsProvider();
        SongsViewModelFactory factory = new SongsViewModelFactory(provider);
        songsViewModel = new  ViewModelProvider(this,factory).get(SongsViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSongsBinding.inflate(inflater,container,false);

        GroupAdapter adapter = new GroupAdapter();
        binding.songsList.setAdapter(adapter);
        songsViewModel.songItems.observe(getViewLifecycleOwner(), new Observer<List<SongItem>>() {
            @Override
            public void onChanged(List<SongItem> songItems) {
                adapter.addAll(songItems);
            }
        });

        return binding.getRoot();
    }


}

