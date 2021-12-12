package juegoViborita;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Juego extends JPanel implements KeyListener, Runnable {
    
	

	private static final long serialVersionUID = 1L;
	private final static int PANTALLA_INICIO = 1;
    private final static int PANTALLA_JUEGO = 2;
    private final static int PANTALLA_PERDEDOR = 3;
    private final static int PANTALLA_GANADOR = 4;
	
	private int anchoJuego;
	private int largoJuego;
	private int tiempoDeEsperaEntreActualizaciones; 
	
	private Viborita viborita;
	private HongoBueno hongoBueno; 
	private HongoMalo hongoMalo; 
	private List<HongoMalo> hongosMalos;
	
	private int Score;
    private long goal;
    private boolean juegoCorriendo;
    private int pantallaActual;
	private Portada portada;
	 private Pantalla pantallaGanador;
	private PantallaPerdedor pantallaPerdedor;
	
    
    private int puntos;
    private int nivel;
    private Sonidos sonidos;
	
	
		
		public Juego (int anchoJuego, int largoJuego, int tiempoDeEsperaEntreActualizaciones ) {
			this.pantallaActual = PANTALLA_INICIO;
			this.anchoJuego = anchoJuego;
			this.largoJuego = largoJuego;
			this.tiempoDeEsperaEntreActualizaciones = tiempoDeEsperaEntreActualizaciones;
			this.portada = new Portada(anchoJuego, largoJuego, "imagenes/portada.png");
	        this.hongosMalos = new ArrayList<HongoMalo>();
	       
	      //  cargarSonidos();
	       // this.sonidos.tocarSonido("apertura"); 
	        inicializarJuego (); //para cuando inicia el juego como pára cuyando perdes
		}



		private void inicializarJuego() {
			this.pantallaPerdedor = null;
	        this.viborita = new Viborita (); 
	        viborita.crecerCola();
	        this.hongoBueno = new HongoBueno();
	        hongoBueno.nuevoHonguitoBueno(); 
	        agregarHonguitosMalos (); 
	        //Score=0; 
	      
	    }
		
		private void agregarHonguitosMalos () {
			if(puntos>10 && puntos<=20) {
				hongoMalo.nuevoHonguito();
			}
			
		}
		
		 protected void paintComponent(Graphics g) {
		   
		        if (pantallaActual == PANTALLA_INICIO) {
		            dibujarInicioJuego(g);
		        }
		        if (pantallaActual == PANTALLA_PERDEDOR) {
		            if (this.pantallaPerdedor == null) {
		                this.pantallaPerdedor = new PantallaPerdedor(anchoJuego, largoJuego, "imagenes/perdiste.png", this.nivel;
		            }
		            pantallaPerdedor.dibujarse(g);
		        }
		        if (pantallaActual == PANTALLA_GANADOR) {
		            pantallaGanador.dibujarse(g);
		        }
		        if (pantallaActual == PANTALLA_JUEGO) {
		            viborita.dibujarse(g);
		            hongoBueno.dibujarse(g)
		         
		         
		        }
		    }
		
		 
		 private void dibujarInicioJuego(Graphics g) {
		        portada.dibujarse(g);
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
		
		// En este metodo se actualiza el estado de todos los elementos del juego
	    private void actualizarJuego() {
	        verificarEstadoAmbiente();
	        viborita.moverse();
	     
	       
	    }
	   
	    
	    private void dibujarJuego() {
	        this.repaint();
	    }
	    
	    private void esperar(int milisegundos) {
	        try {
	            Thread.sleep(milisegundos);
	        } catch (Exception e1) {
	            throw new RuntimeException(e1);
	        }
	    }
		
	    private void verificarEstadoAmbiente() {
	    	chequearColision(); 
	        verificarFinDeJuego();
	    }
	    
	    private void verificarFinDeJuego() {

	        if (pantallaActual == PANTALLA_PERDEDOR) {
	        	inicializarJuego();
	            
	        }
	    }
		
	    private void chequearColision(){
	        if(viborita.getLargoCuerpito().get(0).equals(hongoBueno.getHongoBueno())) {
	            hongoBueno.nuevoHonguitoBueno();
	            viborita.crecerCola();;
	            Score+=10;
	        }
	        
	        
	        
	        for(int n = 1; n < viborita.getLargoCuerpito().size(); n++) {
	            if(viborita.getLargoCuerpito().get(0).equals(viborita.getLargoCuerpito().get(n)) && viborita.getLargoCuerpito().size() > 2) {
	            	pantallaActual = PANTALLA_PERDEDOR;
	            	
	            }
	        }
	    }

		public void paintJuego(Graphics graphics) {
			g.setColor(Color.MAGENTA); //color rectangulo que enmarca cabeceraTitulo, arriba, a los puntos, niveles y vidas
			g.drawRect(24, 10, 851, 55);
			
		
			
			g.setColor(Color.GREEN);//color BORDE RECTANGULO DEL ESPACIO DE JUEGO
			g.drawRect(25, 74, 851, 577);
			
			g.setColor(Color.DARK_GRAY); //COLOR RELLENO DEL RECTANGULO DEL ESPAICO DE JUEGO
			g.fillRect(26, 75, 850, 575);
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Impact", Font.PLAIN, 14));
			g.drawString("Scores: "+puntos, 780, 30);
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Impact", Font.PLAIN, 14));
			g.drawString("Length: "+length, 780, 50);
			
		}
		
		
		
		
		



		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void keyPressed(KeyEvent e) {
			int tecla = e.getKeyCode();
			   
		    switch (tecla){
		        case KeyEvent.VK_UP:
		            viborita.direccion("ARR");
		            break;
		        case KeyEvent.VK_DOWN:
		        	viborita.direccion("ABA");
		            break;
		        case KeyEvent.VK_LEFT:
		        	viborita.direccion("IZQ");
		            break;
		        case KeyEvent.VK_RIGHT:
		        	viborita.direccion("DER");
		            break;
		        case KeyEvent.VK_E:
		            System.exit(0);
		        
		    }

		}
			



		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		

		
	

}