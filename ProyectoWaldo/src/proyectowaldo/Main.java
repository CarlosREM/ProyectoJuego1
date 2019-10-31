package proyectowaldo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ConfigManager;

/**
 *
 * @author Fabricio Ceciliano
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Menu Principal - Where's Waldo Generator");
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ConfigManager.loadConfig();
            launch(args);
        }
        catch (Exception ex) {
            System.out.println("<ERROR> : Al cargar configuraciones");
        }
    }
       
}
