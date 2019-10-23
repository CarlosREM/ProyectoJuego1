package util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author carlo
 */
public class ImageResizer {
    
    public static BufferedImage resize(BufferedImage image, int newHeight, int newWidth) {
        Image tmp = image.getScaledInstance(newHeight, newWidth, Image.SCALE_SMOOTH);
        image = new BufferedImage(newHeight, newWidth, BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D g2d = image.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return image;
    }
}
