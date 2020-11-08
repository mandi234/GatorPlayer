package com.example.gatorplayer.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

import com.example.gatorplayer.R;
import com.example.gatorplayer.adapters.SongsAdapter;
import com.example.gatorplayer.model.Song;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPerms();

        RecyclerView rvSongs = findViewById(R.id.rvSongs);

        //songs = Arrays.asList(new Song("chuj"), new Song("kutas"), new Song("chuj"), new Song("kutas"), new Song("chuj"), new Song("kutas"), new Song("chuj"), new Song("kutas"));
        songs = getAllSongs(this);
        SongsAdapter adapter = new SongsAdapter(songs);

        rvSongs.setAdapter(adapter);
        rvSongs.setLayoutManager(new LinearLayoutManager(this));

    }

    private void checkPerms() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);

                return;
            }
        }
    }

    private List<Song> getAllSongs(final Context context) {
        final List<Song> tempAudioList = new ArrayList<>();

        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Audio.AudioColumns.DATA, MediaStore.Audio.AudioColumns.TITLE, MediaStore.Audio.AudioColumns.ALBUM, MediaStore.Audio.ArtistColumns.ARTIST,};
        //String[] projection = {MediaStore.Audio.AudioColumns.DATA, MediaStore.Audio.AudioColumns.TITLE, MediaStore.Audio.AudioColumns.ALBUM, MediaStore.Audio.ArtistColumns.ARTIST,};
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
        Cursor c = context.getContentResolver().query(uri,
                projection,
                null,
                null, // yourFolderName
                null);

        if (c != null) {
            while (c.moveToNext()) {
                Song Song = new Song();
                String path = c.getString(0);
                String name = c.getString(1);
                String album = c.getString(2);
                String artist = c.getString(3);

                Song.setaName(name);
                Song.setaAlbum(album);
                Song.setaArtist(artist);
                Song.setaPath(path);

                Log.e("Name :" + name, " Album :" + album);
                Log.e("Path :" + path, " Artist :" + artist);

                tempAudioList.add(Song);
            }
            c.close();
        }

        return tempAudioList;
    }
}
