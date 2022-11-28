package WorldOfZuul.Items;

import WorldOfZuul.DataTypes.Item;
import WorldOfZuul.Utility.ImageLoader;

import java.io.IOException;

public class ItemCan extends Item {
    public ItemCan() {
        name = "Can";

        try {
            image = ImageLoader.getInstance().Load("/objects/can.png", 32,32);

        }catch (IOException e) {
            e.printStackTrace();
        }
        collision=true;
    }
}
