package controlador;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import modelo.*;
import vista.*;


public class ControlNotificaciones implements ActionListener {
	private VerNotificaciones vista;
	private Ventana frame;
	
	public ControlNotificaciones(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaNotificaciones();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("IrProyecto")) {
			Proyecto p = NotificacionProyectoEstado.getProyecto();
		}
		else if (e.getActionCommand().equals("AprobarRegistro")) {
			
		}
		else if (e.getActionCommand().equals("AprobarProyecto")) {
			
		}
		
	}
}
