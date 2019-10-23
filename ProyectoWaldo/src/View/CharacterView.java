/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import ADT.Character;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author carlo
 */
public class CharacterView extends JPanel {
    
    private final Character character;

    public java.awt.image.BufferedImage getImage() {
        return character.getImage();
    }
    
    public CharacterView(Character character) {
        this.character = character;
        
        loadImage();
        setup();
    }
    
    private void setup() {
        setOpaque(false);
        
        addMouseListener(new MouseAdapter() {
           
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
                Color c = new Color(((CharacterView) e.getComponent()).getImage());
            }
        });
    }
    
    private void loadImage() {
        
    }
}
