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

public class ControlDetalleColectivo implements ActionListener{
	
	private JFrame frame;
	private DetalleColectivo vista;
	private Colectivo colectivo;

	public ControlDetalleColectivo(JFrame frame, DetalleColectivo vista, Colectivo c) {
		this.frame = frame;
		this.vista = vista;
		this.colectivo = c;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("unirme")) {
			colectivo.unirseAColectivo((Ciudadano) Aplicacion.getAplicacion().getUsuarioActual());
			((Ciudadano) Aplicacion.getAplicacion().getUsuarioActual()).anadirAMisColectivos(colectivo);
			vista.getBotonUnirme().setEnabled(false);
			JOptionPane.showMessageDialog(vista,
					"Te has unido a " +colectivo.getTitulo(), "Unirme a colectivo", JOptionPane.INFORMATION_MESSAGE);
		}else {
			
		}
	}
	
	public void setVistaDetalleColectivo() {
		vista.setTitulo(colectivo.getTitulo());
		Usuario usuario = Aplicacion.getAplicacion().getUsuarioActual();
		
		if(!(usuario instanceof Administrador)) {
			vista.setUnirme(colectivo.getElementos().contains(usuario));
		}
		vista.setControlador(this);
	}
	
	public void resetVista() {
		Usuario usuario = Aplicacion.getAplicacion().getUsuarioActual();
		
		vista.resetButtonPanel();
		
		if(!(usuario instanceof Administrador)) {
			vista.setUnirme(colectivo.getElementos().contains(usuario));
		}
		
		vista.setControlador(this);
		

	}
}
