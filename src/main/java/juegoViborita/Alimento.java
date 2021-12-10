package juegoViborita;

import java.awt.Graphics;

public abstract class Alimento  {
	
	private int[] hongosPosicionX = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,
			425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	
	private int[] hongosPosicionY = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,
			425,450,475,500,525,550,575,600,625};
	
	private int ancho;
	private int largo; 

	public Alimento(int[] hongosPosicionX , int[] hongosPosicionY, int ancho, int largo) {
		this.hongosPosicionX =hongosPosicionX;
		this.hongosPosicionY= hongosPosicionY; 
		this.setAncho(ancho);
		this.setLargo(largo); 
		
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

	//son rebundantes pero si extiendod e Elemento Basico me trae otras cosas que no me interesa. Cambiar elemento basico. 
	
	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	} 

}
