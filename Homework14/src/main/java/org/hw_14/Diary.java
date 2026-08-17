package org.hw_14;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    String name;
    private ArrayList<String> notes;

    protected Diary (String name, ArrayList<String> notes) {
        this.name = name;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    protected ArrayList<String> getNotes() {
        return notes;
    }

    public Diary (String name) {
        this.name = name;
        this.notes = new ArrayList<>();
    }

    public void addNote (String note) {
        notes.add(note);
    }

    @Override
    public String toString() {
        return "Diary{" +
                "name='" + name + '\'' +
                ", notes=" + notes +
                '}';
    }
}
