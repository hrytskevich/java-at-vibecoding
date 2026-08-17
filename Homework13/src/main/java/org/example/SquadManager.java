package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SquadManager {

    public void demonstrateListCreations() {
        ArrayList<String> mainSquad = new ArrayList<>();
        mainSquad.add("Джон");
        mainSquad.add("Питер");
        mainSquad.add("Сэм");
        mainSquad.add("Лука");

        List<String> supportSquad = Arrays.asList("Боб", "Дод", "Лол");

        List<String> eliteSquad = List.of("Изабелла", "Джоанна");

        try {
            mainSquad.add("Рон");
            System.out.println("Успешно добавлен участник основного отряда Рон");
            System.out.println("Список участников: " + mainSquad);
        }
        catch (RuntimeException e) {
            System.out.println("Возникло исключение " + e.getClass());
        }

        try {
            mainSquad.remove("Лука");
            System.out.println("Успешно удалён участник основного отряда Лука");
            System.out.println("Список участников: " + mainSquad);
        }
        catch (RuntimeException e) {
            System.out.println("Возникло исключение " + e.getClass());
        }

        try {
            supportSquad.add("Кок");
            System.out.println("Успешно добавлен участник отряда поддержки Кок");
            System.out.println("Список участников: " + supportSquad);
        }
        catch (RuntimeException e) {
            System.out.println("Возникло исключение " + e.getClass());
        }

        try {
            supportSquad.remove("Лол");
            System.out.println("Успешно удалён участник отряда поддержки Лол");
            System.out.println("Список участников: " + supportSquad);
        }
        catch (RuntimeException e) {
            System.out.println("Возникло исключение " + e.getClass());
        }

        try {
            eliteSquad.add("Барабара");
            System.out.println("Успешно добавлен участник элитного отряда Барабара");
            System.out.println("Список участников: " + eliteSquad);
        }
        catch (RuntimeException e) {
            System.out.println("Возникло исключение " + e.getClass());
        }

        try {
            eliteSquad.remove("Джоанна");
            System.out.println("Успешно удалён участник элитного отряда Джоанна");
            System.out.println("Список участников: " + eliteSquad);
        }
        catch (RuntimeException e) {
            System.out.println("Возникло исключение " + e.getClass());
        }
    }

    public void filterOutCowards(List<String> squad) {
        System.out.println("*** Фильтрация отряда: удаление трусов ***");
        System.out.println("Отряд до фильтрации: " + squad);
        Iterator<String> iterator = squad.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().toLowerCase().startsWith("трус")) {
                iterator.remove();
            }
        }
        System.out.println(("Отряд после фильтрации: " + squad));
    }

    public void filterOutInjured(List<String> squad) {
        System.out.println("*** Фильтрация отряда: удаление раненых ***");
        System.out.println("Отряд до фильтрации: " + squad);
        squad.removeIf(item -> item.toLowerCase().startsWith("раненый"));
        System.out.println(("Отряд после фильтрации: " + squad));
    }
}
