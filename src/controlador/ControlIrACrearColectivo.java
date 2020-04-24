package controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.*;
import vista.*;


public class ControlIrACrearColectivo implements ActionListener {
	
	private MiPerfil vista;
	private Ventana frame;
	
	public ControlIrACrearColectivo(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaMiPerfil();
	}

	/**
	 * Cambia la vista a CrearProyecto
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// mostrar nueva vista
		frame.mostrarPanel("crearColectivo");
		
	}
	
}