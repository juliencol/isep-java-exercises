import Object.Consumable.Consumable;
import Object.Consumable.Parchment;
import Object.Equipment.Equipment;

import java.util.*;

public class Character {
    String name;
    HashMap<String, Integer> characteristics = new HashMap<>();
    ArrayList<Integer> healthPoints;
    ArrayList<Integer> manaPoints;
    ArrayList<Equipment> equipmentInventory;
    ArrayList<Consumable> consumableInventory;
    ArrayList<Equipment> equipments;
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

    public ArrayList<Equipment> getEquipmentInventoryInventory() { return this.equipmentInventory; }
    public void setEquipmentInventory(ArrayList<Equipment> equipmentInventory) {
        this.equipmentInventory = equipmentInventory;
    }

    public ArrayList<Consumable> getConsumableInventory() { return this.consumableInventory; }
    public void setConsumableInventory(ArrayList<Consumable> consumableInventory) {
        this.consumableInventory = consumableInventory;
    }

    public ArrayList<Equipment> getEquipments() { return this.equipments; }
    public void setEquipments(ArrayList<Equipment> equipments) {
        this.equipments = equipments;
    }

    public ArrayList<Spell> getSpells() { return this.spells; }
    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }

    public Character(String name, HashMap<String, Integer> characteristics, ArrayList<Integer> healthPoints, ArrayList<Integer> manaPoints, ArrayList<Equipment> equipmentInventory, ArrayList<Consumable> consumableInventory, ArrayList<Equipment> equipments, ArrayList<Spell> spells) {
        name = name;
        characteristics = characteristics;
        healthPoints = healthPoints;
        manaPoints = manaPoints;
        equipmentInventory = equipmentInventory;
        consumableInventory = consumableInventory;
        equipments = equipments;
        spells = spells;
    }
}
