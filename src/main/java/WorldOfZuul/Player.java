package WorldOfZuul;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player {
    public int x, y;
    public int speed;
    GamePanel gp;
    KeyHandler keyH;



    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public Player (GamePanel gp, KeyHandler keyH){
        this.gp=gp;
        this.keyH=keyH;
        setDefaultValues();
        getPlayerImage();

    }

    public void setDefaultValues (){
        x=80;
        y=80;
        speed=4;
        direction = "down";
    }


    public void getPlayerImage(){
        try{
            up1= ImageIO.read(getClass().getResourceAsStream("/character/boy_up_1.png"));
            up2= ImageIO.read(getClass().getResourceAsStream("/character/boy_up_2.png"));
            down1= ImageIO.read(getClass().getResourceAsStream("/character/boy_down_1.png"));
            down2= ImageIO.read(getClass().getResourceAsStream("/character/boy_down_2.png"));
            left1= ImageIO.read(getClass().getResourceAsStream("/character/boy_left_1.png"));
            left2= ImageIO.read(getClass().getResourceAsStream("/character/boy_left_2.png"));
            right1= ImageIO.read(getClass().getResourceAsStream("/character/boy_right_1.png"));
            right2= ImageIO.read(getClass().getResourceAsStream("/character/boy_right_2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update (){
        if (keyH.upPressed == true) {
            direction = "up";
            y -= speed;
        } else if (keyH.downPressed == true) {
            direction ="down";
            y += speed;
        } else if (keyH.leftPressed == true) {
            direction = "left";
            x -= speed;
        } else if (keyH.rightPressed == true) {
            direction = "right";
            x += speed;

        }
    }
    public void draw(Graphics2D g2){
        //This makes a white rectangle.
        //g2.setColor(Color.white);

        //This is the coordinates and size
       // g2.fillRect(x, y, gp.UNIT_SIZE, gp.UNIT_SIZE);

        BufferedImage image = null;
        switch (direction){
            case"up":
                image=up1;
                break;
            case "down":
                image=down1;
                break;
            case "left":
                image=left1;
                break;
            case "right":
                image=right1;
                break;
        }
        g2.drawImage(image, x, y, gp.UNIT_SIZE, gp.UNIT_SIZE, null);

    }
}
