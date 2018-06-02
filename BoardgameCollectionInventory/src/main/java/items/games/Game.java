package items.games;

import enums.GameGenreTypes;
import items.Item;

public class Game extends Item {

    private GameGenreTypes genre;

    public Game(String name, double price, GameGenreTypes genre) {
        super(name, price);
        this.genre = genre;
    }

    public GameGenreTypes getGenre() {
        return this.genre;
    }


}
