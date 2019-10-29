package model;

import Patterns.PrototypeFactory;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import util.JsonManager;
import adt.Character;
import adt.Scenario;
import java.io.IOException;

/**
 *
 * @author Carlos Esquivel
 */
public class ConfigManager {
    
    private static final String JSON_PERSONAJES = "./src/config/personajes.json";
    private static final String JSON_ESCENARIOS = "./src/config/escenarios.json";

    
    public static void loadConfig() throws FileNotFoundException {
        loadCharacters();
        loadScenarios();
    }
    
    private static void loadCharacters() throws FileNotFoundException {
        Type formListType = new TypeToken<ArrayList<Character>>() {}.getType();
        ArrayList<Character> characterArray = (ArrayList<Character>) JsonManager.parseJsonFile(JSON_PERSONAJES, formListType);
        for (Character character : characterArray)
            PrototypeFactory.addCharacterPrototype(character.getNombre(), character);
    }
    
    private static void loadScenarios() throws FileNotFoundException {
        Type formListType = new TypeToken<ArrayList<Scenario>>() {}.getType();
        ArrayList<Scenario> scenarioArray = (ArrayList<Scenario>) JsonManager.parseJsonFile(JSON_ESCENARIOS, formListType);
        for (Scenario scenario : scenarioArray)
            PrototypeFactory.addScenarioPrototype(scenario.getNombre(), scenario);
    }
    
    
    public static void saveConfig() throws IOException {
        JsonManager.saveJsonFile(getCharacterArray(), JSON_PERSONAJES);
        JsonManager.saveJsonFile(getScenarioArray(), JSON_ESCENARIOS);
    }
    
    private static ArrayList<Character> getCharacterArray() {
        ArrayList<Character> characterArray = new ArrayList<>();
        for (String key : PrototypeFactory.getCharacterKeys())
            characterArray.add((Character) PrototypeFactory.getCharacterPrototype(key));
        return characterArray;
    }
    
    private static ArrayList<Scenario> getScenarioArray() {
        ArrayList<Scenario> scenarioArray = new ArrayList<>();
        for (String key : PrototypeFactory.getScenarioKeys())
            scenarioArray.add((Scenario) PrototypeFactory.getScenarioPrototype(key));
        return scenarioArray;    
    }
}
