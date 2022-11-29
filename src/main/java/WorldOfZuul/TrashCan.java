package WorldOfZuul;

import WorldOfZuul.DataTypes.Item;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;

public class TrashCan extends Entity
{
    public BufferedImage image;
    public GamePanel gamePanel;
    public Item.ItemType itemType;


    public TrashCan(GamePanel gamePanel, Item.ItemType itemType) {
        this.itemType = itemType;
        this.gamePanel = gamePanel;

        collider = new Rectangle(64,64);
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
}
