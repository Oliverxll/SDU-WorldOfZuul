package WorldOfZuul;

import WorldOfZuul.DataTypes.Position;
import WorldOfZuul.Utility.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity
{
    private int moveSpeed;
    private BufferedImage[] up, down, left, right;
    private String direction;
    private int spriteCounter = 0;
    private int spriteNum = 0;

    private GamePanel gamePanel;
    private KeyHandler keyhandler;

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
            up = new BufferedImage[] {
                    ImageLoader.getInstance().Load("/sprites/player/boy_up_1.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE),
                    ImageLoader.getInstance().Load("/sprites/player/boy_up_2.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE)
            };
            down = new BufferedImage[] {
                    ImageLoader.getInstance().Load("/sprites/player/boy_down_1.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE),
                    ImageLoader.getInstance().Load("/sprites/player/boy_down_2.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE)
            };
            left = new BufferedImage[] {
                    ImageLoader.getInstance().Load("/sprites/player/boy_left_1.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE),
                    ImageLoader.getInstance().Load("/sprites/player/boy_left_2.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE)
            };
            right = new BufferedImage[] {
                    ImageLoader.getInstance().Load("/sprites/player/boy_right_1.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE),
                    ImageLoader.getInstance().Load("/sprites/player/boy_right_2.png", gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE)
            };

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
                if (spriteNum == 0) {
                    spriteNum = 1;
                } else {
                    spriteNum = 0;
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
                image = up[spriteNum];
            }
            case "down" ->
            {
                image = down[spriteNum];
            }
            case "left" ->
            {
                image = left[spriteNum];
            }
            case "right" ->
            {
                image = right[spriteNum];
            }
        }
        g2.drawImage(image, position.x, position.y, gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE, null);

    }
}
