package WorldOfZuul.Utility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader
{
    private static ImageLoader instance = new ImageLoader();

    private ImageLoader() { } // Private = No one can instantiate it.

    public static ImageLoader getInstance()
    {
        return instance;
    }

    public BufferedImage Load(String path, int width, int height) throws IOException
    {
        BufferedImage oldImage = ImageIO.read(getClass().getResourceAsStream(path));

        BufferedImage newImage = new BufferedImage(width, height, oldImage.getType());
        Graphics2D g2 = newImage.createGraphics(); // Creates a Graphics2D, can be used to draw into this BufferedImage (newImage).
        g2.drawImage(oldImage, 0, 0, width, height, null);
        g2.dispose();

        return newImage;
    }
}
