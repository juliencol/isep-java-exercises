package fr.patrickwang;

import java.util.*;

public class Library {
    TreeSet<Artist> library;
    Scanner scanner;

    public void run() {
        if (library == null) library = new TreeSet<>();

        while (true) {
            displayMenu();
        }
    }

    private void displayMenu() {
        System.out.println("Bienvenue sur voter bibliothèque musicale !\n" +
                "Tapez 1 pour ajouter un artiste à votre collection.\n" +
                "Tapez 2 pour supprimer un artiste de votre collection.\n" +
                "Tapez 3 pour lister tous les artistes.\n" +
                "Tapez 4 pour ajouter un album à un artiste.\n" +
                "Tapez 5 pour retirer un album à un artiste.\n" +
                "Tapez 6 pour lister tous les albums pour un artiste donné."
        );
        scanner = new Scanner(System.in);
        int choice;
        do {
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }
        } while (choice < 1 || choice > 6);

        switch (choice) {
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

    private void addArtist() {
        System.out.println("Nom de l'artiste :");
        String name = scanner.nextLine();
        System.out.println("Encore actif (y/n):");
        boolean isActive = scanner.nextLine().equals("y");
        Artist artist = new Artist(name, isActive, new ArrayList<>());
        library.add(artist);
    }

    private void removeArtist() {
        System.out.println("Nom de l'artiste :");
        String name = scanner.nextLine();
        if (getArtistByName(name) != null) library.remove(getArtistByName(name));
    }

    private void listArtists() {
        Iterator<Artist> iterator = library.iterator();
        while (iterator.hasNext()) {
            Artist artist = iterator.next();
            System.out.println(artist.toString());
        }
    }

    private void addAlbum() {
        System.out.println("Nom de l'artiste :");
        String artistName = scanner.nextLine();
        if (getArtistByName(artistName) != null) {
            Artist artist = getArtistByName(artistName);
            System.out.println("Nom de l'album :");
            String name = scanner.nextLine();
            System.out.println("Année de sortie :");
            int annee;
            do {
                try {
                    annee = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    annee = 0;
                }
            } while (annee == 0);

            List<Song> songs = new ArrayList<>();
            String choix;
            do {
                System.out.println("*** Ajout d'une chanson à l'album ***");
                songs.add(createSong());
                System.out.println("Voulez-vous ajouter une autre chanson à cet album (y/n) ?");
                choix = scanner.nextLine();
            } while (choix.equals("y"));
            Album album = new Album(name, annee, songs);
            artist.addAlbum(album);
        }
    }

    private Song createSong() {
        System.out.println("Nom de la chanson :");
        String name = scanner.nextLine();
        System.out.println("Durée de la chanson :");
        int duree;
        do {
            try {
                duree = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                duree = 0;
            }
        } while (duree == 0);
        return new Song(name, duree);
    }

    private void removeAlbum() {
        System.out.println("Nom de l'artiste :");
        String artistName = scanner.nextLine();
        if (getArtistByName(artistName) != null) {
            Artist artist = getArtistByName(artistName);
            System.out.println("Nom de l'album à supprimer :");
            String albumName = scanner.nextLine();
            artist.removeAlbum(albumName);
        }
    }

    private void listAlbumsForArtist() {
        System.out.println("Nom de l'artiste :");
        String artistName = scanner.nextLine();
        if (getArtistByName(artistName) != null) {
            StringBuilder builder = new StringBuilder();
            builder.append(artistName)
                    .append("\n");
            Artist artist = getArtistByName(artistName);
            for (Album album : artist.getAlbums()) {
                builder.append(album.toString())
                        .append("\n");
            }
            System.out.println(builder.toString());
        } else {
            System.out.println("Aucun album pour " + artistName);
        }
    }

    private Artist getArtistByName(String artistName) {
        Iterator<Artist> iterator = library.iterator();
        while (iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.getName().equals(artistName)) {
                return artist;
            }
        }
        return null;
    }
}
