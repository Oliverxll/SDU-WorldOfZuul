package WorldOfZuul;

import java.util.ArrayList;
import java.util.List;

public class Inventory
{
    private List<Item> inventory;

    public Inventory() {
        inventory = new ArrayList<Item>();
    }

    // Accessor.
    public List<Item> getAll() {
        return inventory;
    }

    // Gets the item with a given name from the inventory.
    public Item get(String itemName)
    {
        for (Item item : inventory)
        {
            // .contains() compares string values.
            if (item.getName().contains(itemName)) {
                return item;
            }
        }
        // If the item wasn't found.
        return null;
    }

    public void add(Item item) {
        inventory.add(item);
    }

    public void remove(Item itemToGet)
    {
        inventory.remove(itemToGet);
    }
}
