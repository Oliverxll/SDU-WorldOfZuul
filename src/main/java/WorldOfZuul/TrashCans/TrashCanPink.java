package WorldOfZuul.TrashCans;

import WorldOfZuul.DataTypes.Item;
import WorldOfZuul.GamePanel;
import WorldOfZuul.TrashCan;
import WorldOfZuul.Utility.ImageLoader;

import java.io.IOException;

public class TrashCanPink extends TrashCan
{
    public TrashCanPink(GamePanel gamePanel) {
        super(gamePanel, Item.ItemType.PLASTIC);

        try {
            image = ImageLoader.getInstance().Load("/TrashCan/TrashCanPink.png", 64, 64);

        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
