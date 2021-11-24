package juegoCalamar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
public class Calamar extends ElementoBasico  {
	
	private BufferedImage img; 
	
	public Calamar(int posicionX, int posicionY, int velocidadX, int velocidadY, int ancho, int largo, Color color) {
        super(posicionX, posicionY, velocidadX, velocidadY, ancho, largo, color);
        String path = Paths.get(Calamar.class.getClassLoader().getResource("JuegoCalamar.imagenes/calamarimagen.png").getPath())
                .toString();
        try {
            this.img = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void dibujarse(Graphics graphics) {
        try {
            graphics.drawImage(img, getPosicionX(), getPosicionY(), this.getAncho(), this.getLargo(), null);
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
    }

    public void destruirse(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillOval(getPosicionX(), getPosicionY(), getAncho(), getLargo());
    }


}
