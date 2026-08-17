package org.hw_14;

public class Movie {
    private String name;
    private double rating;

    public Movie(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "ФИЛЬМ: " +
                "название: '" + name + '\'' +
                ", рейтинг: " + rating;
    }
}
