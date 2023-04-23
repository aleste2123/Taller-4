package Interfaz;


import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelInformacion extends JPanel {
	
	private JTextField jugadas;
	private JTextField jugador;
	
	public PanelInformacion() {
		setPreferredSize(new Dimension(800,50));
        FlowLayout fl = new FlowLayout();
        setLayout(fl);
       
		
		JPanel PanelJugadas = new JPanel();
		this.add(PanelJugadas);
		JLabel lbjugadas = new JLabel("Jugadas:");
		jugadas = new JTextField();
		jugadas.setPreferredSize(new Dimension(150,30));
		jugadas.setEditable(false);
		PanelJugadas.add(lbjugadas);
		PanelJugadas.add(jugadas);
		
		
		
		JPanel PanelJugador = new JPanel();
		this.add(PanelJugador);
		JLabel pljugador = new JLabel("Jugador:");
		jugador = new JTextField();
		jugador.setPreferredSize(new Dimension(150,30));
		jugador.setEditable(false);
		PanelJugador.add(pljugador);
		PanelJugador.add(jugador);
		
		
	}


	
	
	public void actualizarJugador(String nombre) {
		jugador.setText(nombre);
		
	}
	
	public String getJugador() {
		return jugador.getText();
	}

	
	
	public void actualizarContador(int darJugadas) {
		
		// TODO Auto-generated method stub
		jugadas.setText(String.valueOf(darJugadas));
	}
}
