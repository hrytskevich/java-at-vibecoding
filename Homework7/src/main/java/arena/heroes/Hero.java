package arena.heroes;

public class Hero {
    public final static int MAX_LEVEL = 100;
    public final static int MAX_HEALTH = 100;
    public static int heroesCreated;
    public String name;
    public int level;
    public int health;

    public void Hero (String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;
    }

    public void printInfo() {
        System.out.println();
        System.out.println("***---ИНФОРМАЦИЯ О ГЕРОЕ---***");
        System.out.println("Имя: " + this.name);
        System.out.println("Уровень: " + this.level + "/" + MAX_LEVEL);
        System.out.println("Здоровье: " + this.health + "/" + MAX_HEALTH);
        System.out.println();
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void levelUp() {
        if (this.level < MAX_LEVEL) {
            this.level += 1;
        }
        else System.out.println("Достигнут максимальный уровень героя " + this.level + "/" + MAX_LEVEL);
    }

    public void attack() {
        System.out.println("Герой наносит обычный удар");
    }

    public void attack(String target) {
        System.out.println("Герой наносит обычный удар. Цель: " + target);
    }

    public void attack(String target, int times) {
        System.out.printf("Герой атакует цель %s %d раз(а).", target, times);
    }

    public static void printHeroesCreated() {
        System.out.println("Всего создано героев: " + heroesCreated);
    }

    public final void rest() {
        System.out.println("Герой отдыхает и восстанавливает силы.");
    }
}
