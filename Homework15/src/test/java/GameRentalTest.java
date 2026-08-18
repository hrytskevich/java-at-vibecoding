import org.example.BoardGame;
import org.example.GameRental;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameRentalTest {

    public GameRental gameRental;

    @BeforeEach
    public void createGameCatalog() {
        BoardGame boardGame1 = new BoardGame("Монополия", 12, 10);
        BoardGame boardGame2 = new BoardGame("Alias", 20, 30);
        BoardGame boardGame3 = new BoardGame("Лото", 5, 8);
        gameRental = new GameRental();
        gameRental.addGame(boardGame1);
        gameRental.addGame(boardGame2);
        gameRental.addGame(boardGame3);
        gameRental.findGame("Лото").setRented(true);
    }

    @ParameterizedTest
    @CsvSource({
            "Монополия, 12",
            "Alias, 21"
    })
    public void testRentGamePositive(String gameName, int age) {
        Assertions.assertTrue(gameRental.rentGame(gameName, age));
        Assertions.assertTrue(gameRental.findGame(gameName).isRented());
    }

    @Test
    public void testRentGameNotExist() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gameRental.rentGame("Крокодил", 13);
        });
    }

    @ParameterizedTest
    @CsvSource({
           "Монополия, 11",
           "Лото, 10"
    })
    public void testRentGameReturnFalse(String gameName, int age) {
        Assertions.assertFalse(gameRental.rentGame(gameName, age));
    }

    @Test
    public void testReturnGame() {
        Assertions.assertTrue(gameRental.returnGame("Лото"));
        Assertions.assertFalse(gameRental.findGame("Лото").isRented());
    }

    @ParameterizedTest
    @CsvSource({
            "Крокодил",
            "Монополия"
    })
    public void testReturnGameReturnFalse(String gameName) {
        Assertions.assertFalse(gameRental.returnGame(gameName));
    }

    @Test
    public void testReset() {
        gameRental.reset();
        for (BoardGame boardGame : gameRental.getBoardGames()) {
            Assertions.assertFalse(boardGame.isRented());
        }
    }


}
