package juegoViborita;

public abstract class PersonajeBasico implements Personaje {
	
	private int posicionX;
	
	private int posicionY;
	
	private int velocidadX;
	
	private int velocidadY; 
	
	
	public PersonajeBasico (int posicionX, int posicionY, int velocidadX, int velocidadY) {
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
		this.setVelocidadX(velocidadX);
		this.setVelocidadY(velocidadY); 
	}
	
	//public boolean detectarColision (Personaje personaje) {
	//completar el método más adelante


	public int getPosicionX() {
		return posicionX;
	}


	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}
	
	
	public int getPosicionY() {
		return posicionY;
	}


	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	
	
	public int getVelocidadX() {
		return velocidadX;
	}


	public void setVelocidadX(int velocidadX) {
		this.velocidadX = velocidadX;
	}

	
	public int getVelocidadY() {
		return velocidadY;
	}


	public void setVelocidadY(int velocidadY) {
		this.velocidadY = velocidadY;
	}

}