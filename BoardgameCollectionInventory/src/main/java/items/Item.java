package items;

public abstract class Item {

    private String name;
    private double price;
    private boolean sellable;


    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.sellable = false;

    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean isSellable() {
        return this.sellable;
    }

    public void makeSellable() {
        this.sellable = true;
    }

    public void makeNotSellable() {
        this.sellable = false;
    }

    public void setPrice(double amount) {
        this.price = amount;
    }

    public void addToPrice (double amount) {
        this.price += amount;
    }

    public double markUpByPercentage(double percentage) {
        return (this.getPrice() * (1 + (percentage / 100)));
    }

}
