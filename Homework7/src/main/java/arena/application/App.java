package arena.application;

import arena.heroes.Archer;
import arena.heroes.Hero;
import arena.heroes.Knight;
import arena.heroes.Mage;

public class App {
    public static void main(String[] args) {
        Hero[] heroes = {
                new Knight("Олдвин", 8, 100, "Шлем"),
                new Archer("Лайонел", 36, 85, 10),
                new Mage("Грегор", 81, 99, 50)
        };

        for (int i = 0; i < heroes.length; i++) {
            heroes[i].printInfo();
            heroes[i].attack();
        }

        final Knight knight = new Knight("Олрик", 20, 87, "Доспехи");

        System.out.println(knight.toString());

        knight.takeDamage(10);

        System.out.println(knight.toString());
    }
}