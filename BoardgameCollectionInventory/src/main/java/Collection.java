import items.Item;

import java.util.ArrayList;

public class Collection {

    private ArrayList <Item> collection;

    public Collection() {
        this.collection = new ArrayList <>();
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

    public ArrayList <Item> getCollection() {
        return this.collection;
    }

//    public Item getItemFromCollection(Item item) {
//        if (checkCollectionContains(item)) {return item;} else {return null;}
//    }

    public Item getItemFromCollection(Item item) {
        if (checkCollectionContains(item)){
            removeFromCollection(item);
            return item;
        }else{return null;}

    }

}
