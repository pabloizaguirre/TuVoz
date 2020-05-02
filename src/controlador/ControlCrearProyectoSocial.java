package controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.*;
import vista.*;

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
	 * Cambia la vista a CrearProyectoSocial
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if(vista.getGrupoSocial().equals("") || vista.getTipoAlcance().equals(null)) {
			JOptionPane.showMessageDialog(vista,
					"Debe completar todos los apartados.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		CrearProyecto v = frame.getVistaCrearProyecto();
		
		if(vista.getColectivos().equals("No")) {
			new ProyectoSocial(v.getNombre(),v.getDescripcion(),v.getPresupuesto(),
					(Ciudadano)Aplicacion.getAplicacion().getUsuarioActual(), vista.getGrupoSocial(),vista.getTipoAlcance());
		} else {
			Colectivo col = Colectivo.buscarColectivo(vista.getColectivos());
			
			new ProyectoSocial(v.getNombre(),v.getDescripcion(),v.getPresupuesto(),
				col, vista.getGrupoSocial(),vista.getTipoAlcance());
		}

		JOptionPane.showMessageDialog(vista,
					"Proyecto creado y enviado a supervisión por parte de la Administración de Tu Voz.", "Proyecto creado", JOptionPane.INFORMATION_MESSAGE);
			
		
		// mostrar nueva vista
		frame.resetHome();

		frame.mostrarPanel("home");
		
	}
}
