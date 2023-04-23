package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;
import uniandes.dpoo.taller4.modelo.Tablero;

@SuppressWarnings("serial")
public class PanelTabla extends JPanel implements ActionListener,MouseMotionListener,MouseListener {
	private int sizeC = 0;
	private Dimension size = new Dimension(700,700);
	private int sideC = 0;
	private InterfazPrincipal interfaz;
	private Tablero tablero = null;
	private boolean[][] matriz = null;
	private static final Toolkit window = Toolkit.getDefaultToolkit();
	private static final Image bombillo_on = window.getImage("data/on.png");
	private static final Image bombillo_off = window.getImage("data/off.png");
	
	public PanelTabla(InterfazPrincipal interface_principal, int tamm) {
		this.setSize(size);
		this.setVisible(true);
		this.sideC = tamm;
		this.sizeC = size.height/tamm;
		this.interfaz = interface_principal;
		this.tablero = interface_principal.getTabla();
		this.matriz = interface_principal.getTabla().darTablero();
		
	
		addMouseListener(this);
	}
	
	public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2d = (Graphics2D) g;
			int alto = (int) (size.height/sideC * 0.85);
			int ancho = (int) (size.width/sideC  * 0.85);
			int fila = 1;
			int columna = 1;
			int xaxis = 0;
			int yaxis = 0;
			
			
			while (columna <= sideC && fila <= sideC){
				boolean on = matriz[fila-1][columna-1];
				RoundRectangle2D.Double rectangle = new RoundRectangle2D.Double(xaxis,yaxis,alto,ancho,20,20);
				g2d.draw(rectangle);
				if (on) {
					g2d.setPaint( new GradientPaint( xaxis, yaxis, Color.yellow, xaxis+ancho, yaxis+alto,Color.white ) );
				}
				else if (on == false) {
					g2d.setPaint( new GradientPaint( xaxis, yaxis, Color.black, xaxis+ancho, yaxis+alto,Color.white ) );
				}
				g2d.fill(rectangle);
				
				if (on) {
					g2d.drawImage(bombillo_on,xaxis+1,yaxis+1,ancho-1,alto-1,this);
				}
				else if (on == false) {
					g2d.drawImage(bombillo_off,xaxis+1,yaxis+1,ancho-1,alto-1,this);
				}
				xaxis += ancho;
				if (columna == sideC) {
					yaxis += alto;
					xaxis = 0;
					columna = 1;
					fila ++;
				}
				else {columna++;}
			}
		}
	
	private void actualizarTamanoTablero(int n) {
		interfaz.setTabla(new Tablero(n));
		interfaz.setTamano(n);
		this.sideC = n;
		this.sizeC = size.height/n;
		actualizarTabla();
		
	}
	
	private void pintarCasilla(int fila, int columna) {
			tablero.jugar(fila, columna);
			interfaz.setTabla(tablero);
			interfaz.jugadas();
			actualizarTabla();
			interfaz.endgame();
			
	}
	
	private int[] encontrarCasilla(int X, int Y) {
		int fila = (Y / sizeC);
		int columna = (X / sizeC);
		int[] casilla = {fila,columna};
		return casilla;
	}

	public void actualizarTabla() {
		this.tablero = interfaz.getTabla();
		this.matriz = interfaz.getTabla().darTablero();
		repaint();
	}
	
		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String tamanio = interfaz.getConfig().tamanhotabla();
		if (tamanio.equals("4x4")) {
			actualizarTamanoTablero(4);			
		}
		if (tamanio.equals("5x5")) {
			System.out.println("sirve :(");
			actualizarTamanoTablero(5);			
		}
		if (tamanio.equals("6x6")) {
			actualizarTamanoTablero(6);			
		}
		if (tamanio.equals("7x7")) {
			actualizarTamanoTablero(7);			
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int coordX = e.getX();
		int coordY = e.getY();
		if (coordX <= sizeC*sideC && coordY <= sizeC*sideC) {
			int[] casilla = encontrarCasilla(coordX,coordY);
			pintarCasilla(casilla[0], casilla[1]);
						
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
