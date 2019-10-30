package proyectowaldo;

import adt.Scenario;
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
        cambiarImagen(RESOURCES_DIR, "Escenarios");
    }
    
    public Scenario getEscenario() {
        String nombre = txtNombre.getText();
        return new Scenario(nombre, imgPath);
    }
    
    @Override
    public boolean checkEmpty() {
        boolean nameEmpty = txtNombre.getText().isEmpty(),
                imgEmpty = imgPath.isEmpty();

        return nameEmpty && imgEmpty;
    }
}
