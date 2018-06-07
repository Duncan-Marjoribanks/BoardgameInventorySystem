package codeclan.example.javaProject.models;



public class GameCollection extends Collection{

    public double calculateTotalPotentialProfit() {
        double total = 0.00;
        for (Item item : this.collection) {
            Game game = (Game)item;
            total += game.calculateProfit();
        }
        return total;
    }


}
