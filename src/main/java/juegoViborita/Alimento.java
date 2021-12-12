package juegoViborita;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public abstract class Alimento extends ElementoBasico   {
	
	private Random random;
	private Point alimento; 
	
	
	public Alimento(int posicionX, int posicionY, int ancho, int largo, Color color) {
		super(posicionX, posicionY, ancho, largo, color);
		this.random = new Random (); 
		this.alimento = new Point (); 
	}
	
	
	public abstract void nuevoAlimento (); 
	
	
	public Point getAlimento() {
        return alimento; 
    }

}
