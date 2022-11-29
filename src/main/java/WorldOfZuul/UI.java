package WorldOfZuul;

import WorldOfZuul.DataTypes.Position;

import java.awt.*;

public class UI {
    GamePanel gamePanel;
    Graphics2D g2;

    Font arial_40;

    public UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        arial_40 = new Font("Arial", Font.PLAIN, 30);
    }

    public void drawInventory() {
        Rectangle frame = new Rectangle(gamePanel.UNIT_SIZE * 14, gamePanel.UNIT_SIZE * 1,
                                        gamePanel.UNIT_SIZE * 1, gamePanel.UNIT_SIZE * 10);
        
        drawSubWindow(frame.x, frame.y, frame.width, frame.height);

        // SLOTS
        final Position slotStart = new Position(frame.x + 20, frame.y + 20);
        Position slot = new Position(slotStart);

        for (int i = 0; i < gamePanel.player.inventory.count(); i++)
        {
            g2.drawImage(gamePanel.player.inventory.get(i).image, slot.x, slot.y,null);

            slot.y += gamePanel.UNIT_SIZE;
        }
    }

    private void drawWinCondition()
    {
        Rectangle frame = new Rectangle(gamePanel.UNIT_SIZE * 4, gamePanel.UNIT_SIZE * 5,
                                        gamePanel.UNIT_SIZE * 8, gamePanel.UNIT_SIZE * 2);


        drawSubWindow(frame.x, frame.y, frame.width, frame.height);

        g2.drawString("You collected and sorted all the trash!", frame.x + 10, frame.y + frame.height - (frame.height - 40));
        g2.drawString("Congratulations, you win!", frame.x + 90, frame.y + frame.height - (frame.height - 100));
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
        g2.setFont(arial_40);

        g2.setColor(Color.white);

        if (gamePanel.keyHandler.showInventory) {
            drawInventory();
        }

        if (gamePanel.winCondition) {
            drawWinCondition();
        }
    }
}
