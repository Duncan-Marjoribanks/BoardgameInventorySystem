package codeclan.example.javaProject.models;

public class Accessory extends Item {

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
