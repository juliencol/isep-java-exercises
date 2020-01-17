import Object.Equipment.Equipment;

import java.util.*;

public class Character {
    String name;
    HashMap<String, Integer> characteristics = new HashMap<>();
    ArrayList<Integer> healthPoints;
    ArrayList<Integer> manaPoints;
    ArrayList<Equipment> inventory;
    ArrayList<Spell> spells;

    public String getName() {
        return this.name;
    }

    public HashMap<String, Integer> getCharacteristics() {
        return this.characteristics;
    }
    public void setCharacteristics(HashMap<String, Integer> characteristics) {
        this.characteristics = characteristics;
    }

    public ArrayList<Integer> getHealthPoints() {
        return this.healthPoints;
    }
    public void setHealthPoints(ArrayList<Integer> healthPoints) { this.healthPoints = healthPoints; }

    public ArrayList<Integer> getManaPoints () {
        return this.manaPoints;
    }
    public void setManaPoints(ArrayList<Integer> manaPoints) {
        this.manaPoints = manaPoints;
    }

    public ArrayList<Equipment> getInventory() { return this.inventory; }
    public void setInventory(ArrayList<Equipment> inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Spell> getSpells() { return this.spells; }
    public void setSpells(ArrayList<Spell> inventory) {
        this.spells = spells;
    }

public Character(String name, HashMap<String, Integer> characteristics, ArrayList<Integer> healthPoints, ArrayList<Integer> manaPoints, ArrayList<Equipment> inventory, ArrayList<Spell> spells) {
        name = name;
        characteristics = characteristics;
        healthPoints = healthPoints;
        manaPoints = manaPoints;
        inventory = inventory;
        spells = spells;
    }
}
