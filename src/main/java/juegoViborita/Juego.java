package juegoViborita;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	private PantallaIlustrada portada;
	private PantallaIlustrada pantallaGanador;
	private PantallaPerdedor pantallaPerdedor;
	private CabeceraTitulo cabeceraTitulo; 
	private Nivel nivel; 
	public static int level = 1;
	private Puntaje puntaje; 
	private Sonidos sonidos; 
	
	
	public Juego (int anchoJuego, int largoJuego, int tiempoDeEsperaEntreActualizaciones ) {
		this.pantallaActual = PANTALLA_INICIO; 
		this.anchoJuego = anchoJuego;
		this.largoJuego = largoJuego;
		this.tiempoDeEsperaEntreActualizaciones = tiempoDeEsperaEntreActualizaciones;
		this.portada = new PantallaIlustrada(anchoJuego, largoJuego, "imagenes/portada.png"); 
		this.pantallaGanador = new PantallaIlustrada(anchoJuego, largoJuego, "imagenes/ganaste.png"); 
	    cargarSonidos();
	    this.sonidos.repetirSonido("background");
	    inicializarJuego (); 
	}

	private void inicializarJuego() {
		this.pantallaPerdedor = null;
		this.nivel = new Nivel(100,47, new Font("Impact", Font.PLAIN, 20), Color.magenta);
		this.puntaje = new Puntaje (700, 47, new Font("Impact",Font.PLAIN, 20), Color.magenta);
		this.cabeceraTitulo = new CabeceraTitulo (851, 55, "imagenes/cabecera3.png"); 
        this.viborita = new Viborita(); 
        viborita.crecerCola();
	    this.hongoBueno = new HongoBueno(); 
        hongoBueno.nuevoHonguitoBueno(); 
        this.hongoMalo = new HongoMalo (); 
	    hongoMalo.nuevoHonguitoMalo();  
	   
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
	   
	
	protected void paintComponent(Graphics g) {
		this.limpiarPantalla (g); 
		if (pantallaActual == PANTALLA_INICIO) {
			dibujarInicioJuego(g);
		}
		if (pantallaActual == PANTALLA_PERDEDOR) {
			if (this.pantallaPerdedor == null) {
				this.pantallaPerdedor = new PantallaPerdedor(anchoJuego, largoJuego, "imagenes/perdiste.png", this.puntaje.getPuntaje());
			}
			pantallaPerdedor.dibujarse(g);
		}
		if (pantallaActual == PANTALLA_GANADOR) {
			pantallaGanador.dibujarse(g);
		}
		if (pantallaActual == PANTALLA_JUEGO) {
			dibujarEspacioDeJuego(g);     
		}
	}
		 	 
		 
	private void dibujarInicioJuego(Graphics g) {
		portada.dibujarse(g);
	}
		 
	private void dibujarEspacioDeJuego (Graphics g) {
		cabeceraTitulo.dibujarse(g); 
		g.setColor(Color.DARK_GRAY); 
		g.fillRect(26, 75, 850, 575);
		viborita.dibujarse(g);
	    nivel.dibujarse(g); 
	    puntaje.dibujarse(g);
	    hongoBueno.dibujarse(g); 
	    hongoMalo.dibujarse(g);
	}

	private void actualizarJuego() {
		verificarEstadoAmbiente();
		viborita.moverse();
	}
	    
	private void cargarSonidos() {
		try {
			sonidos = new Sonidos();
			sonidos.agregarSonido("background", "musica/Encantador.wav");
			sonidos.agregarSonido("vida", "musica/vida.wav");
			sonidos.agregarSonido("juego", "musica/juego.wav");
			sonidos.agregarSonido("perdiste", "musica/perdiste.wav");
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}
	}

	private void limpiarPantalla(Graphics graphics) {
		graphics.setColor(Color.DARK_GRAY); 
		graphics.fillRect(0, 0, anchoJuego, largoJuego);
	}
	    
	private void dibujarJuego() {
		this.repaint(); 
	}
	       
	private void esperar(int milisegundos) {
		try {
			Thread.sleep(milisegundos);
		} catch (Exception e1) {
		}
	}
	    
	private void verificarEstadoAmbiente() {
		chequearColisionHongosBuenos();
		chequearColisionHongosMalos(); 
		chequearColisionParedes ();
		chequearColisionConCuerpoViborita();
		chequearPuntosyNiveles(); 
		verificarFinDeJuego();
	}
  
	private void verificarFinDeJuego() {
		if (pantallaActual == PANTALLA_PERDEDOR) {
			inicializarJuego();   
		}
		if (puntaje.getPuntaje() == 50) {
			pantallaActual = PANTALLA_GANADOR;  
		}
	}
	    
	private void chequearColisionHongosBuenos(){ 
		if(viborita.getLargoCuerpito().get(0).equals(hongoBueno.getHongoBueno())) {
			hongoBueno.nuevoHonguitoBueno();
			hongoMalo.nuevoHonguitoMalo();
			viborita.crecerCola();
			puntaje.sumarPunto();
			sonidos.tocarSonido("vida");
		}
	}
	    	
	private void chequearColisionHongosMalos () {	
		if(viborita.getLargoCuerpito().get(0).equals(hongoMalo.getHongoMalo())) {
			pantallaActual = PANTALLA_PERDEDOR;
			sonidos.tocarSonido("perdiste");
		}
	}
	        
	private void chequearColisionParedes () {	
		if(viborita.getLargoCuerpito().get(0).x < 0 || viborita.getLargoCuerpito().get(0).x > 45 ||  
			viborita.getLargoCuerpito().get(0).y < 3 || viborita.getLargoCuerpito().get(0).y > 34) {
				pantallaActual = PANTALLA_PERDEDOR;
	        	sonidos.tocarSonido("perdiste");
		}
	}
	  
	private void chequearColisionConCuerpoViborita () {
		for(int i = 1; i < viborita.getLargoCuerpito().size(); i++) {
			if(viborita.getLargoCuerpito().get(0).equals(viborita.getLargoCuerpito().get(i)) && viborita.getLargoCuerpito().size() > 2) {
				pantallaActual = PANTALLA_PERDEDOR;
				sonidos.tocarSonido("perdiste");
			}
		}
	}
	   
	public void chequearPuntosyNiveles() {
		if (puntaje.getPuntaje() >= 0 && puntaje.getPuntaje() <=10 ) {
			level= 1; 
		} else if (puntaje.getPuntaje() >= 11 && puntaje.getPuntaje() <= 20) {
			level= 2;
	    	nivel.dibujarse(getGraphics());
		}else if (puntaje.getPuntaje() >= 21 &&  puntaje.getPuntaje() <= 30 ) {
			level= 3;
			nivel.dibujarse(getGraphics());  		
		}else if (puntaje.getPuntaje() >= 31 &&  puntaje.getPuntaje() <= 40 ) {
			level= 4;
			nivel.dibujarse(getGraphics());; 
		}else if (puntaje.getPuntaje() >= 41 &&  puntaje.getPuntaje() <= 50 ) {
			level= 5;
			nivel.dibujarse(getGraphics());	
		}else if (puntaje.getPuntaje() == 50) {
			pantallaActual = PANTALLA_GANADOR; 
		}
	}
	      	
	public void agregarHongosMalos (Graphics g) {
		hongoMalo.nuevoHonguitoMalo();
		hongoMalo.dibujarse(g);	
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
	        switch (tecla) {
	        	case KeyEvent.VK_SPACE:
		    		this.repaint();
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
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}
}