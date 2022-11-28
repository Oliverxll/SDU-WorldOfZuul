package WorldOfZuul.Items;

import WorldOfZuul.Utility.ImageLoader;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ItemKey extends SuperItem {
    public ItemKey() {
        name = "plastic";

        try {
            image = ImageLoader.getInstance().Load("/Objects/apple.png", 32,32);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
