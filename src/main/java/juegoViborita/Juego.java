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
	 
	

    private int pantallaActual;
	private Pantalla portada;
	private Pantalla pantallaGanador;
	private PantallaPerdedor pantallaPerdedor;
	private ImageIcon image;
	
    
    private int puntos;
    private int nivel;
    private int length;
    //private Sonidos sonidos;
	
	
		
		public Juego (int anchoJuego, int largoJuego, int tiempoDeEsperaEntreActualizaciones ) {
			this.pantallaActual = PANTALLA_INICIO;
			this.anchoJuego = anchoJuego;
			this.largoJuego = largoJuego;
			this.tiempoDeEsperaEntreActualizaciones = tiempoDeEsperaEntreActualizaciones;
			this.portada = new Pantalla(anchoJuego, largoJuego, "imagenes/portada.png");
	        
	       
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
	        length = 0; 
	       
	      
	    }
		
		private void agregarHonguitosMalos () {
			if(puntos>10 && puntos<=20) { //level 2
				hongoMalo.nuevoHonguito();
				 
			}
			
			if (puntos>20) {
				hongoMalo.nuevoHonguito(); //level 3
				hongoMalo.nuevoHonguito();
				hongoMalo.nuevoHonguito();
				hongoMalo.nuevoHonguito();

			}
		
		}
	
		
		 protected void paintComponent(Graphics g) {
				this.limpiarPantalla (g); 
		        if (pantallaActual == PANTALLA_INICIO) {
		            dibujarInicioJuego(g);
		        }
		        if (pantallaActual == PANTALLA_PERDEDOR) {
		            if (this.pantallaPerdedor == null) {
		                this.pantallaPerdedor = new PantallaPerdedor(anchoJuego, largoJuego, "imagenes/perdiste.png", this.nivel);
		            }
		            pantallaPerdedor.dibujarse(g);
		        }
		        if (pantallaActual == PANTALLA_GANADOR) {
		            pantallaGanador.dibujarse(g);
		        }
		        if (pantallaActual == PANTALLA_JUEGO) {
		            viborita.dibujarse(g);
		            hongoBueno.dibujarse(g); 
		         
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
	        chequearColision(); 
	       
	 
	    }
	   
	 // metodo para limpiar la pantalla
	    private void limpiarPantalla(Graphics graphics) {
	    			
	    	graphics.setColor(Color.MAGENTA); //color rectangulo que enmarca cabeceraTitulo, arriba, a los puntos, niveles y vidas
			graphics.drawRect(24, 10, 851, 55);
			 
			 image=new ImageIcon("cabecera.png"); //cabeceraTitulo-fondo de color liso y el nombre en el medio
			 image.paintIcon(this,graphics, 25, 11);
			
			 graphics.setColor(Color.GREEN);//color BORDE RECTANGULO DEL ESPACIO DE JUEGO
			 graphics.drawRect(25, 74, 851, 577);
			
			 graphics.setColor(Color.DARK_GRAY); //COLOR RELLENO DEL RECTANGULO DEL ESPAICO DE JUEGO
			 graphics.fillRect(26, 75, 850, 575);
			 
			 graphics.setColor(Color.MAGENTA);
			 graphics.setFont(new Font("Impact", Font.PLAIN, 20));
			 graphics.drawString("LEVEL 1 score(0-10)", 100, 47);
			
			 graphics.setColor(Color.WHITE);
			 graphics.setFont(new Font("Impact", Font.PLAIN, 14));
			 graphics.drawString("Scores: "+puntos, 780, 30);
			
			 graphics.setColor(Color.WHITE);
			 graphics.setFont(new Font("Impact", Font.PLAIN, 14));
			 graphics.drawString("Length: "+length, 780, 50);
	    }
	    
	    
	    private void dibujarJuego() {
	        this.repaint(); //va a llamar a paint component
	    }
	    
	    private void esperar(int milisegundos) {
	        try {
	            Thread.sleep(milisegundos);
	        } catch (Exception e1) {
	            throw new RuntimeException(e1);
	        }
	    }
		
	    private void verificarEstadoAmbiente() {
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
	            viborita.crecerCola();
	            length++;
	        }
	        
	        /* Si traspasa la pared, usar este if que lo dejo bloqueado ya que la idea es que sea en otro nivel que ocurra
	        if(viborita.getLargoCuerpito().get(0).x < 0 || viborita.getLargoCuerpito().get(0).x > 39 ||
	        		viborita.getLargoCuerpito().get(0).y < 1 || viborita.getLargoCuerpito().get(0).y > 29) {
	        		pantallaActual = PANTALLA_PERDEDOR;
	            }
	        */
	        
	        for(int n = 1; n < viborita.getLargoCuerpito().size(); n++) {
	            if(viborita.getLargoCuerpito().get(0).equals(viborita.getLargoCuerpito().get(n)) && viborita.getLargoCuerpito().size() > 2) {
	            	pantallaActual = PANTALLA_PERDEDOR;
	            	
	            }
	        }
	    }

	    public void paintJuego(Graphics graphics) {
			 graphics.setColor(Color.MAGENTA); //color rectangulo que enmarca cabeceraTitulo, arriba, a los puntos, niveles y vidas
			 graphics.drawRect(24, 10, 851, 55);
			
			 graphics.setColor(Color.GREEN);//color BORDE RECTANGULO DEL ESPACIO DE JUEGO
			 graphics.drawRect(25, 74, 851, 577);
			
			 graphics.setColor(Color.DARK_GRAY); //COLOR RELLENO DEL RECTANGULO DEL ESPAICO DE JUEGO
			 graphics.fillRect(26, 75, 850, 575);
			
			 graphics.setColor(Color.WHITE);
			 graphics.setFont(new Font("Impact", Font.PLAIN, 14));
			 graphics.drawString("Scores: "+puntos, 780, 30);
			
			 graphics.setColor(Color.WHITE);
			 graphics.setFont(new Font("Impact", Font.PLAIN, 14));
			 graphics.drawString("Length: "+length, 780, 50);
			
		}
		
		
		

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void keyPressed(KeyEvent e) {
			if (pantallaActual == PANTALLA_INICIO) {
	            inicializarJuego();
	            pantallaActual = PANTALLA_JUEGO;
	        }

	        if (pantallaActual == PANTALLA_PERDEDOR || pantallaActual == PANTALLA_GANADOR) {
	            pantallaActual = PANTALLA_INICIO;
	        }

	        if (pantallaActual == PANTALLA_JUEGO) {

			int tecla = e.getKeyCode();
			   
		    switch (tecla){
		    	case KeyEvent.VK_SPACE:
		    		repaint(); 
		    	
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
		}
			



		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		

		
	

}