package controlador;

import java.awt.event.*;

import javax.swing.*;

import modelo.*;
import vista.DetalleProyecto;

public class ControlDetalleProyecto implements ActionListener{
	
	private JFrame frame;
	private DetalleProyecto vista;
	private Proyecto proyecto;

	public ControlDetalleProyecto(JFrame frame, DetalleProyecto vista, Proyecto p) {
		this.frame = frame;
		this.vista = vista;
		this.proyecto = p;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Usuario usuarioActual = Aplicacion.getAplicacion().getUsuarioActual();
		Object source = e.getSource();
		if(e.getActionCommand().contentEquals("apoyar")) {
			vista.getProyecto().apoyarProyecto((ElementoColectivo) usuarioActual);
			((JButton) source).setText("Apoyado");
			((JButton) source).setEnabled(false);
		} else if(e.getActionCommand().contentEquals("suscribirse")) {
			vista.getProyecto().suscribirProyecto((Ciudadano) usuarioActual);
			((JButton) source).setText("Suscrito");
			((JButton) source).setEnabled(false);
		} else if(e.getActionCommand().contentEquals("solicitarInforme")) {
			JOptionPane.showMessageDialog(vista,
					"Queda implementar bien solicitar informe", "Pulsado solicitar informe", JOptionPane.DEFAULT_OPTION);
		} else if(e.getActionCommand().contentEquals("enviarAFinanciacion")) {
			try {
				vista.getProyecto().enviarProyecto();
				JOptionPane.showMessageDialog(vista,
						"Queda controlar bien las excepciones", "Pulsado enviar Proyecto", JOptionPane.DEFAULT_OPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void setVistaDetalleProyecto() {
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
				if(proyecto.getEstado().equals(EstadoProyecto.DISPONIBLE)) {
					vista.setEnviarAFinanciacion();
				}
			}
		}
	}

}
