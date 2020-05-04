package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

import javax.swing.JButton;
import modelo.*;
import vista.*;
/**
 * Clase ControlMiPerfil.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class ControlMiPerfil implements ActionListener {

	private Ventana frame;
	private MiPerfil vista;
	
	private HashMap<JButton, Proyecto> proyectos = new HashMap<JButton, Proyecto>();
	private HashMap<JButton, Colectivo> colectivos = new HashMap<JButton, Colectivo>();
	
	public ControlMiPerfil(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaMiPerfil();
	}

	/**
	 * Método encargado de gestionar los eventos relacionados con los botones de la vista 
	 * de mi perfil
	 * 
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(e.getActionCommand().equals("cerrarSesion")){
			Aplicacion.getAplicacion().setUsuarioActual(null);
			frame.getVistaBarraSuperior().setVisible(false);
			frame.mostrarPanel("inicioRegistro");
		} else if(proyectos.containsKey(source)) {
			Proyecto p = proyectos.get(source);
			
			//comprobamos si ya se ha creado una vista para este proyecto
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
		} else if (colectivos.containsKey(source)) {
			Colectivo c = colectivos.get(source);
			
			//comprobamos si ya hemos creado una vista para este colectivo
			if(frame.getColectivos().containsKey(c.getTitulo())) {
				ControlDetalleColectivo contr = frame.getColectivos().get(c.getTitulo());
				contr.resetVista();
			} else {
				DetalleColectivo vistaColectivo = new DetalleColectivo();
				ControlDetalleColectivo contr = new ControlDetalleColectivo(frame, vistaColectivo, c);
				contr.setVistaDetalleColectivo();
				frame.getColectivos().put(c.getTitulo(), contr);
				
				frame.anadirVentana(vistaColectivo, c.getTitulo());
			}
			frame.mostrarPanel("" + c.getTitulo());
		}
	}
	
	/**
	 * Método encargado de establecer la vista de mi perfil
	 * 
	 * 
	 */
	public void setVista() {
		vista.resetBotones();
		setBotonesProyectos();
		setBotonesColectivos();
		vista.setTitulo(Aplicacion.getAplicacion().getUsuarioActual().getNombreUsuario());
		vista.setControlador(this);
	}
	
	/**
	 * Método encargado de establecer los botones de los proyectos que aparecen en mi perfil
	 * 
	 * 
	 */
	public void setBotonesProyectos() {
		JButton botonProyecto;
		Usuario usuario = Aplicacion.getAplicacion().getUsuarioActual();
		if (usuario instanceof Ciudadano) {
			for(Proyecto p:((Ciudadano)usuario).getProyectosPropuestos()) {
				botonProyecto = new JButton(p.getTitulo());
				botonProyecto.addActionListener(this);
				vista.addBotonProyecto(botonProyecto);
				proyectos.put(botonProyecto, p);
			}
		}
	}
	
	/**
	 * Método encargado de crear los botones de los proyectos pasados como argumento
	 * 
	 * @param p proyecto del cual queremos crear un boton
	 * 
	 */
	public void addBotonProyecto(Proyecto p) {
		JButton botonProyecto = new JButton(p.getTitulo());
		botonProyecto.addActionListener(this);
		vista.addBotonProyecto(botonProyecto);
		proyectos.put(botonProyecto, p);
	}
	
	/**
	 * Método encargado de establecer los botones de los colectivo que aparecen en mi perfil
	 * 
	 * 
	 */
	public void setBotonesColectivos() {
		JButton botonColectivo;
		Usuario usuario = Aplicacion.getAplicacion().getUsuarioActual();
		if(usuario instanceof Ciudadano) {
			for(Colectivo c:((Ciudadano) usuario).getMisColectivos()) {
				botonColectivo = new JButton(c.getTitulo());
				botonColectivo.addActionListener(this);
				vista.addBotonColectivo(botonColectivo);
				colectivos.put(botonColectivo, c);
			}
		}
	}
	
	/**
	 * Método encargado de crear los botones de los colectivos pasados como argumento
	 * 
	 * @param c colectivo del cual queremos crear un boton
	 * 
	 */
	public void addBotonColectivo(Colectivo c) {
		JButton botonColectivo = new JButton(c.getTitulo());
		botonColectivo.addActionListener(this);
		vista.addBotonColectivo(botonColectivo);
		colectivos.put(botonColectivo, c);
	}
}
