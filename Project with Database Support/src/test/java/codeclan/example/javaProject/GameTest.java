package codeclan.example.javaProject;

import codeclan.example.javaProject.enums.GameGenreTypes;
import codeclan.example.javaProject.models.Game;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GameTest {

    Game game, game2, game3;

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
        game3 = new Game(
                "Zombicide",
                40,
                10,
                45,
                10,
                false,
                GameGenreTypes.COOPERATIVE
        );
    }

    @Test
    public void canGetName() {
        assertEquals("Settlers of Catan", game.getName());
    }

    @Test
    public void canSetName() {
        game.setName("NotCatan");
        assertEquals("Not Catan", game.getName());
    }

    @Test
    public void canGetPrice() {
        assertEquals(30.00, game.getBuyPrice(), 0.01);
    }

    @Test
    public void canSetPrice() {
        game.setBuyPrice(40.00);
        assertEquals(40.00, game.getBuyPrice(), 0.01);
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
    public void canSetMarketValue() {
        game.setMarketValue(50.00);
        assertEquals(50.00, game.getMarketValue(), 0.01);
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
        assertEquals(7.50, game3.getShippingCost());
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

    @Test
    public void canSetKeyWord() {
        game.setKeyword("beginner friendly");
        assertEquals(true, game.checkKeywords("beginner friendly"));
    }

    @Test
    public void canRemoveKeyword() {
        game.setKeyword("beginner friendly");
        game.removeAKeyword("beginner friendly");
        assertEquals(0, game.countKeywords());
    }

    @Test
    public void canClearKeywords() {
        game.setKeyword("beginner friendly");
        game.clearKeywords();
        assertEquals(0, game.countKeywords());
    }

    @Test
    public void canGetKeywords() {
        game.setKeyword("beginner friendly");
        game.setKeyword("second keyword");
        assertEquals("[beginner friendly, second keyword]", game.getKeywords());
    }
}

