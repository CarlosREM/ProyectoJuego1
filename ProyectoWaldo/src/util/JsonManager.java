package util;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author Carlos Esquivel
 * @author Fabricio Ceciliano
 */
public class JsonManager {
    private static final Gson GSON = new Gson();
    
    public static Object parseJsonFile(String dir, Class objClass) throws FileNotFoundException {
        return GSON.fromJson(new FileReader(dir), objClass);
    }
    
    public static Object parseJsonFile(String dir, Type classType) throws FileNotFoundException {
        return GSON.fromJson(new FileReader(dir), classType);
    }
    
    public static void saveJsonFile(Object obj, String dir) throws IOException {
        GSON.toJson(obj, new FileWriter(dir));
    }
    
    public static void saveJsonFile(ArrayList<?> list, String dir) throws IOException {
        GSON.toJson(list, new FileWriter(dir));
    }
}
