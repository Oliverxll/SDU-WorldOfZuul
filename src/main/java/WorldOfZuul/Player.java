package WorldOfZuul;

import WorldOfZuul.DataTypes.Position;
import WorldOfZuul.Utility.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity
{
    public int moveSpeed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;

    GamePanel gamePanel;
    KeyHandler keyhandler;

    public Player(GamePanel gamePanel, KeyHandler keyhandler)
    {
        this.gamePanel = gamePanel;
        this.keyhandler = keyhandler;
        setDefaultValues();
        getPlayerImage();
    }

    public Player()
    {
        this.position = new Position();
    }

    public Player(Position position)
    {
        this.position = position;
    }

    public void setDefaultValues()
    {
        position = new Position(80, 80);
        moveSpeed = 4;
        direction = "down";
    }

    public void getPlayerImage()
    {
        try
        {
            up1 = ImageLoader.getInstance().Load("/sprites/player/boy_up_1.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE);
            up2 = ImageLoader.getInstance().Load("/sprites/player/boy_up_2.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE);
            down1 = ImageLoader.getInstance().Load("/sprites/player/boy_down_1.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE);
            down2 = ImageLoader.getInstance().Load("/sprites/player/boy_down_2.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE);
            left1 = ImageLoader.getInstance().Load("/sprites/player/boy_left_1.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE);
            left2 = ImageLoader.getInstance().Load("/sprites/player/boy_left_2.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE);
            right1 = ImageLoader.getInstance().Load("/sprites/player/boy_right_1.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE);
            right2 = ImageLoader.getInstance().Load("/sprites/player/boy_right_2.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void update (){
        if (keyhandler.upPressed) {
            direction = "up";
            position.y -= moveSpeed;
        } else if (keyhandler.downPressed) {
            direction ="down";
            position.y += moveSpeed;
        } else if (keyhandler.leftPressed) {
            direction = "left";
            position.x -= moveSpeed;
        } else if (keyhandler.rightPressed) {
            direction = "right";
            position.x += moveSpeed;
        }

        if (keyhandler.upPressed || keyhandler.downPressed || keyhandler.leftPressed || keyhandler.rightPressed) {
            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }
    public void draw(Graphics2D g2)
    {
        BufferedImage image = null;

        switch (direction){
            case "up" -> {
                if (spriteNum == 1)
                    image = up1;
                else
                    image = up2;
            }
            case "down" ->
            {
                if (spriteNum == 1)
                    image = down1;
                else
                    image = down2;
            }
            case "left" ->
            {
                if (spriteNum == 1)
                    image = left1;
                else
                    image = left2;
            }
            case "right" ->
            {
                if (spriteNum == 1)
                    image = right1;
                else
                    image = right2;
            }
        }
        g2.drawImage(image, position.x, position.y, gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE, null);

    }
}
