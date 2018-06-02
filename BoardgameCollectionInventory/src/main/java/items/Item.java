package items;

public abstract class Item {

    private String name;
    private double price;


    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
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
