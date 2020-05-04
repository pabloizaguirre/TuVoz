package controlador;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import modelo.*;
import vista.DetalleProyecto;
/**
 * Clase ControlDetalleColectivo.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class ControlDetalleProyecto implements ActionListener{
	
	private JFrame frame;
	private DetalleProyecto vista;
	private Proyecto proyecto;

	public ControlDetalleProyecto(JFrame frame, DetalleProyecto vista, Proyecto p) {
		this.frame = frame;
		this.vista = vista;
		this.proyecto = p;
	}
	
	/**
	 * Método para gestionar los eventos que se pueden producir en la vista de detalle de un 
	 * proyecto: Apoyar proyecto, suscribirse, solicitar informes o enviar a financiación
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Usuario usuarioActual = Aplicacion.getAplicacion().getUsuarioActual();
		Object source = e.getSource();
		if(e.getActionCommand().contentEquals("apoyar")) { // al pulsar en el boton apoyar
			String colectivoApoyante = vista.getColectivoApoyante();
			if(colectivoApoyante.equals("Apoyar individualmente")) {
				proyecto.apoyarProyecto((ElementoColectivo) usuarioActual);
			} else {
				colectivoApoyante = colectivoApoyante.substring(23);
				proyecto.apoyarProyecto(Colectivo.buscarColectivo(colectivoApoyante));
			}
			((JButton) source).setText("Apoyado");
			((JButton) source).setEnabled(false);
			vista.getComboColectivos().setVisible(false);
		} else if(e.getActionCommand().contentEquals("suscribirse")) { // al pulsar en el boton suscribirse
			proyecto.suscribirProyecto((Ciudadano) usuarioActual);
			((JButton) source).setText("Suscrito");
			((JButton) source).setEnabled(false);
		} else if(e.getActionCommand().contentEquals("solicitarInforme")) { // al pulsar en el boton solicitar informe
			if (usuarioActual instanceof Ciudadano) {
				int apoyos = ((Ciudadano) usuarioActual).solicitarInformePopularidad(proyecto);
				if(apoyos==-1) {
					JOptionPane.showMessageDialog(vista,
							"No tienes acceso al informe.", "Informe de popularidad del proyecto " + proyecto.getTitulo(), JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(vista,
							"Número de apoyos del proyecto: " + apoyos, "Informe de popularidad del proyecto " + proyecto.getTitulo(), JOptionPane.DEFAULT_OPTION);
				}
			}
		} else if(e.getActionCommand().contentEquals("enviarAFinanciacion")) { // al pulsar en el boton de enviar a financiacion
			try {
				proyecto.enviarProyecto();
				((JButton) source).setText("Enviado a financiacion");
				((JButton) source).setEnabled(false);
				vista.setLabelEstado("Estado: " + proyecto.consultarEstadoProyecto());
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(vista,
						"No se ha podido enviar correctamente a financiacion. Vuelve a intentarlo más adelante.", "Pulsado enviar Proyecto", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Método encargado de gestionar los elementos de la vista de detalle de un proyecto: el estado,
	 * titulo, presupuesto, botones, etc
	 * 
	 * 
	 */
	public void setVistaDetalleProyecto() {
		EstadoProyecto estado = proyecto.consultarEstadoProyecto();
		vista.setTitulo(proyecto.getTitulo());
		Usuario usuario = Aplicacion.getAplicacion().getUsuarioActual();
		if(proyecto instanceof ProyectoSocial) {
			vista.setLabelTipo("Proyecto social");
		} else {
			vista.setLabelTipo("Proyecto de infraestructura");
		}
		if(!(usuario instanceof Administrador)) {
			boolean apoyado = proyecto.getListadoApoyos().contains(usuario);
			
			//establecemos la lista de colectivos creados para poder apoyar como colectivo
			if (!apoyado) {
				List<String> lista = new ArrayList<String>();
				for (ElementoColectivo c:((Ciudadano)usuario).getColectivosCreados()) {
					lista.add("Apoyar como colectivo: " + c.toString());
				}
				if(lista.size()>0 && (estado.equals(EstadoProyecto.DISPONIBLE)|| estado.equals(EstadoProyecto.NOENVIADO))) {
					vista.setComboColectivos(lista);
				}
			}
			if(estado.equals(EstadoProyecto.DISPONIBLE) || estado.equals(EstadoProyecto.NOENVIADO)) {
				vista.setApoyar(apoyado);
				
			}
			vista.setSuscribirse(proyecto.getListadoSuscripciones().contains(usuario));
			if(proyecto.getCreador().equals(usuario)) {
				vista.setSolicitarInforme();
				if(estado.equals(EstadoProyecto.DISPONIBLE)) {
					vista.setEnviarAFinanciacion();
				}
			}
		}
		vista.setPresupuestoSolicitado(proyecto.getPresupuestoSolicitado());
		
		if(estado.equals(EstadoProyecto.FINANCIADO)) {
			vista.setLabelEstado("Estado: " + estado + ", con presupuesto concedido de " + proyecto.getPresupuestoConcedido() + "€");
		} else {
			vista.setLabelEstado("Estado: " + estado);
		}
		
		vista.setDescripcion(proyecto.getDescripcion());
		
		if(proyecto instanceof ProyectoSocial) {
			vista.setDetallesOpcionalesSocial(((ProyectoSocial) proyecto).getGrupoSocial(), ((ProyectoSocial) proyecto).getAlcance().toString());
		} else {
			List<String> listaDistritos = new ArrayList<String>();
			for(Distrito d:((ProyectoInfraestructura) proyecto).getDistritosAfectados()) {
				listaDistritos.add(d.toString());
			}
			vista.setDetallesOpcionalesInfraestructura(listaDistritos, ((ProyectoInfraestructura) proyecto).getImagen().getPath());
		}
		vista.setControlador(this);
	}
	
	/**
	 * Método encargado de actualizar la vista de detalle de un proyecto
	 * 
	 * 
	 */
	public void resetVista() {
		EstadoProyecto estado = proyecto.consultarEstadoProyecto();
		Usuario usuario = Aplicacion.getAplicacion().getUsuarioActual();
		if(estado.equals(EstadoProyecto.FINANCIADO)) {
			vista.setLabelEstado("Estado: " + estado + ", con presupuesto concedido de " + proyecto.getPresupuestoConcedido() + "�");
		} else {
			vista.setLabelEstado("Estado: " + estado);
		}
		
		vista.resetButtonPanel();
		
		if(!(usuario instanceof Administrador)) {
			boolean apoyado = proyecto.getListadoApoyos().contains(usuario);
			
			//establecemos la lista de colectivos creados para poder apoyar como colectivo
			if (!apoyado) {
				List<String> lista = new ArrayList<String>();
				for (ElementoColectivo c:((Ciudadano)usuario).getColectivosCreados()) {
					lista.add("Apoyar como colectivo: " + c.toString());
				}
				if(lista.size()>0 && (estado.equals(EstadoProyecto.DISPONIBLE)|| estado.equals(EstadoProyecto.NOENVIADO))) {
					vista.setComboColectivos(lista);
				}
			}
			if(estado.equals(EstadoProyecto.DISPONIBLE) || estado.equals(EstadoProyecto.NOENVIADO)) {
				vista.setApoyar(apoyado);
				
			}
			vista.setSuscribirse(proyecto.getListadoSuscripciones().contains(usuario));
			if(proyecto.getCreador().equals(usuario)) {
				vista.setSolicitarInforme();
				if(estado.equals(EstadoProyecto.DISPONIBLE)) {
					vista.setEnviarAFinanciacion();
				}
			}
		}
		vista.setControlador(this);
	}

}
