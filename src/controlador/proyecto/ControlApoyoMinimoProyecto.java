package controlador.proyecto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.aplicacion.Aplicacion;
import vista.*;
import vista.proyecto.ApoyoMinimoProyecto;

/**
 * Clase ControlApoyoMinimoProyecto.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class ControlApoyoMinimoProyecto implements ActionListener{
private ApoyoMinimoProyecto vista;
	private Ventana frame;
	
	
	public ControlApoyoMinimoProyecto(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaApoyoMinimoProyecto();
	}
	
	/**
	 * Método para gestionar los eventos acontecidos en la vista de gestión del número de apoyos mínimos
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("aceptar")) {
			if(vista.getEntrada().equals("")) {
				JOptionPane.showMessageDialog(vista,
					"Debe introducir un numero minimo de apoyos.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			Aplicacion.getAplicacion().setApoyosMin(Integer.parseInt(vista.getEntrada()));
			JOptionPane.showMessageDialog(vista,
					"Se ha actualizado el numero minimo de apoyos para proyecto a "+Integer.parseInt(vista.getEntrada()), 
					"Cambio de numero minimo de apoyos", JOptionPane.INFORMATION_MESSAGE);
			frame.mostrarPanel("home");
		}
	}
	}
	