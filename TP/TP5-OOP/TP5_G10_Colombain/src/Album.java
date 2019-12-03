import java.util.*;

public class Album {
    String title;
    Integer year;
    List songs;

    /* default constructor */
    Album(String title, Integer year, List songs) {
        this.title = title;
        this.year = year;
        this.songs = songs;
    }

    public String getTitle(){
        return this.title;
    }

}
