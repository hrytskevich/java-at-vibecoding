import org.example.BoardGame;
import org.example.GameRental;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RentalCostTest {
    public static GameRental gameRental;

    @BeforeAll
    public static void createGameCatalog() {
        BoardGame boardGame1 = new BoardGame("Монополия", 12, 10);
        BoardGame boardGame2 = new BoardGame("Alias", 20, 30);
        BoardGame boardGame3 = new BoardGame("Лото", 5, 8);
        gameRental = new GameRental();
        gameRental.addGame(boardGame1);
        gameRental.addGame(boardGame2);
        gameRental.addGame(boardGame3);
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void testCalculateCost(String gameName, int days, int expectedCost) {
        Assertions.assertEquals(gameRental.calculateCost(gameName, days), expectedCost);
    }

    static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("Монополия", 5, 50),
                Arguments.of("Лото", 1, 8)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "Крокодил, 1",
            "Лото, 0",
            "Alias, -1"
    })
    public void testRentGameException(String gameName, int days) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gameRental.calculateCost(gameName, days);
        });
    }
}
