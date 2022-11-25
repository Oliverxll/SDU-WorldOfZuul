package WorldOfZuul;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyHandler implements KeyListener { //keylistener receives keyboard events.
    //It then wants us to implement the methods: keyTyped, keyPressed and keyReleased

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); //It returns the integer key code associated with the key pressed

        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            rightPressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            leftPressed = false;
        }

        if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            rightPressed = false;
        }

    }

    enum MoveDirection {
        UP, DOWN, LEFT, RIGHT, NOTHING
    }

}
