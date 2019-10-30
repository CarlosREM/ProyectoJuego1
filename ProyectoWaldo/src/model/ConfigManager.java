package model;

import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;

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
        Type formListType = new TypeToken<ArrayList<Character>>() {}.getType();
        ArrayList<Character> characterArray = (ArrayList<Character>) JsonManager.parseJsonFile(JSON_PERSONAJES, formListType);
        if (characterArray != null) {
            for (Character character : characterArray)
                CharacterPrototypeFactory.addPrototype(character.getNombre(), character);
        }
    }
    
    private static void loadScenarios() throws Exception {
        Type formListType = new TypeToken<ArrayList<Scenario>>() {}.getType();
        ArrayList<Scenario> scenarioArray = (ArrayList<Scenario>) JsonManager.parseJsonFile(JSON_ESCENARIOS, formListType);
        if (scenarioArray != null) {
            for (Scenario scenario : scenarioArray)
                ScenarioPrototypeFactory.addPrototype(scenario.getNombre(), scenario);
        }
    }
    
    
    public static void saveConfig() throws IOException {
        JsonManager.saveJsonFile(getCharacterArray(), JSON_PERSONAJES);
        JsonManager.saveJsonFile(getScenarioArray(), JSON_ESCENARIOS);
    }
    
    private static ArrayList<Character> getCharacterArray() {
        ArrayList<Character> characterArray = new ArrayList<>();
        for (String key : CharacterPrototypeFactory.getKeys())
            characterArray.add((Character) CharacterPrototypeFactory.getPrototype(key));
        return characterArray;
    }
    
    private static ArrayList<Scenario> getScenarioArray() {
        ArrayList<Scenario> scenarioArray = new ArrayList<>();
        for (String key : CharacterPrototypeFactory.getKeys())
            scenarioArray.add((Scenario) CharacterPrototypeFactory.getPrototype(key));
        return scenarioArray;    
    }
}
