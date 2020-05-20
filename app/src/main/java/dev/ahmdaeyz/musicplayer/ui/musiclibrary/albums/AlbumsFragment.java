package dev.ahmdaeyz.musicplayer.ui.musiclibrary.albums;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xwray.groupie.GroupAdapter;

import java.util.List;

import dev.ahmdaeyz.musicplayer.R;
import dev.ahmdaeyz.musicplayer.data.AlbumsProvider;
import dev.ahmdaeyz.musicplayer.data.inapp.InAppAlbumsProvider;
import dev.ahmdaeyz.musicplayer.databinding.FragmentAlbumsBinding;


public class AlbumsFragment extends Fragment {

    private FragmentAlbumsBinding binding;
    private AlbumsViewModel albumsViewModel;
    public AlbumsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlbumsProvider albumsProvider = new InAppAlbumsProvider();
        AlbumsViewModelFactory factory = new AlbumsViewModelFactory(albumsProvider);
        albumsViewModel = new ViewModelProvider(this,factory).get(AlbumsViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAlbumsBinding.inflate(inflater,container,false);
        GroupAdapter adapter = new GroupAdapter();
        binding.albumsList.setAdapter(adapter);

        albumsViewModel.AlbumsItems.observe(getViewLifecycleOwner(), new Observer<List<AlbumItem>>() {
            @Override
            public void onChanged(List<AlbumItem> albumItems) {
                adapter.addAll(albumItems);
            }
        });
        return binding.getRoot();
    }



}
