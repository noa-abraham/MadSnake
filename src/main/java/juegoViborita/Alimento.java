package juegoViborita;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Alimento extends ElementoBasico  {
	
	private int[] hongosPosicionX = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,
			425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	
	private int[] hongosPosicionY = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,
			425,450,475,500,525,550,575,600,625};
	

	public Alimento (int posicionX, int posicionY, int ancho, int largo, Color color, int[] hongosPosicionX, int[] hongosPosicionY ) {
		super(posicionX, posicionY, ancho, largo, color);
		this.hongosPosicionX = hongosPosicionX;
		this.hongosPosicionY = hongosPosicionY; 
	}
	
	

	public abstract void serComido(Graphics graphics);
	
	public abstract void dibujarse (Graphics graphics);

	
	
	public int[] getHongoPosicionX() {
		return hongosPosicionX;
	}

	public void setHongoPosicionX(int[] hongoBuenoX) {
		this.hongosPosicionX = hongoBuenoX;
	}

	public int[] getHongoPosicionY() {
		return hongosPosicionY;
	}

	public void setHongoPosicionY(int[] hongoBuenoY) {
		this.hongosPosicionY = hongoBuenoY;
	}


}
