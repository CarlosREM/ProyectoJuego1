package adt;

import java.awt.image.BufferedImage;
import util.ImageResizer;

/**
 *
 * @author carlo
 */
public class Character {
    
    private BufferedImage image;
    private final int height, width;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Character(BufferedImage image, int height, int width) {
        this.image = ImageResizer.resize(image, height, width);
        this.height = height;
        this.width = width;
    }
    
}
