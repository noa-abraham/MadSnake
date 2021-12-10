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
	private final static int PANTALLA_INICIO = 1;
	private final static int PANTALLA_JUEGO = 2;
	private final static int PANTALLA_PERDEDOR = 3;
	private final static int PANTALLA_GANADOR = 4;
	private int anchoJuego;
    private int largoJuego;
    private int tiempoDeEsperaEntreActualizaciones;
    private ElementoBasico vibora;
    private ElementoBasico hongosBuenos; 
    private ElementoBasico hongosMalos; 
	private Pantalla fondo; 
	private Puntos puntos; 
	private Nivel nivel; 
	private int pantallaActual;
	private Pantalla portada; 
	private Pantalla pantallaGanador;
    private Pantalla pantallaPerdedor;
    

    
    public JuegoMadSnake (int anchoJuego, int largoJuego, int tiempoDeEsperaEntreActualizaciones) {
    	this.pantallaActual = PANTALLA_INICIO;
        this.anchoJuego = anchoJuego;
        this.largoJuego = largoJuego;
		this.fondo = crearFondo(); 
		this.vibora = crearVibora();
		this.hongosBuenos = crearHongos();
		this.hongosMalos = crearHongos(); 
		this.tiempoDeEsperaEntreActualizaciones = tiempoDeEsperaEntreActualizaciones; 
		this.portada = new Pantalla(anchoJuego, largoJuego, "imagenes/portada.png");
        this.pantallaGanador = new Pantalla(anchoJuego, largoJuego, "imagenes/ganaste.png");
      //  inicializarJuego();
		
	}
    
    @Override
	public Dimension getPreferredSize() {
		return new Dimension(anchoJuego, largoJuego);
	}
    
    
    
    @Override
    public void run() {
        while (true) {
            if (pantallaActual == PANTALLA_JUEGO) {
                actualizarJuego();
            }
            dibujarJuego();
            esperar(tiempoDeEsperaEntreActualizaciones);
        }
    }

    
 // metodo para esperar una cantidad de milisegundos
    private void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
    }

	
	@Override
    protected void paintComponent(Graphics g) {
		fondo.dibujarse(g);
		vibora.dibujarse(g);
		hongosBuenos.dibujarse(g);
	}
	
	 private void actualizarJuego() {
	     vibora.moverse();
	      
	    }
	 
	 
	 private void dibujarJuego() {
	        this.repaint();
	 }
	 
	  private Pantalla crearFondo() {
	    	return new Pantalla (anchoJuego, anchoJuego, name); 
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

