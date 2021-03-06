package items;

import java.util.ArrayList;

public abstract class Item {

    private String name;
    private double buyPrice;
    private int weight;
    private double marketValue;
    private int idealMarkup;
    private boolean favourite;
    private boolean sellable;
    private ArrayList<String> keywords;

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
        this.keywords = new ArrayList<>();
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

    public double getMarketValue() {
        return this.marketValue;
    }

    public void setMarketValue(double amount) {
        this.marketValue = amount;
    }

    public int getIdealMarkup() {
        return this.idealMarkup;
    }

    public void setIdealMarkup(int amount) {
        this.idealMarkup = amount;
    }

    public boolean getFavourite() {
        return this.favourite;
    }

    public void setFavouriteTrue() {
        this.favourite = true;
    }

    public void setFavouriteFalse() {
        this.favourite = false;
    }

    private void makeSellable() {
        this.sellable = true;
    }

    private void makeNotSellable() {
        this.sellable = false;
    }

    public boolean checkIfSellable() {
        if(!this.favourite && (marketValue >= this.markUpByPercentage(this.idealMarkup)))
        {this.makeSellable();}
        else
        {this.makeNotSellable();}
        return this.sellable;
    }

    public double calculateProfit() {
        if (checkIfSellable()){
            return this.marketValue - this.getBuyPrice();}
        return 0.00;
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

    public double getTotalSellingPrice() {
        return this.markUpByPercentage(idealMarkup) + this.getShippingCost();
    }

    public int countKeywords() {
        return this.keywords.size();
    }

    public boolean checkKeywords(String word) {
        return this.keywords.contains(word);
    }

    public void setKeyword(String keyword) {
        this.keywords.add(keyword);
    }

    public void removeAKeyword(String word) {
        if (this.keywords.contains(word)){
            this.keywords.remove(word);
        }
    }

    public void clearKeywords() {
        this.keywords.clear();
    }

}
