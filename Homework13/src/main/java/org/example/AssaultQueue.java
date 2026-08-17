package org.example;

import java.util.LinkedList;

public class AssaultQueue {
    private LinkedList<String> queue;

    public AssaultQueue() {
        this.queue = new LinkedList<>();
    }

    public void addRecruit(String name) {
        queue.addLast(name);
    }

    public String retreatCoward() {
        String item = queue.getFirst();
        queue.removeFirst();
        return item;
    }

    public void printQueue() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Очередь штурмовиков: " + queue;
    }
}
