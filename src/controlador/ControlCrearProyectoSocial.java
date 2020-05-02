package controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.*;
import vista.*;


/**
 * Clase ControlCrearProyectoSocial.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */


public class ControlCrearProyectoSocial implements ActionListener {
	
	private CrearProyectoSocial vista;
	private Ventana frame;
	private CrearProyecto vistaProyecto;
	
	public ControlCrearProyectoSocial(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaCrearProyectoSocial();
		this.vistaProyecto = frame.getVistaCrearProyecto();
	}
	
	/**
	 * Método para gestionar los eventos que se pueden producir en la vista de creación de 
	 * proyecto social. Se crea proyecto de forma individual o de forma colectiva
	 * según la entrada del ComboBox de la vista
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ProyectoSocial p;

		if(vista.getGrupoSocial().equals("") || vista.getTipoAlcance().equals(null)) {
			JOptionPane.showMessageDialog(vista,
					"Debe completar todos los apartados.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		CrearProyecto v = frame.getVistaCrearProyecto();
		
		if(vista.getColectivos().equals("No")) {
			p = new ProyectoSocial(v.getNombre(),v.getDescripcion(),v.getPresupuesto(),
					(Ciudadano)Aplicacion.getAplicacion().getUsuarioActual(), vista.getGrupoSocial(),vista.getTipoAlcance());
			vista.limpiarJtf();
			v.limpiarJtf();
		} else {
			Colectivo col = Colectivo.buscarColectivo(vista.getColectivos());
			
			p = new ProyectoSocial(v.getNombre(),v.getDescripcion(),v.getPresupuesto(),
				col, vista.getGrupoSocial(),vista.getTipoAlcance());
			vista.limpiarJtf();
			v.limpiarJtf();
		}

		JOptionPane.showMessageDialog(vista,
					"Proyecto creado y enviado a supervisión por parte de la Administración de Tu Voz.", "Proyecto creado", JOptionPane.INFORMATION_MESSAGE);	
		
		// mostrar nueva vista
		frame.getControlHome().addBotonProyecto(p);;

		frame.mostrarPanel("home");
		
	}
}
