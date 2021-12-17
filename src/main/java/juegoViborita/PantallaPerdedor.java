package juegoViborita;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PantallaPerdedor extends PantallaIlustrada {
	
	int puntaje;  

	public PantallaPerdedor(int ancho, int largo,String resource, int puntaje) {
		super(ancho, largo, resource);
		this.puntaje = puntaje; 
	}
	
	public void dibujarse(Graphics graphics) {
        super.dibujarse(graphics);
        String mensajePuntos = " punto";
        if (puntaje  >= 1) {
            mensajePuntos += "s";
        }
        mostrarMensaje(graphics, "Obtuviste: " + puntaje + mensajePuntos);
    }

    private void mostrarMensaje(Graphics g, String mensaje) {
        g.setColor(Color.blue);
        g.setFont(new Font("Impact", 8, 30));
        g.drawString(mensaje, 370, 300);
    }
	 		 
 }