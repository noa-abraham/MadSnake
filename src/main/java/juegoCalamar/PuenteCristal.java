package juegoCalamar;

import java.awt.Color;
import java.awt.Graphics;

public class PuenteCristal extends ElementoBasico {

    public PuenteCristal(int posicionX, int posicionY, double velocidadX, double velocidadY, int ancho, int largo,
            Color color) {
        super(posicionX, posicionY, velocidadX, velocidadY, ancho, largo, color);
    }

    public void dibujarse(Graphics graphics) {
        int casillas = 3;
        for (int j = 0; j < casillas; j++) {
            for (int i = 0; i < casillas; i++) {
               if ((j % 2) != 0) {
            	   graphics.setColor(getColor()); //color que le pasé
            	   graphics.fillRect(getPosicionX(), getPosicionY(), getAncho(), getLargo());
               }
               if ((i % 2 != 0)) {
            	   graphics.setColor(getColor()); //color que le pasé
            	   graphics.fillRect(getPosicionX(), getPosicionY(), getAncho(), getLargo());
               }
            }
         }
        
        
    }

}