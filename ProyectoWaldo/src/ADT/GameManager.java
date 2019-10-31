/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Fabricio Ceciliano
 */
public class GameManager {
    private int currentFoundCharacters = 0;
    private int maxCharacters = 0;
    
    private static GameManager instance = null;
    
    private GameManager(){ }
    
    public static GameManager getInstance(){
        if(instance == null){
            instance = new GameManager();
        }
        return instance;
    }

    public int getCurrentFoundCharacters() {
        return currentFoundCharacters;
    }

    public void setCurrentFoundCharacters(int currentFoundCharacters) {
        this.currentFoundCharacters = currentFoundCharacters;
    }

    public int getMaxCharacters() {
        return maxCharacters;
    }

    public void setMaxCharacters(int maxCharacters) {
        this.maxCharacters = maxCharacters;
    }    
}
