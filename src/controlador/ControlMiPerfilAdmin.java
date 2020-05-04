package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.*;
import vista.*;
/**
 * Clase ControlMiPerfilAdmin.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class ControlMiPerfilAdmin implements ActionListener {

	private Ventana frame;
	private MiPerfilAdmin vista;
	
	public ControlMiPerfilAdmin(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaMiPerfilAdmin();
	}
	/**
	 * MÃ©todo encargado de gestionar los eventos relacionados con los botones de la vista 
	 * de mi perfil administrador
	 * 
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("cerrarSesion")){
			Aplicacion.getAplicacion().setUsuarioActual(null);
			frame.getVistaBarraSuperior().setVisible(false);
			frame.mostrarPanel("inicioRegistro");
		} else if (e.getActionCommand().contentEquals("reset")) {
			int option = JOptionPane.showConfirmDialog(
					frame, 
					"¿Estás seguro de que quieres resetear la aplicacion?",
					"Confirmacion", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE);
			if(option == JOptionPane.YES_OPTION) {
				Aplicacion.getAplicacion().getListadoElementoColectivos().clear();
				Aplicacion.getAplicacion().getListadoProyectos().clear();
				Aplicacion.getAplicacion().getListaNombres().clear();
				Aplicacion.getAplicacion().getAdministrador().getNotificaciones().clear();
				Aplicacion.getAplicacion().setUsuarioActual(null);
			
				File fichero = new File("data.dat");
				fichero.delete();
				System.exit(0);
			}
		}/*Si pulsamos en avanzar la fecha siendo Admin*/
		else if(e.getActionCommand().contentEquals("adelantoFecha")) {
			JOptionPane.showMessageDialog(vista,
					"Hoy es "+FechaSimulada.getHoy() , "Avanzando 30 dias", JOptionPane.INFORMATION_MESSAGE);
			FechaSimulada.avanzar(30);
			JOptionPane.showMessageDialog(vista,
					"Ahora, hoy es " + FechaSimulada.getHoy() , "Avanzando 30 dias", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(e.getActionCommand().equals("bloquear") || e.getActionCommand().equals("desbloquear")) {
			Ciudadano ciu = Ciudadano.buscarCiudadano(vista.getUsuario());
			if(ciu==null) {
				JOptionPane.showMessageDialog(vista,
					"No existe un usuario con las credenciales introducidas", "Error", JOptionPane.ERROR_MESSAGE);
				vista.limpiarJtf();
				return;
		}
			if(e.getActionCommand().equals("bloquear")) {
				ciu.bloquearCiudadano();
				JOptionPane.showMessageDialog(vista,
					ciu.getNombreUsuario()+" ha sido bloqueado", "Ciudadano bloquado", JOptionPane.INFORMATION_MESSAGE);
		}
		
			else if(e.getActionCommand().equals("desbloquear")) {
				ciu.desbloquearCiudadano();
				JOptionPane.showMessageDialog(vista,
					ciu.getNombreUsuario()+" ha sido desbloqueado", "Ciudadano desbloquado", JOptionPane.INFORMATION_MESSAGE);
		}vista.limpiarJtf();
			
		}
	}
}