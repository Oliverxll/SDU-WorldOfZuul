package WorldOfZuul.TrashCans;

import WorldOfZuul.DataTypes.Item;
import WorldOfZuul.Utility.ImageLoader;

import java.io.IOException;

public class TrashCanWhite extends Item{
    public TrashCanWhite() {
        super("White trash can", Item.ItemType.TRASHCAN);

        try {
            image = ImageLoader.getInstance().Load("/TrashCan/TrashCanWhite.png", 40, 40);

        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
