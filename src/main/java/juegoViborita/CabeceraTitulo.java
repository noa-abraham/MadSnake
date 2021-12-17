package juegoViborita;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class CabeceraTitulo extends PantallaIlustrada {
	
	private BufferedImage img;
	
	public CabeceraTitulo(int ancho, int largo, String resource) {
		super(ancho, largo, resource);
		try {
			String path = Paths.get(CabeceraTitulo.class.getClassLoader().getResource("imagenes/cabecera2.png").toURI()).toString();
			this.img = ImageIO.read(new File(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public void dibujarse(Graphics graphics) {
		try {
			graphics.drawImage(img, 25, 11, 850, 55, null);
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}
	}
}