package codeclan.example.javaProject.models;

import javax.persistence.*;

@Entity
@Table (name = "accessory")
public class Accessory extends Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public Accessory() {
    }

    public Accessory(
            String name,
            double buyPrice,
            int weight,
            double marketValue,
            int idealMarkup,
            boolean favourite)
    {
        super(
                name,
                buyPrice,
                weight,
                marketValue,
                idealMarkup,
                favourite
        );
    }

}
