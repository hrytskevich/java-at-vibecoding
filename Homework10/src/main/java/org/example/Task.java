package org.example;

public class Task {
    private String taskName;
    private boolean isDone;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public void makeDone() {
        if (this.isDone) {
            System.out.println("Задача уже была выполнена!");
        } else {
            this.isDone = true;
            System.out.println("Успешно! Задача выполнена.");
        }
    }

    public void printInfo() {
        System.out.println((isDone ? "[✓] " : "[] ") + this.taskName);
    }
}
