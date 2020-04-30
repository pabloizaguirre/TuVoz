package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Proyecto;
import vista.*;

public class ControlIrAProyecto implements ActionListener {

	private Ventana frame;
	private Proyecto proyecto;
	
	public ControlIrAProyecto(Ventana frame, Proyecto p) {
		this.frame = frame;
		this.proyecto = p;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DetalleProyecto vista = new DetalleProyecto(proyecto);
		//vista.setControladorApoyar(new ControlApoyar(frame, vista));
		frame.anadirVentana(vista, proyecto.toString());
		frame.mostrarPanel(proyecto.toString());
	}

	
}
