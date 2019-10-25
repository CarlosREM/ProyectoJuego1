/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectowaldo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Fabricio Ceciliano
 */
public class MainViewController implements Initializable {
       
    @FXML private StackPane gamePane;
    @FXML private Pane configPane;
    @FXML private TextField txtCantPersonajes;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
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
        
        /*
        Image image = new Image("file:///C:\\Users\\carlo\\Pictures\\test sprites\\attack.png", 100, 200, false, false);
        ImageView waldo1 = new ImageView(image);
        ImageView waldo2 = new ImageView(image);
        ImageView waldo3 = new ImageView(image);
        waldo1.setPickOnBounds(false);
        waldo2.setPickOnBounds(false);
        waldo3.setPickOnBounds(false);
        waldo1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("waldo1");
                event.consume();
            }
        });
        waldo2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("waldo2");
                event.consume();
            }
        });
        waldo3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("waldo3");
                event.consume();
            }
        });
        
        gamePane.getChildren().addAll(waldo1, waldo2, waldo3);  
        waldo2.setTranslateX(100);
        waldo3.setTranslateX(200);
        waldo3.setTranslateY(300);
        */
    }    
    
}
