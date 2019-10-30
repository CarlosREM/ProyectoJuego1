package proyectowaldo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import adt.Character;
import adt.CharacterPrototypeFactory;
import adt.Scenario;
import adt.ScenarioPrototypeFactory;
import javafx.scene.control.Alert;
import model.ConfigManager;

/**
 *
 * @author Fabricio Ceciliano
 */
public class ConfigViewController implements Initializable {
       
    @FXML private AnchorPane pnOpciones;
    @FXML private ScrollPane scrollPersonajes;
    @FXML private FlowPane pnPersonajes;
    @FXML private ScrollPane scrollEscenarios;
    @FXML private FlowPane pnEscenarios;
    
    // in pnOpciones
    @FXML private Button btnPersonajes;
    @FXML private Button btnAddPersonaje;
    @FXML private Button btnEscenarios;
    @FXML private Button btnAddEscenario;
    
    @FXML private Button btnCancelar;
    @FXML private Button btnGuardar;
    
    
    private ArrayList<PnPersonajeController> personajeControllerArray = new ArrayList<>();
    private ArrayList<PnEscenarioController> escenarioControllerArray = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadPersonajes();
        loadEscenarios();
    }
    private void loadPersonajes() {
        PnPersonajeController newController;
        Character newCharacter;
        for (String key : CharacterPrototypeFactory.getKeys()) {
            newController = addPersonaje(false);
            personajeControllerArray.add(newController);
            newCharacter = (Character) CharacterPrototypeFactory.getPrototype(key);
            
            newController.setNombre(newCharacter.getNombre());
            newController.setImage(newCharacter.getImage());
            newController.setWidth(newCharacter.getWidth());
            newController.setHeight(newCharacter.getHeight());
            newController.setUsar(newCharacter.isUseOnGeneration());
            newController.setWaldo(newCharacter.isIsWaldo());
        }
    }
    private void loadEscenarios() {
        PnEscenarioController newController;
        Scenario newCharacter;
        for (String key : ScenarioPrototypeFactory.getKeys()) {
            newController = addEscenario(false);
            escenarioControllerArray.add(newController);
            newCharacter = (Scenario) CharacterPrototypeFactory.getPrototype(key);
            
            newController.setNombre(newCharacter.getNombre());
            newController.setImage(newCharacter.getImage());
        }
    }
    
    
    @FXML
    private void switchToPersonajes(ActionEvent event) {
        if (!scrollPersonajes.isVisible()) {
            scrollEscenarios.setVisible(false);
            scrollPersonajes.setVisible(true);
        }
    }
    @FXML
    private void btnAddPersonajeAction(ActionEvent event) {
        PnPersonajeController newController = addPersonaje(true);
        if (newController != null)
            personajeControllerArray.add(newController);
    }
    
    private PnPersonajeController addPersonaje(boolean switchScreen) {
        AnchorPane pnNewPersonaje;
        PnPersonajeController newController;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PnPersonaje.fxml"));
            pnNewPersonaje = (AnchorPane) loader.load();
            pnPersonajes.getChildren().add(pnNewPersonaje);
            if (switchScreen) switchToPersonajes(null);
            newController = loader.getController();
        }
        catch(Exception ex) {
            ex.printStackTrace();
            newController = null;
        }
        return newController;
    }
    
    @FXML
    private void switchToEscenarios(ActionEvent event) {
        if (!scrollEscenarios.isVisible()) {
            scrollPersonajes.setVisible(false);
            scrollEscenarios.setVisible(true);
        }
    }
    @FXML
    private void btnAddEscenarioAction(ActionEvent event) {
        PnEscenarioController newController = addEscenario(true);
        if (newController != null)
            escenarioControllerArray.add(newController);
    }

    private PnEscenarioController addEscenario(boolean switchScreen) {
        AnchorPane pnNewEscenario;
        PnEscenarioController newController;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PnEscenario.fxml"));
            pnNewEscenario = (AnchorPane) loader.load();
            pnEscenarios.getChildren().add(pnNewEscenario);
            if (switchScreen) switchToEscenarios(null);
            newController = loader.getController();
        }
        catch(Exception ex) {
            ex.printStackTrace();
            newController = null;
        }
        return newController;
    }
    
    
    @FXML
    private void btnGuardarAction(ActionEvent event) {
        try {
            guardarPersonajes();
            guardarEscenarios();
            ConfigManager.saveConfig();

            Stage stage = (Stage) btnGuardar.getScene().getWindow();
            stage.close();
        }
        catch(InstantiationException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "TODOS los campos de TODOS los objetos insertados deben ser llenados");
            alert.setTitle("Informacion incompleta - Administrar Recursos");
            alert.showAndWait();
        }
    }
    
    private void guardarPersonajes() throws InstantiationException {
        CharacterPrototypeFactory.removeAll();
        Character personaje;
        for (PnPersonajeController controller :personajeControllerArray) {
            if (controller.checkEmpty())
                throw new InstantiationException();
            personaje = controller.getPersonaje();
            CharacterPrototypeFactory.addPrototype(personaje.getNombre(), personaje);
        }
    }
    
    private void guardarEscenarios() throws InstantiationException {
        ScenarioPrototypeFactory.removeAll();
        Scenario escenario;
        for (PnEscenarioController controller : escenarioControllerArray) {
            if (controller.checkEmpty())
                throw new InstantiationException();
            escenario = controller.getEscenario();
            ScenarioPrototypeFactory.addPrototype(escenario.getNombre(), escenario);
        }
    }
    
    @FXML
    private void btnCancelAction(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
  
}
