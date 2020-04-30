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
		
		home.setActionCommand("home");

		left.add(home);

		JPanel right = new JPanel();
		busquedaTF = new JTextField(15);
		busqueda = new JButton("Busqueda");
		busqueda.setActionCommand("busqueda");
		notificaciones = new JButton("Notificaciones");
		notificaciones.setActionCommand("notificaciones");
		miPerfil = new JButton("Mi Perfil");
		miPerfil.setActionCommand("miPerfil");
		
		right.add(busquedaTF);
		right.add(busqueda);
		right.add(notificaciones);
		right.add(miPerfil);
		
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
	}

	public void setControlador(ActionListener c) {  
		miPerfil.addActionListener(c);
		home.addActionListener(c);
		busqueda.addActionListener(c);
	}
	public String getBusqueda() {
		return busquedaTF.getText();
	}
}
