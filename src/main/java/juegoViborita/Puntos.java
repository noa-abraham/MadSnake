package juegoViborita;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Puntos implements Dibujable {

    private int posicionX;
    private int posicionY;
    private Font font;
    private Color color;
    private int puntos = 0; 

    public Puntos (int posicionX, int posicionY, Font font, Color color) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.font = font;
        this.color = color;
        this.puntos = 0;
    }

    public void dibujarse(Graphics g) {
        g.setColor(color);
        g.setFont(font);
        g.drawString("Puntaje: " + String.valueOf(puntos), posicionX, posicionY);
    }



    public void sumarPunto() {
        puntos++;
    }

    public int getPuntaje() {
        return puntos;
    }
    
}