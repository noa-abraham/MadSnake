package juegoViborita;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

public class Juego extends JPanel implements KeyListener, Runnable {
	

    private static final long serialVersionUID = 1L;
    private int anchoJuego;
    private int largoJuego;
    private int tiempoDeEsperaEntreActualizaciones;
    private ElementoBasico fondo; 
    private ElementoBasico vibora;
    private ElementoBasico hongos; 

    
    public Juego (int anchoJuego, int largoJuego) {
		this.anchoJuego = anchoJuego; 
		this.largoJuego = largoJuego;
		this.fondo = crearFondo(); 
		this.vibora = crearVibora();
		this.hongos = crearHongos(); 
		
	}
    
    @Override
	public Dimension getPreferredSize() {
		return new Dimension(anchoJuego, largoJuego);
	}
    
    @Override
   	public void run() {
    	while (true) {
    		actualizarJuego(); 
    		dibujarJuego();
    		esperar(tiempoDeEsperaEntreActualizaciones);
    	}
       
   	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		 if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			vibora.setVelocidadX(vibora.getPosicionX() + 1 );
			vibora.setPosicionX(anchoJuego);
			
			
		} if(arg0.getKeyCode()== KeyEvent.VK_LEFT) {
			vibora.setVelocidadX(vibora.getPosicionX() - 1);
			vibora.setPosicionX(anchoJuego);
			
		} if(arg0.getKeyCode()== KeyEvent.VK_UP) {
			vibora.setVelocidadY(vibora.getPosicionY()-1);
		
			
		} if(arg0.getKeyCode()== KeyEvent.VK_DOWN) {
			vibora.setVelocidadY(vibora.getPosicionY() + 1);
			
		}
	}
		

	@Override
	public void keyReleased(KeyEvent arg0) {
		// si suelto la tecla 39 o la 37 se asigna velocidad 0 a la vibora
        if (arg0.getKeyCode() == KeyEvent.VK_RIGHT || arg0.getKeyCode() == KeyEvent.VK_LEFT) {
            vibora.setVelocidadX(0); 
        }
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	
		
	}
	
	@Override
    protected void paintComponent(Graphics g) {
		fondo.dibujarse(g);
		vibora.dibujarse(g);
		hongos.dibujarse(g);
	}
	
	 private void actualizarJuego() {
	     vibora.moverse();
	      
	    }
	 
	 
	 
	 private void dibujarJuego() {
	        this.repaint();
	 }
	 
	  private ElementoBasico crearFondo() {
	    	return new Fondo (0, 0, 0, 0, 600, 640, null);
	    }
	    
	    
	  private ElementoBasico crearVibora() {
	       return new Vibora(80,80, 0, 0, 40, 40, Color.CYAN);
	  }
	  
	  private ElementoBasico crearHongos () {
		  return new Hongos(280,580, 0, 0, 40, 40, Color.green);
	  }
	  
	// metodo para esperar una cantidad de milisegundos
	    private void esperar(int milisegundos) {
	        try {
	            Thread.sleep(milisegundos);
	        } catch (Exception e1) {
	            throw new RuntimeException(e1);
	        }
	    }

}
