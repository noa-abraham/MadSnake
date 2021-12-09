package juegoViborita;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ArrancarJuego {

    public static void main(String[] args) {

        // Propiedades del Juego
        int anchoVentana = 905;
        int largoVentana = 700;
        int tiempoDeEsperaEntreActualizaciones = 80;
        
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
        
        Juego juego = new Juego (anchoVentana, largoVentana); 
        
        ventana.add(juego); 
        
        ventana.addKeyListener(juego);
        
        ventana.pack();
        
        Thread thread = new Thread(juego);
        
        thread.start();
    }

}