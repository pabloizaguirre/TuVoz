package vista;

import java.awt.BorderLayout;

import javax.swing.*;

import modelo.Notificacion;

public class VerNotificaciones extends JPanel{
	
	private JLabel mensaje = new JLabel("");
	private JButton IrProyecto;
	private JButton AprobarRegistro;
	private JButton AprobarProyecto;
	
	public VerNotificaciones(){
		BoxLayout notiLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(notiLayout);
		JLabel intro = new JLabel ("Notificaciones");
		this.add(intro);
		
		
    }
    
	public JPanel NotificacionCiudadanoProyecto() {
		final JPanel notiCiudadano = new JPanel();
		BoxLayout layoutNoticiu = new BoxLayout(notiCiudadano, BoxLayout.Y_AXIS);
		notiCiudadano.setLayout(layoutNoticiu);
		this.add(mensaje);
		IrProyecto = new JButton("Ir al proyecto");
		IrProyecto.setActionCommand("botonIrProyecto");
		return notiCiudadano;
		}
	
	public JPanel NotificacionAprobarRegistro() {
		final JPanel notiRegistro = new JPanel();
		BoxLayout layoutNotireg = new BoxLayout(notiRegistro, BoxLayout.Y_AXIS);
		notiRegistro.setLayout(layoutNotireg);
		this.add(mensaje);
		AprobarRegistro = new JButton("Aprobar registro");
		AprobarRegistro.setActionCommand("botonAprobarRegistro");
		return notiRegistro;
	}
	
	public JPanel NotificacionAprobarProyecto() {
		final JPanel notiProye = new JPanel();
		BoxLayout layoutNotiproye = new BoxLayout(notiProye, BoxLayout.Y_AXIS);
		notiProye.setLayout(layoutNotiproye);
		this.add(mensaje);
		AprobarProyecto = new JButton("Aprobar proyecto");
		AprobarProyecto.setActionCommand("botonAprobarProyecto");
		return notiProye;
	}
	
	public void setMensaje(String texto) {
		mensaje.setText(texto);
	}
}