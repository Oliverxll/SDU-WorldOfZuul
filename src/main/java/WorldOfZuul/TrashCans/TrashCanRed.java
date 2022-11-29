package WorldOfZuul.TrashCans;

import WorldOfZuul.DataTypes.Item;
import WorldOfZuul.Utility.ImageLoader;

import java.io.IOException;

public class TrashCanRed extends  Item{
    public TrashCanRed() {
        super("Red trash can", Item.ItemType.TRASHCAN);

        try {
            image = ImageLoader.getInstance().Load("/TrashCan/TrashCanRed.png", 40, 40);

        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
