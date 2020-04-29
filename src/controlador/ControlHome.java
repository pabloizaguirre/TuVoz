package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.*;

import vista.Home;
import vista.Ventana;

public class ControlHome implements ActionListener{
	private Home vista;
	private Ventana frame;
	
	private HashMap<JButton, Proyecto> proyectos = new HashMap<JButton, Proyecto>();
	
	public ControlHome(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaHome();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="botonProyecto") {
			String s
			JOptionPane.showMessageDialog(vista,
					"Yendo al proyecto: ", "Error en el registro", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
