package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Proyecto;
import vista.*;
/**
 * Clase ControlIrAProyecto.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class ControlIrAProyecto implements ActionListener {

	private Ventana frame;
	private Proyecto proyecto;
	
	public ControlIrAProyecto(Ventana frame, Proyecto p) {
		this.frame = frame;
		this.proyecto = p;
		
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
		Object source = e.getSource();
		if(proyectos.containsKey(source)) {
			Proyecto p = proyectos.get(source);
			
			if(frame.getProyectos().containsKey(p.getId())) {
				ControlDetalleProyecto contr = frame.getProyectos().get(p.getId());
				contr.resetVista();
			} else {
				DetalleProyecto vistaProyecto = new DetalleProyecto();
				ControlDetalleProyecto c = new ControlDetalleProyecto(frame, vistaProyecto, p);
				c.setVistaDetalleProyecto();
				frame.getProyectos().put(p.getId(), c);
				
				frame.anadirVentana(vistaProyecto, "" + p.getId());
			}
			
			
			frame.mostrarPanel("" + p.getId());
		}
	}

	
}
