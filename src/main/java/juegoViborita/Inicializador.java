package juegoViborita;

import java.awt.Color;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Inicializador  {
	
	
	public static void main(String[] args) {

       
        int anchoVentana = 905;
        int largoVentana = 700;
     
       
        
     // Activar aceleracion de graficos en 2 dimensiones
        System.setProperty("sun.java2d.opengl", "true");

        // Crear un objeto de tipo JFrame que es la ventana donde va estar el juego
        JFrame ventana = new JFrame("****M A D  // S N I K E**** ");

        // Cerrar la aplicacion cuando el usuario hace click en la 'X'
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Abrir la ventana en el centro de la pantalla
        ventana.setLocationRelativeTo(null);

        // Mostrar la ventana
        ventana.setVisible(true);
        
        JuegoMadSnake juegoMadSnake = new JuegoMadSnake (anchoVentana, largoVentana); 
        
     
		ventana.add(juegoMadSnake);
		// Enviar los eventos recibidos de movimientos del teclado al juego (esto es
        // porque la clase Juego implementa: MouseMotionListener)
        ventana.addKeyListener(juegoMadSnake);

        // Achicar la ventana lo maximo posible para que entren los componentes
        ventana.pack();

        
        Thread thread = new Thread(juegoMadSnake);
        thread.start();
    }

}