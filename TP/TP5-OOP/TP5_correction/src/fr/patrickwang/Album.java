package fr.patrickwang;

import java.util.List;

public class Album {
    String title;
    int year;
    List<Song> songs;

    public Album() {
    }

    public Album(String title, int year, List<Song> songs) {
        this.title = title;
        this.year = year;
        this.songs = songs;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(title);
        for (Song s : songs) {
            builder.append("\n\t")
                    .append(s.toString());
        }
        return builder.toString();
    }
}
