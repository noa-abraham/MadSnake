package juegoViborita;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public abstract class Alimento extends ElementoBasico   {
 
	public Alimento(int posicionX, int posicionY, int ancho, int largo, Color color) {
		super(posicionX, posicionY, ancho, largo, color);
	}

}
