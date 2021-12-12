package juegoViborita;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;



public class Viborita implements Dibujable  {
	
	
	private ArrayList<Point> largoCuerpito = new ArrayList<Point>();
	private int posicionX = 0; 
	private int posicionY = 0; 
	

	public Viborita() {
		largoCuerpito.add(new Point (20,15)); //15 es el centro de la pantalla

	}


	@Override
	public void dibujarse(Graphics graphics) {
		
		for(int n = 0; n < largoCuerpito.size(); n++) {
			graphics.setColor(Color.pink);
            Point p = largoCuerpito.get(n);
            graphics.fillRect(p.x*20, p.y*20, 20, 20);
        }
		
	}
	
	public void moverse () {
        for(int n = largoCuerpito.size()-1; n > 0; n--) {
            largoCuerpito.get(n).setLocation(largoCuerpito.get(n-1));
        }
        largoCuerpito.get(0).x += posicionX;
        largoCuerpito.get(0).y += posicionY;
    }
    
    public void crecerCola () {
            largoCuerpito.add(new Point());
        }
    
    public void direccion(String sentidoDireccion) {
        switch(sentidoDireccion){
            case "ARR":
                posicionX = 0;
                posicionY = -1;
                break;
            case "ABA":
                posicionX = 0;
                posicionY = 1;
                break;
            case "IZQ":
                posicionX = -1;
                posicionY = 0;
                break;
            case "DER":
                posicionX = 1;
                posicionY = 0;
                break;
            
        }
    }

	public ArrayList<Point> getLargoCuerpito() {
		return largoCuerpito;
	}


	public void setLargoCuerpito(ArrayList<Point> largoCuerpito) {
		this.largoCuerpito = largoCuerpito;
	}


	



}
