import java.util.*;

public class Library {
    Scanner scanner;
    TreeSet<Artist> library;

    public void run() {
        if (library == null) library = new TreeSet<>();
        while (true) {
            displayMenu();
        }
    }

    public void displayMenu() {
        scanner = new Scanner(System.in);
        int userChoice;
        System.out.println("Press 1 to add an artist to your collection.\n" +
                "Press 2 to delete an artist from your collection. " +
                "Press 3 to list all available artists.\n" +
                "Press 4 to add an album to an artist.\n" +
                "Press 5 to remove an album from an artist.\n" +
                "Press 6 to list the albums of a given artist."
        );
        do {
            userChoice = scanner.nextInt();
        } while (userChoice < 1 || userChoice > 6);

        switch (userChoice) {
            case 1:
                addArtist();
                break;
            case 2:
                removeArtist();
                break;
            case 3:
                listArtists();
                break;
            case 4:
                addAlbum();
                break;
            case 5:
                removeAlbum();
                break;
            case 6:
                listAlbumsForArtist();
                break;
        }
    }

    public void addArtist() {
        // Create an instance of Artist
        System.out.println("Enter your artist's name: ");
        String artistName = scanner.nextLine();
        System.out.println("Is " + artistName + " active? (y/n)");
        boolean artistActive = scanner.nextLine().equals("y");
        Artist userArtist = new Artist(artistName, artistActive, new ArrayList<>());

        // Adds the instance to the library if it's not already there
        if (library.contains(userArtist)) {
            System.out.println("Sorry, this artist is already in your library.");
        }
        else {
            library.add(userArtist);
            System.out.println(userArtist.name + " has been added yo your library successfully.");
        }
    }

    public void removeArtist() {
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

    public void listArtists() {
        for(Artist artist : library) {
            System.out.print(artist.getName());
        }
    }

    public void addAlbum() {
        System.out.println("Enter the name of an artist: ");
        String userArtistName = scanner.nextLine();
        for(Artist artist : library) {
            if(artist.getName().equals(userArtistName)) {
                System.out.println("Enter the title of the album: ");
                String userAlbumTitle = scanner.nextLine();

                System.out.println("Enter the year of the album: ");
                int userAlbumYear = scanner.nextInt();

                System.out.println("Enter the songs of the album: ");
                Song userAlbumSong1 = new Song();
                Song userAlbumSong2 = new Song();
                ArrayList<Song> userAlbumSongs = new ArrayList<Song>();
                userAlbumSongs.add(userAlbumSong1);
                userAlbumSongs.add(userAlbumSong2);
                Album userAlbum = new Album(userAlbumTitle, userAlbumYear, userAlbumSongs);

                if (artist.albums.contains(userAlbumSongs)) {
                    System.out.println("Sorry, this album is already in your library.");
                }
                else {
                    artist.addAlbum(userAlbum);
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
