package controlador;

import java.awt.event.*;

import vista.*;

public class ControlIrAHome implements ActionListener {
	private Home vista;
	private Ventana frame;
	
	public ControlIrAHome(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaHome();
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
