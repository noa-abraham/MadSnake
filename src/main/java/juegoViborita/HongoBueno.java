package juegoViborita;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Random;

import javax.imageio.ImageIO;

public class HongoBueno implements Dibujable  {
	
	private Random random;
 //   private Point hongoBueno;
    private BufferedImage img;
    private int xpos; 
    private int ypos; 
    
    private int[] comidax = { 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475,
			500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850 };
	private int[] comiday = { 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500,
			525, 550, 575, 600, 625 };

	public HongoBueno(int[] comidax, int[] comiday) {
		this.random = new Random ();
		this.comidax = comidax;
		this.comiday = comiday; 
	//	this.hongoBueno = new Point (); 
		try {
		String path = Paths.get(HongoBueno.class.getClassLoader().getResource("imagenes/hongoVerde.png").toURI()).toString();
		this.img = ImageIO.read(new File(path));
		} catch (IOException e) {
		throw new RuntimeException(e);
		} catch (URISyntaxException e) {
		e.printStackTrace();
		}
	}
		
	public void nuevoHonguitoBueno() {
		xpos = random.nextInt(34);
		ypos = random.nextInt(23);
		
	//	hongoBueno.x = random.nextInt(34);
	//	hongoBueno.y = random.nextInt(23);
    }

	@Override
	public void dibujarse(Graphics graphics) {
		try {
			graphics.drawImage(img, comidax[xpos], comiday[ypos], null);
           // graphics.drawImage(img, hongoBueno.x*20, hongoBueno.y*20, 20, 20, null);
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
	}
	
	
}