package adt;

import Patterns.IPrototype;
import javafx.scene.image.Image;

/**
 *
 * @author Carlos Esquivel
 * @author Fabricio Ceciliano
 */
public class Character implements IPrototype {
    
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
    
    @Override
    public IPrototype clone() {
        return new Character(this.getImage(), this.getNombre(), this.getHeight(), this.getWidth());
    }

    @Override
    public IPrototype deepClone() {
        return clone();
    }
}
