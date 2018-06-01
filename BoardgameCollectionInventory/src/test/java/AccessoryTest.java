import items.accessories.Accessory;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AccessoryTest {

    Accessory accessory;

    @Before
    public void before() {
        accessory = new Accessory("Dice - D6", 1.00);
    }

    @Test
    public void canGetName() {
        assertEquals("Dice - D6", accessory.getName());
    }

    @Test
    public void canGetPrice() {
        assertEquals(1.00, accessory.getPrice(), 0.01);
    }
}
