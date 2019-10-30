package adt;

import adt.Character;
import adt.CharacterPrototypeFactory;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import util.RandomGenerator;

/**
 *
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 */

public class GeneratorManager {
    
    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    public GeneratorManager(int minX, int maxX, int minY, int maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }
        
    public void loadBasicCharacters(StackPane gamePane){
        for (String key : CharacterPrototypeFactory.getKeys()){
            Character character = (Character)CharacterPrototypeFactory.getPrototype(key);
            if (!character.isUseOnGeneration())
                continue;
            Image characterImage = new Image(character.getImage(),character.getWidth(),character.getHeight(),true,true);
            ImageView characterImageView = new ImageView(characterImage);
            characterImageView.setPickOnBounds(false);
            characterImageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    showMessage(AlertType.INFORMATION, character.getNombre() + " encontrado.", "Personaje encontrado");
                                        
                    if(verifyWinnerCondition()){
                        showMessage(AlertType.INFORMATION, "Ha encontrado todos los personajes. Felicidades!", "Ganador - Juego terminado");
                    }
                        
                    characterImageView.setVisible(false);
                    
                    event.consume();
                }
            });
            
            gamePane.getChildren().add(characterImageView);
            characterImageView.setTranslateX(RandomGenerator.getRandomIntegerBetweenRange(minX, maxX));
            characterImageView.setTranslateY(RandomGenerator.getRandomIntegerBetweenRange(minY, maxY));
        }
    }
    
    public void loadCharacters(int amount){
        
    }
    
    private boolean verifyWinnerCondition(){
        return (GameManager.getInstance().getCurrentFoundCharacters() == GameManager.getInstance().getMaxCharacters());
    }
    
    private void showMessage(AlertType messageType, String message, String title){
        Alert alert = new Alert(messageType,message);
        alert.setTitle(title);
        alert.showAndWait();
    }
}
