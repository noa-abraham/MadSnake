package juegoViborita;


import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class Inicializador  {
	

	public static void main(String[] args) {
		
		int anchoVentana = 905;
		int largoVentana = 700;
		int tiempoDeEsperaEntreActualizaciones = 90;

      
        System.setProperty("sun.java2d.opengl", "true");

     
        JFrame ventana = new JFrame("****M A D  // S N A K E**** ");
        
        ventana.setBounds(10, 10,905,700); 
        ventana.setBackground(Color.black); 
        ventana.setResizable(false); 
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
        
        Juego juego = new Juego (anchoVentana, largoVentana, tiempoDeEsperaEntreActualizaciones ); 
        juego.setFocusable(true); 
        juego.setFocusTraversalKeysEnabled(false); 
        
     // Agregar a la ventana el JComponent (Juego hereda de JComponent)
        ventana.add(juego);
        

        // Enviar los eventos recibidos de movimientos del teclado al juego (esto es
        // porque la clase Juego implementa: MouseMotionListener)
        ventana.addKeyListener(juego);

        // Achicar la ventana lo maximo posible para que entren los componentes
        ventana.pack();

        // Crear un thread y pasarle como parametro al juego que implementa la interfaz
        // "Runnable"
        Thread thread = new Thread(juego);

        // Arrancar el juego
        thread.start();

    }
}