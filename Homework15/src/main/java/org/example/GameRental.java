package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class GameRental {
    private ArrayList<BoardGame> boardGames;

    public GameRental() {
        this.boardGames = new ArrayList<>();
    }

    public GameRental(ArrayList<BoardGame> boardGames) {
        this.boardGames = boardGames;
    }

    public void addGame(BoardGame game) {
        if (game == null) throw new IllegalArgumentException("Нельзя передавать null");
        if (boardGames.contains(game)) throw new IllegalArgumentException("Нельзя передавать дубликат");
        else {
            boardGames.add(game);
        }
    }

    public ArrayList<BoardGame> getBoardGames() {
        return boardGames;
    }

    public BoardGame findGame(String name) {
        for (BoardGame game : boardGames) {
            if (game.getName().equals(name))
                return game;
        }
        return null;
    }

    public boolean rentGame(String name, int customerAge) {
        BoardGame game = findGame(name);
        if (game == null) throw new IllegalArgumentException("Игры не существует");
        if (!game.canBeRentedBy(customerAge))
            return false;
        if (game.isRented())
            return false;
        else {
            game.setRented(true);
            return true;
        }
    }

    public boolean returnGame(String name) {
        BoardGame game = findGame(name);
        if (game == null)
            return false;
        if (!game.isRented())
            return false;
        else {
            game.setRented(false);
            return true;
        }
    }

    public int calculateCost(String name, int days) {
        if (days <= 0) throw new IllegalArgumentException("Количество дней не может быть <= 0");
        BoardGame game = findGame(name);
        if (game == null) throw new IllegalArgumentException("Игры не существует");
        return game.getPricePerDay() * days;
    }

    public void reset() {
        for (BoardGame boardgame : boardGames) {
            boardgame.setRented(false);
        }
    }

}
