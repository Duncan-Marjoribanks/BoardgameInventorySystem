package codeclan.example.javaProject.models;


import codeclan.example.javaProject.enums.GameGenreTypes;

import javax.persistence.*;

@Entity
@Table (name = "game")
public class Game extends Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private GameGenreTypes genre;

    public Game(
            String name,
            double buyPrice,
            int weight,
            double marketValue,
            int idealMarkup,
            boolean favourite,
            GameGenreTypes genre

    ) {
        super(
                name,
                buyPrice,
                weight,
                marketValue,
                idealMarkup,
                favourite
        );
        this.genre = genre;
    }

    public GameGenreTypes getGenre() {
        return this.genre;
    }

    public void setGenre (GameGenreTypes genre){
        this.genre = genre;
    }

}
