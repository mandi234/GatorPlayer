package com.example.gatorplayer.model;

import android.net.Uri;

import java.util.Observable;

public class CurrentSongSingleton extends Observable {
    private static final CurrentSongSingleton ourInstance = new CurrentSongSingleton();

    private Uri aPath;
    private String aName;
    private String aAlbum;
    private String aArtist;

    public static CurrentSongSingleton getInstance() {
        return ourInstance;
    }

    private CurrentSongSingleton() {
        aPath = Uri.EMPTY;
    }

    public static CurrentSongSingleton getOurInstance() {
        return ourInstance;
    }

    public Uri getaPath() {
        return aPath;
    }

    public void setaPath(Uri aPath) {
        if(!this.aPath.equals(aPath)) {
            this.aPath = aPath;

            setChanged();
        }
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaAlbum() {
        return aAlbum;
    }

    public void setaAlbum(String aAlbum) {
        this.aAlbum = aAlbum;
    }

    public String getaArtist() {
        return aArtist;
    }

    public void setaArtist(String aArtist) {
        this.aArtist = aArtist;
    }
}
