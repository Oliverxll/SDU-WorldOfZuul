package WorldOfZuul;

import WorldOfZuul.DataTypes.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity
{
    public int moveSpeed;
    GamePanel gamePanel;
    KeyHandler keyhandler;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    String direction;

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
            up1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/boy_right_2.png"));

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
    }
    public void draw(Graphics2D g2){
        //This makes a white rectangle.
        //g2.setColor(Color.white);

        //This is the coordinates and size
        //g2.fillRect(position.x, position.y, gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE);

        BufferedImage image = null;
        switch (direction){
            case "up" -> {
                image = up1;
            }
            case "down" ->
            {
                image = down1;
            }
            case "left" ->
            {
                image = left1;
            }
            case "right" ->
            {
                image = right1;
            }
        }
        g2.drawImage(image, position.x, position.y, gamePanel.UNIT_SIZE, gamePanel.UNIT_SIZE, null);

    }
}
