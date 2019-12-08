public class Song {
    protected String title;
    int duration;

    Song() {

    }

    Song(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String toString() {
        return title + "(" + convertDuration() + ")";
    }

    public String convertDuration() {
        int minutes = duration / 60;
        int seconds = duration % 60;
        return minutes + ":" + seconds;
    }
}
