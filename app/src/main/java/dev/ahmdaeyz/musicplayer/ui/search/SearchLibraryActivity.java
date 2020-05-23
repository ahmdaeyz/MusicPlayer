package dev.ahmdaeyz.musicplayer.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.jakewharton.rxbinding3.widget.RxTextView;
import com.xwray.groupie.GroupAdapter;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import dev.ahmdaeyz.musicplayer.R;
import dev.ahmdaeyz.musicplayer.data.SongsProvider;
import dev.ahmdaeyz.musicplayer.data.inapp.InAppSongsProvider;
import dev.ahmdaeyz.musicplayer.databinding.ActivitySearchLibraryBinding;
import dev.ahmdaeyz.musicplayer.model.Song;
import dev.ahmdaeyz.musicplayer.ui.musiclibrary.songs.SongItem;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class SearchLibraryActivity extends AppCompatActivity {
    private ActivitySearchLibraryBinding binding;
    private CompositeDisposable disposables = new CompositeDisposable();
    private SearchLibraryViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchLibraryBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        SongsProvider provider = new  InAppSongsProvider();
        SearchLibraryViewModelFactory factory = new SearchLibraryViewModelFactory(provider);
        viewModel = new ViewModelProvider(this,factory).get(SearchLibraryViewModel.class);
        GroupAdapter adapter = new GroupAdapter();
        binding.resultsList.setAdapter(adapter);
        disposables.add(
                RxTextView.textChanges(binding.searchEditText)
                .debounce(200, TimeUnit.MILLISECONDS)
                .filter((charSequence)-> charSequence.toString().trim().length()>0)
                .flatMap((charSequence)->{
                    return viewModel.searchSongsLibrary(
                            charSequence.toString()
                            .toLowerCase()
                            .trim()
                    ).toObservable();
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe((list)->{
                    binding.searchInfo.setVisibility(View.GONE);
                    List<SongItem> songItems = list.stream()
                            .map(Song.class::cast)
                            .map((SongItem::new))
                            .collect(Collectors.toList());
                    adapter.clear();
                    adapter.addAll(songItems);
                    if (list.size() == 0) {
                        binding.searchInfo.setVisibility(View.VISIBLE);
                        binding.searchInfo.setText(getString(R.string.no_such_song));
                    } else {
                        binding.searchInfo.setVisibility(View.GONE);
                    }
                })
        );
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
