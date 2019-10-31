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
        Scenario scenario = (Scenario) ScenarioPrototypeFactory.getPrototype(key);
        File file = new File(scenario.getImage());
        Image img = new Image(file.toURI().toString());
        gamePane.setBackground(new Background(new BackgroundImage(img,
                                              BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                                              BackgroundPosition.DEFAULT, bgSize)));
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
        }
        catch (Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR, "Ocurrio un error al abrir la ventana");
            alert.setTitle("Error - Menu Principal");
            alert.showAndWait();
        }

    }
    
    public void loadBichos(){
        Image megaman = new Image("file:///C://Users//Gómez Montero//Desktop//ProyectoJuego1//ProyectoWaldo//src//resources//personajes//Megaman.png", 100, 200, true, true);
        Image waldo = new Image("file:///C://Users//Gómez Montero//Desktop//ProyectoJuego1//ProyectoWaldo//src//resources//personajes//Waldo.png", 100, 200, true, true);
        Image wenda = new Image("file:///C://Users//Gómez Montero//Desktop//ProyectoJuego1//ProyectoWaldo//src//resources//personajes//Wenda.png", 100, 200, true, true);
        Image woof = new Image("file:///C://Users//Gómez Montero//Desktop//ProyectoJuego1//ProyectoWaldo//src//resources//personajes//Woof.png", 100, 200, true, true);
        Image odlaw = new Image("file:///C://Users//Gómez Montero//Desktop//ProyectoJuego1//ProyectoWaldo//src//resources//personajes//Odlaw.png", 100, 200, true, true);
        Image wizard = new Image("file:///C://Users//Gómez Montero//Desktop//ProyectoJuego1//ProyectoWaldo//src//resources//personajes//Wizard.png", 100, 200, true, true);
        ImageView waldo2 = new ImageView(waldo);
        ImageView wenda2 = new ImageView(wenda);
        ImageView woof2 = new ImageView(woof);
        ImageView odlaw2 = new ImageView(odlaw);
        ImageView wizard2 = new ImageView(wizard);
        
        
        waldo2.setPickOnBounds(false);
        wenda2.setPickOnBounds(false);
        woof2.setPickOnBounds(false);
        odlaw2.setPickOnBounds(false);
        wizard2.setPickOnBounds(false);
        
        waldo2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Waldo");
                event.consume();
            }
        });
        wenda2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Wenda");
                event.consume();
            }
        });
        woof2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Woof");
                event.consume();
                
                woof2.setVisible(false);
            }
        });
        odlaw2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Odlaw");
                event.consume();
            }
        });
        wizard2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Wizard");
                event.consume();
            }
        });
        
        
        
        int minX = 0-(paneWidth/2);
        int maxX = 0+(paneWidth/2);
        int minY = 0-(paneHeight/2);
        int maxY = 0+(paneHeight/2);
        
       
        
        ImageView megaman2;
        for(int i=0; i<100; i++){
            megaman2 = new ImageView(megaman);
            gamePane.getChildren().add(megaman2);
            float num1 = RandomGenerator.getRandomIntegerBetweenRange(minX, maxX);
            float num2 = RandomGenerator.getRandomIntegerBetweenRange(minY, maxY);
            megaman2.setTranslateX(num1);
            megaman2.setTranslateY(num2);
        }
        
        gamePane.getChildren().addAll(waldo2, wenda2, woof2, odlaw2, wizard2); 
        
        waldo2.setTranslateX(RandomGenerator.getRandomIntegerBetweenRange(minX, maxX));
        waldo2.setTranslateY(RandomGenerator.getRandomIntegerBetweenRange(minY, maxY));
        wenda2.setTranslateX(RandomGenerator.getRandomIntegerBetweenRange(minX, maxX));
        wenda2.setTranslateY(RandomGenerator.getRandomIntegerBetweenRange(minY, maxY));
        woof2.setTranslateX(RandomGenerator.getRandomIntegerBetweenRange(minX, maxX));
        woof2.setTranslateY(RandomGenerator.getRandomIntegerBetweenRange(minY, maxY));
        odlaw2.setTranslateX(RandomGenerator.getRandomIntegerBetweenRange(minX, maxX));
        odlaw2.setTranslateY(RandomGenerator.getRandomIntegerBetweenRange(minY, maxY));
        wizard2.setTranslateX(RandomGenerator.getRandomIntegerBetweenRange(minX, maxX));
        wizard2.setTranslateY(RandomGenerator.getRandomIntegerBetweenRange(minY, maxY));
        
    }
    
    @FXML
    private void btnGenerarAction(ActionEvent event) {
        GeneratorManager gm = new GeneratorManager(0 - paneWidth/2, 0 + paneWidth/2,
                                                   0 - paneHeight/2, 0 + paneHeight/2);
        gm.loadCharacters(gamePane);
    }
}
