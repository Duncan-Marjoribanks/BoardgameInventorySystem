package codeclan.example.javaProject;

import codeclan.example.javaProject.models.Accessory;
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

    @Test
    public void canSetIdealMarkUp() {
        accessory.setIdealMarkup(25);
        assertEquals(25, accessory.getIdealMarkup());
        assertEquals(true, accessory.checkIfSellable());
    }

    @Test
    public void canGetMarketValue() {
        assertEquals(2.00, accessory.getMarketValue());
    }

    @Test
    public void canCheckIfSellable() {
        assertEquals(true, accessory.checkIfSellable());
    }

    @Test
    public void canCheckIfSellableIfTooCheap() {
        accessory.setMarketValue(0.20);
        assertEquals(false, accessory.checkIfSellable());
    }

    @Test
    public void canMakeFavorite() {
        accessory.setFavouriteTrue();
        assertEquals(true, accessory.getFavourite());
        assertEquals(false, accessory.checkIfSellable());
    }

    @Test
    public void canMakeNotFavourite() {
        accessory.setFavouriteTrue();
        accessory.setFavouriteFalse();
        assertEquals(false, accessory.getFavourite());
    }

    @Test
    public void canGetShippingCost() {
        assertEquals(3.00, accessory.getShippingCost());
    }

    @Test
    public void canGetTotalSellPrice() {
        assertEquals(4.50, accessory.getTotalSellingPrice());
    }

    @Test
    public void canGetWeight() {
        assertEquals(1, accessory.getWeight());
    }

    @Test
    public void canCalculateProfitFromSale() {
        assertEquals(1.00, accessory.calculateProfit());
    }

}
