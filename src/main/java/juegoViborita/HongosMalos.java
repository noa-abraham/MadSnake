package juegoViborita;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class HongosMalos extends Alimento {

	private BufferedImage img;

	public HongosMalos(int[] hongosPosicionX, int[] hongosPosicionY, int ancho, int largo) {
		super(hongosPosicionX, hongosPosicionY, ancho, largo);
		try {
			String path = Paths.get(HongosBuenos.class.getClassLoader().getResource("imagenes/hongoVioleta.gif").toURI()).toString();
			this.img = ImageIO.read(new File(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void serComido(Graphics graphics) {
		
    }
		

	@Override
	public void dibujarse(Graphics graphics) {
		try {
			graphics.drawImage(img, getHongoPosicionX(), getHongoPosicionY(), null);
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}
	}

}
