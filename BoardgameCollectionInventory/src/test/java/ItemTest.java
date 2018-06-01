import items.Item;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ItemTest {

    Item item;

    @Before
    public void before() {
        item = new Item("Settlers of Catan", 30.00);
    }

    @Test
    public void canGetName() {
        assertEquals("Settlers of Catan", item.getName());
    }

    @Test
    public void canGetPrice() {
        assertEquals(30.00, item.getPrice(), 0.01);
    }

}
