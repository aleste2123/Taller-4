package Interfaz;


import uniandes.dpoo.taller4.modelo.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.*;


@SuppressWarnings("serial")
public class InterfazPrincipal extends JFrame implements ActionListener{
	
	private PanelConfiguraciones PanelConfig;
	private PanelInformacion PanelInfo;
	private PanelBotones panelBotones;
	private PanelTabla panelTabla;
	private Tablero tabla;
	private Top10 top10;
	
	private int level = 5;
	
	private static final int FACIL = 2;
	private static final int MEDIO = 5;
	private static final int HARD = 11;
	

	private int tamanho = 7;
	
	private static final File TOP = new File("data/top10.csv");

	
	/* Layout de la ventana principal */
	public InterfazPrincipal () {
		
		
		this.setTitle("LightsOut");
		this.setSize(800,720);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        
      
	
		tabla = new Tablero(tamanho);
        panelTabla = new PanelTabla(this, tamanho);
        PanelConfig = new PanelConfiguraciones(this);
        PanelInfo = new PanelInformacion();
        panelBotones = new PanelBotones(this);
        
        this.add(PanelConfig, BorderLayout.NORTH);
        this.add(panelTabla, BorderLayout.CENTER);
        this.add(panelBotones,BorderLayout.EAST);
        this.add(PanelInfo, BorderLayout.SOUTH);
        
        
        top10 = new Top10();
		top10.cargarRecords(TOP);
        
        
        addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent x)
			{
				try {
					top10.salvarRecords(TOP);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	
        
		
		setVisible(true);
		
	}
	public void reiniciar() {
		tabla.reiniciar();
		panelTabla.actualizarTabla();
		PanelInfo.actualizarContador(tabla.darJugadas());
	}
	

	public void jugadas() {
		PanelInfo.actualizarContador(tabla.darJugadas());
	}
	
	public void setTabla(Tablero tabla) {
		// TODO Auto-generated method stub
		PanelInfo.actualizarContador(tabla.darJugadas());	
	}
	
	
	
	public void nuevo_game() {
		reiniciar();
		tabla.desordenar(level);
		panelTabla.actualizarTabla();
	}
	
	public void setTamano(int n) {
		tamanho = n;
	}
	
	
	public Top10 getTop() {
		return top10;
	}
	
	public Tablero getTabla() {
		// TODO Auto-generated method stub
		return this.tabla;
	}

	public PanelTabla getTabla_juego() {
		return this.panelTabla;
		
	}
	
	public PanelConfiguraciones getConfig() {
		return this.PanelConfig;
	}
	
	public void endgame() {
		if (tabla.tableroIluminado() && tabla.darJugadas()!=0 ) {
			top10.agregarRegistro(PanelInfo.getJugador(), tabla.darJugadas());
			JOptionPane.showMessageDialog(this, "Enhorabuena" + PanelInfo.getJugador() + " has terminado el juego. Tuviste una puntuación de: " + tabla.calcularPuntaje() + "puntos"   );
			nuevo_game();
		}
	}
	
	
	public static void main(String[] args) {
		new InterfazPrincipal();	
	}
	



	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == PanelBotones.getbtreiniciar()) {
			reiniciar();
		}
		if (e.getSource() == PanelBotones.getbtnuevo()) {
			nuevo_game();
		}
		
		if (e.getSource()==PanelConfiguraciones.getbtFacil()) {
			level = FACIL;
		}
		
		if (e.getSource()==PanelConfiguraciones.getbtMedio()) {
			level = MEDIO;
		}
		
		if (e.getSource()==PanelConfiguraciones.getbtHard()) {
			level = HARD;
		}
		if (e.getSource()==panelBotones.getbtjugador()) {
			String jugador = JOptionPane.showInputDialog(this, "Ingresa el nombre del Jugador");
			PanelInfo.actualizarJugador(jugador);
		}
		if (e.getSource()==panelBotones.getbt10()) {
		    new mostrar_players(this);
		}
		
		
		
		
	
		
	}
		
	
		
		
	
	
}
