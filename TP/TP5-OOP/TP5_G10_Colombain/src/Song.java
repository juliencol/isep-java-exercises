public class Song {
    String title;
    String duration;

    /* default constructor */
    Song(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

    public String toString() {
        String result = "";
        result = this.title + " (mm:ss)";
        return result;
    }
}
