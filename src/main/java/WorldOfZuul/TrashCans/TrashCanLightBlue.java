package WorldOfZuul.TrashCans;

import WorldOfZuul.DataTypes.Item;
import WorldOfZuul.GamePanel;
import WorldOfZuul.TrashCan;
import WorldOfZuul.Utility.ImageLoader;

import java.io.IOException;

public class TrashCanLightBlue extends TrashCan
{
    public TrashCanLightBlue(GamePanel gamePanel) {
        super(gamePanel, Item.ItemType.GLASS);

        try {
            image = ImageLoader.getInstance().Load("/TrashCan/TrashCanLightBlue.png", 64, 64);

        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
