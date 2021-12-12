package juegoViborita;

import java.awt.Color;
import java.awt.Graphics;

public interface Elemento extends Dibujable {
	
	public int getPosicionX();

	public int getPosicionY();

	public int getAncho();

	public int getLargo();

	public Color getColor();
	
	public void hayColision (Elemento elemento); 

	public void dibujarse(Graphics graphics);

}
