package WorldOfZuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


public class Room
{
    private String description;
    private HashMap<String, Room> exits;
    private Item item; //TODO: make it a list.


    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    public Room(String description, Item item)
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.item = item;
    }

    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("You are " + description + ".\n" + getExitString());

        // If there are any items in the room, we want to tell the player they are there.
        if (item != null) {
            builder.append("\nThere is something lying around in the street." + "\n" + item.getName());
        }

        return builder.toString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    // Accessor.
    public Item getItem() {
        return item;
    }

    // Mutator.
    public void setItem(Item item) {
        this.item = item;
    }
}

