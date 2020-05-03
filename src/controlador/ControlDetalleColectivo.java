package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.Administrador;
import modelo.Aplicacion;
import modelo.Ciudadano;
import modelo.Colectivo;
import modelo.Proyecto;
import modelo.Usuario;
import vista.DetalleColectivo;
import vista.DetalleProyecto;
/**
 * Clase ControlDetalleColectivo.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class ControlDetalleColectivo implements ActionListener{
	
	private JFrame frame;
	private DetalleColectivo vista;
	private Colectivo colectivo;

	public ControlDetalleColectivo(JFrame frame, DetalleColectivo vista, Colectivo c) {
		this.frame = frame;
		this.vista = vista;
		this.colectivo = c;
	}
	/**
	 * Método para gestionar los eventos que se pueden producir en la vista de detalle de un colectivo
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("unirme")) {
			colectivo.unirseAColectivo((Ciudadano) Aplicacion.getAplicacion().getUsuarioActual());
			((Ciudadano) Aplicacion.getAplicacion().getUsuarioActual()).anadirAMisColectivos(colectivo);
			vista.getBotonUnirme().setEnabled(false);

		}
	}
	
	/**
	 * Método encargado de gestionar los botones de la vista, según si el usuario actual pertece
	 * o no al colectivo, o sea su representante
	 * 
	 * 
	 */
	
	public void setVistaDetalleColectivo() {
		vista.setTitulo(colectivo.getTitulo());
		Usuario usuario = Aplicacion.getAplicacion().getUsuarioActual();
		
		if(!(usuario instanceof Administrador)) {
			vista.setUnirme(colectivo.getElementos().contains(usuario));
		}
		vista.setControlador(this);
	}
	
	/**
	 * Método para actualizar la vista de detalle de un colectivo
	 * 
	 * @param e action event
	 */
	
	public void resetVista() {
		Usuario usuario = Aplicacion.getAplicacion().getUsuarioActual();
		
		vista.resetButtonPanel();
		
		if(!(usuario instanceof Administrador)) {
			vista.setUnirme(colectivo.getElementos().contains(usuario));
		}
		
		vista.setControlador(this);
		

	}
}
