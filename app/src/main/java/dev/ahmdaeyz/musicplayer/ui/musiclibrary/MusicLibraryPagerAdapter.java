package dev.ahmdaeyz.musicplayer.ui.musiclibrary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import dev.ahmdaeyz.musicplayer.ui.musiclibrary.albums.AlbumsFragment;
import dev.ahmdaeyz.musicplayer.ui.musiclibrary.playlists.PlaylistsFragment;
import dev.ahmdaeyz.musicplayer.ui.musiclibrary.songs.SongsFragment;

public class MusicLibraryPagerAdapter extends FragmentPagerAdapter {

    private String titles[] = {
      "Playlists",
      "Albums",
      "Songs"
    };

    public MusicLibraryPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PlaylistsFragment();
            case 1:
                return new AlbumsFragment();
            case 2:
                return new SongsFragment();
        }
        return new PlaylistsFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
