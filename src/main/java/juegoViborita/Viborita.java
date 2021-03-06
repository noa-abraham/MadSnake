package juegoViborita;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Viborita implements Dibujable {

	private ArrayList<Point> largoCuerpito = new ArrayList<Point>();

	private int posicionX = 0;
	private int posicionY = 0;
	private int anchoViborita = 20;
	private int largoViborita = 20;

	public Viborita() {
		largoCuerpito.add(new Point(20, 10));
	}

	@Override
	public void dibujarse(Graphics g) {
		for (int n = 0; n < largoCuerpito.size(); n++) {
			g.setColor(Color.MAGENTA);
			Point puntoDelCuerpito = largoCuerpito.get(n);
			g.fillRect(puntoDelCuerpito.x * 20, puntoDelCuerpito.y * 20, anchoViborita, largoViborita);
		}

	}

	public void moverse() {
		for (int n = largoCuerpito.size() - 1; n > 0; n--) {
			largoCuerpito.get(n).setLocation(largoCuerpito.get(n - 1));
		}
		largoCuerpito.get(0).x += posicionX;
		largoCuerpito.get(0).y += posicionY;
	}

	public void crecerCola() {
		largoCuerpito.add(new Point());
	}

	public void direccion(String sentidoDireccion) {
		switch (sentidoDireccion) {
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
}