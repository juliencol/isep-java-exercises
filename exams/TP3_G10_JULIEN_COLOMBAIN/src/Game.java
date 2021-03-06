import Object.Consumable.Consumable;
import Object.Consumable.Parchment;
import Object.Equipment.Armor;
import Object.Equipment.Equipment;
import Object.Equipment.Shield;
import Object.Equipment.Weapon;

import java.util.*;

public class Game {
    // Declaring useful variables
    Scanner scanner = new Scanner(System.in);
    private Object Parchment;
    private Class<? extends Consumable> Potion;
    HashMap<String, Integer> characteristics = new HashMap<>();
    ArrayList<Integer> healthPoints = new ArrayList<Integer>();
    ArrayList<Integer> manaPoints = new ArrayList<Integer>();
    ArrayList<Equipment> equipmentInventory = new  ArrayList<Equipment>();
    ArrayList<Consumable> consumableInventory = new  ArrayList<Consumable>();
    ArrayList<Equipment> equipments = new ArrayList<Equipment>();
    ArrayList<Spell> spells = new ArrayList<Spell>();

    // Creating spells
    Spell fireBall = new Spell("boule de feu", 35, 25);
    Spell lightStrike = new Spell("éclair en série", 8, 5);
    Spell blizzard = new Spell("blizzard", 12, 15);

    // Creating parchments
    Parchment fireBallParchment = new Parchment("parchemin boule de feu");
    Parchment lightStrikeParchment = new Parchment("parchemin éclair en série");
    Parchment blizzardParchment = new Parchment("parchemin blizzard");


    // Creating weapons
    Weapon swordIrebleue = new Weapon("Irebleue", 6);
    Shield shieldTempete = new Shield("bouclier Tempête", 0.5);
    Armor armorBravoureArkaine = new Armor("Bravoure d'Arkaire", 50);


    public void start() {
        int actionPlayerChoice = 0;
        int characterClassPlayerChoice;
        String characterName;

        // 2.5.2. Création d'un personnage
        System.out.println("Indiquez la classe que vous voulez jouer");
        System.out.println("(1) Guerrier");
        System.out.println("(2) Archère");
        System.out.println("(3) Sorcier");
        characterClassPlayerChoice = Integer.parseInt(scanner.nextLine());
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

        Character currentPlayerCharacter = new Character(characterName, characteristics, healthPoints, manaPoints, equipmentInventory, consumableInventory, equipments, spells);
        System.out.println("Bienvenue dans le jeu " + characterName);

        // 2.5.3. Menu de jeu
        System.out.println("Faites votres choix:");
        System.out.println("(1) Récupérer un objet");
        System.out.println("(2) Mettre un équipement");
        System.out.println("(3) Retirer un équipement");
        System.out.println("(4) Utiliser un objet consommable");
        System.out.println("(5) Jeter un sort");
        System.out.println("(6) Quitter le jeu");
        actionPlayerChoice = Integer.parseInt(scanner.nextLine());
        do {
            switch(actionPlayerChoice) {
                case 1:
                    getObjectInPlayerInventory();
                    break;
                case 2:
                    putOnEquipment();
                    break;
                case 3:
                    removeEquipment();
                    break;
                case 4:
                    consumeConsumable();
                    break;
                case 5:
                    throwSpell();
                    break;
                case 6:
                    System.out.println("A bientôt pour une nouvelle session de jeu. ");
                    break;
            }
        } while(actionPlayerChoice != 6);
    }

    // 2.5.4. Récupération d'objets
    public void getObjectInPlayerInventory() {
        int playerObjectChoice = 0;
        int playerEquipmentTypeChoice = 0;
        int playerConsumableTypeChoice = 0;
        int weaponDamage = 0;
        int armor = 0;
        int playerParchmentChoice = 0;
        double shieldBlockChance = 0;
        String weaponName;
        String shieldName;
        String armorName;

        System.out.println("Quel type d’objet souhaitez-vous ajouter à votre inventaire ?");
        System.out.println("(1) Équipement");
        System.out.println("(2) Consommable");
        playerObjectChoice = Integer.parseInt(scanner.nextLine());
        switch(playerObjectChoice) {
            case 1:
                System.out.println("Quel type d’équipement souhaitez-vous ajouter à votre inventaire ?");
                System.out.println("(1) Arme");
                System.out.println("(2) Bouclier");
                System.out.println("(3) Armure");
                playerEquipmentTypeChoice = Integer.parseInt(scanner.nextLine());
                switch(playerEquipmentTypeChoice) {
                    case 1:
                        System.out.println("Nom de l'arme ?");
                        weaponName = scanner.nextLine();
                        System.out.println("Dégâts de l’arme ?");
                        weaponDamage = Integer.parseInt(scanner.nextLine());
                        Weapon playerWeapon = new Weapon(weaponName, weaponDamage);
                        equipmentInventory.add(playerWeapon);
                        System.out.println("Arme ajoutée à l’inventaire !");
                        break;
                    case 2:
                        System.out.println("Nom du bouclier ?");
                        shieldName = scanner.nextLine();
                        System.out.println("Chance de bloquer ?");
                        shieldBlockChance = scanner.nextDouble();
                        Shield playerShield = new Shield(shieldName, shieldBlockChance);
                        equipmentInventory.add(playerShield);
                        System.out.println("Arme ajoutée à l’inventaire !");
                        break;
                    case 3:
                        System.out.println("Nom de l'armure ?");
                        armorName = scanner.nextLine();
                        System.out.println("Armure ?");
                        armor = Integer.parseInt(scanner.nextLine());
                        Armor playerArmor = new Armor(armorName, armor);
                        equipmentInventory.add(playerArmor);
                        System.out.println("Armure ajoutée à l’inventaire !");
                        break;
                }
            case 2:
                System.out.println("Quel type de consommable souhaitez-vous ajouter à votre inventaire ?");
                System.out.println("(1) Potion de vie");
                System.out.println("(2) Potion de mana");
                System.out.println("(3) Parchemin de sort");
                playerConsumableTypeChoice = Integer.parseInt(scanner.nextLine());
                switch(playerConsumableTypeChoice) {
                    case 1:
                        Consumable healthPotion = new Consumable("potion de vie");
                        consumableInventory.add(healthPotion);
                        System.out.println("Une potion de vie a été ajoutée à l'inventaire !");
                        break;
                    case 2:
                        Consumable manaPotion = new Consumable("potion de mana");
                        consumableInventory.add(manaPotion);
                        System.out.println("Une potion de mana a été ajoutée à l'inventaire !");
                        break;
                    case 3:
                        System.out.println("Quel parchemin de sort souhaitez-vous ajouter à votre inventaire ?");
                        System.out.println("(1) Boule de feu");
                        System.out.println("(2) Éclair en série");
                        System.out.println("(3) Blizzard");
                        playerParchmentChoice = Integer.parseInt(scanner.nextLine());
                        switch(playerParchmentChoice) {
                            case 1:
                                Consumable fireBallParchment = new Consumable("boule de feu");
                                consumableInventory.add(fireBallParchment);
                                System.out.println("Un parchemin de sort pour boule de feu a été ajouté à votre inventaire !");
                                break;
                            case 2:
                                Consumable lightStrikeParchment = new Consumable("éclair en série");
                                consumableInventory.add(lightStrikeParchment);
                                System.out.println("Un parchemin de sort pour Éclair en série a été ajouté à votre inventaire !");
                                break;
                            case 3:
                                Consumable blizzardParchment = new Consumable("blizzard");
                                consumableInventory.add(blizzardParchment);
                                System.out.println("Un parchemin de sort pour blizzard a été ajouté à votre inventaire !");
                                break;
                        }
                        break;
                }
        }
    }

    // 2.5.5. Mettre un équipement
    public void putOnEquipment() {
        int playerPutOnEquipmentChoice = 0;
        if(equipmentInventory.size() == 0) {
            System.out.println("Oups, l'inventaire est vide.");
        }
        else {
            System.out.println("Quel équipement souhaitez-vous porter ?");
            for(Equipment equipment : equipmentInventory) {
                for(int i = 0; i < equipmentInventory.size(); i++) {
                    System.out.print('('+ i + ") " + equipment.getName());
                }
                for(int i = 0; i < equipmentInventory.size(); i++) {
                    playerPutOnEquipmentChoice = Integer.parseInt(scanner.nextLine());
                    if(playerPutOnEquipmentChoice == i) {
                        equipments.add(equipment);
                        System.out.println("Vous avez équipé " + equipment.getName() + " !");
                        break;
                    }
                }
            }
        }
    }

    // 2.5.5. Retirer un équipement
    public void removeEquipment() {
        int playerRemoveEquipmentChoice = 0;
        if(equipments.size() == 0) {
            System.out.println("Oups, vous ne poretez déjà aucun équipement.");
        }
        else {
            System.out.println("Quel équipement souhaitez-vous retirer ?");
            for(Equipment equipment : equipments) {
                for(int i = 0; i < equipments.size(); i++) {
                    System.out.print('('+ i + ") " + equipment.getName());
                }
                for(int i = 0; i < equipments.size(); i++) {
                    playerRemoveEquipmentChoice = Integer.parseInt(scanner.nextLine());
                    if(playerRemoveEquipmentChoice == i) {
                        equipments.remove(equipment);
                        System.out.println("Vous avez enlevé " + equipment.getName() + " !");
                        break;
                    }
                }
            }
        }
    }

    // 2.5.6. Utiliser un objet consommable
    public void consumeConsumable() {
        int playerConsumeConsumableChoice = 0;
        if(consumableInventory.size() == 0) {
            System.out.println("Oups, l'inventaire est vide.");
        }
        else {
            System.out.println("Quel objet consommable souhaitez-vous utiliser ?");
            for(Consumable consumable : consumableInventory) {
                for(int i = 0; i < consumableInventory.size(); i++) {
                    System.out.print('('+ i + ") " + consumable.getName());
                }
                for(int i = 0; i < consumableInventory.size(); i++) {
                    playerConsumeConsumableChoice = Integer.parseInt(scanner.nextLine());
                    if(playerConsumeConsumableChoice == i) {
                        if (consumable.getClass() == Parchment) {
                            if(consumable.getName() == "parchemin boule de feu" ) {
                                spells.add(fireBall);
                            }
                            else if(consumable.getName() == "parchemin éclair en série") {
                                spells.add(lightStrike);
                            }
                            else if(consumable.getName() == "parchemin blizzard") {
                                spells.add(blizzard);
                            }
                            System.out.println("Vous avez appris le sort " + consumable.getName() + " !");
                        }
                        else if (consumable.getClass() == Potion) {
                            System.out.println("Vous avez consommé " + consumable.getName() + " !");
                            if (consumable.getName() == "potion de vie" ) {
                                int currentHealthPoints = healthPoints.get(0);
                                int maxHealthPoints = healthPoints.get(1);
                                if (currentHealthPoints < maxHealthPoints - 30) {
                                    currentHealthPoints += 30;
                                }
                                else {
                                    currentHealthPoints = maxHealthPoints;
                                }
                            }
                            else if(consumable.getName() == "potion de mana" ){
                                int currentManaPoints = manaPoints.get(0);
                                int maxManaPoints = healthPoints.get(1);
                                if (currentManaPoints < maxManaPoints - 30) {
                                    currentManaPoints += 30;
                                }
                                else {
                                    currentManaPoints = maxManaPoints;
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
    }

    // 2.5.7. Jeter un sort
    public void throwSpell() {
        int playerThrowSpellChoice = 0;
        if(spells.size() == 0) {
            System.out.println("Vous ne connaissez aucun sort, vous ne pouvez rien lancer.");
        }
        else {
            System.out.println("Quel sort souhaitez-vous jeter ?");
            for(Consumable spell : consumableInventory) {
                for(int i = 0; i < spells.size(); i++) {
                    System.out.print('('+ i + ") " + spell.getName());
                }
                for(int i = 0; i < spells.size(); i++) {
                    playerThrowSpellChoice = Integer.parseInt(scanner.nextLine());
                    if(playerThrowSpellChoice == i) {
                        System.out.println("Vous avez lancé le sort " + spell.getName() + " !");
                        break;
                    }
                }
            }
        }
    }
}
