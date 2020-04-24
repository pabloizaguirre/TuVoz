package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BarraSuperior extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BarraSuperior() {
		add(new JButton("Home"));
		add(new JTextField(15));
		add(new JButton("Busqueda"));
		add(new JButton("Notificaciones"));
		add(new JButton("Mi Perfil"));
		
		
	}
}
