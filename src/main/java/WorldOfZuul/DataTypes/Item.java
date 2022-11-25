package WorldOfZuul.DataTypes;

import java.awt.image.BufferedImage;

public class Item
{
    public String name;
    public String description;
    public BufferedImage image;
    public boolean collision;
    public Position position;

    public ItemType itemType;

    public Item() {
        this.name = "No name";
        this.description = "No description";
        itemType = ItemType.UNKNOWN;
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        itemType = ItemType.UNKNOWN;
    }

    public Item(String name, String description, ItemType itemType) {
        this(name, description);
        this.itemType = itemType;
    }

    public enum ItemType
    {
        TRASH,
        PAPER,
        METAL,
        PLASTIC,
        FOOD,
        UNKNOWN
    }
}
