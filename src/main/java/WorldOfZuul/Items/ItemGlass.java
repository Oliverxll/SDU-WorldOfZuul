package WorldOfZuul.Items;

import WorldOfZuul.DataTypes.Item;
import WorldOfZuul.Utility.ImageLoader;

import java.io.IOException;

public class ItemGlass extends Item {
    public ItemGlass() {
        super("Glass", ItemType.GLASS);

        try {
            image = ImageLoader.getInstance().Load("/objects/glass.png", 32,32);

        }catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
