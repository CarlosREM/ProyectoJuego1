package adt;

import javafx.scene.image.Image;

/**
 *
 * @author carlo
 */
public class Character {
    
    private Image image;
    private String nombre;
    private final int height, width;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Character(Image image, String nombre, int height, int width) {
        this.image = image;
        this.nombre = nombre;
        this.height = height;
        this.width = width;
    }
}
