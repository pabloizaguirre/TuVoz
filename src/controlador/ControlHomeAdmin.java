package controlador;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;

import modelo.*;

import vista.*;

public class ControlHomeAdmin implements ActionListener{
	private HomeAdmin vista;
	private Ventana frame;
	
	private HashMap<JButton, Proyecto> proyectos = new HashMap<JButton, Proyecto>();
	
	public ControlHomeAdmin(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaHomeAdmin();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("apoyoProyecto")) {
			
			JOptionPane.showMessageDialog(vista,
					"Numero de apoyos actuales: " +Aplicacion.getAplicacion().getApoyosMin() , "Gestionar apoyos minimos", JOptionPane.INFORMATION_MESSAGE);
			frame.mostrarPanel("apoyoMinimoProyecto");
		}
	}

}
