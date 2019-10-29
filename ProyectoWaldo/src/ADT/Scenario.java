package adt;

import Patterns.IPrototype;
import javafx.scene.image.Image;

/**
 *
 * @author Carlos Esquivel
 * @author Fabricio Ceciliano
 */
public class Scenario implements IPrototype {
    
    private String nombre;
    private Image image;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Scenario(String nombre, Image image) {
        this.nombre = nombre;
        this.image = image;
    }

    public Scenario() {}

    @Override
    public IPrototype clone() {
    return this;
    }

    @Override
    public IPrototype deepClone() {
        return clone();
    }
}
