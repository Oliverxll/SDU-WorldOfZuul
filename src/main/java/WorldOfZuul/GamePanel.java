package WorldOfZuul;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {// GamePanel is a subclass to JPanel

    // SCREEN SETTINGS
    final int UNIT_SIZE_UNSCALED = 16; //16x16 Tile
    final int SCALE = 4;
    final int UNIT_SIZE = UNIT_SIZE_UNSCALED * SCALE; // Make it 64-bit. This will make things scale up n size it fit screen


    //We decide the size of the game screen
    final int maxScreenCol = 16; //Horizontally
    final int maxScreenRow = 12; // Vertically

    final int ScreenWidth = UNIT_SIZE * maxScreenCol; // 64* 16 = 1024 pixels
    final int ScreenHeight = UNIT_SIZE * maxScreenRow; //64 * 12 = 768 pixels
    //The size of our game screen will then be 1024 x 768 pixels


    //FPS
    int FPS = 60;

    //instantiate the keyHandler
    KeyHandler keyH = new KeyHandler();


    //When we call this thread it will automatically call the run method further below
    Thread gameThread; // Makes it possible to start and stop a game. To use Thread we implement "Runnable" to this class


    //Set players default possition
    int playerX = 80;
    int playerY = 80;
    int playerSpeed = 4; //This mean 4 pixels. Så the player will move 4 pixels every time they move

    //Constructor
    public GamePanel() {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));//Sets the size of this class
        this.setBackground(Color.BLACK); //Sets the background color to black
        this.addKeyListener(keyH); //Makes the game panel recognize the key input
        this.setFocusable(true); // This makes the game panel focused on key input
    }


    //We initiate thread. "(this)" is the class gamePanel
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start(); //It will automatically call the run method
    }


    //This is a method that we get recommended when implementing "Runnable" to the class
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;  //It will draw on the screen every 0,016 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;


        //As long as this game loop continues it will update and repaint
        while (gameThread != null) {

            //Update information such as characters position
            update();

            //Draw the screen with the updated information
            repaint();


            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    public void update() {
        if (keyH.upPressed == true) {
            playerY -= playerSpeed;
        } else if (keyH.downPressed == true) {
            playerY += playerSpeed;
        } else if (keyH.leftPressed == true) {
            playerX -= playerSpeed;
        } else if (keyH.rightPressed == true) {
            playerX += playerSpeed;

        }

    }

    //"paintComponent" is a builtin method in Java. The class "graphics" can draw objects on screen
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //The graphics2D extend the graphics class. So we change the graphics g to graphics 2D
        Graphics2D g2 = (Graphics2D) g;


        //This makes a white rectangle.
        g2.setColor(Color.white);

        //This is the coordinates and size
        g2.fillRect(playerX, playerY, UNIT_SIZE, UNIT_SIZE);

        g2.dispose();

    }
}
