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

public class HongoMalo implements Dibujable {
	private Random random;
    private Point hongoMalo;
    private BufferedImage img;
    private int posicionX = 34; 
    private int posicionY = 23; 
    
    public HongoMalo(){
        random = new Random(); 
        hongoMalo = new Point();
        try {
    		String path = Paths.get(HongoMalo.class.getClassLoader().getResource("imagenes/hongoAzul.gif").toURI()).toString();
    		this.img = ImageIO.read(new File(path));
    		} 
        catch (IOException e) {
    		throw new RuntimeException(e);
    		} catch (URISyntaxException e) {
    			e.printStackTrace();
    		}
    }
   

    public void nuevoHonguitoMalo() {
        hongoMalo.x = random.nextInt(posicionX);
        hongoMalo.y = random.nextInt(posicionY);
        if (hongoMalo.y <= 3) {
        	hongoMalo.y = 4;
		}
		if (hongoMalo.x <= 1) {
			hongoMalo.x = 4; 
		}
    }

	@Override
    public void dibujarse(Graphics graphics) {
    	try {
    		graphics.drawImage(img, hongoMalo.x*20, hongoMalo.y*20, 20, 20, null);
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
    }
	
	
    public Point getHongoMalo() {
        return hongoMalo;
    }
}

