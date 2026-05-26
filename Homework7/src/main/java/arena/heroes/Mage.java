package arena.heroes;

public class Mage extends Hero {
    public int mana;

    @Override
    public void attack() {
        System.out.println("Маг запускает огненный шар!");
    }

    public Mage (String name, int level, int health, int mana) {
        super.Hero(name, level, health);
        this.mana = mana;
    }
}
