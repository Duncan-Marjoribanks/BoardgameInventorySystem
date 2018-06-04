import enums.GameGenreTypes;
import items.games.Game;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GameTest {

    Game game;

    @Before
    public void before() {
        game = new Game("Settlers of Catan", 30.00, 5, GameGenreTypes.TRADING, 33.00, 10, false);
    }

    @Test
    public void canGetName() {
        assertEquals("Settlers of Catan", game.getName());
    }

    @Test
    public void canGetPrice() {
        assertEquals(30.00, game.getBuyPrice(), 0.01);
    }

    @Test
    public void canAddArbitaryMarkup() {
        game.addToPrice(5.00);
        assertEquals(35.00, game.getBuyPrice(), 0.01);
    }

    @Test
    public void canMarkupByPercentage() {
        assertEquals(33.00, game.markUpByPercentage(10), 0.01);
    }

    @Test
    public void canSetIdealMarkUp() {
        game.setIdealMarkup(25);
        assertEquals(25, game.getIdealMarkup());
        assertEquals(false, game.checkIfSellable());
    }

    @Test
    public void canGetGenre() {
        assertEquals(GameGenreTypes.TRADING, game.getGenre());
    }

    @Test
    public void canGetMarketValue() {
        assertEquals(33.00, game.getMarketValue());
    }

    @Test
    public void canCheckIfSellable() {
        assertEquals(true, game.checkIfSellable());
    }

    @Test
    public void canCheckIfSellableIfTooCheap() {
        game.setMarketValue(20.00);
        assertEquals(false, game.checkIfSellable());
    }

    @Test
    public void canMakeFavorite() {
        game.setFavouriteTrue();
        assertEquals(true, game.getFavourite());
        assertEquals(false, game.checkIfSellable());
    }


}
