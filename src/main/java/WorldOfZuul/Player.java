package WorldOfZuul;

import WorldOfZuul.DataTypes.IntVector2;
import WorldOfZuul.DataTypes.Position;

public class Player
{
    public Position position;

    public Player() {
        this.position = new Position();
    }

    public Player(Position position) {
        this.position = position;
    }

    public int speed;
    GamePanel gamePanel;
    KeyHandler keyhandler;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public Player (GamePanel gamePanel, KeyHandler keyhandler){
        this.gamePanel = gamePanel;
        this.keyhandler = keyhandler;
        setDefaultValues();
        getPlayerImage();

    }

    public void setDefaultValues (){
        position.x = 80;
        position.y = 80;
        speed = 4;
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
        if (keyhandler.upPressed == true) {
            direction = "up";
            position.y -= speed;
        } else if (keyhandler.downPressed == true) {
            direction ="down";
            position.y += speed;
        } else if (keyhandler.leftPressed == true) {
            direction = "left";
            position.x -= speed;
        } else if (keyhandler.rightPressed == true) {
            direction = "right";
            position.x += speed;

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
