package Interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.RegistroTop10;

public class mostrar_players {
	
	
	
	@SuppressWarnings("rawtypes")
	private JList lista;
	@SuppressWarnings("rawtypes")
	private DefaultListModel modelo;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public mostrar_players(InterfazPrincipal interfaz_principal) {
		JFrame yay = new JFrame();
		JDialog jd = new JDialog(yay);
		
	    jd.setLayout(new FlowLayout());
	
	    jd.setBounds(100, 100, 100, 400);
		jd.setResizable( false );
		yay.setTitle("Top 10");
		
		Collection<RegistroTop10> registros = interfaz_principal.getTop().darRegistros();
		
		lista = new JList();
		
		modelo = new DefaultListModel();
		
		int h=1;
		for (RegistroTop10 registro : registros) {
			JPanel panel = new JPanel();
			panel.setForeground(Color.white);
			panel.add(new JLabel(h+")  "+registro.darNombre()+"  "+registro.darPuntos()));
			if (h <= 5) {
				panel.setBackground(Color.yellow);
			
			}
			if (h <= 8 && h >= 6) {
				panel.setBackground(Color.blue);
			
			}
			if (h >= 9) {
				panel.setBackground(Color.red);	
			}
			
			h++;
			jd.add(panel);
		}
	
		lista.setModel(modelo);
		
	    
		    
	    JButton jButton = new JButton("Cerrar");
	    jButton.addActionListener((ActionListener) new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            jd.setVisible(false);
	        }
	    });
	
	    jd.add(jButton);
	    jd.setVisible(true);
	}
}


