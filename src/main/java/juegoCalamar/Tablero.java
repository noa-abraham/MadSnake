package juegoCalamar;

import java.awt.Color;
import java.awt.Graphics;

public class Tablero extends ElementoBasico {
	
	
	public Tablero(int posicionX, int posicionY, double velocidadX, double velocidadY, int ancho, int largo,
            Color color) {
        super(posicionX, posicionY, velocidadX, velocidadY, ancho, largo, color);
    }

    public void dibujarse(Graphics graphics) { //dibuja el puente
        graphics.setColor(getColor());
        graphics.fillRect(getPosicionX(), getPosicionY(), getAncho(), getLargo());
    }
    
    public void destruirse (Graphics graphic) { //cuando se pierde
    	
    }

}
