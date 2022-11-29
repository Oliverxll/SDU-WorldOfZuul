package WorldOfZuul;

import WorldOfZuul.DataTypes.Item;
import WorldOfZuul.Items.*;
import WorldOfZuul.TrashCans.*;

public class AssetSetter extends Item {
    GamePanel gamePanel;
    public AssetSetter(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void setObject (){
        gamePanel.items[0]= new ItemApple();
        gamePanel.items[0].position.x = 21 * gamePanel.UNIT_SIZE;
        gamePanel.items[0].position.y = 7 * gamePanel.UNIT_SIZE;

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

    public void setTrashCan(){
        gamePanel.items[5]= new TrashCanBlue();
        gamePanel.items[5].position.x = 26 *gamePanel.UNIT_SIZE;
        gamePanel.items[5].position.y = 5 * gamePanel.UNIT_SIZE;

        gamePanel.items[6]= new TrashCanGreen();
        gamePanel.items[6].position.x = 26 *gamePanel.UNIT_SIZE;
        gamePanel.items[6].position.y = 35 * gamePanel.UNIT_SIZE;

        gamePanel.items[7]= new TrashCanPink();
        gamePanel.items[7].position.x = 29 *gamePanel.UNIT_SIZE;
        gamePanel.items[7].position.y = 26 * gamePanel.UNIT_SIZE;

        gamePanel.items[8]= new TrashCanLightBlue();
        gamePanel.items[8].position.x = 18 *gamePanel.UNIT_SIZE;
        gamePanel.items[8].position.y = 21 * gamePanel.UNIT_SIZE;

        gamePanel.items[9]= new TrashCanWhite();
        gamePanel.items[9].position.x = 40 *gamePanel.UNIT_SIZE;
        gamePanel.items[9].position.y = 21 * gamePanel.UNIT_SIZE;

    }
}
