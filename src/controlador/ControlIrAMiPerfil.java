package controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.*;
import vista.*;
/**
 * Clase ControlMiPerfil.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public class ControlIrAMiPerfil implements ActionListener {
	
	private MiPerfil vista;
	private Ventana frame;
	
	public ControlIrAMiPerfil(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaMiPerfil();
	}

	/**
	 * Método encargado de gestionar los eventos relacionados con los botones de la vista 
	 * de mi perfil
	 * 
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// mostrar nueva vista
		frame.mostrarPanel("miPerfil");
		
	}
	
}
