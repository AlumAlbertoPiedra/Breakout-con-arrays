
package com.venegaspiedraalberto.proyecto_breakout;

import java.util.Random;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * Creación de los obstaculos del juego
 * @author Alberto
 */

public class BloquesView extends GridPane {
        //Rectangle rectangleObstaculo = new Rectangle();
        Rectangle [] [] rect;
        Bloques bloques;
        BolaView bolaView;
        PalaView palaView;
        int colorRojo = 0;
        int colorVerde = 0;
        int colorAzul = 0;
        int colorRojoE = 0;
        int colorVerdeE = 0;
        int colorAzulE = 0;
           
        
                       
    /**
     * Creación de los obstaculos
     * @param bloques Tamaño del array
     */
    public BloquesView(Bloques bloques) { 
        this.bloques = bloques;
        
        rect = new Rectangle [bloques.columnas] [bloques.filas];
        for (int a= 0; a<bloques.columnas; a++){           
            for(int b=0; b<bloques.filas; b++){
                Rectangle rectangulo = new Rectangle(bloques.ANCHOBLOQUE, bloques.ALTOBLOQUE);
                rect [a] [b] = rectangulo;
                this.add(rect [a] [b], a, b);
            }
        }
        this.setStyle("-fx-padding: 140 0 0 0;-fx-grid-lines-visible: true");
        this.actualizarBloque(bloques);
        
        
        
    }
    /**
     * Colocar los obstaculos e su posición
     */
    public void inicializar(){
        for(int y=0; y<bloques.filas; y++) {
            for(int x=0; x<bloques.columnas; x++) {
                rect [x] [y].setTranslateX(0);
            }
        }
    }
    /**
     * Cambiar el color de los bloques y bloques especiales
     * @param bloques Tamaño Array
     */
    public void actualizarBloque(Bloques bloques){
        this.bloques=bloques;
    for(int y=0; y<bloques.filas; y++) {
                colorRojo = getNumAleatorio(0, 255);
                colorVerde = getNumAleatorio(0, 255);
                colorAzul = getNumAleatorio(0, 255);
            for(int x=0; x<bloques.columnas; x++) {
                char caracter= bloques.getchar(x, y);
                rect [x] [y].setWidth(bloques.ANCHOBLOQUE);
                rect [x] [y].setHeight(bloques.ALTOBLOQUE);
                switch (caracter) {
                    case '+':
                        colorRojoE = getNumAleatorio(0, 255);
                        colorVerdeE = getNumAleatorio(0, 255);
                        colorAzulE = getNumAleatorio(0, 255);
                        rect [x] [y].setFill(Color.rgb(colorRojoE, colorVerdeE, colorAzulE));
                        System.out.println(x);
                        System.out.println(y);
                        break;
                    case '-':
                        colorRojoE = getNumAleatorio(0, 255);
                        colorVerdeE = getNumAleatorio(0, 255);
                        colorAzulE = getNumAleatorio(0, 255);
                        rect [x] [y].setFill(Color.rgb(colorRojoE, colorVerdeE, colorAzulE));
                        System.out.println("A");
                        break;
                    case '*':
                        rect [x] [y].setFill(Color.rgb(colorRojo, colorVerde, colorAzul));
                        break;
                    default:
                        break;
                }  
            }
        }
    }
    /**
     * Colisión de los obstaculos y la bola
     * @param bolaView Creación de la bola
     * @param palaView Creación de la pala
     */
    public void colisionObjeto(BolaView bolaView, PalaView palaView){
        for(int x=0; x<bloques.columnas; x++) {
            for(int y=0; y<bloques.filas; y++) {
                Shape shapeColision = Shape.intersect(bolaView.circleBall, rect [x] [y]);
                boolean colisionVacia = shapeColision.getBoundsInLocal().isEmpty();
                if (colisionVacia == false) {
                    bolaView.ballCurrentSpeedX = -bolaView.ballCurrentSpeedX;
                    bolaView.ballCurrentSpeedY = -bolaView.ballCurrentSpeedY;
                    //System.out.println("Hola");
                    bloques.eliminarBloque(x, y, bolaView, palaView);
                    rect[x] [y].setTranslateX(2000);
                    bloques.score +=10;                   
                }    
            }
        } 
    }
    /**
     * Reinicar los obstaculos
     */
    public void resetGame() {
        
        this.inicializar();
    }
    /**
     * Sacar número aleatorio
     * @param min Mínimo que puede salir
     * @param max Maximo que puede salir
     * @return Devuelve el número que ha salido aleatoriamente
     */
    public int getNumAleatorio(int min, int max) {
        Random random = new Random();
        int color = random.nextInt(max-min+1) + min;
        return color;
    }
}