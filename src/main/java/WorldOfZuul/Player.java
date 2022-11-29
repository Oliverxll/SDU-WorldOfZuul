package WorldOfZuul;

import WorldOfZuul.DataTypes.*;
import WorldOfZuul.Utility.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity
{
    private BufferedImage[] up, down, left, right;

    // Animation variables
    private int spriteCounter = 0;
    private int spriteNum = 0;

    public Position screenPos;

    private GamePanel gamePanel;
    private KeyHandler keyhandler;

    Inventory inventory = new Inventory();

    public Player(GamePanel gamePanel, KeyHandler keyhandler)
    {
        this.gamePanel = gamePanel;
        this.keyhandler = keyhandler;

        screenPos = new Position(gamePanel.screenWidth/2 - gamePanel.UNIT_SIZE/2,
                                 gamePanel.screenHeight/2 - gamePanel.UNIT_SIZE/2);



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
        position = new Position(gamePanel.worldWidth / 2 - gamePanel.UNIT_SIZE / 2,
                                gamePanel.worldHeight / 2 - gamePanel.UNIT_SIZE / 2);

        collider = new Rectangle(11, 22, gamePanel.UNIT_SIZE - 22, gamePanel.UNIT_SIZE - 22);

        colliderAreaDefaultX = collider.x;
        colliderAreaDefaultY = collider.y;

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
        // We only want to do anything when we're pressing a key.
        if (keyhandler.upPressed || keyhandler.downPressed || keyhandler.leftPressed || keyhandler.rightPressed) {

            if (keyhandler.upPressed) {
                direction = "up";
            } else if (keyhandler.downPressed) {
                direction = "down";
            } else if (keyhandler.leftPressed) {
                direction = "left";
            } else if (keyhandler.rightPressed) {
                direction = "right";
            }

            collision = false;
            gamePanel.collisionChecker.checkTile(this);

            //Check item collection
            int itemIndex = gamePanel.collisionChecker.checkItem(this,true);
            pickUpItem(itemIndex);

            int trashIndex = gamePanel.collisionChecker.checkTrash(this,true);
            removeTrash(trashIndex);

            if (!collision) {
                switch (direction) {
                    case "up" -> position.y -= moveSpeed;
                    case "down" -> position.y += moveSpeed;
                    case "left" -> position.x -= moveSpeed;
                    case "right" -> position.x += moveSpeed;
                }
            }

            // Every frame we count up by one.
            spriteCounter++;
            // Making this animate the sprite at 0.2 seconds per sprite. (12 / 60 = 0.2)
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

    private void removeTrash(int trashIndex)
    {
        if (trashIndex != 999) {
            Item.ItemType itemType = gamePanel.trashCans[trashIndex].itemType;

            for (int i = 0; i < gamePanel.player.inventory.count(); i++)
            {
                if (gamePanel.player.inventory.get(i).itemType == itemType)
                {
                    gamePanel.player.inventory.remove(gamePanel.player.inventory.get(i));

                    if (gamePanel.player.inventory.count() == 0) {
                        for (int j = 0; j < gamePanel.items.length; j++)
                        {
                            if (gamePanel.items[j] != null)
                                return;
                        }
                        gamePanel.winCondition = true;
                    }
                }
            }
        }
    }

    public void pickUpItem(int i){
        if (i != 999){
            Item.ItemType itemType = gamePanel.items[i].itemType;

            switch (itemType)
            {
                case FOOD, PLASTIC, PAPER, GLASS, METAL -> {
                    inventory.add(gamePanel.items[i]);
                    gamePanel.items[i] = null;
                }
            }
        }
    }


    public void draw(Graphics2D g2)
    {
        BufferedImage image = null;

        switch (direction) {
            case "up" -> image = up[spriteNum];
            case "down" -> image = down[spriteNum];
            case "left" -> image = left[spriteNum];
            case "right" -> image = right[spriteNum];
        }

        g2.drawImage(image, screenPos.x, screenPos.y, null);
    }
}
