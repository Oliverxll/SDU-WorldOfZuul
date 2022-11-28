package WorldOfZuul.Items;

import WorldOfZuul.DataTypes.Item;
import WorldOfZuul.Utility.ImageLoader;

import java.io.IOException;

public class ItemPlastic extends Item {
    public ItemPlastic() {
        name = "Plastic";

        try {
            image = ImageLoader.getInstance().Load("/objects/plastic.png", 32,32);

        }catch (IOException e) {
            e.printStackTrace();
        }
        collision=true;
    }
}

