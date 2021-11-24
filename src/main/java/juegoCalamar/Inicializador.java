package juegoCalamar;

import javax.swing.JFrame;
import javax.swing.WindowConstants; 

public class Inicializador {
	public static void main(String[] args) {

        // Propiedades del Juego
        int anchoVentana = 800;
        int largoVentana = 600;

        // Activar aceleracion de graficos en 2 dimensiones
        System.setProperty("sun.java2d.opengl", "true");

        // Crear un objeto de tipo JFrame que es la ventana donde va estar el juego
        JFrame ventana = new JFrame("Mi Juego");

        // Cerrar la aplicacion cuando el usuario hace click en la 'X'
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Abrir la ventana en el centro de la pantalla
        ventana.setLocationRelativeTo(null);

        // Mostrar la ventana
        ventana.setVisible(true);

        // Crear un "JPanel" llamado Juego y agregarlo a la ventana
        Panel panel = new Panel(anchoVentana, largoVentana);

        // Agregar a la ventana el JPanel (Panel hereda de JPanel)
        ventana.add(panel);

        // Achicar la ventana lo maximo posible para que entren los componentes
        ventana.pack();

    }
	

}
