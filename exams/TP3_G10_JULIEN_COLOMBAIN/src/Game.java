import java.util.*;

public class Game {
    Scanner scanner = new Scanner(System.in);

    public void start() {
        int actionPlayerChoice = 0;
        int characterClassPlayerChoice;
        String characterName;

        // 2.5.2. Création d'un personnage
        System.out.println("Indiquez la classe que vous voulez jouer");
        System.out.println("(1) Guerrier");
        System.out.println("(2) Archère");
        System.out.println("(3) Sorcier");
        characterClassPlayerChoice = scanner.nextInt();
        scanner.nextLine();
        if (characterClassPlayerChoice == 1) {
            System.out.println("Vous souhaitez créer un Guerrier ! Quel nom souhaitez-vous lui donner ?");
        }
        else if (characterClassPlayerChoice == 2) {
            System.out.println("Vous souhaitez créer une Archère ! Quel nom souhaitez-vous lui donner ?");
        }
        else if (characterClassPlayerChoice == 3) {
            System.out.println("Vous souhaitez créer un Sorcier ! Quel nom souhaitez-vous lui donner ?");
        }
        characterName = scanner.nextLine();
        System.out.println("Bienvenue dans le jeu " + characterName);

        // 2.5.3. Menu de jeu
        System.out.println("Faites votres choix:");
        System.out.println("(1) Récupérer un objet");
        System.out.println("(2) Mettre un équipement");
        System.out.println("(3) Retirer un équipement");
        System.out.println("(4) Utiliser un objet consommable");
        System.out.println("(5) Jeter un sort");
        System.out.println("(6) Quitter le jeu");
        switch(actionPlayerChoice) {
            case 1:
                getObjectInPlayerInventory();
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
        }
    }

    public void getObjectInPlayerInventory() {
        int playerObjectChoice = 0;
        int playerEquipmentTypeChoice = 0;
        int playerConsumableTypeChoice = 0;
        String weaponName;
        int weaponDamage = 0;
        int playerParchmentChoice = 0;

        System.out.println("Quel type d’objet souhaitez-vous ajouter à votre inventaire ?");
        System.out.println("(1) Équipement");
        System.out.println("(2) Consommable");

        switch(playerObjectChoice) {
            case 1:
                System.out.println("Quel type d’équipement souhaitez-vous ajouter à votre inventaire ?");
                System.out.println("(1) Arme");
                System.out.println("(2) Bouclier");
                System.out.println("(3) Armure");
                playerEquipmentTypeChoice = scanner.nextInt();
                switch(playerEquipmentTypeChoice) {
                    case 1:
                        System.out.println("Nom de l'arme ?");
                        weaponName = scanner.nextLine();
                        System.out.println("Dégâts de l’arme ?");
                        weaponDamage = scanner.nextInt();
                        System.out.println("Arme ajoutée à l’inventaire !");
                    case 2:
                        // TODO
                    case 3:
                        // TODO
                }
            case 2:
                System.out.println("Quel type de consommable souhaitez-vous ajouter à votre inventaire ?");
                System.out.println("(1) Potion de vie");
                System.out.println("(2) Potion de mana");
                System.out.println("(3) Parchemin de sort");
                playerConsumableTypeChoice = scanner.nextInt();
                switch(playerConsumableTypeChoice) {
                    case 1:
                        // TODO
                    case 2:
                        // TODO
                    case 3:
                        System.out.println("Quel parchemin de sort souhaitez-vous ajouter à votre inventaire ?");
                        System.out.println("(1) Boule de feu");
                        System.out.println("(2) Éclair en série");
                        System.out.println("(3) Blizzard");
                        playerParchmentChoice = scanner.nextInt();
                        switch(playerParchmentChoice) {
                            case 1:
                                // TODO
                            case 2:
                                System.out.println("Un parchemin de sort pour Éclair en série a été ajouté à votre inventaire !");
                            case 3:
                                // TODO
                        }

                }
        }
    }
}
