package WorldOfZuul.Items;

import WorldOfZuul.DataTypes.Item;
import WorldOfZuul.Utility.ImageLoader;

import java.io.IOException;

public class ItemPaper extends Item {
    public ItemPaper() {
        super("Paper", ItemType.PAPER);

        try {
            image = ImageLoader.getInstance().Load("/objects/paper.png", 32,32);

        }catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}