/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectowaldo;

import java.net.URL;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
    
    @FXML
    private void switchToPersonajes(ActionEvent event) {
        if (!scrollPersonajes.isVisible()) {
            scrollEscenarios.setVisible(false);
            scrollPersonajes.setVisible(true);
        }
    }
    @FXML
    private void addPersonaje(ActionEvent event) {
        AnchorPane pnNewPersonaje;
        try {
            pnNewPersonaje = (AnchorPane) FXMLLoader.load(getClass().getResource("PnPersonaje.fxml"));
            pnPersonajes.getChildren().add(pnNewPersonaje);
            switchToPersonajes(event);
        }
        catch(Exception ex) {
            System.out.println("fuck");
        }
    }
    
    @FXML
    private void switchToEscenarios(ActionEvent event) {
        if (!scrollEscenarios.isVisible()) {
            scrollPersonajes.setVisible(false);
            scrollEscenarios.setVisible(true);
        }
    }
    @FXML
    private void addEscenario(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane pnNewEscenario;
        try {
            pnNewEscenario = (AnchorPane) FXMLLoader.load(getClass().getResource("PnEscenario.fxml"));
            pnEscenarios.getChildren().add(pnNewEscenario);
            
            switchToEscenarios(event);
        }
        catch(Exception ex) {
            System.out.println("fuck");
        }
    }
    
    
    @FXML
    private void btnGuardarAction(ActionEvent event) {
        
        //guardar el mierdero que el mae haya hecho
        
        Stage stage = (Stage) btnGuardar.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void btnCancelAction(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
  
}
