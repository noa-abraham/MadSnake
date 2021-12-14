package juegoViborita;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PantallaPerdedor extends Pantalla {
	


	public PantallaPerdedor(int ancho, int largo,String resource) {
		super(ancho, largo, resource);
	
		
	}
	
	 public void dibujarse(Graphics graphics) {
	        super.dibujarse(graphics);
	        mostrarMensaje (graphics); 
	        
	 }
	 
	 private void mostrarMensaje(Graphics g) {
	    	g.setColor(Color.GREEN);
			g.setFont(new Font("Impact", Font.BOLD, 50));
			g.drawString("PERDISTE!",350,410);
			g.setFont(new Font("Impact", Font.BOLD, 30));
			g.drawString("Presioná ESPACIO para iniciar",300,450);
	    }

}
