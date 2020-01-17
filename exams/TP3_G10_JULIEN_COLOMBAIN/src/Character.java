import java.util.*;

public class Character {
    String name;
    HashMap<String, Integer> characteristics = new HashMap<>();
    ArrayList<String> healthPoints;
    ArrayList<String> manaPoints;

    public String getName() {
        return this.name;
    }

    public HashMap<String, Integer> getCharacteristics() {
        return this.characteristics;
    }
    public void setCharacteristics(HashMap<String, Integer> characteristics) {
        this.characteristics = characteristics;
    }

    public ArrayList<String> getHealthPoints() {
        return this.healthPoints;
    }
    public void setHealthPoints(ArrayList<String> healthPoints) { this.healthPoints = healthPoints; }

    public ArrayList<String> getManaPoints () {
        return this.manaPoints;
    }
    public void setManaPoints(ArrayList<String> manaPoints) {
        this.manaPoints = manaPoints;
    }

    public Character(String name, HashMap<String, Integer> characteristics, ArrayList<String> healthPoints, ArrayList<String> manaPoints) {
        name = name;
        characteristics = characteristics;
        healthPoints = healthPoints;
        manaPoints = manaPoints;
    }
}
