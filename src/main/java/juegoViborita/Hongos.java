package juegoViborita;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

public class Hongos extends ElementoBasico {
	
	private BufferedImage img;

	public Hongos(int posicionX, int posicionY, double velocidadX, double velocidadY, int ancho, int largo,
			Color color) {
		super(posicionX, posicionY, velocidadX, velocidadY, ancho, largo, color);
		try {
			String path = Paths.get(Hongos.class.getClassLoader().getResource("imagenes/hongoVioleta.gif").toURI()).toString();
			this.img = ImageIO.read(new File(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}
	
		
	@Override
	public boolean hayColision(ElementoBasico elemento) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void dibujarse(Graphics graphics) {
		try {
			graphics.drawImage(img, getPosicionX(), getPosicionY(), null);
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}
		
	}
		
}