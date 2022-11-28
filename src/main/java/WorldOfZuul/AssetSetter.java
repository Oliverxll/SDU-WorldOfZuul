package WorldOfZuul;

import WorldOfZuul.Items.ItemApple;

public class AssetSetter {
    GamePanel gamePanel;
    public AssetSetter(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void setObject (){
        gamePanel.superItems[0]= new ItemApple();
        gamePanel.superItems[0].worldX = 25 * gamePanel.UNIT_SIZE;
        gamePanel.superItems[0].worldY = 5 * gamePanel.UNIT_SIZE;

        gamePanel.superItems[1]= new ItemApple();
        gamePanel.superItems[1].worldX = 25*gamePanel.UNIT_SIZE;
        gamePanel.superItems[1].worldY = 43 * gamePanel.UNIT_SIZE;
    }
}
