package Object.Equipment;

public class Armor extends Equipment {
    String name;
    int armor;

    public String getName() { return this.name; }
    public int getArmor() { return this.armor; }

    public Armor(String name, int armor) {
        super();
        name = name;
        armor = armor;
    }
}
