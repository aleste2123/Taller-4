package Interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;


@SuppressWarnings("serial")
public class PanelConfiguraciones  extends JPanel {
	private JComboBox<String> slDificultad;
	private static JRadioButton btFacil;
	private static JRadioButton btMedio;
	private static JRadioButton btDificil;
	
	
	public PanelConfiguraciones(InterfazPrincipal interfaz) {
		this.setBackground(new Color(43, 137, 223));
		JPanel panel_c = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
		panel_c.setBackground(new Color(43, 137, 223));
		
		
		/* Tamaño: */
		JLabel jlbsize = new JLabel("Tamaño:");
		jlbsize.setForeground(Color.white);
		panel_c.add(jlbsize);
		
		slDificultad = new JComboBox<String>();
		slDificultad.setBounds(10,10,80,20);
		slDificultad.addItem("7x7");
		slDificultad.addItem("6x6");
		slDificultad.addItem("5x5");
		slDificultad.addItem("4x4");
		panel_c.add(slDificultad);
		
		
		/* DIFICULTAD: */
		JLabel jlblevel = new JLabel("Dificultad:");
		jlblevel.setForeground(Color.white);
		panel_c.add(jlblevel);
		
		/* boton facil: */
		btFacil = new JRadioButton("Fácil");
		btFacil.setForeground(Color.white);
		panel_c.add(btFacil);
		
		/* boton medio: */
		btMedio = new JRadioButton("Medio");
		btMedio.setForeground(Color.white);
		panel_c.add(btMedio);
		
		
		/* boton dificil: */
		btDificil = new JRadioButton("Difícil");
		btDificil.setForeground(Color.white);
		panel_c.add(btDificil);
		
		/* grupo de botones */
		ButtonGroup gpBt = new ButtonGroup();
		gpBt.add(btFacil);
		gpBt.add(btMedio);
		gpBt.add(btDificil);
		
		/* añadir*/
		this.add(panel_c);
		
		/* sleccion de dificultad y de tamaño*/
		slDificultad.addActionListener(interfaz.getTabla_juego());
		btFacil.addActionListener(interfaz);
		btMedio.addActionListener(interfaz);
		btDificil.addActionListener(interfaz);
		
  
	}

	public String tamanhotabla() {
		 return slDificultad.getSelectedItem().toString();
	 }
	
	
	public static JRadioButton getbtFacil() {
		return btFacil;
	}
	
	public static JRadioButton getbtMedio() {
		return btMedio;
	}
	
	public static JRadioButton getbtHard() {
		return btDificil;
	}

	
}
