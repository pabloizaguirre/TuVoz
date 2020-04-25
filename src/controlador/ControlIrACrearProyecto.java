package controlador;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.*;
import vista.*;

public class ControlIrACrearProyecto implements ActionListener {
	private CrearProyecto vista;
	private Ventana frame;
	
	public ControlIrACrearProyecto(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaCrearProyecto();
	}
	
	/**
	 * Cambia la vista a CrearProyecto
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// mostrar nueva vista
		frame.mostrarPanel("crearProyecto");
		
	}
}
