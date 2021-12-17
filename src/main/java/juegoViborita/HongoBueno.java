package juegoViborita;

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
    private BufferedImage img;
  
    private int posicionX = 34; 
    private int posicionY = 23; 

	public HongoBueno() {
		this.random = new Random ();
		this.hongoBueno = new Point (); 
		try {
			String path = Paths.get(HongoBueno.class.getClassLoader().getResource("imagenes/hongoVioleta.gif").toURI()).toString();
			this.img = ImageIO.read(new File(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
		
	public void nuevoHonguitoBueno() {
		hongoBueno.x = random.nextInt(posicionX); 
		hongoBueno.y = random.nextInt(posicionY);
		if (hongoBueno.y <= 3) {
			hongoBueno.y = 4;
		}
		if (hongoBueno.x <= 1) {
			hongoBueno.x = 4; 
		}
	}

	@Override
	public void dibujarse(Graphics graphics) {
		try {
			graphics.drawImage(img, hongoBueno.x*20, hongoBueno.y*20, 20, 20, null); 
        } catch (Exception e1) {
        	throw new RuntimeException(e1);
        }
	}

	public Point getHongoBueno() {
		return hongoBueno;  
	}

}