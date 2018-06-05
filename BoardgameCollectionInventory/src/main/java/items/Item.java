package items;

public abstract class Item {

    private String name;
    private double buyPrice;
    private int weight;
    private double marketValue;
    private int idealMarkup;
    private boolean favourite;
    private boolean sellable;

    public Item(
            String name,
            double buyPrice,
            int weight,
            double marketValue,
            int idealMarkup,
            boolean favourite)
    {
        this.name = name;
        this.buyPrice = buyPrice;
        this.weight = weight;
        this.marketValue = marketValue;
        this.idealMarkup = idealMarkup;
        this.favourite = favourite;
        this.sellable = false;
    }


    public boolean checkIfSellable() {
        if(!this.favourite && (marketValue >= this.markUpByPercentage(this.idealMarkup)))
        {this.makeSellable();}
        else
        {this.makeNotSellable();}
        return this.sellable;
    }

    private void makeSellable() {
        this.sellable = true;
    }

    private void makeNotSellable() {
        this.sellable = false;
    }

    public double getMarketValue() {
        return this.marketValue;
    }

    public int getIdealMarkup() {
        return this.idealMarkup;
    }

    public boolean getFavourite() {
        return this.favourite;
    }

    public void setMarketValue(double amount) {
        this.marketValue = amount;
    }

    public void setIdealMarkup(int amount) {
        this.idealMarkup = amount;
    }

    public void setFavouriteTrue() {
        this.favourite = true;
    }

    public void setFavouriteFalse() {
        this.favourite = false;
    }

    public double getTotalSellingPrice() {
        return this.markUpByPercentage(idealMarkup) + this.getShippingCost();
    }

    public double calculateProfit() {
        if (checkIfSellable()){
            return this.marketValue - this.getBuyPrice();}
        return 0.00;
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

    public void addToPrice (double amount) {
        this.buyPrice += amount;
    }

    public double markUpByPercentage(double percentage) {
        return (this.getBuyPrice() * (1 + (percentage / 100)));
    }

    public double getShippingCost() {
        if (weight <= 4)
            return 3.00;
        if (weight <= 8)
            return 5.00;
        if (weight <= 12)
            return 7.50;
        else return 20.00;
    }

}
