package controlador.proyecto.crear;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controlador.Controlador;
import modelo.*;
import modelo.aplicacion.Aplicacion;
import modelo.elementocolectivo.colectivo.Colectivo;
import modelo.proyecto.ProyectoSocial;
import modelo.proyecto.TipoAlcance;
import vista.*;
import vista.proyecto.crear.CrearProyecto;
import vista.proyecto.crear.CrearProyectoSocial;


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
	private Controlador controlador;
	
	public ControlCrearProyectoSocial(Ventana frame, Controlador contr) {
		this.frame = frame;
		this.vista = frame.getVistaCrearProyectoSocial();
		this.vistaProyecto = frame.getVistaCrearProyecto();
		this.controlador = contr;
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

		if(vista.getGrupoSocial().equals("") || vista.getTipoAlcance().equals("")) {
			JOptionPane.showMessageDialog(vista,
					"Debe completar todos los apartados.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} else if (vista.getGrupoSocial().length()>25) {
			JOptionPane.showMessageDialog(vista,
					"Nombre del grupo social demasiado largo.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		CrearProyecto v = frame.getVistaCrearProyecto();
		TipoAlcance tipoAlcance;
		if(vista.getTipoAlcance().equals("nacional")) {
			tipoAlcance = TipoAlcance.NACIONAL;
		} else {
			tipoAlcance = TipoAlcance.INTERNACIONAL;
		}
		
		if(vista.getColectivos().equals("No")) {
			p = new ProyectoSocial(v.getNombre(),v.getDescripcion(),v.getPresupuesto(),
					(Ciudadano)Aplicacion.getAplicacion().getUsuarioActual(), vista.getGrupoSocial(),tipoAlcance);
			vista.limpiarJtf();
			v.limpiarJtf();
		} else {
			Colectivo col = Colectivo.buscarColectivo(vista.getColectivos());
			
			p = new ProyectoSocial(v.getNombre(),v.getDescripcion(),v.getPresupuesto(),
				col, vista.getGrupoSocial(),tipoAlcance);
			vista.limpiarJtf();
			v.limpiarJtf();
		}

		JOptionPane.showMessageDialog(vista,
					"Proyecto creado y enviado a supervision por parte de la Administracion de Tu Voz.", "Proyecto creado", JOptionPane.INFORMATION_MESSAGE);	
		
		// mostrar nueva vista
		controlador.getControlHome().addBotonProyecto(p);
		controlador.getControlMiPerfil().addBotonProyecto(p);

		frame.mostrarPanel("home");
		
	}
}
