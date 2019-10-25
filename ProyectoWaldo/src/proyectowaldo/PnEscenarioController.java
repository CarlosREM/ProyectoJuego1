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

/**
 *
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 */
public class PnEscenarioController extends PnItemController {
        
    private static final String RESOURCES_DIR = "./src/resources/escenarios";
       
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    
        
    @FXML
    private void btnCambiarImagenAction(ActionEvent event) {
        cambiarImagen(RESOURCES_DIR);
    }
}
