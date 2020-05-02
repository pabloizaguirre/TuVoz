package controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.*;
import vista.*;

public class ControlCrearColectivo implements ActionListener {
	private CrearColectivo vista;
	private Ventana frame;
	
	
	public ControlCrearColectivo(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaCrearColectivo();
	}
	
	/**
	 * 
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(vista.getNombre().contentEquals("")) {
			JOptionPane.showMessageDialog(vista,
					"Debe proporcionar un nombre para el nuevo colectivo.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(Colectivo.buscarColectivo(vista.getNombre())!=null) {
			JOptionPane.showMessageDialog(vista,
					"Ya existe un colectivo con ese titulo", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (vista.getColectivos().equals("No")) {
			new Colectivo(vista.getNombre(), (Ciudadano)Aplicacion.getAplicacion().getUsuarioActual());
			vista.limpiarJtf();
		} else {
			new Colectivo(vista.getNombre(), Colectivo.buscarColectivo(vista.getColectivos()));
			vista.limpiarJtf();
		}
		
		// mostrar nueva vista
		frame.resetHome();
		frame.mostrarPanel("home");
	}
}
