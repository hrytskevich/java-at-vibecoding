package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);
        String coffeeName = null;
        int mlWater = 0;

        System.out.println("Введите количество воды:");
        try {
            mlWater = scanner.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Ошибка: нужно было ввести число");
        }
        finally {
            scanner.close();
        }

        try {
            coffeeMachine.makeCoffee(mlWater);
        }
        catch (NotEnoughWaterException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Проверка кофемашины завершена");
        }

        try {
            System.out.println("Рассчитанное количество целых чашек кофе: " + coffeeMachine.calculateCups(mlWater, 0));
            }
        catch (ArithmeticException e) {
            System.out.println("Ошибка: размер чашки не может быть 0");
        }

        try {
            coffeeMachine.printCoffeeName(coffeeName);
        }
        catch (NullPointerException e) {
            System.out.println("Ошибка: название кофе отсутствует");
        }

    }
}
