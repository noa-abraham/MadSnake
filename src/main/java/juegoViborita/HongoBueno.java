package juegoViborita;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Random;

import javax.imageio.ImageIO;

public class HongoBueno implements Dibujable  {
	
	private Random random;
    private Point hongoBueno;
    


	public HongoBueno() {
		this.random = new Random (); 
		this.hongoBueno = new Point (); 
		
	}
	
	public void nuevoHonguitoBueno() {
		hongoBueno.x = random.nextInt(34);
		hongoBueno.y = random.nextInt(23);
    }

	@Override
	public void dibujarse(Graphics graphics) {
		graphics.setColor(Color.red);
		graphics.fillOval(hongoBueno.x*25, hongoBueno.y*25, 25, 25);
		
	}
	
	public Point getHongoBueno() {
        return hongoBueno;
    }

	
}