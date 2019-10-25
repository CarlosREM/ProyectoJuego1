/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patterns;

import java.util.HashMap;

/**
 *
 * @author Fabricio Ceciliano
 */
public class PrototypeFactory {
    private static HashMap<String, IPrototype> prototypes = new HashMap<>();
    
    public static IPrototype getPrototype(String prototypeName){
        return prototypes.get(prototypeName).clone();
    }
    
    public static void addProtype(String prototypeName, IPrototype prototype){
        prototypes.put(prototypeName, prototype);
    }
}
