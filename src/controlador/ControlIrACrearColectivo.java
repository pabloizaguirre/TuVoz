package controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.*;
import vista.*;

/**
 * Clase ControlIrACrearColectivo.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class ControlIrACrearColectivo implements ActionListener {
	
	private MiPerfil vista;
	private Ventana frame;
	
	public ControlIrACrearColectivo(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaMiPerfil();
	}

	/**
	 * Método encargado de mostrar la vista de creacion de colectivo cuando se acciona el
	 * boton para crear un nuevo colectivo
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// mostrar nueva vista
		CrearColectivo.addColectivos(((Ciudadano)Aplicacion.getAplicacion().getUsuarioActual()).getColectivosCreados());
		frame.mostrarPanel("crearColectivo");
		
	}
	
}
