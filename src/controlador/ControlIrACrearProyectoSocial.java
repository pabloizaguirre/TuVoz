package controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.*;
import vista.*;

public class ControlIrACrearProyectoSocial implements ActionListener {
	
	private CrearProyectoSocial vista;
	private Ventana frame;
	
	public ControlIrACrearProyectoSocial(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaCrearProyectoSocial();
	}
	
	/**
	 * Cambia la vista a CrearProyectoSocial
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// mostrar nueva vista
		frame.mostrarPanel("crearProyectoSocial");
		
	}
}
