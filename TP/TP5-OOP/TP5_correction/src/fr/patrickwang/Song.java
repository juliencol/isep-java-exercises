package fr.patrickwang;

public class Song {
    String title;
    int duration;

    public Song() {
    }

    public Song(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return this.title + " (" + convertDuration() + ")";
    }

    private String convertDuration() {
        int minutes = duration / 60;
        int secondes = duration % 60;
        return minutes + ":" + secondes;
    }
}
