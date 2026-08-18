import org.example.BoardGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardGameTest {
    @Test
    public void testCreateGame() {
        BoardGame game = new BoardGame("Монополия", 15, 10);
        Assertions.assertEquals("Монополия", game.getName());
        Assertions.assertEquals(15, game.getMinAge());
        Assertions.assertEquals(10, game.getPricePerDay());
        Assertions.assertFalse(game.isRented());
    }

    @Test
    public void testCreateGameWithoutName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BoardGame(null, 12, 10);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BoardGame("", 12, 10);
        });
    }

    @Test
    public void testCreateGameWrongAge() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BoardGame("Монополия", -1, 10);
        });
    }

    @Test
    public void testCreateGameAge0() {
        Assertions.assertDoesNotThrow(() -> {
            new BoardGame("Монополия", 0, 10);
        });
    }

    @Test
    public void testCreateGamePrice0() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BoardGame("Монополия", 15, 0);
        });
    }

    @Test
    public void testCreateGamePriceLower0() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BoardGame("Монополия", 15, -1);
        });
    }

    @Test
    public void testCreateGameAgeEqualsMin() {
        BoardGame game = new BoardGame("Монополия", 15, 10);
        Assertions.assertTrue(game.canBeRentedBy(15));
    }

    @Test
    public void testCreateGameAgeHigherMin() {
        BoardGame game = new BoardGame("Монополия", 15, 10);
        Assertions.assertTrue(game.canBeRentedBy(16));
    }

    @Test
    public void testCreateGameAgeLowerMin() {
        BoardGame game = new BoardGame("Монополия", 15, 10);
        Assertions.assertFalse(game.canBeRentedBy(14));
    }

}
