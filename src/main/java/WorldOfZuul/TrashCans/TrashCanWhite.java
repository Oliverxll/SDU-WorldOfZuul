package WorldOfZuul.TrashCans;

import WorldOfZuul.DataTypes.Item;
import WorldOfZuul.GamePanel;
import WorldOfZuul.TrashCan;
import WorldOfZuul.Utility.ImageLoader;

import java.io.IOException;

public class TrashCanWhite extends TrashCan
{
    public TrashCanWhite(GamePanel gamePanel) {
        super(gamePanel, Item.ItemType.METAL);

        try {
            image = ImageLoader.getInstance().Load("/TrashCan/TrashCanWhite.png", 64, 64);

        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}
