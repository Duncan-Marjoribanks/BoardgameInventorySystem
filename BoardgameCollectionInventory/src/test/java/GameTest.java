import enums.GameGenreTypes;
import items.games.Game;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GameTest {

    Game game, game2;

    @Before
    public void before() {
        game = new Game(
                "Settlers of Catan",
                30.00,
                5,
                33.00,
                10,
                false,
                GameGenreTypes.TRADING
        );
        game2 = new Game(
                "Dominion",
                35,
                28,
                40,
                15,
                true,
                GameGenreTypes.DECK_BUILDER
        );
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
    public void canSetGenre() {
        game.setGenre(GameGenreTypes.BLUFFING);
        assertEquals(GameGenreTypes.BLUFFING, game.getGenre());
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

    @Test
    public void canMakeNotFavourite() {
        game.setFavouriteTrue();
        game.setFavouriteFalse();
        assertEquals(false, game.getFavourite());
    }

    @Test
    public void canGetShippingCost() {
        assertEquals(5.00, game.getShippingCost());
        assertEquals(20.00, game2.getShippingCost());
    }

    @Test
    public void canGetTotalSellPrice() {
        assertEquals(38.00, game.getTotalSellingPrice());
        assertEquals(60.25, game2.getTotalSellingPrice());
    }

    @Test
    public void canGetWeight() {
        assertEquals(5, game.getWeight());
    }

    @Test
    public void canCalculateProfitFromSale() {
        assertEquals(3.00, game.calculateProfit());
    }
}
