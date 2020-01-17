package Object.Equipment;

public class Weapon extends Equipment {
    String name;
    int damage;

    public String getName() {
        return this.name;
    }

    public int getDamage() {return this.damage; }

    public Weapon(String name, int damage) {
        super(name);
        damage = damage;
    }
}
