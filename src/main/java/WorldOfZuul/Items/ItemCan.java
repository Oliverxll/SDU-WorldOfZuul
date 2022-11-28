package WorldOfZuul.Items;

import WorldOfZuul.Utility.ImageLoader;

import java.io.IOException;

public class ItemCan extends SuperItem{
    public ItemCan() {
        name = "Can";

        try {
            image = ImageLoader.getInstance().Load("/objects/apple.png", 32,32);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
