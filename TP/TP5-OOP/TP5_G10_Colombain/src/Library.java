import java.util.*;

public class Library {
    static Scanner scanner = new Scanner(System.in);
    TreeSet<Artist> library = new TreeSet<Artist>();

    public void displayMenu() {
        // This method displays a menu for the user to select an action. */

        System.out.println("Tapez 1 pour ajouter un artiste à votre collection.\n" +
                "Tapez 2 pour supprimer un artiste de votre collection. Tapez 3 pour lister tous les artistes.\n" +
                "Tapez 4 pour ajouter un album à un artiste.\n" +
                "Tapez 5 pour retirer un album à un artiste.\n" +
                "Tapez 6 pour lister tous les albums pour un artiste donné.");
        Integer userChoice = scanner.nextInt();
    }

    public void addArtist() {
        /* This method allow the user to add an artist to a library. */

        // Create an instance of Artist
        System.out.println("Enter your artist's name: ");
        String artistName = scanner.nextLine();
        System.out.println("Is " + artistName + " active?");
        Boolean artistActive = scanner.nextBoolean();
        ArrayList<String> artistAlbums = new ArrayList<String>();
        Artist userArtist = new Artist(artistName, artistActive, artistAlbums);

        // Adds the instance to the library if it's not already there
        if (library.contains(userArtist)) {
            System.out.println("Sorry, this artist is already in your library.");
        }
        else {
            this.library.add(userArtist);
            System.out.println(userArtist.name + " has been added yo your library successfully.");
        }
    }

    public void removeArtist() {
        /* This method allow the user to remove an artist from his library. */

        System.out.println("Enter the name of the artist you want to delete: ");
        String userArtistName = scanner.nextLine();
        for(Artist artist : library) {
            if(artist.getName().equals(userArtistName)) {
                this.library.remove(artist);
                System.out.println(userArtistName + " has been removed from your library successfully.");
            }
            else {
                System.out.println("Sorry, this artist is not in your library.");
            }
        }
    }

    public void listArtist() {
        /* This method all the artists present in the library. */

        for(Artist artist : library) {
            System.out.print(artist.getName());
        }
    }

    public void addAlbum() {
        /* This method adds an album to an artist in the library. */

        System.out.println("Enter the name of an artist: ");
        String userArtistName = scanner.nextLine();

        for(Artist artist : library) {
            if(artist.getName().equals(userArtistName)) {
                System.out.println("Enter the title of the album: ");
                String userAlbumTitle = scanner.nextLine();

                System.out.println("Enter the year of the album: ");
                Integer userAlbumYear = scanner.nextInt();

                System.out.println("Enter the songs of the album: ");
                String userAlbumSong1 = scanner.nextLine();
                String userAlbumSong2 = scanner.nextLine();
                ArrayList<String> userAlbumSongs = new ArrayList<String>();
                userAlbumSongs.add(userAlbumSong1);
                userAlbumSongs.add(userAlbumSong2);

                if (artist.albums.contains(userAlbumSongs)) {
                    System.out.println("Sorry, this album is already in your library.");
                }
                else {
                    artist.albums.add(userAlbumSongs);
                }
            }
            else {
                System.out.println("Sorry, this artist in not in your library.");
            }
        }
    }

    public void removeAlbum() {
        /* This method removes an album from an artist in a library. */

        System.out.println("Enter the name of an artist: ");
        String userArtistName = scanner.nextLine();

        for (Artist artist : library) {
            if (artist.getName().equals(userArtistName)) {
                System.out.println("Enter the title of the album: ");
                String userAlbumTitle = scanner.nextLine();

                for (Album album : artist.albums) {
                    if (album.title.equals(userAlbumTitle)) {
                        artist.removeAlbum(album.title);
                    }
                    else {
                        System.out.println("Sorry, this album is not in your library.");
                    }
                }
            }
            else {
                System.out.println("Sorry, this artist in not in your library.");
            }
        }
    }

    public void listAlbumsForArtist() {
        /* This method list all the album of an artist in a library. */

        // ask user to chose an artist
        System.out.println("Enter an artist name: ");
        String userArtistName = scanner.nextLine();

        // list the albums of the chosen artist
        for (Artist artist : library) {
            if (artist.getName().equals(artist.name)) {
                System.out.println(artist.albums);
            }
            else {
                System.out.println("Sorry this artist is not in the library.");
            }
        }
    }
}
