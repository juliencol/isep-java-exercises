import java.util.*;

public class Artist {
    protected String name;
    private boolean isActive;
    protected List<Album> albums;

    public Artist() {
    }

    public Artist(String name, boolean isActive, List<Album> albums) {
        this.name = name;
        this.isActive = isActive;
        this.albums = albums;
    }

    public List<Album> getAlbum() {
        return albums;
    }

    public String getName() {
        return this.name;
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public void removeAlbum(String albumName) {
        if (Arrays.asList(albums).contains(albumName)) {
            albums.remove(albumName);
        }
        else {
            System.out.println("Sorry, this album is not in the list.");
        }
    }
}
