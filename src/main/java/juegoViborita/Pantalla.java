package juegoViborita;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;


public class Pantalla implements Dibujable {
	
	private BufferedImage img;
	protected int ancho;
    protected int largo;
	
    public Pantalla (int ancho, int largo, String resource) {
		try {
			String path = Paths.get(Pantalla.class.getClassLoader().getResource("imagenes/portada.png").toURI()).toString();
			this.img = ImageIO.read(new File(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
    }

	@Override
	public void dibujarse(Graphics graphics) {
		try {
			graphics.drawImage(img, 0, 0, ancho, largo, null);
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}
		
	}

}
