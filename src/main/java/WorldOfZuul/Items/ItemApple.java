package WorldOfZuul.Items;

import WorldOfZuul.Utility.ImageLoader;

import java.io.IOException;

public class ItemApple extends SuperItem {
    public ItemApple() {
        name = "plastic";

        try {
            image = ImageLoader.getInstance().Load("/objects/apple.png", 32,32);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
