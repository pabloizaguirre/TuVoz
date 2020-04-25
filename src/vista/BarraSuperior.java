package vista;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BarraSuperior extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static BarraSuperior barraSuperior;
	
	private JButton home;
	private JTextField busquedaTF;
	private JButton busqueda;
	private JButton notificaciones;
	private JButton miPerfil;

	private BarraSuperior() {
		home = new JButton("Home");
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
	
	public static BarraSuperior getBarraSuperior() {
		if(barraSuperior==null) {
			barraSuperior = new BarraSuperior();
		}
		return barraSuperior;
	}
	
	public void setControladorMiPerfil(ActionListener c) {  
		miPerfil.addActionListener(c);
	}
}
