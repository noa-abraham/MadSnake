package juegoViborita;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Nivel implements Dibujable {

	 private int posicionX;
	 private int posicionY;
	 private Font font;
	 private Color color;
	 private int nivel; 

    public Nivel (int posicionX, int posicionY, Font font, Color color) {
    	this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.font = font;
        this.color = color;
        this.nivel = 1;
    }

    
    @Override
    public void dibujarse(Graphics g) {
        g.setColor(color);
        g.setFont(font);
        g.drawString("Nivel: " + Juego.level, posicionX, posicionY);
    }
    
    
    public int getNivel() {
        return nivel;
    }
}