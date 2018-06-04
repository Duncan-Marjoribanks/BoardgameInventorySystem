package items.games;

import enums.GameGenreTypes;
import items.Item;

public class Game extends Item {

    private GameGenreTypes genre;
    private double marketValue;
    private int idealMarkup;
    private boolean favourite;
    private boolean sellable;

    public Game(String name,
                double buyPrice,
                int weight,
                GameGenreTypes genre,
                double marketValue,
                int idealMarkup,
                boolean favourite) {
        super(name, buyPrice, weight);
        this.genre = genre;
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

    public GameGenreTypes getGenre() {
        return this.genre;
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

    public void setGenre(GameGenreTypes genre) {
        this.genre = genre;
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
        return this.marketValue - this.getBuyPrice();
    }




}
