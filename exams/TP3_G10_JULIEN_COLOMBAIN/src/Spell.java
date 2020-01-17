public class Spell {
    String name;
    int damageDealed;
    int manaPointsNeeded;

    public String getName() {
        return this.name;
    }

    public int getDamageDealed() {
        return this.damageDealed;
    }

    public int getManaPointsNeeded() {
        return this.manaPointsNeeded;
    }

    public Spell(String name, int damageDealed, int manaPointsNeeded) {
        name = name;
        damageDealed = damageDealed;
        manaPointsNeeded = manaPointsNeeded;
    }
}
