package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.Notificacion;

public class VerNotificaciones extends JPanel{
	
	private JButton IrProyecto = new JButton("a");
	private JButton AprobarRegistro = new JButton("b");
	private JButton AprobarProyecto = new JButton("c");
	private JTextArea mensaje = new JTextArea();
	
	public VerNotificaciones(){
		BoxLayout notiLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(notiLayout);
		JLabel intro = new JLabel ("Notificaciones");
		this.add(intro);
		
		
    }
    
	public void NotificacionCiudadanoProyecto(String texto) {
		final JPanel notiCiudadano = new JPanel();
		BoxLayout layoutNoticiu = new BoxLayout(notiCiudadano, BoxLayout.Y_AXIS);
		notiCiudadano.setLayout(layoutNoticiu);
		
		mensaje.setEditable(false);
		mensaje.setLineWrap(true);
		mensaje.setBackground(null);
		mensaje.setFont(new Font(mensaje.getFont().getName(), Font.PLAIN, mensaje.getFont().getSize()+20));
		
		this.add(mensaje);
		IrProyecto = new JButton("Ir al proyecto");
		IrProyecto.setActionCommand("botonIrProyecto");
		notiCiudadano.setVisible(true);
		this.add(notiCiudadano);
		}
	
	public void NotificacionAprobarRegistro(String texto) {
		final JPanel notiRegistro = new JPanel();
		BoxLayout layoutNotireg = new BoxLayout(notiRegistro, BoxLayout.Y_AXIS);
		notiRegistro.setLayout(layoutNotireg);
		
		mensaje.setEditable(false);
		mensaje.setLineWrap(true);
		mensaje.setBackground(null);
		mensaje.setFont(new Font(mensaje.getFont().getName(), Font.PLAIN, mensaje.getFont().getSize()+20));
		
		this.add(mensaje);
		AprobarRegistro = new JButton("Aprobar registro");
		AprobarRegistro.setActionCommand("botonAprobarRegistro");
		notiRegistro.setVisible(true);
		this.add(notiRegistro);
	}
	
	public void NotificacionAprobarProyecto(String texto) {
		final JPanel notiProye = new JPanel();
		BoxLayout layoutNotiproye = new BoxLayout(notiProye, BoxLayout.Y_AXIS);
		notiProye.setLayout(layoutNotiproye);

		mensaje.setEditable(false);
		mensaje.setLineWrap(true);
		mensaje.setBackground(null);
		mensaje.setFont(new Font(mensaje.getFont().getName(), Font.PLAIN, mensaje.getFont().getSize()+20));
		
		this.add(mensaje);
		AprobarProyecto = new JButton("Aprobar proyecto");
		AprobarProyecto.setActionCommand("botonAprobarProyecto");
		notiProye.setVisible(true);
		this.add(notiProye);
	}
	
	public void setMensje(String texto) {
		this.mensaje.append(texto);
	}
	
	public void setControlNotificaciones(ActionListener c) {  
		IrProyecto.addActionListener(c);
		AprobarRegistro.addActionListener(c);
		AprobarProyecto.addActionListener(c);
	}
}