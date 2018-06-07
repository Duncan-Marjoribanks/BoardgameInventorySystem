package codeclan.example.javaProject.models;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import java.util.ArrayList;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Item {

    private String name;
    private double buyPrice;
    private int weight;
    private double marketValue;
    private int idealMarkup;
    private boolean favourite;
    private boolean sellable;

    public Item() {

    }
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

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public double getBuyPrice() {
        return this.buyPrice;
    }

    public void setBuyPrice(double newPrice) {
        this.buyPrice = newPrice;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int newWeight) {
        this.weight = newWeight;
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

//    public String getKeywords() {
//        return this.keywords.toString();
//    }
//
//    public int countKeywords() {
//        return this.keywords.size();
//    }
//
//    public boolean checkKeywords(String word) {
//        return this.keywords.contains(word);
//    }
//
//    public void setKeyword(String keyword) {
//        this.keywords.add(keyword);
//    }
//
//    public void removeAKeyword(String word) {
//        if (this.keywords.contains(word)){
//            this.keywords.remove(word);
//        }
//    }
//
//    public void clearKeywords() {
//        this.keywords.clear();
//    }

}
