package juegoViborita;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;


public class PantallaIlustrada implements Dibujable {
	
	private BufferedImage img;
	protected int ancho;
    protected int largo;
	
    public PantallaIlustrada (int ancho, int largo, String resource) {
		try {
			this.ancho = ancho;
			this.largo = ancho; 
			String path = Paths.get(PantallaIlustrada.class.getClassLoader().getResource(resource).toURI()).toString();
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
	