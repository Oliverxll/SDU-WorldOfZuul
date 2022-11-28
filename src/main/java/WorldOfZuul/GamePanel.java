package WorldOfZuul;

import WorldOfZuul.DataTypes.Item;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {// GamePanel is a subclass to JPanel

    // SCREEN SETTINGS
    final int UNIT_SIZE_UNSCALED = 16; //16x16 Tile
    final int SCALE = 4;
    public final int UNIT_SIZE = UNIT_SIZE_UNSCALED * SCALE; // Make it 64-bit. This will make things scale up n size it fit screen
    final int maxScreenCol = 16; //Horizontally
    final int maxScreenRow = 12; // Vertically
    final int screenWidth = maxScreenCol * UNIT_SIZE; // 64 * 16 = 1024 pixels
    final int screenHeight = maxScreenRow * UNIT_SIZE; //64 * 12 = 768 pixels
    //The size of our game screen will then be 1024 x 768 pixels

    // WORLD SETTINGS
    public final int maxWorldCol = 48;
    public final int maxWorldRow = 48;
    public final int worldWidth = maxWorldCol * UNIT_SIZE;
    public final int worldHeight = maxWorldRow * UNIT_SIZE;

    //FPS
    int FPS = 60;

    CollisionChecker collisionChecker = new CollisionChecker(this);
    TileManager tileManager = new TileManager(this);
    //instantiate the keyHandler
    KeyHandler keyHandler = new KeyHandler();
    //When we call this thread it will automatically call the run method further below
    Thread gameThread; // Makes it possible to start and stop a game. To use Thread we implement "Runnable" to this class
    //Instantiate the player class
    public AssetSetter assetSetter = new AssetSetter(this);
    public Player player = new Player(this, keyHandler);
    public Item superItems [] = new Item[10];

    //Constructor
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));//Sets the size of this class
        this.setBackground(Color.BLACK); //Sets the background color to black
        this.addKeyListener(keyHandler); //Makes the game panel recognize the key input
        this.setFocusable(true); // This makes the game panel focused on key input
    }

    public void setUpGame (){
        assetSetter.setObject();
    }


    //We initiate thread. "(this)" is the class gamePanel
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start(); //It will automatically call the run method
    }


    //This is a method that we get recommended when implementing "Runnable" to the class
    @Override
    public void run() {
        double drawInterval = 1000000000f / FPS;  //It will draw on the screen every 0,016 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        // FPS Debug variables.
        long timer = 0;
        int drawCount = 0;

        //As long as this game loop continues it will update and repaint
        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1)
            {
                //Update information such as characters position
                update();

                //Draw the screen with the updated information
                repaint();

                delta--;
                drawCount++;
            }

            // FPS debug console logging.
            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer -= 1000000000;
            }
        }
    }

    public void update() {
        player.update();

    }

    //"paintComponent" is a builtin method in Java. The class "graphics" can draw objects on screen
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //The graphics2D extend the graphics class. So we change the graphics g to graphics 2D
        Graphics2D g2 = (Graphics2D) g;

        //Tile
        tileManager.draw(g2);

        //Objects
        for (int i = 0; i< superItems.length;i++){
            if (superItems[i]!=null){
                superItems[i].draw(g2,this);
            }
        }

        //Player
        player.draw(g2);

        g2.dispose();
    }
}
