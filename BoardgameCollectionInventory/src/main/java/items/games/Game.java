package items.games;

import enums.GameGenreTypes;
import items.Item;

public class Game extends Item {

    private GameGenreTypes genre;


    public Game(String name,
                double buyPrice,
                int weight,
                double marketValue,
                int idealMarkup,
                boolean favourite,
                GameGenreTypes genre) {
        super(name, buyPrice, weight, marketValue, idealMarkup, favourite);
        this.genre = genre;
        }

        public GameGenreTypes getGenre() {
            return this.genre;
        }

        public void setGenre (GameGenreTypes genre){
            this.genre = genre;
        }


}
