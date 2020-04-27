package controlador;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import modelo.*;
import vista.*;

public class ControlCrearProyectoInfraestructura implements ActionListener {
	private CrearProyectoInfraestructura vista;
	private Ventana frame;
	private static ImageIcon imagen;
	
	public ControlCrearProyectoInfraestructura(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaCrearProyectoInfraestructura();
	}

	public static void setImagen(ImageIcon i) {
		imagen = i;

	}

	
	/**
	 * Cambia la vista a CrearProyectoInfraestructura
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(imagen.equals(null) || vista.getDistritos().equals("")) {
			JOptionPane.showMessageDialog(vista,
					"Debe completar todos los apartados.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		CrearProyecto v = frame.getVistaCrearProyecto();
		 
		Ciudadano ciu = (Ciudadano)Aplicacion.getAplicacion().getUsuarioActual();
		
		
		
		//new ProyectoInfraestructura(v.getNombre(),v.getDescripcion(),v.getPresupuesto(),
			//	(ElementoColectivo)Aplicacion.getAplicacion().getUsuarioActual(), imagen,vista.getDistritos());
		JOptionPane.showMessageDialog(vista,
					"Proyecto creado y enviado a supervisión por parte de la Administración de Tu Voz.", "Proyecto creado", JOptionPane.INFORMATION_MESSAGE);
			
		
		// mostrar nueva vista
		frame.mostrarPanel("home");
		
	}
}
