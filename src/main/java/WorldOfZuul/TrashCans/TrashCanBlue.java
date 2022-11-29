package WorldOfZuul.TrashCans;

import WorldOfZuul.DataTypes.Item;
import WorldOfZuul.GamePanel;
import WorldOfZuul.TrashCan;
import WorldOfZuul.Utility.ImageLoader;

import java.io.IOException;

public class TrashCanBlue extends TrashCan
{

    public TrashCanBlue(GamePanel gamePanel) {
        super(gamePanel, Item.ItemType.PAPER);

        try {
            image = ImageLoader.getInstance().Load("/TrashCan/TrashCanBlue.png", 64, 64);

        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

