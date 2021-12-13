package juegoViborita;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PantallaGanador extends Pantalla {



	public PantallaGanador(int ancho, int largo, String resource) {
		super(ancho, largo, resource);

	}
	
	 public void dibujarse(Graphics graphics) {
	        super.dibujarse(graphics);
	        mostrarMensaje(graphics);
	    }

	    private void mostrarMensaje(Graphics g) {
	    	g.setColor(Color.blue);
			g.setFont(new Font("Impact", Font.BOLD, 50));
			g.drawString("GANASTE !",310,300);
			g.setFont(new Font("Impact", Font.BOLD, 30));
			g.drawString("Presiona ESPACIO para iniciar",260,340);
	    }


}
