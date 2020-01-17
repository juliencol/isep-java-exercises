package Object.Equipment;

public class Shield extends Equipment {
    String name;
    double blockChance;

    public String getName() {
        return this.name;
    }

    public double getBlockChance() { return this.blockChance; }

    public Shield(String name, double blockChance) {
        super(name);
        blockChance = blockChance;
    }
}
