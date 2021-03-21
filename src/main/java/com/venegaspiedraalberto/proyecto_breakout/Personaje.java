package com.venegaspiedraalberto.proyecto_breakout;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Personaje extends Group {

    Rectangle zonaContacto1 = new Rectangle(-20, 0, 90, 120);
    int velocidadJefe = 5;
    BolaView bolaView;

    public Personaje() {

        Rectangle rectangleCuerpoInferior = new Rectangle(0, 50, 50, 70);
        Rectangle rectangleMano1 = new Rectangle(-15, 40, 15, 30);
        Rectangle rectangleMano2 = new Rectangle(50, 40, 15, 30);
        Rectangle rectangleCuerpoSuperior = new Rectangle(0, 35, 50, 20);
        Polygon polygonCuello = new Polygon(10.0, 35.0, 40.0, 35.0, 32.0, 15.0, 17.0, 15.0);
        polygonCuello.setStrokeWidth(5.0);
        Circle circleCabeza = new Circle(24, 12, 10);
        Polygon polygonCuerno1 = new Polygon(13.0, 5.0, 5.0, 5.0, 5.0, 12.0);
        polygonCuerno1.setLayoutX(25);
        polygonCuerno1.setLayoutY(-4);
        Polygon polygonCuerno2 = new Polygon(5.0, 5.0, 13.0, 5.0, 5.0, 12.0);
        polygonCuerno2.setLayoutX(3);
        polygonCuerno2.setLayoutY(-4);
        Polygon polygonOjo = new Polygon(5.0, 10.0, 15.0, 10.0, 10.0, 5.0);
        polygonOjo.setLayoutX(14);
        polygonOjo.setLayoutY(2);

        zonaContacto1.setVisible(false);

        rectangleMano1.setFill(Color.GREY);
        rectangleMano2.setFill(Color.GREY);
        rectangleCuerpoInferior.setFill(Color.PURPLE);
        rectangleCuerpoSuperior.setFill(Color.DARKGREY);
        polygonCuello.setFill(Color.PURPLE);
        circleCabeza.setFill(Color.PURPLE);
        polygonCuerno1.setFill(Color.GREY);
        polygonCuerno1.setRotate(270);
        polygonCuerno2.setFill(Color.GREY);
        polygonCuerno2.setRotate(180);
        polygonOjo.setFill(Color.RED);

        this.getChildren().add(rectangleCuerpoInferior);
        this.getChildren().add(rectangleCuerpoSuperior);
        this.getChildren().add(rectangleMano1);
        this.getChildren().add(rectangleMano2);
        this.getChildren().add(polygonCuello);
        this.getChildren().add(circleCabeza);
        this.getChildren().add(polygonCuerno1);
        this.getChildren().add(polygonCuerno2);
        this.getChildren().add(polygonOjo);
        this.getChildren().add(zonaContacto1);

        this.setLayoutX(50);
        this.setLayoutY(0);
        this.setScaleX(0.75);
        this.setScaleY(0.75);
    }

    public void colisionPersonaje(Circle circleBall, Bloques bloques, BolaView bolaView) {
        Shape shapeColision = Shape.intersect(circleBall, zonaContacto1);
        boolean colisionVaciaPersonaje = shapeColision.getBoundsInLocal().isEmpty();
        if (colisionVaciaPersonaje == false) {
            bolaView.ballCurrentSpeedY = -bolaView.ballCurrentSpeedY;
            System.out.println("Prueba");
            if (this.getLayoutX() >= 540) {
                this.setLayoutX(this.getLayoutX() - 200);
                velocidadJefe = -velocidadJefe;
            } else if (this.getLayoutY() <= 260) {
                this.setLayoutX(this.getLayoutX() + 200);
                velocidadJefe = -velocidadJefe;
            }
            bloques.score += 50;
            //textScore.setText(String.valueOf(bloques.score));
            bloques.vidaJefe -= 1;
            if (bloques.vidaJefe == 0) {
                //winGame(); 
                bloques.vida = 0;
            }
        }
    }
    public void resetGame(){
        this.setLayoutX(50);
        this.setLayoutY(0);
    }
}
