package adt;

import Patterns.IPrototype;

/**
 *
 * @author Carlos Esquivel
 * @author Fabricio Ceciliano
 */
public class Character implements IPrototype<Character> {
    
    private String image;
    private final int height, width;
    private String nombre;
    private boolean isWaldo;
    private boolean useOnGeneration;

    public Character(String image, int height, int width, String nombre, boolean isWaldo, boolean useOnGeneration) {
        this.image = image;
        this.height = height;
        this.width = width;
        this.nombre = nombre;
        this.isWaldo = isWaldo;
        this.useOnGeneration = useOnGeneration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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
    public Character clone() {
        return new Character(this.getImage(), this.getHeight(), this.getWidth(), this.getNombre(), this.isIsWaldo(),this.isUseOnGeneration());
    }

    @Override
    public Character deepClone() {
        
        return this.clone();
    }
    
   

}
