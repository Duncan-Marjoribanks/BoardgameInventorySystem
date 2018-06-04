package items;

public abstract class Item {

    private String name;
    private double buyPrice;
    private int weight;


    public Item(String name, double buyPrice, int weight) {
        this.name = name;
        this.buyPrice = buyPrice;

    }

    public String getName() {
        return this.name;
    }

    public double getBuyPrice() {
        return this.buyPrice;
    }

    private void setPrice(double amount) {
        this.buyPrice = amount;
    }

    public void addToPrice (double amount) {
        this.buyPrice += amount;
    }

    public double markUpByPercentage(double percentage) {
        return (this.getBuyPrice() * (1 + (percentage / 100)));
    }

}
