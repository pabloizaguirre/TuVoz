package controlador.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.Controlador;
import controlador.colectivo.detalle.ControlDetalleColectivo;
import controlador.proyecto.detalle.ControlDetalleProyecto;
import modelo.*;
import modelo.aplicacion.Aplicacion;
import modelo.elementocolectivo.colectivo.Colectivo;
import modelo.proyecto.Proyecto;
import modelo.usuario.Administrador;
import vista.*;
import vista.colectivo.detalle.DetalleColectivo;
import vista.interfaz.BarraSuperior;
import vista.proyecto.detalle.DetalleProyecto;


/**
 * Clase ControlApoyoMinimoProyecto.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class ControlBarraSuperior implements ActionListener{
	private BarraSuperior vista;
	private Ventana frame;
	private Controlador controlador;
	
	
	public ControlBarraSuperior(Ventana frame, Controlador contr) {
		this.frame = frame;
		this.vista = frame.getVistaBarraSuperior();
		this.controlador = contr;
	}
	
	/**
	 * Método para gestionar los eventos que pueden producirse en la barra superior
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source.equals("home")) {
			frame.mostrarPanel("home");
		}else if(source.equals("atras")) {
			String ultimaVista = frame.getUltimaVista();
			if(ultimaVista==null || ultimaVista.equals("inicioRegistro")) {
				return;
			}
			frame.mostrarPanel(ultimaVista);
		}else if(source.equals("miPerfil")) {
			if(Aplicacion.getAplicacion().getUsuarioActual() instanceof Ciudadano) {
				frame.mostrarPanel("miPerfil");
			}else if(Aplicacion.getAplicacion().getUsuarioActual() instanceof Administrador) {
				frame.mostrarPanel("miPerfilAdmin");
			}
		}else if(source.equals("notificaciones")) {
			controlador.getControlNotificaciones().setVista();
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

			}vista.limpiarJtf();
		}
		return;
	}
	
}
