package controlador;

import java.awt.event.*;

import vista.MiPerfil;
import vista.Ventana;

public class ControlIrAHome implements ActionListener {
	private MiPerfil vista;
	private Ventana frame;
	
	public ControlIrAHome(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaMiPerfil();
	}

	/**
	 * Cambia la vista al inicio
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// mostrar nueva vista
		frame.mostrarPanel("home");
		
	}
}
