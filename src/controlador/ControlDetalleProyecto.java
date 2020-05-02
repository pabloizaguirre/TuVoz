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
		if(e.getActionCommand().contentEquals("apoyar")) {
			proyecto.apoyarProyecto((ElementoColectivo) usuarioActual);
			((JButton) source).setText("Apoyado");
			((JButton) source).setEnabled(false);
		} else if(e.getActionCommand().contentEquals("suscribirse")) {
			proyecto.suscribirProyecto((Ciudadano) usuarioActual);
			((JButton) source).setText("Suscrito");
			((JButton) source).setEnabled(false);
		} else if(e.getActionCommand().contentEquals("solicitarInforme")) {
			JOptionPane.showMessageDialog(vista,
					"Queda implementar bien solicitar informe", "Pulsado solicitar informe", JOptionPane.DEFAULT_OPTION);
		} else if(e.getActionCommand().contentEquals("enviarAFinanciacion")) {
			try {
				proyecto.enviarProyecto();
				JOptionPane.showMessageDialog(vista,
						"Queda controlar bien las excepciones", "Pulsado enviar Proyecto", JOptionPane.DEFAULT_OPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
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
		EstadoProyecto estado = proyecto.getEstado();
		vista.setTitulo(proyecto.getTitulo());
		Usuario usuario = Aplicacion.getAplicacion().getUsuarioActual();
		if(proyecto instanceof ProyectoSocial) {
			vista.setLabelTipo("Proyecto social");
		} else {
			vista.setLabelTipo("Proyecto de infraestructura");
		}
		if(!(usuario instanceof Administrador)) {
			vista.setApoyar(proyecto.getListadoApoyos().contains(usuario));
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
		EstadoProyecto estado = proyecto.getEstado();
		Usuario usuario = Aplicacion.getAplicacion().getUsuarioActual();
		if(estado.equals(EstadoProyecto.FINANCIADO)) {
			vista.setLabelEstado("Estado: " + estado + ", con presupuesto concedido de " + proyecto.getPresupuestoConcedido() + "€");
		} else {
			vista.setLabelEstado("Estado: " + estado);
		}
		
		vista.resetButtonPanel();
		
		if(!(usuario instanceof Administrador)) {
			vista.setApoyar(proyecto.getListadoApoyos().contains(usuario));
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
