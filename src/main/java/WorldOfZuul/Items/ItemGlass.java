package WorldOfZuul.Items;

import WorldOfZuul.Utility.ImageLoader;

import java.io.IOException;

public class ItemGlass extends SuperItem{
    public ItemGlass() {
        name = "Can";

        try {
            image = ImageLoader.getInstance().Load("/objects/can.png", 32,32);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
