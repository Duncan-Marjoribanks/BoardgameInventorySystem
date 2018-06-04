package items.games;

import enums.GameGenreTypes;
import items.Item;

public class Game extends Item {

    private GameGenreTypes genre;
    private double marketValue;
    private int idealMarkup;
    private boolean favourite;

    public Game(String name,
                double price,
                GameGenreTypes genre,
                double marketValue,
                int idealMarkup,
                boolean favourite) {
        super(name, price);
        this.genre = genre;
        this.marketValue = marketValue;
        this.idealMarkup = idealMarkup;
        this.favourite = favourite;
        if(!this.favourite && (marketValue >= this.markUpByPercentage(this.idealMarkup)))
        {this.makeSellable();}
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




}
