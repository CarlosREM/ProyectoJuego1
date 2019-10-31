package proyectowaldo;

import adt.GeneratorManager;
import adt.Scenario;
import adt.ScenarioPrototypeFactory;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.RandomGenerator;

/**
 *
 * @author Fabricio Ceciliano
 */
public class MainViewController implements Initializable {
       
    @FXML private StackPane gamePane;
    
    @FXML private Button btnConfig;
    @FXML private TextField txtCantPersonajes;
    @FXML private ComboBox<String> cmBxEscenarios;
    @FXML private Button btnGenerar;
    
    private static final int paneWidth = 1100;
    private static final int paneHeight = 900;
    private static final int characterWidth = 100;
    private static final int characterHeight = 200;
    
    private boolean SelectedScenario = false;
    private final BackgroundSize bgSize = new BackgroundSize(100, 100, false, false, true, true);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        txtCantPersonajes.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {
                if (!newValue.matches("\\d*")) {
                    txtCantPersonajes.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        
        //loadBichos();
        loadEscenarios();
    }
    
    private void loadEscenarios() {
        gamePane.setBackground(null);

        SelectedScenario = false;
        
        ObservableList<String> data = cmBxEscenarios.getItems();
        data.clear();
        for (String key : ScenarioPrototypeFactory.getKeys())
            data.add(key);
    }
    
    @FXML
    private void onCmbxEscenariosItemSelect(ActionEvent event) {
        SelectedScenario = true;
        
        String key = cmBxEscenarios.getSelectionModel().getSelectedItem();
        if(key != null){
            Scenario scenario = (Scenario) ScenarioPrototypeFactory.getPrototype(key);
            File file = new File(scenario.getImage());
            Image img = new Image(file.toURI().toString());
            gamePane.setBackground(new Background(new BackgroundImage(img,
                                                  BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                                                  BackgroundPosition.DEFAULT, bgSize)));
        }
    }
    
    @FXML
    private void openConfigWindow(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("ConfigView.fxml"));                    
            Stage newWindow = new Stage();
            newWindow.setTitle("Administrar Recursos - Where's Waldo Generator");
            newWindow.setScene(new Scene(root));
            newWindow.setResizable(false);
            newWindow.initOwner(btnConfig.getScene().getWindow());
            newWindow.initModality(Modality.WINDOW_MODAL);
            newWindow.showAndWait();
            
            loadEscenarios();
            gamePane.getChildren().clear();            
        }
        catch (Exception ex) {
            Alert alert = new Alert(AlertType.ERROR, "Ocurrio un error al abrir la ventana");
            alert.setTitle("Error - Menu Principal");
            alert.showAndWait();
        }

    }

    @FXML
    private void btnGenerarAction(ActionEvent event) {
        gamePane.getChildren().clear();
        GeneratorManager gm = new GeneratorManager(0 - (paneWidth/2), 0 + (paneWidth/2),
                                                   0 - (paneHeight/2), 0 + (paneHeight/2));
        gm.loadCharacters(gamePane,Integer.parseInt(txtCantPersonajes.getText()));
    }
}
