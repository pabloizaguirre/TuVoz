package vista;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class BarraSuperior extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton home;
	private JTextField busquedaTF;
	private JButton busqueda;
	private JButton notificaciones;
	private JButton miPerfil;

	public BarraSuperior() {
		setLayout(new BorderLayout());

		JPanel left = new JPanel();

		home = new JButton("Inicio");

		left.add(home);

		JPanel right = new JPanel();
		busquedaTF = new JTextField(15);
		busqueda = new JButton("Busqueda");
		notificaciones = new JButton("Notificaciones");
		miPerfil = new JButton("Mi Perfil");
		
		right.add(busquedaTF);
		right.add(busqueda);
		right.add(notificaciones);
		right.add(miPerfil);
		
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
	}

	public void setControladorMiPerfil(ActionListener c) {  
		miPerfil.addActionListener(c);
	}
	
	public void setControladorHome(ActionListener c) {
		home.addActionListener(c);
	}
}
