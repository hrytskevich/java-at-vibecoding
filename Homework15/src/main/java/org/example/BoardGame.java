package org.example;

import java.util.Objects;

public class BoardGame {
    private String name;
    private int minAge;
    private int pricePerDay;
    private boolean isRented;

    public BoardGame(String name, int minAge, int pricePerDay) {
        if (name == null || name.equals("") || minAge < 0 || pricePerDay <= 0)
            throw new IllegalArgumentException("Неверные входные параметры");
        else {
            this.name = name;
            this.minAge = minAge;
            this.pricePerDay = pricePerDay;
            this.isRented = false;
        }
    }

    public String getName() {
        return name;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public boolean isRented() {
        return isRented;
    }

    public boolean canBeRentedBy(int age) {
        return (age >= minAge);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardGame boardGame = (BoardGame) o;
        return Objects.equals(name, boardGame.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
