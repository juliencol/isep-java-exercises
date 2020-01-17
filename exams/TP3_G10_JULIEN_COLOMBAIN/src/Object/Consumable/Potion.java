package Object.Consumable;

public class Potion extends Consumable {
    String type;

    public String getType() { return this.type; }

    public Potion(String name) {
        super(name);
    }
}
