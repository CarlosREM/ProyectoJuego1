/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patterns;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Fabricio Ceciliano
 */
public class PrototypeFactory {
    private static HashMap<String, IPrototype> characterPrototypes = new HashMap<>();
    private static HashMap<String, IPrototype> scenarioPrototypes = new HashMap<>();
    
    public static IPrototype getCharacterPrototype(String prototypeName){
        return characterPrototypes.get(prototypeName).clone();
    }
    
    public static void addCharacterPrototype(String prototypeName, IPrototype prototype){
        characterPrototypes.put(prototypeName, prototype);
    }
    
    public static void removeCharacterPrototype(String prototypeName){
        characterPrototypes.remove(prototypeName);
    }
    
    public static void removeAllCharacters(){
        characterPrototypes.clear();
    }
    
    public static Set<String> getCharacterKeys() {
        return characterPrototypes.keySet();
    }
    
    public static IPrototype getScenarioPrototype(String prototypeName){
        return characterPrototypes.get(prototypeName).clone();
    }
    
    public static void addScenarioPrototype(String prototypeName, IPrototype prototype){
        characterPrototypes.put(prototypeName, prototype);
    }
    
    public static void removeScenarioPrototype(String prototypeName){
        characterPrototypes.remove(prototypeName);
    }
    
    public static void removeAllScenarios(){
        characterPrototypes.clear();
    }
    
    public static Set<String> getScenarioKeys() {
        return scenarioPrototypes.keySet();
    }
}
