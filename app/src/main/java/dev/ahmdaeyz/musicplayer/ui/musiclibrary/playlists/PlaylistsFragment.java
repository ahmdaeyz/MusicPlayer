package dev.ahmdaeyz.musicplayer.ui.musiclibrary.playlists;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skydoves.transformationlayout.TransformationCompat;
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.Item;
import com.xwray.groupie.OnItemClickListener;
import com.xwray.groupie.OnItemLongClickListener;

import org.parceler.Parcels;

import java.util.List;

import dev.ahmdaeyz.musicplayer.data.PlaylistsProvider;
import dev.ahmdaeyz.musicplayer.data.inapp.InAppPlaylistsProvider;
import dev.ahmdaeyz.musicplayer.databinding.FragmentPlaylistsBinding;
import dev.ahmdaeyz.musicplayer.ui.playlistdetails.PlaylistDetailsActivity;

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

        adapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(@NonNull Item item, @NonNull View view) {

                Log.d("Item Clicked","yes");
                PlaylistItem playlistItem = (PlaylistItem) item;
                Intent intent = new Intent(requireContext(), PlaylistDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(PLAYLIST_ARG, Parcels.wrap(playlistItem.getPlaylist()));
                intent.putExtras(bundle);
                TransformationCompat.INSTANCE.startActivity(
                        playlistItem.initializeViewBinding(view).transformationLayout,intent);
                return true;
            }

        });
        return binding.getRoot();
    }
}
