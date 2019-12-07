package fr.patrickwang;

import java.util.ArrayList;
import java.util.List;

public class Artist implements Comparable {
    private String name;
    private boolean isActive;
    private List<Album> albums;

    public Artist() {
    }

    public Artist(String name, boolean isActive, List<Album> albums) {
        this.name = name;
        this.isActive = isActive;
        this.albums = albums;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void addAlbum(Album album) {
        if (albums == null) albums = new ArrayList<>();
        if (!albums.contains(album)) albums.add(album);
    }

    public void removeAlbum(String albumName) {
        if (getAlbumByName(albumName) != null) {
            albums.remove(getAlbumByName(albumName));
        }
    }

    private Album getAlbumByName(String albumName) {
        for (Album album : albums) {
            if (album.getTitle().equals(albumName)) return album;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        Artist other = (Artist) o;
        return this.getName().compareTo(other.getName());
    }
}
