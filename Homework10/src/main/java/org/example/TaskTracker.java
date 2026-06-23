package org.example;

import java.util.ArrayList;

public class TaskTracker {
    private ArrayList<Task> taskList;
    private String taskTrackerName;

    public TaskTracker(String taskTrackerName) {
        this.taskTrackerName = taskTrackerName;
        this.taskList = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        this.taskList.add(task);
        System.out.printf("Задача \"%s\" добавлена в список. %n", task.getTaskName());
    }

    public void printTaskList() {
        System.out.println("\nСписок задач: " + taskTrackerName);
        for (Task item : taskList) {
            item.printInfo();
        }
    }

    public void makeTaskDone(String taskName) {
        boolean isExist = false;
        for (Task item : taskList) {
            if (item.getTaskName().equals(taskName)) {
                System.out.printf("Задача \"%s\". Выполнение.... %n", item.getTaskName());
                item.makeDone();
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.printf("Задача с названием \"%s\" не найдена! %n", taskName);
        }
    }

    public void printTaskStatus(String taskName) {
        boolean isExist = false;
        for (Task item : taskList) {
            if (item.getTaskName().equals(taskName)) {
                System.out.printf("Задача \"%s\". Получение статуса.... %n", item.getTaskName());
                System.out.println(item.isDone() ? "-- Задача выполнена" : "-- Задача не выполнена");
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.printf("Задача с названием \"%s\" не найдена! %n", taskName);
        }
    }

    public void printStatistic() {
        int done = 0;
        System.out.println("\nВсего задач: " + taskList.size());
        for (Task item : taskList) {
          if (item.isDone()) {
              done++;
          }
        }
        System.out.println("Выполнено: " + done);
        System.out.println("Открыто: " + (taskList.size() - done));
    }
}
