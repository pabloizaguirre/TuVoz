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
			if(Aplicacion.getAplicacion().getUsuarioActual().getClass().equals(Ciudadano.class)) {
				frame.mostrarPanel("home");
			}else if(Aplicacion.getAplicacion().getUsuarioActual().getClass().equals(Administrador.class)) {
				frame.mostrarPanel("homeAdmin");
			}
		}else if(e.getActionCommand().equals("cerrarSesion")){
			Aplicacion.guardarAplicacion();
			Aplicacion.getAplicacion().setUsuarioActual(null);
			frame.mostrarPanel("inicioRegistro");
		}else if(e.getActionCommand().equals("miPerfil")) {

			frame.mostrarPanel("miPerfil");
		}else if(e.getActionCommand().equals("notificaciones")) {
			frame.mostrarPanel("notificaciones");
		}else if(e.getActionCommand().equals("busqueda")) {
			if(Proyecto.buscarProyecto(vista.getBusqueda())!=null) {
				Proyecto proyecto = Proyecto.buscarProyecto(vista.getBusqueda());
				DetalleProyecto vistaProyecto = new DetalleProyecto();
				ControlDetalleProyecto c = new ControlDetalleProyecto(frame, vistaProyecto, proyecto);
				c.setVistaDetalleProyecto();
				
				frame.anadirVentana(vistaProyecto, "" + proyecto.getId());
				frame.mostrarPanel("" + proyecto.getId());
			}
			else if(Colectivo.buscarColectivo(vista.getBusqueda())!=null) {
				Colectivo colectivo = Colectivo.buscarColectivo(vista.getBusqueda());
				DetalleColectivo vista = new DetalleColectivo(colectivo);
				vista.setUnirme((Ciudadano) Aplicacion.getAplicacion().getUsuarioActual());
				frame.anadirVentana(vista, colectivo.toString());
				frame.mostrarPanel(colectivo.toString());
			}
		}
		return;
	}
	
}
