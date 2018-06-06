import items.Item;
import java.util.ArrayList;

public abstract class Collection {

    protected ArrayList <Item> collection;
    public ArrayList <Item> keyCollection;

    protected Collection() {
        this.collection = new ArrayList <>();
        this.keyCollection = new ArrayList <>();
    }

    public int countCollection() {
        return this.collection.size();
    }

    public void addToCollection(Item item) {
        this.collection.add(item);
    }

    public void removeFromCollection(Item item) {
        if (checkCollectionContains(item)) {
            this.collection.remove(item);
        }
    }

    public void clearCollection() {
        this.collection.clear();
    }

    public boolean checkCollectionContains(Item item) {
        return this.collection.contains(item);
    }

    public ArrayList<Item> getEntireCollection() {
        return this.collection;
    }

    public Item getItemFromCollection(Item item) {
        if (checkCollectionContains(item)) {
            removeFromCollection(item);
            return item;
        } else {
            return null;
        }
    }

    public double getTotalPrice() {
        double total = 0.00;
        for (Item item : this.collection) {
            total += item.getBuyPrice();
        }
        return total;
    }

    public int countNumberOfSpecificItems(Item item) {
        int number = 0;
        for (Item eachItem : this.collection) {
            if (eachItem == item) {
                number++;
            }
        }
        return number;
    }

    public double getTotalPriceForGroupOfTheSameItems(Item item) {
        double total = 0;
        for (Item eachItem : this.collection) {
            if (eachItem == item) {
                total += item.getBuyPrice();
            }
        }
        return total;
    }

    public String getStringItemNames() {
        String names = "";
        for (Item item : this.collection) {
            names = names + (item.getName() + ", ");
        }
        return names;
    }

    public String getNamesOfAllItems() {
        StringBuilder names = new StringBuilder("");
        for (Item item : this.collection){
            names.append(item.getName()).append(", ");
        }
        return names.toString();
    }

    public ArrayList<Item> getItemsByKeyword(String word) {
        keyCollection.clear();
        for (Item item : this.collection) {
            if (item.checkKeywords(word)) {
                keyCollection.add(item);
            }
        }
        return keyCollection;
    }


}
