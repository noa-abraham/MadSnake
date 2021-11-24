package juegoCalamar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel {

    private static final long serialVersionUID = 1L;
    private int anchoJuego;
    private int largoJuego;

    public Panel(int anchoJuego, int largoJuego) {
        this.anchoJuego = anchoJuego;
        this.largoJuego = largoJuego;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(anchoJuego, largoJuego);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujar(g);
    }
    
    public void dibujar(Graphics graphics) {
        graphics.setColor(Color.blue);
        graphics.fillRect(90, 120, 200,300);
        graphics.setFont(new Font("Arial", 8, 20));
        graphics.drawString("Hola manola", 100, 100);

    }

}