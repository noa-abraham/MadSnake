package juegoViborita;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;


public class Fondo extends ElementoBasico {
	
	private Image imagen; 

	public Fondo(int posicionX, int posicionY, double velocidadX, double velocidadY, int ancho, int largo,
			Color color) {
		super(posicionX, posicionY, velocidadX, velocidadY, ancho, largo, color);
		
	}

	@Override
	public void dibujarse(Graphics graphics) {
		File miImagen = new File ("resources/imagenes/fondo.png"); 
		try {
			imagen = ImageIO.read(miImagen); 
		} catch (Exception e1) {
			throw new RuntimeException (e1); 
		}
		graphics.drawImage(imagen, getPosicionX(), getPosicionY(), this.getAncho(), this.getLargo(), null);
		
	}


	@Override
	public boolean hayColision(ElementoBasico elemento) {
		// TODO Auto-generated method stub
		return false;
	}
		

}
