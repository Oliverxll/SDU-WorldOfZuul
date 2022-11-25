package WorldOfZuul;


import javax.swing.*;

public class Main{


    public static void main(String[] args) {

        JFrame window = new JFrame(); //Makes the JFrame window. This is our main window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Makes the game close properly when clicking (X)
        window.setResizable(false);// The user can't change the size of the window
        window.setTitle("World of Garbage"); //Set the title of the window

       // We add the GamePanel class to main
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack(); // "pack()" makes the window the size that we set in GamePanel



        window.setLocationRelativeTo(null);// Places the window in the center of the screen
        window.setVisible(true);//So we can se window

        gamePanel.startGameThread();




    }
}