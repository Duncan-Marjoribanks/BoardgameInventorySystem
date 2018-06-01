import items.Item;

import java.util.ArrayList;

public class Collection {

    private ArrayList<Item> collection;

    public Collection(){
        this.collection = new ArrayList <>();
    }

    public int countCollection() {
        return this.collection.size();
    }

    public void addToCollection(Item item) {
        this.collection.add(item);
    }

    public void removeFromCollection(Item item) {
        this.collection.remove(item);
    }

    public void clearCollection() {
        this.collection.clear();
    }

    public boolean checkCollectionContains(Item item) {
         if (collection.contains(item)){return true;} else {return false;}
    }
}
