import java.util.*;

public class Main {
    public static String[] messagesChiffres = {
            "xz hvwdq pq ovsdq v wpz pq xkvnnzpu",
            "jk hjq gdzp don jqw wpz fzqqt",
            "pq ovqqdnwzu svdz wjpmjpun nzn gzwwzn",
            "hjq suzxdzpa",
            "do znw dqwzugdw gz svuozu gp idbkw xope",
            "ezvpxjps zqxjuz do wz uznwz v vssuzqguz",
            "lpz wuzsvnnz nd mz ivdeodn"
    };
    public static String[] messagesDechiffres = {
            "ce matin un lapin a tue un chasseur",
            "oh mon dieu ils ont tue kenny",
            "un lannister paie toujours ses dettes",
            "mon precieux",
            "il est interdit de parler du fight club",
            "beaucoup encore il te reste a apprendre",
            "que trepasse si je faiblis"
    };

    public static char[][] plateau;
    public static Scanner scanner = new Scanner(System.in);
    public static char joueur1 = 'O';
    public static char joueur2 = 'X';
    public static boolean estJoueur1 = true;


    public static void main(String[] args) {
        // TODO: Implémenter cette fonction pour tester vos exercices
        // System.out.println(testDecodeurMessage());
        // System.out.println(decodeurMessage(messagesChiffres[0]));
        // System.out.println(decodeurMessage(messagesDechiffres[0]));
        // puissance4();
    }


    /** Test function
     * returns true if test succeded, false sinon
     * @return
     */
    public static boolean testDecodeurMessage() {
        if (messagesChiffres[0] == messagesDechiffres[0]) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Cette fonction prend un message comme paramètre et le décode selon l'algorithme proposé dans le sujet.
     * Le message décodé est ensuite retourné par cette fonction.
     * @param message   Le message à// unCaractere <- ‘e’ décoder.
     * @return          Le message décodé avec l'algorithme fourni dans le sujet.
     */
    public static String decodeurMessage(String message) {
        // TODO: Implémenter ici l'algorithme de décodage des messages et retourner le message déchiffré

        // methode 1 qui ne marche pas
        /**
        String newMessage = "                     ";
        char newCharacter = ' ';
        int newCharacterInteger = 0;

        for(int i = 0; i < message.length(); i++) {
            char character = message.charAt(i);
            int characterInteger = character;

            if (characterInteger % 2 == 0) {
                newCharacterInteger = characterInteger + 5;
                newCharacter = (char) newCharacterInteger;
            }
            else {
                newCharacterInteger = characterInteger - 3;
                newCharacter = (char) newCharacterInteger;
            }
            char msg = (char) newCharacterInteger;
            newMessage = String.valueOf(msg);
            // System.out.printf(newMessage );
        }
        return newMessage;

        **/


        // methode 2 qui ne marche pas non plus
        int newInteger = 0;
        String messageEncode = "";
        for (int i = 0; i < message.length(); i++) {
            char character = message.charAt(i);
            int caracterInteger = character;

            if (caracterInteger % 2 == 0) {
                if (caracterInteger < 99) {
                    newInteger = 122;
                }
                else {
                    newInteger = caracterInteger + 5;
                }
            }
            if (caracterInteger % 2 == 1) {
                if (caracterInteger > 120) {
                    newInteger = 97;
                }
                else {
                    newInteger = caracterInteger - 3;
                }

            }
            char newMessage = (char) newInteger;
            messageEncode = String.valueOf(newMessage);
            System.out.print(messageEncode);
        }
        return messageEncode;
    }

    /**
     * Cette fonction va lancer le jeu du Puissance 4.
     * Attention, lisez bien la Section 2.2.3 de l'énoncé qui décrit la logique du jeu.
     * C'est cette logique que vous devrez implémenter ici.
     */
    public static void puissance4() {
        // TODO: Implémenter ici la logique globale du jeu du Puissance 4
        while(!finDuJeu()) {
            String answer;
            // 1. On affiche le menu du jeu
            System.out.println("Bienvenue dans le jeu Puissance 4");

            // 2. Si les jours veulent débuter une partie...
            do {
                System.out.println("Voulez vous débuter une partie ? o/n");
                answer = scanner.nextLine();
                if (answer == "n" || answer == "non") {
                    break;
                }
            } while (answer != "o");

            // (a) On initialise le plateau de jeu ;
            initialiserPlateau();

            // (b) On affiche le plateau de jeu ;
            afficherPlateau();

            // (c) On demande au joueur de saisir son coup (cette saisie doit être validée) ;
            do {
                saisieJoueur();
            } while (saisieValide(saisieJoueur()));

            // (d) On met à jour le plateau du jeu avec cette nouvelle saisie ;
            updatePlateau(saisieJoueur());

            // (e) On vérifie si le jeu est fini ou non :
            if (finDuJeu()) {
                // i. Si le jeu est fini, c’est la fin de la partie ;
                break;
            }

            // ii. Sinon, on passe la main à l’autre joueur.
            else {
                do {
                    saisieJoueur();
                } while (saisieValide(saisieJoueur()));
            }

            // (f) On recommence à partir de l’étape (b).
            // we're in a while loop


            // 3. On recommence à partir de l’étape 1.
            // we're in a while loop

        }
    }

    /**
     * Cette fonction permet d'initialiser le plateau avec des espaces (' ')
     */
    public static void initialiserPlateau() {
        // TODO: Implémenter cette fonction.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                plateau[i][j] = ' ';
            }
        }
    }

    /**
     * Cette fonction permet d'afficher le contenu du plateau en console.
     * Attention, on voudra aussi afficher un cadre autour du plateau pour en améliorer sa lisibilité.
     */
    public static void afficherPlateau() {
        // TODO: Implémenter cette fonction.
        // Exemple d'affichage avec les indices de ligne et de colonne :
        //   0123456
        //  +-------+
        // 0|       |
        // 1|       |
        // 2|       |
        // 3| XO    |
        // 4|OOOXX  |
        // 5|OXOXOXO
        //  +-------+

        // seems like frontend
        System.out.print(plateau);
    }

    /**
     * Cette fonction demande au joueur en cours de saisir un entier correspondant à l'indice de la colonne
     * dans laquelle il souhaite déposer son jeton.
     * Cette fonction va faire répéter au joueur la saisie de cet indice tant que celle-ci n'est pas valide. On va
     * donc faire appel à la fonction saisieValide() ici.
     * @return  Un entier représentant l'indice de la colonne jouée.
     */
    public static int saisieJoueur() {
        // TODO: Implémenter cette fonction.
        int indice;
        do {
            System.out.println("Entrer l'indice de la colonne souhaitée: ");
            indice = scanner.nextInt();
        } while (saisieValide(indice));

        return indice;
    }

    /**
     * Cette fonction vérifie que la saisie du joueur est valide. Il y a deux vérifications à faire :
     *  1. Vérifier que : 0 <= indiceColonne <= 6 ;
     *  2. Vérifier que la colonne 'indiceColonne' n'est pas remplie.
     * @param indiceColonne L'indice de colonne saisi par le joueur en cours ;
     * @return              Vrai si la saisie est valide, faux sinon.
     */
    public static boolean saisieValide(int indiceColonne) {
        // TODO: Implémenter cette fonction.
        if (indiceColonne >= 0 && indiceColonne <= 6) {
            // estRemplie est décrite juste en dessous
            if (!estRemplie(indiceColonne)) {
                return true;
            }
        }

        return false;
    }

    /**
    Je me permets d'ajouter une nouvelle fonction pour factoriser le code.
     Cette fonction renvoie true si la colonne est remplie, false sinon.
     **/
    public static boolean estRemplie(int indiceColonne) {
        int compteur = 0;
        for (int i = 0; i < 5; i++) {
            if (plateau[i][indiceColonne] == 'X' || plateau[i][indiceColonne] == 'O') {
                compteur++;
            }
        }
        if (compteur == 6) {
            return true;
        }
        return false;
    }

    /**
     * Cette fonction met à jour le contenu du plateau après que le joueur en cours ait saisit son coup.
     * Cette fonction fera appel à la variable estJoueur1 pour déterminer quel symbole ajouter.
     * @param saisie    L'indice de colonne saisi par le joueur en cours.
     */
    public static void updatePlateau(int saisie) {
        // TODO: Implémenter cette fonction.
        if (estJoueur1) {
            if (saisieValide(saisie)) {
                for(int i = 0; i < 5; i++) {
                    // check if case empty
                    if (plateau[i][saisie] == ' ') {
                        plateau[i][saisie] = 'O';
                    }
                }
            }
        }
        else {
            if (saisieValide(saisie)) {
                for(int i = 0; i < 5; i++) {
                    // check if case empty
                    if (plateau[i][saisie] == ' ') {
                        plateau[i][saisie] = 'X';
                    }
                }
            }
        }
    }

    /**
     * Cette fonction détermine si le jeu est fini ou non. Il existe deux facons puor que le jeu se termine :
     *  - Le plateau est rempli ;
     *  - Un joueur a créé un Puissance 4.
     *
     * @return  Vrai si le jeu est terminé, faux sinon.
     */
    public static boolean finDuJeu() {
        // TODO: Implémenter cette fonction.
        if (plateauEstComplet() || alignementGagnant()) {
            return true;
        }
        return false;
    }

    /**
     * Cette fonction détermine si le plateau est rempli ou non.
     *
     * @return  Vrai si le plateau est complet, faux sinon.
     */
    public static boolean plateauEstComplet() {
        // TODO: Implémenter cette fonction.
        int compteur = 0;
        for (int i = 0; i < 6; i ++) {
            for (int j = 0; j < 5; j++) {
                if (plateau[i][j] == 'X' || plateau[i][j] == 'O') {
                    compteur++;
                }
            }
        }

        if (compteur == 42) {
            return true;
        }

        return false;
    }

    /**
     * Cette fonction détermine si un joueur a crée un Puissance 4.
     * Il existe trois façons de créer un Puissance 4 :
     *  - En créant un alignement sur une ligne ;
     *  - En créant un alignement sur une colonne ;
     *  - En créant un alignement sur une diagonale.
     *
     * @return  Vrai si un joueur a créé un Puissance 4, faux sinon.
     */
    public static boolean alignementGagnant() {
        // TODO: Implémenter cette fonction.
        // check horizontal
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (plateau[i][j] == 'X' && plateau[i][j+1] == 'X' && plateau[i][j+2] == 'X' && plateau[i][j+3] == 'X') {
                    return true;
                }
                if (plateau[i][j] == 'O' && plateau[i][j+1] == 'O' && plateau[i][j+2] == 'O' && plateau[i][j+3] == 'O') {
                    return true;
                }
            }
        }

        // check vertical
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (plateau[i][j] == 'X' && plateau[i+1][j] == 'X' && plateau[i+2][j] == 'X' && plateau[i+3][j] == 'X') {
                    return true;
                }
                if (plateau[i][j] == 'O' && plateau[i+1][j] == 'O' && plateau[i+2][j] == 'O' && plateau[i+3][j] == 'O') {
                    return true;
                }
            }
        }

        // check diagonales montantes
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (plateau[i][j] == 'X' && plateau[i+1][j+1] == 'X' && plateau[i+2][j+2] == 'X' && plateau[i+3][j+3] == 'X') {
                    return true;
                }
                if (plateau[i][j] == 'O' && plateau[i+1][j+1] == 'O' && plateau[i+2][j+2] == 'O' && plateau[i+3][j+3] == 'O') {
                    return true;
                }
            }
        }

        // check diagonales descendantes
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (plateau[i][j] == 'X' && plateau[i-1][j-1] == 'X' && plateau[i-2][j-2] == 'X' && plateau[i-3][j-3] == 'X') {
                    return true;
                }
                if (plateau[i][j] == 'O' && plateau[i-1][j-1] == 'O' && plateau[i-2][j-2] == 'O' && plateau[i-3][j-3] == 'O') {
                    return true;
                }
            }
        }

        return false;
    }
}
