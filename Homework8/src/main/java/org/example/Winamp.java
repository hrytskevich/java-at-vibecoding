package org.example;

public class Winamp {
    public static void main(String[] args) {
        Playlist playlist2000 = new Playlist("Песни 2000-х");

        // добавление песен в плейлист
        playlist2000.addSong("Мак$им - Знаешь ли ты?");
        playlist2000.addSong("Жуки - Батарейка");
        playlist2000.addSong("Руки Вверх - 18 мне уже");
        playlist2000.addSong("Город 312 - Останусь");
        playlist2000.addSong("Юлия Савичева - Высоко");

        System.out.println(playlist2000.toString());

        // удаление песни из плейлиста
        playlist2000.deleteSong(2);

        System.out.println(playlist2000.toString());

        // обновление песни в плейлисте
        playlist2000.updateSong(0,"Мак$им - Мой рай");

        System.out.println(playlist2000.toString());

        // вывод песни из плейлиста
        playlist2000.printSong(3);

        System.out.println(playlist2000.toString());
    }
}