package WorldOfZuul.Items;

import WorldOfZuul.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperItem {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;

    public void draw (Graphics2D graphics2D, GamePanel gamePanel){
        int screenX = worldX - gamePanel.player.position.x + gamePanel.player.screenPos.x;
        int screenY = worldY - gamePanel.player.position.y + gamePanel.player.screenPos.y;

        // This ugly if statement is basically if the tile is outside the players view, we won't render it.
        if (worldX + gamePanel.UNIT_SIZE > gamePanel.player.position.x - gamePanel.player.screenPos.x &&
                worldX - gamePanel.UNIT_SIZE < gamePanel.player.position.x + gamePanel.player.screenPos.x &&
                worldY + gamePanel.UNIT_SIZE > gamePanel.player.position.y - gamePanel.player.screenPos.y &&
                worldY - gamePanel.UNIT_SIZE < gamePanel.player.position.y + gamePanel.player.screenPos.y)
        {
            graphics2D.drawImage(image, screenX, screenY, null);
        }

    }

}
