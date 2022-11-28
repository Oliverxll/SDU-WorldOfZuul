package WorldOfZuul;

import WorldOfZuul.DataTypes.Item;
import WorldOfZuul.Items.*;

public class AssetSetter extends Item {
    GamePanel gamePanel;
    public AssetSetter(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void setObject (){
        gamePanel.superItems[0]= new ItemApple();
        gamePanel.superItems[0].position.x= 25 * gamePanel.UNIT_SIZE;
        gamePanel.superItems[0].position.y= 5 * gamePanel.UNIT_SIZE;

        gamePanel.superItems[1]= new ItemCan();
        gamePanel.superItems[1].position.x= 25*gamePanel.UNIT_SIZE;
        gamePanel.superItems[1].position.y= 43 * gamePanel.UNIT_SIZE;

        gamePanel.superItems[2]= new ItemGlass();
        gamePanel.superItems[2].position.x= 25*gamePanel.UNIT_SIZE;
        gamePanel.superItems[2].position.y= 25 * gamePanel.UNIT_SIZE;

        gamePanel.superItems[3]= new ItemPaper();
        gamePanel.superItems[3].position.x= 5*gamePanel.UNIT_SIZE;
        gamePanel.superItems[3].position.y= 25 * gamePanel.UNIT_SIZE;

        gamePanel.superItems[4]= new ItemPlastic();
        gamePanel.superItems[4].position.x= 43*gamePanel.UNIT_SIZE;
        gamePanel.superItems[4].position.y= 25 * gamePanel.UNIT_SIZE;
    }
}
