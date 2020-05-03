package controlador;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.HashMap;

import javax.swing.*;
import modelo.*;
import vista.*;

/**
 * Clase ControlNotificaciones.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class ControlNotificaciones implements ActionListener {
	private VerNotificaciones vista;
	private Ventana frame;
	
	private HashMap<JButton, Notificacion> HMIrProyecto = new HashMap<JButton, Notificacion>();
	
	private HashMap<JButton, Notificacion> HMAprobarRegistro= new HashMap<JButton, Notificacion>();
	private HashMap<JButton, Notificacion> HMRechazarRegistro= new HashMap<JButton, Notificacion>();
	
	private HashMap<JButton, Notificacion> HMVerProyecto= new HashMap<JButton, Notificacion>();
	private HashMap<JButton, Notificacion> HMAprobarProyecto= new HashMap<JButton, Notificacion>();
	private HashMap<JButton, Notificacion> HMRechazarProyecto= new HashMap<JButton, Notificacion>();

	
	
	public ControlNotificaciones(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaNotificaciones();
		//setVista();
	}
	
	/**
	 * Método encargado de gestionar las notificaciones
	 * 
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(HMIrProyecto.containsKey(source)) {
			Notificacion n = HMIrProyecto.get(source);
			
		}

		else if (HMAprobarRegistro.containsKey(source)) {
			Notificacion n= HMAprobarRegistro.get(source);
			Ciudadano c= ((NotificacionCiudadano)n).getCiudadano();
			c.aprobarRegistro();
			String i =e.getActionCommand();
			int id =Integer.parseInt(i);
			vista.borrarNotificacion(id);
		}
		
		else if (HMRechazarRegistro.containsKey(source)) {
			Notificacion n= HMRechazarRegistro.get(source);
			Ciudadano c = ((NotificacionCiudadano)n).getCiudadano();
			c.eliminarNotificacion(n);
			Aplicacion.getAplicacion().getListadoElementoColectivos().remove(c);
			String i = e.getActionCommand();
			int id = Integer.parseInt(i);
			vista.borrarNotificacion(id);
		}
		
		else if(HMVerProyecto.containsKey(source)) {
			
			
		}
		
		else if (HMAprobarProyecto.containsKey(source)) {
			Notificacion n= HMAprobarProyecto.get(source);
			Proyecto p = ((NotificacionProyectoNuevo)n).getProyecto();
			p.aprobarProyecto();
			String i =e.getActionCommand();
			int id =Integer.valueOf(i);
			vista.borrarNotificacion(id);
		}
		
		else if (HMRechazarProyecto.containsKey(source)) {
			Notificacion n= HMRechazarProyecto.get(source);
			Proyecto p = ((NotificacionProyectoNuevo)n).getProyecto();
			p.rechazarProyecto("Su proyecto ha sido rechazado por infringir las normas de la comunidad");
			String i =e.getActionCommand();
			int id =Integer.parseInt(i);
			vista.borrarNotificacion(id);
		}
		
	}
	
	public void setVista() {
		for(Notificacion n:Aplicacion.getAplicacion().getUsuarioActual().getNotificaciones()) {
			String texto = n.getTextoNotificacion();
			
			if (n instanceof NotificacionCiudadano) {
				JButton AprobarRegistro = new JButton("Aprobar registro");
				JButton RechazarRegistro = new JButton("Rechazar registro");
				
				AprobarRegistro.addActionListener(this);
				RechazarRegistro.addActionListener(this);
				
				HMAprobarRegistro.put(AprobarRegistro, n);
				HMRechazarRegistro.put(RechazarRegistro, n);
				
				vista.addNotificacionAprobarRegistro(texto, AprobarRegistro, RechazarRegistro);
				
				
			}
			
			else if (n instanceof NotificacionProyectoNuevo) {
				JButton VerProyecto = new JButton("Ver proyecto");
				JButton AprobarProyecto = new JButton("Aprobar proyecto");
				JButton RechazarProyecto = new JButton("Rechazar proyecto");
				
				VerProyecto.addActionListener(this);
				AprobarProyecto.addActionListener(this);
				RechazarProyecto.addActionListener(this);
				
				HMVerProyecto.put(VerProyecto, n);
				HMAprobarProyecto.put(AprobarProyecto, n);
				HMRechazarProyecto.put(RechazarProyecto, n);
				
				vista.addNotificacionAprobarProyecto(texto, VerProyecto, AprobarProyecto, RechazarProyecto);
				
			}
			
			else if (n instanceof NotificacionProyectoEstado) {
				JButton IrProyecto = new JButton("Ir a proyecto");
				IrProyecto.addActionListener(this);
				HMIrProyecto.put(IrProyecto,n);
				vista.addNotificacionCiudadanoProyecto(texto, IrProyecto);
			}
		}
	}
}
