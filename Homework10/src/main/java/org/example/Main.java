package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TaskTracker workDay = new TaskTracker("Задачи по работе на день");
        workDay.addTask(new Task("Пройти курс по пожарной безопасности"));
        workDay.addTask(new Task("Выполнить задание по школе Java + AT"));
        workDay.addTask(new Task("Исправить АТ на шаги с созданием сделки"));
        workDay.addTask(new Task("Написать тест-кейсы"));
        workDay.addTask(new Task("Созвон по scrum"));
        workDay.makeTaskDone("Пройти курс по пожарной безопасности");
        workDay.makeTaskDone("Созвон по scrum");
        workDay.makeTaskDone("Попить чай");
        workDay.printTaskStatus("Созвон по scrum");
        workDay.printTaskStatus("Выполнить задание по школе Java + AT");
        workDay.printTaskStatus("Попить чай");
        workDay.printTaskList();
        workDay.printStatistic();
    }
}