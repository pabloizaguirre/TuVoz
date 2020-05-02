package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Aplicacion;
import vista.*;

public class ControlMiPerfil implements ActionListener {

	private Ventana frame;
	private MiPerfil vista;
	
	public ControlMiPerfil(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaMiPerfil();
		setVista();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("cerrarSesion")){
			Aplicacion.guardarAplicacion();
			Aplicacion.getAplicacion().setUsuarioActual(null);
			frame.getVistaBarraSuperior().setVisible(false);
			frame.mostrarPanel("inicioRegistro");
		}
	}
	
	public void setVista() {
		vista.setControlador(this);
	}
}
