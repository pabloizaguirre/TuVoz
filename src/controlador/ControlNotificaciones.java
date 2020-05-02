package controlador;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.HashMap;

import javax.swing.*;
import modelo.*;
import vista.*;


public class ControlNotificaciones implements ActionListener {
	private VerNotificaciones vista;
	private Ventana frame;
	
	private HashMap<JButton, Proyecto> HMIrProyecto = new HashMap<JButton, Proyecto>();
	private HashMap<JButton, Colectivo> colectivos = new HashMap<JButton, Colectivo>();
	
	
	public ControlNotificaciones(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaNotificaciones();
		setVista();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("IrProyecto")) {
			/*Proyecto p = NotificacionProyectoEstado.getProyecto();*/
		}
		else if (e.getActionCommand().equals("AprobarRegistro")) {
			
		}
		else if (e.getActionCommand().equals("AprobarProyecto")) {
			
		}
		
	}
	
	public void setVista() {
		for(Notificacion n:Aplicacion.getAplicacion().getUsuarioActual().getNotificaciones()) {
			String texto = n.getTextoNotificacion();
			
			if (n instanceof NotificacionCiudadano) {
				JPanel j = vista.addNotificacionAprobarRegistro(texto);
				Proyecto p=((NotificacionProyectoEstado) n).getProyecto();
				JButton b= 
				proyectosCambioEstado.put(n,p);
			}
			else if (n instanceof NotificacionProyectoNuevo) {
				vista.addNotificacionAprobarProyecto(texto);
			}
			else if (n instanceof NotificacionProyectoEstado) {
				vista.addNotificacionCiudadanoProyecto(texto);
			}
		}
	}
}
