package adt;

import Patterns.IPrototype;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 */
public class CharacterPrototypeFactory {
    private static final HashMap<String, IPrototype> prototypes = new HashMap<>();
    
    public static IPrototype getPrototype(String prototypeName){
        return prototypes.get(prototypeName).deepClone();
    }
    
    public static void addPrototype(String prototypeName, IPrototype prototype){
        prototypes.put(prototypeName, prototype);
    }
    
    public static void removePrototype(String prototypeName){
        prototypes.remove(prototypeName);
    }
    
    public static void removeAll(){
        prototypes.clear();
    }
    
    public static Set<String> getKeys() {
        return prototypes.keySet();
    }
}
