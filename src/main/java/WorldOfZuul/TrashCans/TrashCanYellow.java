package WorldOfZuul.TrashCans;

import WorldOfZuul.DataTypes.Item;
import WorldOfZuul.Utility.ImageLoader;

import java.io.IOException;

public class TrashCanYellow extends Item {
    public TrashCanYellow() {
        super("Yellow trash can", ItemType.TRASHCAN);

        try {
            image = ImageLoader.getInstance().Load("/TrashCan/TrashCanYellow.png", 40, 40);

        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }

}
