package com.example.gatorplayer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gatorplayer.R;
import com.example.gatorplayer.model.Song;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {

    private final List<Song> mSongs;

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView songName;
        private TextView songPath;
        private TextView songAlbum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            songName = itemView.findViewById(R.id.song_name);
            songPath= itemView.findViewById(R.id.song_path);
            songAlbum = itemView.findViewById(R.id.song_album);
        }
    }

    public SongsAdapter(List<Song> songs) {
        mSongs = songs;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = mSongs.get(position);

        TextView songNameTextView = holder.songName;
        songNameTextView.setText(song.getaName());

        TextView songPathTextView = holder.songPath;
        songPathTextView.setText(song.getaPath());

        TextView songAlbumTextView = holder.songAlbum;
        songAlbumTextView.setText(song.getaAlbum());

    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }
}
