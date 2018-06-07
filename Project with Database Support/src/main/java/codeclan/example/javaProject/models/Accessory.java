package codeclan.example.javaProject.models;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name = "accessory")
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
