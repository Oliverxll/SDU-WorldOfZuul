package WorldOfZuul.TrashCans;

import WorldOfZuul.DataTypes.Item;
import WorldOfZuul.Utility.ImageLoader;

import java.io.IOException;

public class TrashCanBlue extends Item {

    public TrashCanBlue() {
        super("Blue trash can", ItemType.TRASHCAN);

        try {
            image = ImageLoader.getInstance().Load("/TrashCan/TrashCanBlue.png", 40, 40);

        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

