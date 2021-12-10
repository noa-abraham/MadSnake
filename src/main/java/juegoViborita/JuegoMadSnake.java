package juegoViborita;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.JComponent;

public class JuegoMadSnake extends JComponent implements KeyListener, Runnable {
	
	private static final long serialVersionUID = 1L;
    private int anchoJuego;
    private int largoJuego;
    private ElementoBasico vibora;
    private ElementoBasico hongos;
	private Pantalla fondo; 
    

    
    public JuegoMadSnake (int anchoJuego, int largoJuego) {
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
    		//esperar(tiempoDeEsperaEntreActualizaciones);
    	}
       
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
	 
	  private Pantalla crearFondo() {
	    	return new Pantalla (anchoJuego, anchoJuego); 
	    }
	    
	    
	  private ElementoBasico crearVibora() {
	       return new Vibora(80,80, 0, 0, 40, 40, Color.CYAN);
	  }
	  
	  private ElementoBasico crearHongos () {
		  return new HongosBuenos(280,580, 0, 0, 40, 40, Color.green);
	  }
	  

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

}

