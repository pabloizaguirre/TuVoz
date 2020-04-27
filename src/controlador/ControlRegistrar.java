package controlador;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import modelo.*;
import vista.*;

public class ControlRegistrar implements ActionListener {
	
	private InicioRegistro vista;
    private Ventana frame;
	
	
	public ControlRegistrar(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaInicioRegistro();
	}
	
	/**
	 * Cambia la vista a CrearProyectoSocial
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
        if(vista.getNifReg().equals("") || vista.getUsuarioReg().equals("") || 
        		vista.getPasswordReg().equals("")) {
        	JOptionPane.showMessageDialog(vista,
					"Debe rellenar todos los datos de registro.", "Error en el registro", JOptionPane.ERROR_MESSAGE);
        } else if(Aplicacion.getAplicacion().nifEnUso(vista.getNifReg()) || Ciudadano.nombreEnUso(vista.getUsuarioReg())) {
        	JOptionPane.showMessageDialog(vista,
					"Nombre de usuario o NIF en uso", "Error en el registro", JOptionPane.ERROR_MESSAGE);
        } else {
        	new Ciudadano(vista.getPasswordReg(), vista.getUsuarioReg(),vista.getNifReg());
        	JOptionPane.showMessageDialog(vista,
					"Registro satisfactorio, a la espera de admision por la Administracion de Tu Voz", "Registro en Tu Voz", JOptionPane.INFORMATION_MESSAGE);
        }
  }
}
