package controlador;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import modelo.*;
import vista.*;

public class ControlIniciarSesion implements ActionListener {
	
	private InicioRegistro vista;
    private Ventana frame;
	
	
	public ControlIniciarSesion(Ventana frame) {
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
		/*Comprobamos que ambos campos han sido rellenados*/
        if(vista.getNombre().equals("") || vista.getPassword().equals("")) {
        	JOptionPane.showMessageDialog(vista,
					"Debe introducir un nombre de usuario/NIF y contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
        	return;
        } /*Comprobamos si las credenciales introducidas corresponden con el administrador*/
        
        	if(Aplicacion.getAplicacion().getAdministrador().getNombreUsuario().equals(vista.getNombre()) &&
        		Aplicacion.getAplicacion().getAdministrador().getContrasena().equals(vista.getPassword())) {
        	Aplicacion.getAplicacion().setUsuarioActual(Aplicacion.getAplicacion().getAdministrador());
        	
        	JOptionPane.showMessageDialog(vista,
					"Bienvenido, Administrador", "Bienvenido a Tu Voz", JOptionPane.INFORMATION_MESSAGE);
        	frame.mostrarPanel("homeAdmin");
        } 
        /*Comprobamos si las credenciales introducidas corresponden a un ciudadano registrado*/
        else {
        	Ciudadano ciu = Ciudadano.buscarCiudadano(vista.getNombre());
        	if(ciu !=null && ciu.getContrasena().equals(vista.getPassword())) {
        		Aplicacion.getAplicacion().setUsuarioActual((Usuario)ciu);
        	
        		JOptionPane.showMessageDialog(vista,
					"Bienvenido, "+vista.getNombre(), "Bienvenido a Tu Voz", JOptionPane.INFORMATION_MESSAGE);
        		frame.mostrarPanel("home");
        }else {
        	JOptionPane.showMessageDialog(vista,
					"No existe un usuario con las credenciales proporcionadas", "Error de credenciales", JOptionPane.ERROR_MESSAGE);
        }
        }
	}
}

