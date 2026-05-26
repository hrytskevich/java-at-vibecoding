package arena.heroes;

public class Knight extends Hero {
    public String armor;

    @Override
    public void attack() {
        System.out.println("Рыцарь бьёт мечом!");
    }

    public Knight (String name, int level, int health, String armor) {
        super.Hero(name, level, health);
        this.armor = armor;
    }

    /*public void rest() {
        System.out.println("Рыцарь отдыхает и восстанавливает силы.");
    }*/

    @Override
    public String toString() {
        return "Knight{name='" + this.name + "',level=" + this.level + ",health=" + this.health + ",armor='" + this.armor + "'}";
    }
}
