package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Alien> aliens = new ArrayList<Alien>();
        aliens.add(new Alien("Лулу", "Марс", 3));
        aliens.add(new Alien("Лулу", "Марс", 5));
        aliens.add(new Alien("Нана", "Морс", 1));
        aliens.add(new Alien("Фефе", "Мерс", 10));
        aliens.add(new Alien("Тото", "Мурс", 7));
        boolean hasDuplicates = aliens.size() != new HashSet<>(aliens).size();
        System.out.println(aliens.toString());
        System.out.println("Наличие дубликатов (имя+планета) в списке: " + hasDuplicates);

        SquadManager squadManager = new SquadManager();

        squadManager.demonstrateListCreations();

        ArrayList<String> newSquad = new ArrayList<>(List.of("Вася", "Трус Ваня", "Лёша", "Трус Дима", "Сёма"));
        squadManager.filterOutCowards(newSquad);

        ArrayList<String> oldSquad = new ArrayList<>(List.of("Даня", "Раненый Макар", "Захар", "Витя", "Раненый Лёня"));
        squadManager.filterOutInjured(oldSquad);

        AssaultQueue assaultQueue = new AssaultQueue();
        assaultQueue.addRecruit("Давид");
        assaultQueue.addRecruit("Демид");
        assaultQueue.addRecruit("Марк");
        assaultQueue.addRecruit("Лев");
        assaultQueue.addRecruit("Ярослав");
        System.out.println("Выходит из очереди: " + assaultQueue.retreatCoward());
        System.out.println("Выходит из очереди: " + assaultQueue.retreatCoward());
        assaultQueue.addRecruit("Тимофей");
        assaultQueue.addRecruit("Петр");
        assaultQueue.addRecruit("Фёдор");
        assaultQueue.printQueue();

        MissionReport missionReport = new MissionReport("Штурм зоны 51", aliens, 50);
        System.out.println(missionReport.toString());
        MissionReport sameMissionReport = new MissionReport("Штурм зоны 51", aliens, 50);
        System.out.println(sameMissionReport.toString());
        System.out.println("Сравнение через == : " + (missionReport == sameMissionReport));
        System.out.println("Сравнение через equals() : " + (missionReport.equals(sameMissionReport)));
    }
}