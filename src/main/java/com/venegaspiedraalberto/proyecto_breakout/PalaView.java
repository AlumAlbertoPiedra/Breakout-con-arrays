package com.venegaspiedraalberto.proyecto_breakout;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Metodo para crear la pala
 * @author Alberto
 */


public class PalaView {
    int ALTURA_PALA = 10;
    int tamañoPala =80;
    Bloques bloques;
    Rectangle rectPala;
       
    
    
/**
 * Creación de la pala
 * @param bloques tamaño del array
 */
    public PalaView(Bloques bloques){
        rectPala = new Rectangle(bloques.SCENE_TAM_X / 2, bloques.SCENE_TAM_Y - 70, tamañoPala, ALTURA_PALA);
        rectPala.setFill(Color.YELLOW);
    }
}