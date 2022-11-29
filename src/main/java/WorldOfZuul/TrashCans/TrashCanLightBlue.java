package WorldOfZuul.TrashCans;

import WorldOfZuul.DataTypes.Item;
import WorldOfZuul.Utility.ImageLoader;

import java.io.IOException;

public class TrashCanLightBlue extends Item{
    public TrashCanLightBlue() {
        super("Light blue trash can for glass", Item.ItemType.TRASHCAN);

        try {
            image = ImageLoader.getInstance().Load("/TrashCan/TrashCanLightBlue.png", 40, 40);

        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
