package juegoCalamar;

public interface Tablero extends Dibujable {
	
	public int getPosicionX();
	
	public int getPosicionY();
	public int getAncho (); 
	public int getLargo (); 
	public Color getColor(); 
	public void moverse ();
	public boolean hayColision (Tablero tablero); 
	

}
