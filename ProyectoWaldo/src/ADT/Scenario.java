package adt;

import Patterns.IPrototype;
import javafx.scene.image.Image;

/**
 *
 * @author Carlos Esquivel
 * @author Fabricio Ceciliano
 */
public class Scenario implements IPrototype<Scenario> {
    
    private String nombre;
    private String image;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Scenario(String nombre, String image) {
        this.nombre = nombre;
        this.image = image;
    }

    @Override
    public Scenario clone() {
        return new Scenario(this.getNombre(), this.getImage());
    }

    @Override
    public Scenario deepClone() {
        return this.clone();
    }
}
