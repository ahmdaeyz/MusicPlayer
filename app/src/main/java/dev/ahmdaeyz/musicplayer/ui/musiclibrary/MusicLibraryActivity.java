package dev.ahmdaeyz.musicplayer.ui.musiclibrary;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.skydoves.transformationlayout.TransitionExtensionKt;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import dev.ahmdaeyz.musicplayer.R;
import dev.ahmdaeyz.musicplayer.databinding.ActivityMainBinding;
import dev.ahmdaeyz.musicplayer.ui.player.embeddedplayer.PlayerFragment;
import dev.ahmdaeyz.musicplayer.ui.search.SearchLibraryActivity;

public class MusicLibraryActivity extends AppCompatActivity {

    public static final int READ_STORAGE_PERMISSION_REQUEST_CODE = 22234;
    private FragmentManager fragmentManager;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TransitionExtensionKt.onTransformationStartContainer(this);
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        checkReadExternalStoragePermission();
        fragmentManager = getSupportFragmentManager();
        binding.tabs.setupWithViewPager(binding.viewPager);
        MusicLibraryPagerAdapter musicLibraryPagerAdapter = new MusicLibraryPagerAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        binding.viewPager.setAdapter(musicLibraryPagerAdapter);
        setSupportActionBar(binding.toolBar);
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container,new PlayerFragment())
                .commit();
    }



    private void checkReadExternalStoragePermission(){
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

        }else{
            if (!shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)){
                Toast
                        .makeText(
                                this,
                                "App needs to read your music files.",
                                Toast.LENGTH_SHORT
                        ).show();
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_STORAGE_PERMISSION_REQUEST_CODE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case READ_STORAGE_PERMISSION_REQUEST_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){

                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tool_bar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:
                Intent intent = new Intent(this, SearchLibraryActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}