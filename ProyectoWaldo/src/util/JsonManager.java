package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Carlos Esquivel
 * @author Fabricio Ceciliano
 */
public class JsonManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    public static Object parseJsonFile(String dir, Class objClass) throws FileNotFoundException {
        return GSON.fromJson(new FileReader(dir), objClass);
    }
    
    public static void saveJsonFile(Object obj, String dir) throws IOException {
        try (FileWriter fw = new FileWriter(dir)) {
            GSON.toJson(obj, fw);
            fw.flush();
        }
    }
}
