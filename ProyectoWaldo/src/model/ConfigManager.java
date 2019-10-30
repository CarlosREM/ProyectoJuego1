package model;

import util.JsonManager;
import adt.Character;
import adt.Scenario;
import adt.CharacterPrototypeFactory;
import adt.ScenarioPrototypeFactory;

import java.io.IOException;

/**
 *
 * @author Carlos Esquivel
 */
public class ConfigManager {
    
    private static final String JSON_PERSONAJES = "./src/config/personajes.json";
    private static final String JSON_ESCENARIOS = "./src/config/escenarios.json";

    
    public static void loadConfig() throws Exception {
        loadCharacters();
        loadScenarios();
    }
    
    private static void loadCharacters() throws Exception {
        Character[] characterArray = (Character[]) JsonManager.parseJsonFile(JSON_PERSONAJES, Character[].class);
        if (characterArray != null) {
            for (Character character : characterArray)
                CharacterPrototypeFactory.addPrototype(character.getNombre(), character);
        }
    }
    
    private static void loadScenarios() throws Exception {
        Scenario[] scenarioArray = (Scenario[]) JsonManager.parseJsonFile(JSON_ESCENARIOS, Scenario[].class);
        if (scenarioArray != null) {
            for (Scenario scenario : scenarioArray)
                ScenarioPrototypeFactory.addPrototype(scenario.getNombre(), scenario);
        }
    }
    
    
    public static void saveConfig() {
        try {
            JsonManager.saveJsonFile(getCharacterArray(), JSON_PERSONAJES);
            JsonManager.saveJsonFile(getScenarioArray(), JSON_ESCENARIOS);
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private static Character[] getCharacterArray() {
        Character[] characterArray = new Character[CharacterPrototypeFactory.getKeys().size()];
        int i = 0;
        for (String key : CharacterPrototypeFactory.getKeys()) {
            characterArray[i] = (Character) CharacterPrototypeFactory.getPrototype(key);
            i++;
        }
        return characterArray;
    }
    
    private static Scenario[] getScenarioArray() {
        Scenario[] scenarioArray = new Scenario[ScenarioPrototypeFactory.getKeys().size()];
        int i = 0;
        for (String key : ScenarioPrototypeFactory.getKeys()) {
            scenarioArray[i] = (Scenario) ScenarioPrototypeFactory.getPrototype(key);
            i++;
        }
        return scenarioArray;
    }
}
