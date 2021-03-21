package com.venegaspiedraalberto.proyecto_breakout;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Creación de la bola
 * @author Alberto
 */

public class BolaView {
    int ballCenterY = 450;
    int ballCenterX = 500;
    int ballCurrentSpeedX = -5;
    int ballCurrentSpeedY = -5;
    Circle circleBall;
    
    /**
     * Metodo para crear la bola
     */
    public BolaView(){
        circleBall = new Circle(ballCenterX, ballCenterY, 8, Color.LIGHTGRAY);
    
    }
    
    
}