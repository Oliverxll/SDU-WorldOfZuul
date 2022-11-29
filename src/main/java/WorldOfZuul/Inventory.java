package WorldOfZuul;


import WorldOfZuul.DataTypes.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory
{
    private static ArrayList<Item> innerList;

    public Inventory() {
        innerList = new ArrayList<>();
    }

    public static void add(Item item) {
        innerList.add(item);
    }

    public void remove(Item item) {
        innerList.remove(item);
    }

    public List<Item> getAll (){return innerList;}
}
