package controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.*;
import vista.*;
/**
 * Clase ControlCrearColectivo.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class ControlCrearColectivo implements ActionListener {
	private CrearColectivo vista;
	private Ventana frame;
	private Controlador controlador;
	
	
	public ControlCrearColectivo(Ventana frame, Controlador contr) {
		this.frame = frame;
		this.vista = frame.getVistaCrearColectivo();
		this.controlador = contr;
	}
	
	/**
	 * Método para gestionar los eventos que se pueden producir en la vista de creacion de colectivo
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Colectivo c;
		if(vista.getNombre().contentEquals("")) {
			JOptionPane.showMessageDialog(vista,
					"Debe proporcionar un nombre para el nuevo colectivo.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(Colectivo.buscarColectivo(vista.getNombre())!=null) {
			JOptionPane.showMessageDialog(vista,
					"Ya existe un colectivo con ese titulo", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} else if (vista.getColectivos().equals("No")) {
			c = new Colectivo(vista.getNombre(), (Ciudadano)Aplicacion.getAplicacion().getUsuarioActual());
			vista.limpiarJtf();
		} else {
			c = new Colectivo(vista.getNombre(), Colectivo.buscarColectivo(vista.getColectivos()));
			vista.limpiarJtf();
		}
		
		// mostrar nueva vista
		controlador.getControlHome().addBotonColectivo(c);
		controlador.getControlMiPerfil().addBotonColectivo(c);
		frame.mostrarPanel("home");
	}
}
