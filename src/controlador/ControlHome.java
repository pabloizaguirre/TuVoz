package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.*;
import vista.CrearColectivo;
import vista.DetalleColectivo;
import vista.DetalleProyecto;
import vista.Home;
import vista.Ventana;
/**
 * Clase ControlHome.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class ControlHome implements ActionListener{
	private Home vista;
	private Ventana frame;
	
	private HashMap<JButton, Proyecto> proyectos = new HashMap<JButton, Proyecto>();
	private HashMap<JButton, Colectivo> colectivos = new HashMap<JButton, Colectivo>();
	
	public ControlHome(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaHome();
		setVista();
	}
	
	/**
	 * Método encargado de gestionar los botones de la vista, según si el usuario actual pertece
	 * o no al colectivo, o sea su representante
	 * 
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(e.getActionCommand().equals("anadirProyecto")) {
			frame.mostrarPanel("crearProyecto");
		} else if(e.getActionCommand().equals("anadirColectivo")){
			/*Actualizamos la vista de colectivos para crear un subcolectivo*/
			CrearColectivo.addColectivos(((Ciudadano)Aplicacion.getAplicacion().getUsuarioActual()).getColectivosCreados());
			frame.mostrarPanel("crearColectivo");
		} else if(proyectos.containsKey(source)) {
			Proyecto p = proyectos.get(source);
			
			//comprobamos si ya se ha creado una visa para este proyecto
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
	
	public void setVista() {
		vista.resetBotones();
		setBotonesProyectos();
		setBotonesColectivos();
	}
	
	public void setBotonesProyectos() {
		JButton botonProyecto;
		for(Proyecto p:Aplicacion.getAplicacion().getListadoProyectos()) {
			botonProyecto = new JButton(p.getTitulo());
			botonProyecto.addActionListener(this);
			vista.addBotonProyecto(botonProyecto);
			proyectos.put(botonProyecto, p);
		}
	}
	
	public void addBotonProyecto(Proyecto p) {
		JButton botonProyecto = new JButton(p.getTitulo());
		botonProyecto.addActionListener(this);
		vista.addBotonProyecto(botonProyecto);
		proyectos.put(botonProyecto, p);
	}
	
	
	public void setBotonesColectivos() {
		JButton botonColectivo;
		for(ElementoColectivo c:Aplicacion.getAplicacion().getListadoElementoColectivos()) {
			if(c instanceof Colectivo) {
				botonColectivo = new JButton(((Colectivo) c).getTitulo());
				botonColectivo.addActionListener(this);
				vista.addBotonColectivo(botonColectivo);
				colectivos.put(botonColectivo, ((Colectivo) c));
			}
		}
	}
	
	public void addBotonColectivo(Colectivo c) {
		JButton botonColectivo = new JButton(c.getTitulo());
		botonColectivo.addActionListener(this);
		vista.addBotonColectivo(botonColectivo);
		colectivos.put(botonColectivo, c);
	}

}
