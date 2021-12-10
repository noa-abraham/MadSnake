package juegoViborita;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JPanel;

public class Inicio extends JPanel implements KeyListener, Runnable {
	
	//poner en esta clase el sonido de inicio!!!!!!!!!!!!!!!!

    private static final long serialVersionUID = 1L;
    private int anchoJuego;
    private int largoJuego;
    private Pantalla portada; 
   

    
    public Inicio (int anchoJuego, int largoJuego) {
		this.anchoJuego = anchoJuego; 
		this.largoJuego = largoJuego;
		this.portada = new Portada (905, 700, getName()); 
		
	}
    
    protected void paintComponent(Graphics g) {
		portada.dibujarse(g);
	}
    
    @Override
	public Dimension getPreferredSize() {
		return new Dimension(anchoJuego, largoJuego);
	}
    
    
	  @Override
		public void run() {
			// TODO Auto-generated method stub
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
