package controlador;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.*;
import vista.*;
/**
 * Clase ControlIrACrearProyecto.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class ControlIrACrearProyecto implements ActionListener {
	private CrearProyecto vista;
	private Ventana frame;
	
	public ControlIrACrearProyecto(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaCrearProyecto();
	}
	
	/**
	 * Método encargado de mostrar la vista de detalle de un proyecto. En el proceso, se comprueba
	 * si el proyecto en cuestión cuenta con una vista ya creada, o en su defecto, es necesario
	 * crearla
	 * 
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// mostrar nueva vista
		frame.mostrarPanel("crearProyecto");
		
	}
}
