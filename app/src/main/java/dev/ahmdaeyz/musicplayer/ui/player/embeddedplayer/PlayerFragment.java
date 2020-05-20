package dev.ahmdaeyz.musicplayer.ui.player.embeddedplayer;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skydoves.transformationlayout.TransformationCompat;
import com.skydoves.transformationlayout.TransitionExtensionKt;

import dev.ahmdaeyz.musicplayer.R;
import dev.ahmdaeyz.musicplayer.databinding.FragmentPlayerBinding;
import dev.ahmdaeyz.musicplayer.model.Song;
import dev.ahmdaeyz.musicplayer.ui.player.PlayerActivity;

import static dev.ahmdaeyz.musicplayer.ui.utils.Binding.*;


public class PlayerFragment extends Fragment {
    private FragmentPlayerBinding binding;
    private PlayerFragmentViewModel viewModel;

    public PlayerFragment() {
        // Required empty public constructor
    }


//    public static PlayerFragment newInstance(String param1, String param2) {
//        PlayerFragment fragment = new PlayerFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PlayerFragmentViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPlayerBinding.inflate(inflater, container, false);
        bindPlayer();

        binding.songCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(),PlayerActivity.class);
                TransformationCompat.INSTANCE.startActivity(binding.transformationLayout,intent);
            }
        });
        return binding.getRoot();
    }

    private void bindPlayer(){
        viewModel.nowPlaying.observe(getViewLifecycleOwner(), new Observer<Song>() {
            @Override
            public void onChanged(Song song) {
                binding.songArtist.setText(song.getArtist());
                binding.songTitle.setText(song.getTitle());
                bindCircleImageView(binding.songCover,song.getArt(),getResources().getColor(R.color.colorGradientStart,getResources().newTheme()),1);
            }
        });
    }

}