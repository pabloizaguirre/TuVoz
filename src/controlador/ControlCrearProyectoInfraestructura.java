package controlador;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import modelo.*;
import vista.*;

public class ControlCrearProyectoInfraestructura implements ActionListener {
	private CrearProyectoInfraestructura vista;
	private Ventana frame;
	private String ruta = "Unknown";
	
	public ControlCrearProyectoInfraestructura(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaCrearProyectoInfraestructura();
	}

	
	/**
	 * Cambia la vista a CrearProyectoInfraestructura
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("crear")) {
			
		if(this.ruta.equals("Unknown") || vista.getDistritos().size()==0) {
			JOptionPane.showMessageDialog(vista,
					"Debe completar todos los apartados.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		CrearProyecto v = frame.getVistaCrearProyecto();
		 
		
		if(vista.getColectivos().equals("No")) {
			new ProyectoInfraestructura(v.getNombre(),v.getDescripcion(),v.getPresupuesto(),
				(Ciudadano)Aplicacion.getAplicacion().getUsuarioActual(), new Imagen(ruta, "Imagen"),vista.getDistritos());
			vista.limpiar();
			v.limpiarJtf();
		} else {
			Colectivo col = Colectivo.buscarColectivo(vista.getColectivos());
			
			new ProyectoInfraestructura(v.getNombre(),v.getDescripcion(),v.getPresupuesto(),
				col, new Imagen(ruta, "imagen"),vista.getDistritos());
			vista.limpiar();
			v.limpiarJtf();
		}
		
		
		JOptionPane.showMessageDialog(vista,
					"Proyecto creado y enviado a supervisión por parte de la Administración de Tu Voz.", "Proyecto creado", JOptionPane.INFORMATION_MESSAGE);
			
		
		// mostrar nueva vista
		frame.resetHome();
		frame.mostrarPanel("home");
		
		} else if(e.getActionCommand().equals("examinar")) {
			JFileChooser explorador = new JFileChooser();
	        int seleccion = explorador.showOpenDialog(null);
	        if(seleccion==JFileChooser.APPROVE_OPTION) {
	        	File archivo = explorador.getSelectedFile();
	        	this.ruta = archivo.getAbsolutePath();
	        	
		}
		}
	}
}
