package com.example.gatorplayer.adapters;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gatorplayer.R;
import com.example.gatorplayer.model.CurrentSongSingleton;
import com.example.gatorplayer.model.Song;

import java.io.IOException;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {

    private final List<Song> mSongs;
    private Context context;
    private MediaPlayer mediaPlayer;

    public static class ViewHolder extends RecyclerView.ViewHolder  {

        private TextView songName;
        private TextView songAlbum;
        private Uri songPath;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            songName = itemView.findViewById(R.id.song_name);
            songAlbum = itemView.findViewById(R.id.song_album);
        }

        public Uri getSongPath() {
            return songPath;
        }

        public void setSongPath(Uri songPath) {
            this.songPath = songPath;
        }
    }

    public SongsAdapter(List<Song> songs) {
        mSongs = songs;
    }

    public SongsAdapter(List<Song> mSongs, Context context) {
        this.mSongs = mSongs;
        this.context = context;
        mediaPlayer = new MediaPlayer();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View songView = layoutInflater.inflate(R.layout.song_holder_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(songView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Song song = mSongs.get(position);

        TextView songNameTextView = holder.songName;
        songNameTextView.setText(song.getaName());


        TextView songAlbumTextView = holder.songAlbum;
        songAlbumTextView.setText(song.getaAlbum());

        holder.setSongPath(song.getaPath());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Jak nie jak tak!" + song.getaName(), Toast.LENGTH_LONG).show();
                CurrentSongSingleton currentSongSingleton = CurrentSongSingleton.getInstance();
                currentSongSingleton.setaPath(song.getaPath());
                currentSongSingleton.setaAlbum(song.getaAlbum());
                currentSongSingleton.setaName(song.getaName());
                currentSongSingleton.setaArtist(song.getaArtist());
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(0);
                    mediaPlayer.pause();
                }
                try {
                    mediaPlayer.reset();
                    mediaPlayer.setDataSource(context, currentSongSingleton.getaPath());
                    mediaPlayer.setAudioAttributes(
                            new AudioAttributes.Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build()
                    );
                    mediaPlayer.prepare();
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mediaPlayer.start();
                        }
                    });
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {

                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }
}
