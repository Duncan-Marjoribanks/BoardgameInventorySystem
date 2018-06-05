import items.accessories.Accessory;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AccessoryCollectionTest {

    Collection accessoryCollection;
    Accessory accessory, accessory2, accessory3;

    @Before
    public void before() {
        accessoryCollection = new AccessoryCollection();
        accessory = new Accessory(
                "Dice",
                1.00,
                1,
                1.00,
                10,
                false);
        accessory2 = new Accessory(
                "shaker cup",
                2.00,
                1,
                2.50,
                15,
                false);
        accessory3 = new Accessory(
                "measuring tape",
                5.00,
                2,
                5.50,
                10,
                false);
        accessoryCollection.addToCollection(accessory);
        accessoryCollection.addToCollection(accessory2);
    }

    @Test
    public void canCountCollection() {
        assertEquals(2, accessoryCollection.countCollection());
    }

    @Test
    public void canAddToCollection() {
        accessoryCollection.addToCollection(accessory);
        assertEquals(3, accessoryCollection.countCollection());
    }

    @Test
    public void canRemoveFromCollection() {
        accessoryCollection.removeFromCollection(accessory);
        assertEquals(1, accessoryCollection.countCollection());
    }

    @Test
    public void canNotRemoveItemIfNotInCollection() {
        accessoryCollection.removeFromCollection(accessory);
        accessoryCollection.removeFromCollection(accessory);
        assertEquals(1, accessoryCollection.countCollection());
    }

    @Test
    public void canFindIndividualItemInCollection() {
        assertEquals(true, accessoryCollection.checkCollectionContains(accessory));
    }

    @Test
    public void canListAllItemsInCollection() {
        int numberOfItems = accessoryCollection.getEntireCollection().size();
        assertEquals(2, numberOfItems);
    }

    @Test
    public void canClearCollection() {
        accessoryCollection.clearCollection();
        assertEquals(0, accessoryCollection.countCollection());
    }

    @Test
    public void canGetItemFromCollection() {
        assertEquals(accessory, accessoryCollection.getItemFromCollection(accessory));
    }

    @Test
    public void canGetItemPriceFromCollection() {
        assertEquals(1.00, accessoryCollection.getItemFromCollection(accessory).getBuyPrice());
    }

    @Test
    public void canNotGetItemFromCollection() {
        assertEquals(null, accessoryCollection.getItemFromCollection(accessory3));
    }

    @Test
    public void canGetTotalPriceOfCollection() {
        assertEquals(3.00, accessoryCollection.getTotalPrice());
    }

    @Test
    public void canCountItemsBytype() {
        assertEquals(1, accessoryCollection.countNumberOfSpecificItems(accessory));
    }

    @Test
    public void canGetTotalPriceForGroupOfTheSameItems() {
        accessoryCollection.addToCollection(accessory);
        assertEquals(2.00, accessoryCollection.getTotalPriceForGroupOfTheSameItems(accessory), 0.01);
    }

}
