package juegoViborita;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public abstract class Hongo extends ElementoBasico   {
 
	public Hongo(int posicionX, int posicionY, int ancho, int largo, Color color) {
		super(posicionX, posicionY, ancho, largo, color);
	}
	
	public abstract void nuevoAlimento (); 

}
