import items.Item;
import items.accessories.Accessory;
import items.games.Game;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class CollectionTest {

    Collection collection;
    Game game;
    Accessory accessory;

    @Before
    public void before() {
        collection = new Collection();
        game = new Game("Settlers of Catan", 30.00);
        accessory = new Accessory("Dice", 1.00);
    }

    @Test
    public void canCountCollection() {
        assertEquals(0, collection.countCollection());
    }

    @Test
    public void canAddToCollection() {
        collection.addToCollection(game);
        assertEquals(1, collection.countCollection());
    }

    @Test
    public void canRemoveFromCollection() {
        collection.addToCollection(game);
        collection.removeFromCollection(game);
        collection.addToCollection(accessory);
        assertEquals(1, collection.countCollection());
    }

    @Test
    public void canNotRemoveItemFromCollectionBeyondZero() {
        collection.removeFromCollection(game);
        assertEquals(0, collection.countCollection());
    }

    @Test
    public void canFindIndividualItemInCollection() {
        collection.addToCollection(game);
        collection.addToCollection(accessory);
        assertEquals(true, collection.checkCollectionContains(game));
    }

    @Test
    public void canListAllItemsInCollection() {
        collection.addToCollection(game);
        collection.addToCollection(accessory);
        int numberOfItems = collection.getCollection().size();
        assertEquals(2, numberOfItems);
    }
}
