package org.example;

public class CoffeeMachine {
    private static final int mlEnough = 200;

    public void makeCoffee(int ml) {
        if (ml > mlEnough) {
            System.out.println("Кофе приготовлен!");
        }
        else throw new NotEnoughWaterException("Недостаточное количество воды. Количество воды должны быть больше " + mlEnough);
    }

    public int calculateCups(int mlWater, int mlCupVolume) {
        return mlWater / mlCupVolume;
    }

    public void printCoffeeName(String coffeeName) {
        System.out.println("Кофе: " + coffeeName.toUpperCase());
    }
}
