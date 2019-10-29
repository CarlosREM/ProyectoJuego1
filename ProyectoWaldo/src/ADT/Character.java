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
    private final int height, width;
    private String nombre;
    private boolean isWaldo;
    private boolean useOnGeneration;

    public Character(Image image, int height, int width, String nombre, boolean isWaldo, boolean useOnGeneration) {
        this.image = image;
        this.height = height;
        this.width = width;
        this.nombre = nombre;
        this.isWaldo = isWaldo;
        this.useOnGeneration = useOnGeneration;
    }

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

    public boolean isIsWaldo() {
        return isWaldo;
    }

    public void setIsWaldo(boolean isWaldo) {
        this.isWaldo = isWaldo;
    }

    public boolean isUseOnGeneration() {
        return useOnGeneration;
    }

    public void setUseOnGeneration(boolean useOnGeneration) {
        this.useOnGeneration = useOnGeneration;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public IPrototype clone() {
        return new Character(this.getImage(), this.getHeight(), this.getWidth(), this.getNombre(), this.isIsWaldo(),this.isUseOnGeneration());
    }

    @Override
    public IPrototype deepClone() {
        return clone();
    }

}
