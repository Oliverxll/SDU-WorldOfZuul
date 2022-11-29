package WorldOfZuul;


import WorldOfZuul.DataTypes.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory
{
    private ArrayList<Item> innerList;

    public Inventory() {
        innerList = new ArrayList<>();
    }

    public void add(Item item) {
        innerList.add(item);
    }

    public void remove(Item item) {
        innerList.remove(item);
    }

    public Item get(int i) {
        return innerList.get(i);
    }

    public ArrayList<Item> getAll() {
        return innerList;
    }

    public int count() {
        return innerList.size();
    }
}
