package juegoViborita;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

public class HongosBuenos extends Alimento {
	
	private BufferedImage img;
	
	
	public HongosBuenos(int posicionX, int posicionY, int ancho, int largo, Color color, int[] hongosPosicionX, int[] hongosPosicionY) {
		super(posicionX, posicionY, ancho, largo, color, hongosPosicionX, hongosPosicionY);
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
	public void dibujarse(Graphics graphics) {
		try {
			graphics.drawImage(img, this.getAncho(), this.getLargo(), null);
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}
		
	}

	@Override
	public void serComido(Graphics graphics) {
		
    }
		
}