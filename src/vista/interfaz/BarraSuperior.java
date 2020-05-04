package vista.interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 * Clase de la vista BarraSuperior.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class BarraSuperior extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton home;
	private JButton atras;
	private JTextField busquedaTF;
	private JButton busqueda;
	private JButton notificaciones;
	private JButton miPerfil;

	public BarraSuperior() {
		setLayout(new BorderLayout());

		JPanel left = new JPanel();

		home = new JButton("Inicio");
		home.setActionCommand("home");
		
		atras = new JButton("Atras");
		atras.setActionCommand("atras");
		
		left.add(home);
		left.add(atras);
		
		JPanel right = new JPanel();
		busquedaTF = new JTextField(15);
		busquedaTF.setActionCommand("busquedaTF");
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
		atras.addActionListener(c);
		busquedaTF.addActionListener(c);
		busqueda.addActionListener(c);
		notificaciones.addActionListener(c);
	}
	public String getBusqueda() {
		return busquedaTF.getText();
	}
	 /**
     * Metodo para limpiar el campo de busqueda de la barra superior, es llamado
     * tras realizar una búsqueda
     * 
     */
	public void limpiarJtf() {
		busquedaTF.setText("");
	}
}
