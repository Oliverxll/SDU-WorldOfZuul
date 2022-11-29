package WorldOfZuul.TrashCans;

import WorldOfZuul.DataTypes.Item;
import WorldOfZuul.GamePanel;
import WorldOfZuul.TrashCan;
import WorldOfZuul.Utility.ImageLoader;

import java.io.IOException;

public class TrashCanGreen extends TrashCan
{
    public TrashCanGreen(GamePanel gamePanel) {
        super(gamePanel, Item.ItemType.FOOD);

        try {
            image = ImageLoader.getInstance().Load("/TrashCan/TrashCanGreen.png", 64, 64);

        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
