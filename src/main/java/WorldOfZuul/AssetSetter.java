package WorldOfZuul;

import WorldOfZuul.DataTypes.Item;
import WorldOfZuul.Items.*;

public class AssetSetter extends Item {
    GamePanel gamePanel;
    public AssetSetter(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void setObject (){
        gamePanel.items[0]= new ItemApple();
        gamePanel.items[0].position.x = 25 * gamePanel.UNIT_SIZE;
        gamePanel.items[0].position.y = 5 * gamePanel.UNIT_SIZE;

        gamePanel.items[1]= new ItemCan();
        gamePanel.items[1].position.x = 25 * gamePanel.UNIT_SIZE;
        gamePanel.items[1].position.y = 43 * gamePanel.UNIT_SIZE;

        gamePanel.items[2]= new ItemGlass();
        gamePanel.items[2].position.x = 25 * gamePanel.UNIT_SIZE;
        gamePanel.items[2].position.y = 25 * gamePanel.UNIT_SIZE;

        gamePanel.items[3]= new ItemPaper();
        gamePanel.items[3].position.x = 5 * gamePanel.UNIT_SIZE;
        gamePanel.items[3].position.y = 25 * gamePanel.UNIT_SIZE;

        gamePanel.items[4]= new ItemPlastic();
        gamePanel.items[4].position.x = 43 *gamePanel.UNIT_SIZE;
        gamePanel.items[4].position.y = 25 * gamePanel.UNIT_SIZE;
    }
}
