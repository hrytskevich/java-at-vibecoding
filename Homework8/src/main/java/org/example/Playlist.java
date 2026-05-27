package org.example;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Playlist {
    public String playlistName;
    public ArrayList<String> songs;

    public Playlist (String playlistName) {
        this.playlistName = playlistName;
        this.songs = new ArrayList<String>();
    }

    public void addSong(String song) {
        if (song.isEmpty()) {
            System.out.println("Песня без названия не может быть добавлена в плейлист%n");
        }
        else {
            songs.add(song);
            System.out.printf("Песня \"%s\" добавлена в плейлист %s%n", song, playlistName);
        }
    }

    public void deleteSong(int index) {
        if (getSong(index) != null) {
            songs.remove(index);
            System.out.printf("Песня с индексом %d удалена из плейлиста %s%n", index, playlistName);
        }
        else {
            System.out.printf("По индексу %d не найдена песня!%n", index);
        }
    }

    public void updateSong(int index, String newSong) {
        if (getSong(index) != null) {
            songs.set(index, newSong);
            System.out.printf("Песня с индексом %d обновлена в плейлисте %s%n", index, playlistName);
        }
        else {
            System.out.printf("По индексу %d не найдена песня!%n", index);
        }
    }

    public String getSong(int index) {
        try {
            return songs.get(index);
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void printSong(int index) {
        if (getSong(index) != null) {
            System.out.printf("По индексу %d найдена песня %s%n", index, songs.get(index));
        }
        else {
            System.out.printf("По индексу %d не найдена песня!%n", index);
        }
    }

    @Override
    public String toString() {
        return String.format("%nPlaylist{playlistName='" + playlistName + "',songs=" + songs.toString() + "'}%n");
    }
}
