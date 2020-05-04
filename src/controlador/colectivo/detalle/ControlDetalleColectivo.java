package controlador.colectivo.detalle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controlador.proyecto.detalle.ControlDetalleProyecto;
import modelo.Ciudadano;
import modelo.aplicacion.Aplicacion;
import modelo.elementocolectivo.ElementoColectivo;
import modelo.elementocolectivo.colectivo.Colectivo;
import modelo.proyecto.EstadoProyecto;
import modelo.proyecto.Proyecto;
import modelo.usuario.Administrador;
import modelo.usuario.Usuario;
import vista.Ventana;
import vista.colectivo.detalle.DetalleColectivo;
import vista.proyecto.detalle.DetalleProyecto;
/**
 * Clase ControlDetalleColectivo.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class ControlDetalleColectivo implements ActionListener{
	
	private Ventana frame;
	private DetalleColectivo vista;
	private Colectivo colectivo;
	
	private HashMap<JButton, Proyecto> proyectos = new HashMap<JButton, Proyecto>();
	private HashMap<JButton, Colectivo> colectivos = new HashMap<JButton, Colectivo>();
	

	public ControlDetalleColectivo(Ventana frame, DetalleColectivo vista, Colectivo c) {
		this.frame = frame;
		this.vista = vista;
		this.colectivo = c;
	}
	/**
	 * Método para gestionar los eventos que se pueden producir en la vista de detalle de un colectivo
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		Usuario usuarioActual = Aplicacion.getAplicacion().getUsuarioActual();
		if(e.getActionCommand().equals("unirme")) {
			colectivo.unirseAColectivo((Ciudadano) usuarioActual);
			((Ciudadano) usuarioActual).anadirAMisColectivos(colectivo);
			vista.getBotonUnirme().setEnabled(false);

		} else if (e.getActionCommand().equals("solicitarInforme")) {
			if (usuarioActual instanceof Ciudadano) {
				String colectivo2 = vista.getColectivo2();
				colectivo2 = colectivo2.substring(48);
				System.out.println(colectivo2);
				double indice = ((Ciudadano) usuarioActual).solicitarInformeAfinidad(colectivo, Colectivo.buscarColectivo(colectivo2));
				
				if(indice == -1) {
					JOptionPane.showMessageDialog(vista,
							"No tienes acceso al informe.", "Informe de afinidad con el colectivo " + colectivo2, JOptionPane.ERROR_MESSAGE);
				} else if(indice == -2) {
					JOptionPane.showMessageDialog(vista,
							"No se puede determinar el indice de afinidad porque ninguno de los dos proyectos ha creado algun proyecto.", "Informe de afinidad con el colectivo " + colectivo2, JOptionPane.DEFAULT_OPTION);
				} else {
					JOptionPane.showMessageDialog(vista,
							"Indice de afinidad con el colectivo " + colectivo2 + ": " + indice, "Informe de afinidad con el colectivo " + colectivo2, JOptionPane.DEFAULT_OPTION);
				}
			}
		}
		/*Si pulsamos en cualquier proyecto*/
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
	 * Método encargado de gestionar los botones de la vista, según si el usuario actual pertece
	 * o no al colectivo, o sea su representante
	 * 
	 * 
	 */
	
	public void setVistaDetalleColectivo() {
		vista.setTitulo(colectivo.getTitulo());
		Usuario usuario = Aplicacion.getAplicacion().getUsuarioActual();
		
		if(!(usuario instanceof Administrador)) {
			vista.setUnirme(colectivo.getElementos().contains((Ciudadano) usuario));
			
			if(((Ciudadano) usuario).getMisColectivos().contains(colectivo)) {
				List<String> lista = new ArrayList<String>();
				for (Colectivo c:((Ciudadano)usuario).getMisColectivos()) {
					if(!c.equals(colectivo)) {
						lista.add("Solicitar informe de afinidad con el colectivo: " + c.getTitulo());

					}
				}
				if(lista.size()>0) {
					vista.setSolicitarInforme(lista);
				}
			}
			
		}
		JButton botonColectivo;
		boolean flag = false;
		for(ElementoColectivo e:colectivo.getElementos()) {
			if(e instanceof Colectivo) {
				flag=true;
				botonColectivo = new JButton(((Colectivo)e).getTitulo());
				botonColectivo.addActionListener(this);
				vista.addBotonColectivo(botonColectivo);
				colectivos.put(botonColectivo, (Colectivo) e);
			}
			
		}
		if(!flag) {
			vista.setColectivosVacios();
		}
		JButton botonProyecto;
		flag = false;
		for(Proyecto e:colectivo.getProyectosPropuestos()) {
			flag=true;
			botonProyecto = new JButton(e.getTitulo());
			botonProyecto.addActionListener(this);
			vista.addBotonProyecto(botonProyecto);
			proyectos.put(botonProyecto, e);
			
		}
		if(!flag) {
			vista.setProyectosVacios();
		} 
		vista.setControlador(this);
	}
	
	/**
	 * Método para actualizar la vista de detalle de un colectivo
	 * 
	 * @param e action event
	 */
	public void resetVista() {
		vista.resetAll();
		setVistaDetalleColectivo();
	}
}
