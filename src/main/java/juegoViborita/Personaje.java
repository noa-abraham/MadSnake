package juegoViborita;

public interface Personaje extends Dibujable {
	
	public int getPosicionX();
	
	public int getPosicionY(); 
	
	public int getVelocidadX();
	
	public int getVelocidadY(); 
	
	public boolean detectarColision (Personaje personaje); 

}
