package WorldOfZuul;

import java.awt.*;

public class UI {
    GamePanel gamePanel;
    Graphics2D g2;

    public UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void drawInventory() {
        int frameX = gamePanel.UNIT_SIZE * 14;
        int frameY = gamePanel.UNIT_SIZE * 1;
        int frameHeight = gamePanel.UNIT_SIZE * 10;
        int frameWidth = gamePanel.UNIT_SIZE * 1;
        
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
    }

    public void drawSubWindow(int x, int y, int width, int height) {
        Color c = new Color(0,0,0, 150);

        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 20, 20);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke());
        g2.drawRoundRect(x, y, width, height, 20, 20);
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setColor(Color.white);

        if (gamePanel.keyHandler.showInventory) {
            drawInventory();
        }
    }
}
