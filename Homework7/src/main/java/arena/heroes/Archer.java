package arena.heroes;

public class Archer extends Hero {
    public int arrowsCount;

    @Override
    public void attack() {
        System.out.println("Лучник выпускает стрелу!");
    }

    public Archer (String name, int level, int health, int arrowsCount) {
        super.Hero(name, level, health);
        this.arrowsCount = arrowsCount;
    }
}
