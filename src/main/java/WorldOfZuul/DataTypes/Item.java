package WorldOfZuul.DataTypes;

import WorldOfZuul.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item
{
    public String name;
    public String description;
    public BufferedImage image;
    public Position position = new Position();
    public boolean collision;
    public Rectangle collider = new Rectangle(32, 32);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

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

    public void draw (Graphics2D graphics2D, GamePanel gamePanel){
        int screenX = position.x - gamePanel.player.position.x + gamePanel.player.screenPos.x;
        int screenY = position.y - gamePanel.player.position.y + gamePanel.player.screenPos.y;

        // This ugly if statement is basically if the tile is outside the players view, we won't render it.
        if (position.x + gamePanel.UNIT_SIZE > gamePanel.player.position.x - gamePanel.player.screenPos.x &&
                position.x - gamePanel.UNIT_SIZE < gamePanel.player.position.x + gamePanel.player.screenPos.x &&
                position.y + gamePanel.UNIT_SIZE > gamePanel.player.position.y - gamePanel.player.screenPos.y &&
                position.y - gamePanel.UNIT_SIZE < gamePanel.player.position.y + gamePanel.player.screenPos.y)
        {
            graphics2D.drawImage(image, screenX, screenY, null);
        }
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
