package WorldOfZuul;


import WorldOfZuul.DataTypes.Item;

import java.util.ArrayList;

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
}
