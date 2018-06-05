import items.accessories.Accessory;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AccessoryTest {

    Accessory accessory;

    @Before
    public void before() {
        accessory = new Accessory(
                "Dice - D6",
                1.00,
                1,
                2.00,
                50,
                false);
    }

    @Test
    public void canGetName() {
        assertEquals("Dice - D6", accessory.getName());
    }

    @Test
    public void canGetBuyPrice() {
        assertEquals(1.00, accessory.getBuyPrice(), 0.01);
    }

    @Test
    public void canAddArbitaryMarkup() {
        accessory.addToPrice(2.00);
        assertEquals(3, accessory.getBuyPrice(), 0.01);
    }

    @Test
    public void canMarkUpByPercentage() {
        assertEquals(1.15, accessory.markUpByPercentage(15), 0.01);
    }
}
