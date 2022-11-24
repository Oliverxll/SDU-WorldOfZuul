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


    //When we call this thread it will automatically call the run method further below
    Thread gameThread; // Makes it possible to start and stop a game. To use Thread we implement "Runnable" to this class

    //Constructor
    public GamePanel() {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));//Sets the size of this class
        this.setBackground(Color.BLACK); //Sets the background color to black
    }


    //We initiate thread. "(this)" is the class gamePanel
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start(); //It will automatically call the run method
    }


    //This is a method that we get recommended when implementing "Runnable" to the class
    @Override
    public void run() {

    }
}
