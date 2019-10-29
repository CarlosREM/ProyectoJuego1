package ADT;

import Patterns.PrototypeFactory;
import java.util.ArrayList;

/**
 *
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 */

public class GeneratorManager {
    public static ArrayList<Character> generateCharacter(String characterKey, int amount){
        ArrayList<Character> charactersList = new ArrayList<>();
        for(int i=0; i<amount; i++){
            Character character = (Character)PrototypeFactory.getCharacterPrototype(characterKey);
            charactersList.add(character);
        }
        return charactersList;
    }
}
