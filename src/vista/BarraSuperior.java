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
		home = new JButton("Inicio");
		busquedaTF = new JTextField(15);
		busqueda = new JButton("Busqueda");
		notificaciones = new JButton("Notificaciones");
		miPerfil = new JButton("Mi Perfil");
		
		add(home);
		add(busquedaTF);
		add(busqueda);
		add(notificaciones);
		add(miPerfil);
	}

	public void setControladorMiPerfil(ActionListener c) {  
		miPerfil.addActionListener(c);
	}
	
	public void setControladorHome(ActionListener c) {
		home.addActionListener(c);
	}
}
