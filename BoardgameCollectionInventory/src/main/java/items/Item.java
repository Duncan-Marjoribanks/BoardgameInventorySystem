package items;

public abstract class Item {

    private String name;
    private double buyPrice;
    private int weight;


    public Item(String name, double buyPrice, int weight) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.weight = weight;

    }

    public String getName() {
        return this.name;
    }

    public double getBuyPrice() {
        return this.buyPrice;
    }

    public int getWeight() {
        return this.weight;
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

    public double getShippingCost() {
        if (weight <= 4) {
            return 3.00;
        }
        if (weight <= 8) {
            return 5.00;
        }
        if (weight <= 12) {
            return 7.50;
        } else return 20.00;
    }

}
