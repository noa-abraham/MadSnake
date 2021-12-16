package juegoViborita;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class Portada extends Pantalla {
	
	private BufferedImage img;
	
	public Portada(int ancho, int largo, String resource) {
		super(ancho, largo, resource);
		try {
			String path = Paths.get(Portada.class.getClassLoader().getResource("imagenes/portada.png").toURI()).toString();
			this.img = ImageIO.read(new File(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	public void dibujarse(Graphics graphics) {
		try {
			graphics.drawImage(img, 0, 0, ancho, largo, null);
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}
	}
	
}
