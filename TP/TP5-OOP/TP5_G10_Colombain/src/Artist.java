import java.util.*;

public class Artist {
    String name;
    Boolean isActive;
    List albums;

    Artist(String name, Boolean isActive, List albums) {
        this.name = name;
        this.isActive = isActive;
        this.albums = albums;
    }

    public List getAlbum() {
        /* This method returns the list of albums of the artist. */
        return this.albums;
    }

    public String getName() {
        /* This method returns the name of the artist. */
        return this.name;
    }

    public List addAlbum(Album album) {
        /* This method adds an album to the list of albums of the artists and then return the list. */
        this.albums.add(album);
        return albums;
    }

    public void removeAlbum(String albumName) {
        /* This method removes an album in the list of albums of the artists and then return the list. */
        if (Arrays.asList(albums).contains(albumName)) {
            this.albums.remove(albumName);
        }
        else {
            System.out.println("Sorry, this album is not the list.");
        }
    }
}
