package proyectowaldo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

/**
 *
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 */
public class PnPersonajeController extends PnItemController {
       
    private static final String RESOURCES_DIR = "./src/resources/personajes";

    @FXML private CheckBox chkUsar;
    @FXML private CheckBox chkWaldo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    private void btnCambiarImagenAction(ActionEvent event) {
        cambiarImagen(RESOURCES_DIR);
    }
}
