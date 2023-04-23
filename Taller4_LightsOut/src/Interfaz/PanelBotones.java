package Interfaz;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener{
	private InterfazPrincipal interfaz;
	private static JButton btreiniciar;
	private static JButton btnuevo;
	private JButton btjugador;
	private JButton bt10;
	
	


	public PanelBotones(InterfazPrincipal interfaz_peincipal){
		interfaz = interfaz_peincipal;
		
		setPreferredSize( new Dimension( 200, 0 ) );
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), getBorder() ) );
        setLayout( new GridBagLayout( ) );

        btnuevo = new JButton("NUEVO");
  
        btnuevo.setBackground(new Color(72, 156, 225));
        btnuevo.setOpaque(true);
        btnuevo.setBorderPainted(false);
        btnuevo.setForeground(Color.white);
    
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        gbc.fill = GridBagConstraints.BOTH;
    	btnuevo.addActionListener(interfaz);
        add( btnuevo, gbc );

        btreiniciar = new JButton("REINICIAR");
        
        btreiniciar.setBackground(new Color(72, 156, 225));
        btreiniciar.setOpaque(true);
        btreiniciar.setBorderPainted(false);
        btreiniciar.setForeground(Color.white);
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        gbc.fill = GridBagConstraints.BOTH;
        btreiniciar.addActionListener(interfaz);
        add( btreiniciar, gbc );

        bt10 = new JButton("TOP- 10");
        bt10.setBackground(new Color(72, 156, 225));
        bt10.setOpaque(true);
        bt10.setBorderPainted(false);
        bt10.setForeground(Color.white);
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        gbc.fill = GridBagConstraints.BOTH;
        bt10.addActionListener(interfaz);
        add( bt10, gbc );
        
        btjugador = new JButton("CAMBIAR JUGADOR");
        btjugador.setBackground(new Color(72, 156, 225));
        btjugador.setOpaque(true);
        btjugador.setBorderPainted(false);
        btjugador.setForeground(Color.white);
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        gbc.fill = GridBagConstraints.BOTH;
        btjugador.addActionListener(interfaz);
        add( btjugador, gbc );   
        
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub 
		
		
	}

	public static JButton getbtnuevo() {
		return btnuevo;
	}

	
	public static JButton getbtreiniciar() {
		return btreiniciar;
	}

	
	
	public JButton getbtjugador() {
		return btjugador;
	}

	public void setbtjugador(JButton btjugador) {
		this.btjugador = btjugador;
	}
	
	public JButton getbt10() {
		return bt10;
	}
}

