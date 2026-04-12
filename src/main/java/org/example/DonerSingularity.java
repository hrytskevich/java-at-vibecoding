package org.example;

public class DonerSingularity {
    public static void main(String[] args) {
        String employeeName = "Святослав";
        String employeePosition = "Инспектор по качеству шаурмы";
        int shiftPay = 3000;
        int shiftCount = 10;
        int bonus = 4000;
        int burntFine = 450;
        int donerCost = 500;
        int soldQuantity = 732;

        System.out.println("Сотрудник: " + employeeName +
                "\nДолжность: " + employeePosition +
                "\nОплата за смены: " + (shiftPay * shiftCount) +
                "\nШтраф: " + burntFine +
                "\nПремия: " + bonus +
                "\nИтоговая зарплата: " + (shiftPay * shiftCount + bonus - burntFine) +
                "\nВыручка: " + (donerCost * soldQuantity));
    }
}