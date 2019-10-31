package adt;

import adt.Character;
import adt.CharacterPrototypeFactory;
import java.io.File;
import java.util.ArrayList;
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
        
    public void loadCharacters(StackPane gamePane, int amount) {
        GameManager.getInstance().setCurrentFoundCharacters(0);
        loadBasicCharacters(gamePane);
        loadExtraCharacters(gamePane, amount);
    }
    
    public void loadBasicCharacters(StackPane gamePane) {
        int counter = 0;
        for (String key : CharacterPrototypeFactory.getKeys()) {
            Character character = (Character)CharacterPrototypeFactory.getPrototype(key);
            if (character.isUseOnGeneration() && character.isIsWaldo()) {
                counter++;
                File file = new File(character.getImage());
                Image characterImage = new Image(file.toURI().toString(), character.getWidth(), character.getHeight(), true,true);
                ImageView characterImageView = new ImageView(characterImage);
                characterImageView.setPickOnBounds(false);
                characterImageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        showMessage(AlertType.INFORMATION, character.getNombre() + " encontrado.", "Personaje encontrado");
                        GameManager.getInstance().setCurrentFoundCharacters(
                            GameManager.getInstance().getCurrentFoundCharacters() + 1);
                        if(verifyWinnerCondition()){
                            showMessage(AlertType.INFORMATION, "Ha encontrado todos los personajes. Felicidades!", "Ganador - Juego terminado");
                        }
                        characterImageView.setVisible(false);
                        event.consume();
                    }
                });

                gamePane.getChildren().add(characterImageView);
                characterImageView.setTranslateX(RandomGenerator.getRandomIntegerBetweenRange(minX+character.getWidth()+100, maxX-character.getWidth()-100));
                characterImageView.setTranslateY(RandomGenerator.getRandomIntegerBetweenRange(minY+character.getWidth()+100, maxY-character.getWidth()-100));
            }
        }
        GameManager.getInstance().setMaxCharacters(counter);
    }
    
    public void loadExtraCharacters(StackPane gamePane, int amount){
        int trueAmount;
        ArrayList<Image> extraCharactersImages = new ArrayList<>();
        File characterImageFile;
        Image characterImage;
        
        for (String key : CharacterPrototypeFactory.getKeys()){
            Character character = (Character)CharacterPrototypeFactory.getPrototype(key);
            if(character.isUseOnGeneration() && !character.isIsWaldo()){
                characterImageFile = new File(character.getImage());
                characterImage = new Image(characterImageFile.toURI().toString(), character.getWidth(), character.getHeight(), true, true);
                extraCharactersImages.add(characterImage);
            }
        }

        trueAmount = amount/extraCharactersImages.size();
        ImageView characterImageView;
        for(int i=0; i<trueAmount; i++){
            for(Image character : extraCharactersImages){
                characterImageView = new ImageView(character);
                gamePane.getChildren().add(characterImageView);
                characterImageView.setTranslateX(RandomGenerator.getRandomIntegerBetweenRange(minX, maxX));
                characterImageView.setTranslateY(RandomGenerator.getRandomIntegerBetweenRange(minY, maxY));
            }
        }
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
