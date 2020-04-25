package controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.*;
import vista.*;


public class ControlIrAMiPerfil implements ActionListener {
	
	private MiPerfil vista;
	private Ventana frame;
	
	public ControlIrAMiPerfil(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaMiPerfil();
	}

	/**
	 * Cambia la vista a mi perfil
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// mostrar nueva vista
		frame.mostrarPanel("miPerfil");
		
	}
	
}
