package org.hw_14;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Интерстеллар", 8.7));
        movies.add(new Movie("Шрек", 8.1));
        movies.add(new Movie("Начало", 8.8));
        movies.add(new Movie("Веном", 6.6));
        System.out.println("Список фильмов до сортировки:");
        movies.forEach(System.out::println);
        movies.sort(new MovieRatingComparator());
        System.out.println("Список фильмов после сортировки:");
        movies.forEach(System.out::println);

//        Diary diary = new Diary("Катя", new ArrayList<>(List.of("Сегодня первый день в школе!", "Мне поставили пятёрку.")));
//        diary.addNote("С уроков отпустили пораньше.");
//        System.out.println(diary.toString());
        ClassScanner.printClassInfo(new Diary("Катя"));

    }
}