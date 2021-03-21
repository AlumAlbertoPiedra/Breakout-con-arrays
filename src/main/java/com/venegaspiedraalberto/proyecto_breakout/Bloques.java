package com.venegaspiedraalberto.proyecto_breakout; 

import java.util.Random;


// Tengo que crear un array para los rectangulos y poder diferenciarlos entre si


public final class Bloques{ 
    char [] [] pos;
    int columnas= 20;
    int filas;
    int i =3;
    int p =3;
    int puntuacion = 0;
    int score = 0;
    final int ANCHOBLOQUE = 40;
    final int ALTOBLOQUE = 40;
    int vida = 1;
    int vidaJefe = 3;
    int SCENE_TAM_X = 800;
    int SCENE_TAM_Y = 600;
    PalaView palaView;
    BolaView bolaView;
    Bloques bloques;
    Personaje personaje;
    

    
        
    
    public Bloques(int filas){
        this.filas = filas;
        char bloque = '*';
        int especialVelX;
        int especialVelY;
        int especialPalaX;
        int especialPalaY;
        
        
        
        pos = new char [columnas] [filas];
        for(int c=0; c<columnas; c++){
            for(int f=0; f<filas; f++){
                pos [c] [f] = bloque;
            }
        }        
        especialVelX =getNumAleatorio(0,19);
        especialVelY =getNumAleatorio(0,4);
        this.bloqueEspecialVelocidad(especialVelX,especialVelY);
        
        especialPalaX = getNumAleatorio(0,19);
        especialPalaY = getNumAleatorio(0,4);
        this.bloqueEspecialPala(especialPalaX,especialPalaY);
        
        this.mostrarPorConsola();  
    }
    
    public char eliminarBloque(int posX, int posY, BolaView bolaView, PalaView palaView ){
        char caracter= getchar(posX, posY);
        if (caracter == '+'){
            bolaView.ballCurrentSpeedY = 10;
        } else if (caracter == '-') {
            palaView.tamañoPala =palaView.tamañoPala/2;
        }
        char bloqueEliminado = ' ';
        pos [posX] [posY] = bloqueEliminado;
        //this.mostrarPorConsola(); 
        this.comprobarFilaVacia(filas);
        this.comprobarVictoria();
        return caracter;
        
        
 
    }
    
    public void bloqueEspecialVelocidad(int especialVelX, int especialVelY){
        char bloqueEspecialVelocidad = '+';
        pos [especialVelX] [especialVelY] = bloqueEspecialVelocidad;
    }
    public void bloqueEspecialPala(int especialPalaX, int especialPalaY){
        char bloqueEspecialPala = '-';
        pos [especialPalaX] [especialPalaY] = bloqueEspecialPala;
    }
    public int getNumAleatorio(int min, int max) {
        Random random = new Random();
        int num = random.nextInt(max-min+1) + min;
        return num;
    }
    
    public boolean comprobarFilaVacia(int fila){
        for (int x=0; x<columnas; x++){
            char caracter = getchar(fila,x);
            if (caracter != ' '){
                //System.out.println("La fila no esta vacia");
                //System.out.println(caracter);
                return false;
            }            
        }
        System.out.println("La fila esta vacia");
        score += 100;
        return true;
    }
    
    public char getchar(int i, int p){
        char caracter = pos [i] [p];
        return caracter;
    }

    public void mostrarPorConsola() {
        for (int y=0; y<filas; y++){
            for(int x=0; x<columnas; x++){
                System.out.print(pos[x][y] + "");
            }
            System.out.println();
        }    
    }
    public void mostrarPuntuacion() {
        System.out.println(puntuacion);
    }
    public void resetGame() {
        vida = 1;
        vidaJefe = 3;
        palaView.tamañoPala= 80;
    }
    public boolean comprobarVictoria(){
        for (int y=0; y<filas; y++){
            for (int x=0; x<columnas;x++){
                char caracter = getchar(y,x);
                    if (caracter != ' '){
                        //System.out.println("La pantalla no esta vacia");
                        //System.out.println(caracter);
                        return false;
                    }                 
            }
        }
        System.out.println("La pantalla esta vacia");
        score +=500;
        this.winGame();
        return true;
    }
    public void winGame(){
        personaje.setLayoutX(-1200);
        personaje.setLayoutY(-1200);
        bolaView.ballCurrentSpeedX = 0;
        bolaView.ballCurrentSpeedY = 0;
        bolaView.ballCenterY = 400;
        bolaView.ballCenterX = 400;
        vida = 0;
    }        
}