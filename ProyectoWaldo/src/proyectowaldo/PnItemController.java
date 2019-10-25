package proyectowaldo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author Carlos Esquivel
 */
public class PnItemController implements Initializable {
    
    @FXML protected AnchorPane pnMain;
    
    @FXML protected ImageView imgViewer;
    @FXML protected TextField txtNombre;
    @FXML protected Button btnCambiarImagen;
    @FXML protected Button btnEliminar;
        
    @Override
    public void initialize(URL location, ResourceBundle resources) {}
    
        
    protected void cambiarImagen(String ResourcesDir) {
        if (!txtNombre.getText().isEmpty()) {
            try {
                final FileChooser fileChooser = getImageFileChooser(ResourcesDir , "Escenarios");
                File file = fileChooser.showOpenDialog((Stage) pnMain.getScene().getWindow());
                if (file != null) {
                    Image newImage = new Image(file.toURI().toString());
                    BufferedImage bimg = new BufferedImage((int) newImage.getWidth(),
                                                           (int) newImage.getHeight(),
                                                            BufferedImage.TYPE_INT_ARGB);
                    
                    saveImageResource(txtNombre.getText(),
                                      SwingFXUtils.fromFXImage(newImage, bimg),
                                      ResourcesDir);

                    imgViewer.setImage(newImage);
                }
            }
            catch(Exception ex) {
                Alert alert = new Alert(AlertType.ERROR, "Ocurrio un error al cargar la imagen.");
                alert.setTitle("Error - Cambiar imagen");
                alert.showAndWait();
            }
        }
        else {
            Alert alert = new Alert(AlertType.WARNING, "Debe llenar el espacio \"Nombre\" para poder cargar imagenes.");
            alert.showAndWait();
        }
    }
    
    protected FileChooser getImageFileChooser(String ResourceDir, String caller) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Image Files (*.bmp, *.jpeg, *.jpg, *.png)",
                                                                             "*.bmp", "*.jpeg", "*.jpg", "*.png");
        fileChooser.getExtensionFilters().add(filter);
        fileChooser.setInitialDirectory(new File(ResourceDir));
        fileChooser.setTitle("Cambiar imagen - " + caller);
        return fileChooser;
    }
    
    protected void saveImageResource(String imgName, BufferedImage newImage, String ResourceDir) throws IOException {
        ImageIO.write(newImage, "png", new File(ResourceDir + "/" + imgName + ".png"));
    }

    
    @FXML
    private void btnEliminarAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING, "La informacion no sera recuperable. Eliminar?",
                                ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        
        if (alert.getResult() == ButtonType.YES) {
            FlowPane pnParent = (FlowPane) pnMain.getParent();
            pnParent.getChildren().remove(pnMain);
        }
    }
}
