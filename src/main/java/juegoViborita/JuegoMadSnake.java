package juegoViborita;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class JuegoMadSnake extends JComponent implements KeyListener, Runnable {


	private static final long serialVersionUID = 1L;

	// TODO Auto-generated method stub
	private ImageIcon image;
	
	private int[] ViboritaPosicionX=new int[750];
	private int[] ViboritaPosicionY=new int[750];
	
	private boolean left=false, right=false, up=false, down=false; //movimientos
	
	private ImageIcon cabezaVibora;
	private ImageIcon cuerpitoVibora;
	private ImageIcon honguitoBuenoImagen;
	private ImageIcon honguitoMaloImagen;
	
	private int length=3;
	
	
	private int moverse=0;
	
	
	//aparece a parti de 25 px X (como la caberca de titulo) hasta largo/ancho menos lo ya ocupado
	//SON IGUALES! SE PUEDEN SETEAR DE 1 EN UNA CLASE MAYOR.
	private int[] hongoBuenoX = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,
			425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	private int[] hongoBuenoY = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,
			425,450,475,500,525,550,575,600,625};
	
	private int[] hongoMaloPosX = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,
			425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850}; //34
	private int[] hongoMaloPosY = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,
			425,450,475,500,525,550,575,600,625}; //23
	
	private Random random=new Random(); 
	
	private int posXHongoMalo=random.nextInt(hongoMaloPosX.length-1);//CANTIDAD DE POSICIONES DE HOMGP EN X
	private int posYHongoMalo=random.nextInt(hongoMaloPosY.length-1); //CANTIDAD DE POSICIONES DE HOMGP EN Y
	
	//Los 4 hongosMalos(llamados antes bomb)podria crear cuatro instancias (news)
	private int posicionXHongoMalo=0; 
	private int posicionYHongoMalo=0; 
	private int posicionXHongoMalo1=0;
	private int posicionYHongoMalo1=0; 
	private int poscionxHongoMalo2=0; 
	private int posicionYHongoMalo2=0; 
	private int posicionXHongoMalo3=0; 
	private int posicionYHongoMalo3=0;
	
	
	private int puntos;
	
	
	public JuegoMadSnake(int anchoVentana, int largoVentana) {
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g)    //draw everything in the panel
	{
		if(moverse==0)
		{
			ViboritaPosicionX[2]=50;
			ViboritaPosicionX[1]=75;
			ViboritaPosicionX[0]=100;
			
			ViboritaPosicionY[2]=100;
			ViboritaPosicionY[1]=100;
			ViboritaPosicionY[0]=100;
		}
		g.setColor(Color.MAGENTA); //color rectangulo que enmarca cabeceraTitulo, arriba, a los puntos, niveles y vidas
		g.drawRect(24, 10, 851, 55);
		
		image=new ImageIcon("cabecera.png"); //cabeceraTitulo-fondo de color liso y el nombre en el medio
		image.paintIcon(this , g, 25, 11);
		
		g.setColor(Color.GREEN);//color BORDE RECTANGULO DEL ESPACIO DE JUEGO
		g.drawRect(25, 74, 851, 577);
		
		g.setColor(Color.DARK_GRAY); //COLOR RELLENO DEL RECTANGULO DEL ESPAICO DE JUEGO
		g.fillRect(26, 75, 850, 575);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Impact", Font.PLAIN, 14));
		g.drawString("Scores: "+puntos, 780, 30);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Impact", Font.PLAIN, 14));
		g.drawString("Length: "+length, 780, 50);
		
		cabezaVibora=new ImageIcon("upmouth.png");
		cabezaVibora.paintIcon(this, g, ViboritaPosicionX[0], ViboritaPosicionY[0]);
		
		for(int i=0;i<length;i++)
		{
			if(i==0)
			{
				cabezaVibora=new ImageIcon("upmouth.png");
				cabezaVibora.paintIcon(this, g, ViboritaPosicionX[i], ViboritaPosicionY[i]);
			}
			else
			{
				cuerpitoVibora=new ImageIcon("snakeimage.png");
				cuerpitoVibora.paintIcon(this, g, ViboritaPosicionX[i], ViboritaPosicionY[i]);
			}
		}
		
		honguitoBuenoImagen=new ImageIcon("enemy.png");
		honguitoMaloImagen=new ImageIcon("bomb.jpg");
		honguitoBuenoImagen.paintIcon(this, g, hongoBuenoX[posXHongoMalo], hongoBuenoY[posYHongoMalo]);
		
		if(puntos>10 && puntos<=20) {// si los puntos son asi, los honguitos paarecen random en 2 lugares. 
			honguitoMaloImagen.paintIcon(this, g, hongoMaloPosX[posicionXHongoMalo], hongoMaloPosY[posicionYHongoMalo]);
			
		} else if(puntos>20) {
			honguitoMaloImagen.paintIcon(this, g, hongoMaloPosX[posicionXHongoMalo], hongoMaloPosY[posicionYHongoMalo]);
			honguitoMaloImagen.paintIcon(this, g, hongoMaloPosX[posicionXHongoMalo1], hongoMaloPosY[posicionYHongoMalo1]);
			honguitoMaloImagen.paintIcon(this, g, hongoMaloPosX[poscionxHongoMalo2], hongoMaloPosY[posicionYHongoMalo2]);
			honguitoMaloImagen.paintIcon(this, g, hongoMaloPosX[posicionXHongoMalo3], hongoMaloPosY[posicionYHongoMalo3]);
			
		}
		
		//Setea la aparicion random de hongosMalos segun los puntos
		
		if(hongoBuenoX[posXHongoMalo] == ViboritaPosicionX[0] && hongoBuenoY[posYHongoMalo] == ViboritaPosicionY[0]) //si come (general)
		{
			puntos++;
			length++;
			posXHongoMalo=random.nextInt(hongoMaloPosX.length);
			posYHongoMalo=random.nextInt(hongoMaloPosY.length);
			/*while((scores>30 && scores<=50) && (xpos!=0 && xpos!=33) && (ypos!=0 && ypos!=22))
			{
				xpos=random.nextInt(34);
				ypos=random.nextInt(23);
			}*/
				
			if(puntos>10 && puntos<=20)  //si come y tiene mas de 10 (level 2) aparece 1 hongoMalo x 1 hongoBueno
			{ 
				posicionXHongoMalo=random.nextInt(hongoMaloPosX.length);
				posicionYHongoMalo=random.nextInt(hongoMaloPosY.length);
			}
			else if(puntos>20)  // 4 hongosMalos en level 3 (da la pos x y la y)
			{
				posicionXHongoMalo=random.nextInt(hongoMaloPosX.length);
				posicionYHongoMalo=random.nextInt(hongoMaloPosY.length);
				posicionXHongoMalo1=random.nextInt(hongoMaloPosX.length);
				posicionYHongoMalo1=random.nextInt(hongoMaloPosY.length);
				poscionxHongoMalo2=random.nextInt(hongoMaloPosX.length);
				posicionYHongoMalo2=random.nextInt(hongoMaloPosY.length);
				posicionXHongoMalo3=random.nextInt(hongoMaloPosX.length);
				posicionYHongoMalo3=random.nextInt(hongoMaloPosY.length);
			}
		}
		
		//Condicion de perder y muestra pantalla perdiste. 
		
		if (posicionXHongoMalo!=0) {
			if ((hongoMaloPosX[posicionXHongoMalo]==ViboritaPosicionX[0] && hongoMaloPosY[posicionYHongoMalo]==ViboritaPosicionY[0]) || (hongoMaloPosX[posicionXHongoMalo1]==ViboritaPosicionX[0] && hongoMaloPosY[posicionYHongoMalo1]==ViboritaPosicionY[0]) || (hongoMaloPosX[poscionxHongoMalo2]==ViboritaPosicionX[0] && hongoMaloPosY[posicionYHongoMalo2]==ViboritaPosicionY[0]) || (hongoMaloPosX[posicionXHongoMalo3]==ViboritaPosicionX[0] && hongoMaloPosY[posicionYHongoMalo3]==ViboritaPosicionY[0])){
				
				right=false;
				left=false;
				up=false;
				down=false;
				
				//dibujarPantallaPerdedor
			
				g.setColor(Color.GREEN);
				g.setFont(new Font("Impact", Font.BOLD, 50));
				g.drawString("GAME OVER",50,380);
			
				g.setFont(new Font("Impact", Font.BOLD, 30));
				g.drawString("Press spacebar to Restart",280,340);
			}
		}
		
		for(int i=1;i<length;i++) {
			if(ViboritaPosicionX[i]==ViboritaPosicionX[0] && ViboritaPosicionY[i]==ViboritaPosicionY[0]) {
				right=false;
				left=false;
				up=false;
				down=false;
				
				//dibujarPantallaPerdedor
				
				g.setColor(Color.GREEN);
				g.setFont(new Font("Impact", Font.BOLD, 50));
				g.drawString("GAME OVER",300,300);
				
				g.setFont(new Font("Impact", Font.BOLD, 30));
				g.drawString("Press spacebar to Restart",280,340);
				
			}
		}
		
		//Puntos y Niveles
		
		if(puntos>10 && puntos<=20) {
			//dibujarCambioNivel
			g.setColor(Color.MAGENTA);
			g.setFont(new Font("Impact", Font.PLAIN, 20));
			g.drawString("LEVEL 2 score(11-20)", 100, 47);
			
		}
		else if(puntos>=0 && puntos<=10)
		{//dibujarCambioNivel
			g.setColor(Color.MAGENTA);
			g.setFont(new Font("Impact", Font.PLAIN, 20));
			g.drawString("LEVEL 1 score(0-10)", 100, 47);
		}
		else if(puntos>20 && puntos<=30)
		{//dibujarCambioNivel
			g.setColor(Color.MAGENTA);
			g.setFont(new Font("Impact", Font.PLAIN, 20));
			g.drawString("LEVEL 3 score(21-30)", 100, 47);
		}
		else if(puntos>30 && puntos<=40)
		{//dibujarCambioNivel
			g.setColor(Color.MAGENTA);
			g.setFont(new Font("Impact", Font.PLAIN, 20));
			g.drawString("LEVEL 4 score(31-40)", 100, 47);
			
			if(ViboritaPosicionX[0]==850 || ViboritaPosicionX[0]==25 || ViboritaPosicionY[0]==75 || ViboritaPosicionY[0]==625)
			{
				right=false;
				left=false;
				up=false;
				down=false;
				

				//dibujarPantallaPerdedor
				g.setColor(Color.GREEN);
				g.setFont(new Font("Impact", Font.BOLD, 50));
				g.drawString("GAME OVER",300,300);
				
				g.setFont(new Font("Impact", Font.BOLD, 30));
				g.drawString("Press spacebar to Restart",280,340);
			}
				
		}
		else if(puntos>40 && puntos<=50)
		{ //dibujarCambioNivel
			g.setColor(Color.red);
			g.setFont(new Font("Impact", Font.PLAIN, 20));
			g.drawString("LEVEL 5 score(41-50)", 100, 47);
		}
		if(puntos==50)

			//dibujarPantallaGanador
		{
			right=false;
			left=false;
			up=false;
			down=false;
			
			g.setColor(Color.blue);
			g.setFont(new Font("Impact", Font.BOLD, 50));
			g.drawString("You WIN",310,300);
			
			g.setFont(new Font("Impact", Font.BOLD, 30));
			g.drawString("Press spacebar to Restart",260,340);
		}
		g.dispose();
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(right)
		{
			int i=0;
			for(i=length-1;i>=0;i--)
			{
				ViboritaPosicionY[i+1]=ViboritaPosicionY[i];
			}
			for(i=length;i>=0;i--)
			{
				if(i==0)
				{
					ViboritaPosicionX[i]=ViboritaPosicionX[i] + 25;
				}
				else
				{
					ViboritaPosicionX[i]=ViboritaPosicionX[i-1];
				}
				if(ViboritaPosicionX[i]>850)
				{
					ViboritaPosicionX[i]=25;
				}
			}
			repaint();
		}
		if(left)
		{
			int i=0;
			for(i=length-1;i>=0;i--)
			{
				ViboritaPosicionY[i+1]=ViboritaPosicionY[i];
			}
			for(i=length;i>=0;i--)
			{
				if(i==0)
				{
					ViboritaPosicionX[i]=ViboritaPosicionX[i] - 25;
				}
				else
				{
					ViboritaPosicionX[i]=ViboritaPosicionX[i-1];
				}
				if(ViboritaPosicionX[i]<25)
				{
					ViboritaPosicionX[i]=850;
				}
			}
			repaint();
		}
		if(up)
		{
			int i=0;
			for(i=length-1;i>=0;i--)
			{
				ViboritaPosicionX[i+1]=ViboritaPosicionX[i];
			}
			for(i=length;i>=0;i--)
			{
				if(i==0)
				{
					ViboritaPosicionY[i]=ViboritaPosicionY[i] - 25;
				}
				else
				{
					ViboritaPosicionY[i]=ViboritaPosicionY[i-1];
				}
				if(ViboritaPosicionY[i]<75)
				{
					ViboritaPosicionY[i]=625;
				}
			}
			repaint();
		}
		if(down)
		{
			int i=0;
			for(i=length-1;i>=0;i--)
			{
				ViboritaPosicionX[i+1]=ViboritaPosicionX[i];
			}
			for(i=length;i>=0;i--)
			{
				if(i==0)
				{
					ViboritaPosicionY[i]=ViboritaPosicionY[i] + 25;
				}
				else
				{
					ViboritaPosicionY[i]=ViboritaPosicionY[i-1];
				}
				if(ViboritaPosicionY[i]>625)
				{
					ViboritaPosicionY[i]=75;
				}
			}
			repaint();
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()== KeyEvent.VK_SPACE)
		{
			moverse=0;
			length=3;
			puntos=0;
			repaint();
		}
		if(e.getKeyCode()== KeyEvent.VK_RIGHT)
		{
			moverse++;
			right=true;
			if(!left)
			{
				right=true;
			}
			else
			{
				left=true;
				right=false;
			}
			up=false;
			down=false;
		}
		if(e.getKeyCode()== KeyEvent.VK_LEFT)
		{
			moverse++;
			left=true;
			if(!right)
			{
				left=true;
			}
			else
			{
				right=true;
				left=false;
			}
			up=false;
			down=false;
		}
		if(e.getKeyCode()== KeyEvent.VK_UP)
		{
			moverse++;
			up=true;
			if(!down)
			{
				up=true;
			}
			else
			{
				down=true;
				up=false;
			}
			left=false;
			right=false;
		}
		if(e.getKeyCode()== KeyEvent.VK_DOWN)
		{
			moverse++;
			down=true;
			if(!up)
			{
				down=true;
			}
			else
			{
				up=true;
				down=false;
			}
			left=false;
			right=false;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}