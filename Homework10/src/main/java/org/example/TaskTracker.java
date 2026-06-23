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
        System.out.println("Задача добавлена в список.");
    }

    public void printTaskList() {
        System.out.println("Список задач: " + taskTrackerName);
        for (Task item : taskList) {
            item.printInfo();
        }
    }

    public void makeTaskDone(String taskName) {
        for (Task item : taskList) {
            if (item.getTaskName().equals(taskName)) {
                item.makeDone();
                break;
            }
            else System.out.println("Задача с таким названием не найдена!");
        }
    }

    public void printTaskStatus(String taskName) {
        for (Task item : taskList) {
            if (item.getTaskName().equals(taskName)) {
                System.out.println(item.isDone() ? "Задача выполнена" : "Задача не выполнена");
                break;
            }
            else System.out.println("Задача с таким названием не найдена!");
        }
    }

    public void printStatistic() {
        int done = 0;
        System.out.println("Всего задач: " + taskList.size());
        for (Task item : taskList) {
          if (item.isDone()) {
              done++;
          }
        }
        System.out.println("Выполнено: " + done);
        System.out.println("Открыто: " + (taskList.size() - done));
    }
}
