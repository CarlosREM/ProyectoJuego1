package ADT;

import adt.Character;
import adt.CharacterPrototypeFactory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 */

public class GeneratorManager {
    public static List<Character> generateCharacter(String characterKey, int amount){
        List<Character> charactersList = new ArrayList<>();
        Character character;
        for(int i=0; i<amount; i++){
            character = (Character) CharacterPrototypeFactory.getPrototype(characterKey);
            charactersList.add(character);
        }
        return charactersList;
    }
}
