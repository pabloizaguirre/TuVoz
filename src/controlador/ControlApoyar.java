package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.*;
import vista.*;

public class ControlApoyar implements ActionListener {
	private DetalleProyecto vista;
	private Ventana frame;
	
	public ControlApoyar(Ventana frame, DetalleProyecto vista) {
		this.frame = frame;
		this.vista = vista;
	}
	/**
	 * Hace que el usuario que esta utilizando la aplicacion apoye un proyecto
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Usuario usuarioActual = Aplicacion.getAplicacion().getUsuarioActual();
		if(!(usuarioActual instanceof Ciudadano)) {
			return;
		}
		vista.getProyecto().apoyarProyecto((ElementoColectivo) Aplicacion.getAplicacion().getUsuarioActual());
		JButton apoyar = vista.getApoyar();
		apoyar.setText("Apoyado");
		apoyar.setEnabled(false);
		
	}

}
