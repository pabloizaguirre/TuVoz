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
		String aCommand = e.getActionCommand();
		/*Si pulsamos en añadir nuevo proyecto*/
		if(aCommand.equals("anadirProyecto")) {
			frame.mostrarPanel("crearProyecto");
			
		}/*Si pulsamos en añadir nuevo colectivo*/
		else if(e.getActionCommand().equals("anadirColectivo")){
			/*Actualizamos la vista de colectivos para crear un subcolectivo*/
			CrearColectivo.addColectivos(((Ciudadano)Aplicacion.getAplicacion().getUsuarioActual()).getColectivosCreados());
			frame.mostrarPanel("crearColectivo");
		}/*Si pulsamos en gestionar el numero minimo de apoyo de los proyectos siendo Admin*/ 
		else if(e.getActionCommand().equals("apoyoProyecto")) {
				JOptionPane.showMessageDialog(vista,
					"Numero de apoyos actuales: " +Aplicacion.getAplicacion().getApoyosMin() , "Gestionar apoyos minimos", JOptionPane.INFORMATION_MESSAGE);
				frame.mostrarPanel("apoyoMinimoProyecto");
			
		}/*Si pulsamos en cualquier proyecto*/
		else if(proyectos.containsKey(source)) {
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
		}/*Si pulsamos en cualquier colectivo*/ 
		else if (colectivos.containsKey(source)) {
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
     * Metodo encargado de añadir los proyectos y colectivos a la vista
     * 
     * 
     */
	public void setVista() {
		vista.resetBotones();
		setBotonesProyectos();
		setBotonesColectivos();
	}
	/**
	 * Método encargado de añadir los botones de proyecto a la vista.
	 * Se añaden todos los proyectos en la lista de proyectos de la aplicación
	 * 
	 */
	public void setBotonesProyectos() {
		JButton botonProyecto;
		for(Proyecto p:Aplicacion.getAplicacion().getListadoProyectos()) {
			botonProyecto = new JButton(p.getTitulo());
			botonProyecto.addActionListener(this);
			vista.addBotonProyecto(botonProyecto);
			proyectos.put(botonProyecto, p);
		}
	}
	/**
	 * Método encargado de añadir un proyecto pasado como argumento a la vista de home
	 * 
	 * @param p proyecto al cual queremos añadir a la lista de proyectos de home
	 * 
	 */
	public void addBotonProyecto(Proyecto p) {
		JButton botonProyecto = new JButton(p.getTitulo());
		botonProyecto.addActionListener(this);
		vista.addBotonProyecto(botonProyecto);
		proyectos.put(botonProyecto, p);
	}
	
	/**
	 * Método encargado de añadir los botones de colectivos a la vista.
	 * Se añaden todos los proyectos en la lista de proyectos de la aplicación
	 * 
	 */
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
	
	/**
	 * Método encargado de añadir un colectivo pasado como argumento a la vista de home
	 * 
	 * @param c colectivo al cual queremos añadir a la lista de colectivos de home
	 * 
	 */
	public void addBotonColectivo(Colectivo c) {
		JButton botonColectivo = new JButton(c.getTitulo());
		botonColectivo.addActionListener(this);
		vista.addBotonColectivo(botonColectivo);
		colectivos.put(botonColectivo, c);
	}

}
