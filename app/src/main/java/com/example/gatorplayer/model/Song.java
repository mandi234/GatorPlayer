package com.example.gatorplayer.model;

import android.net.Uri;

public class Song {
    private Uri aPath;
    private String aName;
    private String aAlbum;
    private String aArtist;

    public Song() {
    }

    public Song(Uri aPath, String aName, String aAlbum, String aArtist) {
        this.aPath = aPath;
        this.aName = aName;
        this.aAlbum = aAlbum;
        this.aArtist = aArtist;
    }

    public Song(String aName) {
        this.aName = aName;
    }

    public Uri getaPath() {
        return aPath;
    }

    public void setaPath(Uri aPath) {
        this.aPath = aPath;
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
