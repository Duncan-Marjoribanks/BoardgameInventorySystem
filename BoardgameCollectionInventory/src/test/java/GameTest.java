import items.games.Game;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GameTest {

    Game game;

    @Before
    public void before() {
        game = new Game("Settlers of Catan", 30.00);
    }

    @Test
    public void canGetName() {
        assertEquals("Settlers of Catan", game.getName());
    }

    @Test
    public void canGetPrice() {
        assertEquals(30.00, game.getPrice(), 0.01);
    }

    @Test
    public void canAddArbitaryMarkup() {
        game.addToPrice(5.00);
        assertEquals(35.00, game.getPrice(), 0.01);
    }

    @Test
    public void canMarkupByPercentage() {
        assertEquals(33.00, game.markUpByPercentage(10), 0.01);
    }



}
