package juegoViborita;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class HongoMalo {
	
	private Random random;
    private Point honguito;
    
    public HongoMalo(){
        random = new Random(); 
        honguito = new Point();
    }

    public void nuevoHonguito() {
        honguito.x = random.nextInt(34);
        honguito.y = random.nextInt(23);
    }

    public void dibujoHonguito(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(honguito.x*20, honguito.y*20, 20, 20);
    }
    
    public Point getHonguito()
    {
        return honguito;
    }
    
}
	
