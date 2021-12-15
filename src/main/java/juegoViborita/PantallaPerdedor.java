package juegoViborita;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PantallaPerdedor extends Pantalla {
	
	private int puntos; 


	public PantallaPerdedor(int ancho, int largo,String resource, int puntos) {
		super(ancho, largo, resource);
	}
	
	 public void dibujarse(Graphics graphics) {
	        super.dibujarse(graphics);
	        mostrarMensajePerdiste(graphics); 
	 }
	     
	 
	 private void mostrarMensajePerdiste(Graphics g) {
		 g.setColor(Color.orange);
		 g.setFont(new Font("Impact", Font.BOLD, 30));
		 g.drawString("Presioná ESPACIO para iniciar",370,300);
	 }
	 
		 
 }

