package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.*;
import vista.*;

public class ControlBarraSuperior implements ActionListener{
	private BarraSuperior vista;
	private Ventana frame;
	
	
	public ControlBarraSuperior(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaBarraSuperior();
	}
	
	/**
	 * 
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("home")) {
			frame.mostrarPanel("home");
		} else if(e.getActionCommand().equals("miPerfil")) {
			frame.mostrarPanel("miPerfil");
		} else if(e.getActionCommand().equals("notificaciones")) {
			frame.mostrarPanel("notificaciones");
		}else if(e.getActionCommand().equals("busqueda")) {
			if(Proyecto.buscarProyecto(vista.getBusqueda())!=null) {
				Proyecto proyecto = Proyecto.buscarProyecto(vista.getBusqueda());
				DetalleProyecto vista = new DetalleProyecto(proyecto);
				vista.setControladorApoyar(new ControlApoyar(frame, vista));
				frame.anadirVentana(vista, proyecto.toString());
				frame.mostrarPanel(proyecto.toString());
			}
			//Falta el de buscar colectivo
		}
		return;
	}
	
}
