import org.example.BoardGame;
import org.example.GameRental;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameCatalogTest {
    @Test
    public void testAddGamePositive() {
        BoardGame boardGame = new BoardGame("Монополия", 12, 10);
        GameRental gameRental = new GameRental();
        gameRental.addGame(boardGame);
        Assertions.assertEquals("Монополия", gameRental.getBoardGames().getLast().getName());
        Assertions.assertEquals(12, gameRental.getBoardGames().getLast().getMinAge());
        Assertions.assertEquals(10, gameRental.getBoardGames().getLast().getPricePerDay());
        Assertions.assertFalse(gameRental.getBoardGames().getLast().isRented());
    }

    @Test
    public void testAddGameNull() {
        GameRental gameRental = new GameRental();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gameRental.addGame(null);
        });
    }

    @Test
    public void testAddGameDuplicate() {
        BoardGame boardGame1 = new BoardGame("Монополия", 12, 10);
        BoardGame boardGame2 = new BoardGame("Монополия", 20, 30);
        GameRental gameRental = new GameRental();
        gameRental.addGame(boardGame1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gameRental.addGame(boardGame2);
        });
    }

    @Test
    public void testFindGamePositive() {
        BoardGame boardGame1 = new BoardGame("Монополия", 12, 10);
        BoardGame boardGame2 = new BoardGame("Alias", 20, 30);
        GameRental gameRental = new GameRental();
        gameRental.addGame(boardGame1);
        gameRental.addGame(boardGame2);
        Assertions.assertEquals("Монополия", gameRental.findGame("Монополия").getName());
    }

    @Test
    public void testFindGameNegative() {
        BoardGame boardGame1 = new BoardGame("Монополия", 12, 10);
        BoardGame boardGame2 = new BoardGame("Alias", 20, 30);
        GameRental gameRental = new GameRental();
        gameRental.addGame(boardGame1);
        gameRental.addGame(boardGame2);
        Assertions.assertNull(gameRental.findGame("Лото"));
    }
}
