import enums.GameGenreTypes;
import items.accessories.Accessory;
import items.games.Game;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class CollectionTest {

    Collection collection;
    Game game, game2;
    Accessory accessory;

    @Before
    public void before() {
        collection = new Collection();
        game = new Game("Settlers of Catan", 30.00, GameGenreTypes.TRADING);
        game2 = new Game("Dominion", 35.00, GameGenreTypes.CARD_BASED);
        accessory = new Accessory("Dice", 1.00);
        collection.addToCollection(game);
        collection.addToCollection(accessory);
    }

    @Test
    public void canCountCollection() {
        assertEquals(2, collection.countCollection());
    }

    @Test
    public void canAddToCollection() {
        collection.addToCollection(game);
        assertEquals(3, collection.countCollection());
    }

    @Test
    public void canRemoveFromCollection() {
        collection.removeFromCollection(game);
        assertEquals(1, collection.countCollection());
    }

    @Test
    public void canNotRemoveItemFromCollectionBeyondZero() {
        collection.removeFromCollection(game);
        collection.removeFromCollection(game);
        assertEquals(1, collection.countCollection());
    }

    @Test
    public void canFindIndividualItemInCollection() {
        assertEquals(true, collection.checkCollectionContains(game));
    }

    @Test
    public void canListAllItemsInCollection() {
        int numberOfItems = collection.getEntireCollection().size();
        assertEquals(2, numberOfItems);
    }

    @Test
    public void canClearCollection() {
        collection.clearCollection();
        assertEquals(0, collection.countCollection());
    }

    @Test
    public void canGetItemFromCollection() {
        assertEquals(game, collection.getItemFromCollection(game));
    }

    @Test
    public void canGetItemPriceFromCollection() {
        assertEquals(30.00, collection.getItemFromCollection(game).getPrice());
    }

    @Test
    public void canNotGetItemFromCollection() {
        assertEquals(null, collection.getItemFromCollection(game2));
    }

    @Test
    public void canGetTotalBuyPriceOfCollection() {
        assertEquals(31.00, collection.getTotalPrice());
    }

    @Test
    public void canCountItemsBytype() {
        assertEquals(1, collection.countNumberOfSpecificItems(game));
    }


}
