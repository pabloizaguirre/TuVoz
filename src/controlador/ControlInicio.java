package controlador;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import modelo.*;
import vista.*;
/**
 * Clase ControlInicio.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class ControlInicio implements ActionListener {
	
	private InicioRegistro vista;
    private Ventana frame;
    private Controlador controlador;
	
	
	public ControlInicio(Ventana frame, Controlador contr) {
		this.frame = frame;
		this.vista = frame.getVistaInicioRegistro();
		this.controlador = contr;
	}
	
	/**
	 * Método encargado de gestionar las acciones en los botones de la vista de inicio de sesión
	 * y de registro en la aplicacion
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		
		if (source.equals("botonIniciarSesion") || source.equals("nombre") || source.equals("password")) {
			/*Comprobamos que ambos campos han sido rellenados*/
	        if(vista.getNombre().equals("") || vista.getPassword().equals("")) {
	        	JOptionPane.showMessageDialog(vista,
						"Debe introducir un nombre de usuario/NIF y contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
	        	return;
	        } /*Comprobamos si las credenciales introducidas corresponden con el administrador*/
	        
	        if(Aplicacion.getAplicacion().getAdministrador().getNombreUsuario().equals(vista.getNombre()) &&
	        		Aplicacion.getAplicacion().getAdministrador().getContrasena().equals(vista.getPassword())) {
	        	Aplicacion.getAplicacion().setUsuarioActual(Aplicacion.getAplicacion().getAdministrador());
	        	
	        	
	        	controlador.getControlNotificaciones().setVista();
	        	frame.getVistaBarraSuperior().setVisible(true);
	        	vista.limpiarJtf();
	        	controlador.getControlMiPerfil().setVista();
	        	frame.getVistaHome().setAdminMode();
	        	frame.mostrarPanel("home");
	        } 
	        /*Comprobamos si las credenciales introducidas corresponden a un ciudadano registrado*/
	        else {
	        	Ciudadano ciu = Ciudadano.buscarCiudadano(vista.getNombre());
	        	if(ciu !=null && ciu.getContrasena().equals(vista.getPassword())) {
	        		Aplicacion.getAplicacion().setUsuarioActual((Usuario)ciu);
	        	
	   
	        		controlador.getControlNotificaciones().setVista();
	        		frame.getVistaBarraSuperior().setVisible(true);
		        	vista.limpiarJtf();
		        	controlador.getControlMiPerfil().setVista();
		        	frame.getVistaHome().setCiudadanoMode();
	        		frame.mostrarPanel("home");
	        	} else {
	        		JOptionPane.showMessageDialog(vista,
						"No existe un usuario con las credenciales proporcionadas", "Error de credenciales", JOptionPane.ERROR_MESSAGE);
	        	}
	        }
		}
		
		
		else if(source.equals("botonRegistrarse")) {
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
}

