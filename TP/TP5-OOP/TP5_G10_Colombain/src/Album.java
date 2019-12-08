import java.util.*;

public class Album {
    String title;
    int year;
    protected List<Song> songs;

    public Album() {
    }

    public Album(String title, int year, List<Song> songs) {
        this.title = title;
        this.year = year;
        this.songs = songs;
    }

    public String toString() {
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append(title);
       for (Song song: songs) {
            stringBuilder.append("\n").append(song.toString());
       }
       return stringBuilder.toString();
    }

}
