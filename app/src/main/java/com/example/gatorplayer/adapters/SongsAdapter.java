package com.example.gatorplayer.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gatorplayer.R;
import com.example.gatorplayer.activities.MainActivity;
import com.example.gatorplayer.model.Song;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {

    private final List<Song> mSongs;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView songName;
        private TextView songAlbum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            songName = itemView.findViewById(R.id.song_name);
            songAlbum = itemView.findViewById(R.id.song_album);
        }

        @Override
        public void onClick(View view) {

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
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Song song = mSongs.get(position);

        TextView songNameTextView = holder.songName;
        songNameTextView.setText(song.getaName());


        TextView songAlbumTextView = holder.songAlbum;
        songAlbumTextView.setText(song.getaAlbum());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Jak nie jak tak!" + song.getaName(), Toast.LENGTH_LONG).show();
                Log.e("tag", "Weszo!");
            }
        });

    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }
}
