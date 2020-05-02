package vista;


import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import modelo.Notificacion;

public class VerNotificaciones extends JPanel{
	
	private JButton IrProyecto = new JButton("a");
	private JButton AprobarRegistro = new JButton("b");
	private JButton AprobarProyecto = new JButton("c");
	
	
	public VerNotificaciones(){
		BoxLayout notiLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(notiLayout);
		JLabel intro = new JLabel ("Notificaciones");
		this.add(intro);
		
		
    }
    
	public void addNotificacionCiudadanoProyecto(String texto) {
		final JPanel notiCiudadano = new JPanel();
		BoxLayout layoutNoticiu = new BoxLayout(notiCiudadano, BoxLayout.Y_AXIS);
		notiCiudadano.setLayout(layoutNoticiu);
		
		
		JTextArea mensaje = new JTextArea();
		mensaje.append(texto);
		mensaje.setEditable(false);
		mensaje.setLineWrap(true);
		mensaje.setBackground(null);
		notiCiudadano.add(mensaje);
		
		IrProyecto = new JButton("Ir al proyecto");
		IrProyecto.setActionCommand("botonIrProyecto");
		notiCiudadano.add(IrProyecto);
		
		notiCiudadano.setVisible(true);
		this.add(notiCiudadano);
		}
	
	public void addNotificacionAprobarRegistro(String texto) {
		final JPanel notiRegistro = new JPanel();
		BoxLayout layoutNotireg = new BoxLayout(notiRegistro, BoxLayout.Y_AXIS);
		notiRegistro.setLayout(layoutNotireg);
		
		JTextArea mensaje = new JTextArea();
		mensaje.append(texto);
		mensaje.setEditable(false);
		mensaje.setLineWrap(true);
		mensaje.setBackground(null);
		notiRegistro.add(mensaje);
		
		
		AprobarRegistro = new JButton("Aprobar registro");
		AprobarRegistro.setActionCommand("botonAprobarRegistro");
		notiRegistro.add(AprobarRegistro);
		
		notiRegistro.setVisible(true);
		this.add(notiRegistro);
	}
	
	public void addNotificacionAprobarProyecto(String texto) {
		final JPanel notiProye = new JPanel();
		BoxLayout layoutNotiproye = new BoxLayout(notiProye, BoxLayout.Y_AXIS);
		notiProye.setLayout(layoutNotiproye);
		
		JTextArea mensaje = new JTextArea();
		mensaje.append(texto);
		mensaje.setEditable(false);
		mensaje.setLineWrap(true);
		mensaje.setBackground(null);
		notiProye.add(mensaje);
		
		AprobarProyecto = new JButton("Aprobar proyecto");
		AprobarProyecto.setActionCommand("botonAprobarProyecto");
		notiProye.add(AprobarProyecto);
		
		notiProye.setVisible(true);
		this.add(notiProye);
	}
	

	
	public void setControlNotificaciones(ActionListener c) {  
		IrProyecto.addActionListener(c);
		AprobarRegistro.addActionListener(c);
		AprobarProyecto.addActionListener(c);
	}
}