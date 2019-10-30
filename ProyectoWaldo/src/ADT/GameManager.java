/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author Fabricio Ceciliano
 */
public class GameManager {
    private static int currentFoundCharacters = 0;
    private static int maxCharacters = 0;
    
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
        GameManager.currentFoundCharacters = currentFoundCharacters;
    }

    public int getMaxCharacters() {
        return maxCharacters;
    }

    public void setMaxCharacters(int maxCharacters) {
        GameManager.maxCharacters = maxCharacters;
    }    
}
