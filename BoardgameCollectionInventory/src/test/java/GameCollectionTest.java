import enums.GameGenreTypes;
import items.games.Game;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GameCollectionTest {
    GameCollection gameCollection;
    Game game, game2, game3;

    @Before
    public void before() {
        gameCollection = new GameCollection();
        game = new Game("Settlers of Catan", 30.00, GameGenreTypes.TRADING);
        game2 = new Game("Dominion", 35.00, GameGenreTypes.DECK_BUILDER);
        game3 = new Game("Coup", 12.00, GameGenreTypes.BLUFFING);
        gameCollection.addToCollection(game);
        gameCollection.addToCollection(game2);

    }

    @Test
    public void canCountCollection() {
        assertEquals(2, gameCollection.countCollection());
    }

    @Test
    public void canAddToCollection() {
        gameCollection.addToCollection(game3);
        assertEquals(3, gameCollection.countCollection());
    }

    @Test
    public void canRemoveFromCollection() {
        gameCollection.removeFromCollection(game);
        assertEquals(1, gameCollection.countCollection());
    }

    @Test
    public void canNotRemoveItemIfNotInCollection() {
        gameCollection.removeFromCollection(game);
        gameCollection.removeFromCollection(game);
        assertEquals(1, gameCollection.countCollection());
    }

    @Test
    public void canFindIndividualItemInCollection() {
        assertEquals(true, gameCollection.checkCollectionContains(game));
    }

    @Test
    public void canListAllItemsInCollection() {
        int numberOfItems = gameCollection.getEntireCollection().size();
        assertEquals(2, numberOfItems);
    }

    @Test
    public void canClearCollection() {
        gameCollection.clearCollection();
        assertEquals(0, gameCollection.countCollection());
    }

    @Test
    public void canGetItemFromCollection() {
        assertEquals(game, gameCollection.getItemFromCollection(game));
    }

    @Test
    public void canGetItemPriceFromCollection() {
        assertEquals(30.00, gameCollection.getItemFromCollection(game).getPrice());
    }

    @Test
    public void canNotGetItemFromCollection() {
        assertEquals(null, gameCollection.getItemFromCollection(game3));
    }

    @Test
    public void canGetTotalPriceOfCollection() {
        assertEquals(65.00, gameCollection.getTotalPrice());
    }

    @Test
    public void canCountItemsBytype() {
        assertEquals(1, gameCollection.countNumberOfSpecificItems(game));
    }

    @Test
    public void canGetTotalPriceForGroupOfTheSameItems() {
        gameCollection.addToCollection(game);
        assertEquals(60.00, gameCollection.getTotalPriceForGroupOfTheSameItems(game), 0.01);
    }

}
