package proyectowaldo;

import adt.Character;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 */
public class PnPersonajeController extends PnItemController {
       
    private static final String RESOURCES_DIR = "./src/resources/personajes";

    @FXML protected TextField txtHeight;
    @FXML protected TextField txtWidth;
    @FXML private CheckBox chkUsar;
    @FXML private CheckBox chkWaldo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        txtHeight.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {
                if (!newValue.matches("\\d*")) {
                    txtHeight.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        
        txtWidth.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {
                if (!newValue.matches("\\d*")) {
                    txtWidth.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        
    }
    
    @FXML
    private void btnCambiarImagenAction(ActionEvent event) {
        BufferedImage bimg = cambiarImagen(RESOURCES_DIR, "Personajes");
        if (bimg != null) {
            txtHeight.setText(String.valueOf(bimg.getHeight()));
            txtWidth.setText(String.valueOf(bimg.getWidth()));
        }
    }
    
    public Character getPersonaje() {
        int height = Integer.valueOf(txtHeight.getText()),
            width = Integer.valueOf(txtWidth.getText());
        String nombre = txtNombre.getText();
        boolean useCharacter = chkUsar.isSelected(),
                isWaldo = chkWaldo.isSelected();
        return new Character(imgPath, height, width, nombre, isWaldo, useCharacter);
    }
    
    @Override
    public boolean checkEmpty() {
        boolean nameEmpty = txtNombre.getText().isEmpty(),
                heightEmpty = txtHeight.getText().isEmpty(),
                widthEmpty = txtWidth.getText().isEmpty(),
                imgEmpty = imgPath.isEmpty();

        return nameEmpty && heightEmpty && widthEmpty && imgEmpty;
    }
    
    public void setWidth(int width) {
        txtWidth.setText(String.valueOf(width));
    }
    
    public void setHeight(int height) {
        txtHeight.setText(String.valueOf(height));
    }
    
    public void setUsar(boolean usar) {
        chkUsar.setSelected(usar);
    }
    
    public void setWaldo(boolean isWaldo) {
        chkWaldo.setSelected(isWaldo);
    }
}
