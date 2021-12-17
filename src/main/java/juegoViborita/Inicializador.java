package juegoViborita;


import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class Inicializador  {
	

	public static void main(String[] args) {
		
		int anchoVentana = 900;
		int largoVentana = 700;
		int tiempoDeEsperaEntreActualizaciones = 90;

 
        System.setProperty("sun.java2d.opengl", "true");
        JFrame ventana = new JFrame("MAD SNAKE");
        ventana.setBounds(10, 10,900,700); 
        ventana.setBackground(Color.black); 
        ventana.setResizable(false); 
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        Juego juego = new Juego (anchoVentana, largoVentana, tiempoDeEsperaEntreActualizaciones ); 
        juego.setFocusable(true); 
        juego.setFocusTraversalKeysEnabled(false); 
        ventana.add(juego);
        ventana.addKeyListener(juego);
        ventana.pack();
        Thread thread = new Thread(juego);
        thread.start();
    }
}