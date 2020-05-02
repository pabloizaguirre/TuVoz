package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
		String source = e.getActionCommand();
		if(source.equals("home")) {
			if(Aplicacion.getAplicacion().getUsuarioActual().getClass().equals(Ciudadano.class)) {
				frame.mostrarPanel("home");
			}else if(Aplicacion.getAplicacion().getUsuarioActual().getClass().equals(Administrador.class)) {
				frame.mostrarPanel("homeAdmin");
			}
		}else if(source.equals("atras")) {
			String ultimaVista = frame.getUltimaVista();
			if(ultimaVista.equals("inicioRegistro")) {
				return;
			}
			frame.mostrarPanel(ultimaVista);
		}else if(source.equals("miPerfil")) {

			frame.mostrarPanel("miPerfil");
			
		}else if(source.equals("notificaciones")) {
			frame.mostrarPanel("notificaciones");
			
		}else if(source.equals("busqueda") || source.equals("busquedaTF")) {
			if(Proyecto.buscarProyecto(vista.getBusqueda())!=null) {
				Proyecto proyecto = Proyecto.buscarProyecto(vista.getBusqueda());
				
				if(frame.getProyectos().containsKey(proyecto.getId())) {
					ControlDetalleProyecto contr = frame.getProyectos().get(proyecto.getId());
					contr.resetVista();
				} else {
					DetalleProyecto vistaProyecto = new DetalleProyecto();
					ControlDetalleProyecto c = new ControlDetalleProyecto(frame, vistaProyecto, proyecto);
					c.setVistaDetalleProyecto();
					frame.getProyectos().put(proyecto.getId(), c);
					
					frame.anadirVentana(vistaProyecto, "" + proyecto.getId());
				}
				
				frame.mostrarPanel("" + proyecto.getId());
			}
			else if(Colectivo.buscarColectivo(vista.getBusqueda())!=null) {
				Colectivo colectivo = Colectivo.buscarColectivo(vista.getBusqueda());
				if(frame.getColectivos().containsKey(colectivo.getTitulo())) {
					ControlDetalleColectivo contr = frame.getColectivos().get(colectivo.getTitulo());
					contr.resetVista();	
				} else {
					DetalleColectivo vistaColectivo = new DetalleColectivo();
					ControlDetalleColectivo c = new ControlDetalleColectivo(frame, vistaColectivo, colectivo);
					c.setVistaDetalleColectivo();
					frame.getColectivos().put(colectivo.getTitulo(),c);
					frame.anadirVentana(vistaColectivo, "" + colectivo.getTitulo());
				}
				
				frame.mostrarPanel(""+colectivo.getTitulo());

			}
		}
		return;
	}
	
}
