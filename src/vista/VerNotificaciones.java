package vista;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import modelo.Notificacion;

public class VerNotificaciones extends JPanel{
	
	private JButton IrProyecto = new JButton("a");
	private JButton AprobarRegistro = new JButton("b");
	private JButton AprobarProyecto = new JButton("c");
	private JButton RechazarRegistro = new JButton("d");
	private JButton RechazarProyecto = new JButton("e");
	private JButton VerRegistro = new JButton("f");
	private JButton VerProyecto = new JButton("g");
	
	
	public VerNotificaciones(){
		BoxLayout notiLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		this.setLayout(notiLayout);
		JLabel intro = new JLabel ("Notificaciones");
		intro.setFont(new Font(intro.getFont().getName(), Font.PLAIN, intro.getFont().getSize()+20));
		
		this.add(intro);
		this.add(Box.createRigidArea(new Dimension(0, 40)));
		
		
    }
    
	public void addNotificacionCiudadanoProyecto(String texto) {
		final JPanel notiCiudadano = new JPanel();
		BoxLayout layoutNoticiu = new BoxLayout(notiCiudadano, BoxLayout.PAGE_AXIS);
		notiCiudadano.setAlignmentX(LEFT_ALIGNMENT);
		notiCiudadano.setLayout(layoutNoticiu);
		
		
		JTextArea mensaje = new JTextArea();
		mensaje.append(texto);
		mensaje.setEditable(false);
		mensaje.setLineWrap(true);
		mensaje.setBackground(null);
		mensaje.setAlignmentX(LEFT_ALIGNMENT);
		notiCiudadano.add(mensaje);
		
		IrProyecto = new JButton("Ir al proyecto");
		IrProyecto.setActionCommand("botonIrProyecto");
		IrProyecto.setAlignmentX(LEFT_ALIGNMENT);
		notiCiudadano.add(IrProyecto);
		
		notiCiudadano.add(Box.createRigidArea(new Dimension(0, 20)));
		
		notiCiudadano.setVisible(true);
		this.add(notiCiudadano);
		}
	
	public void addNotificacionAprobarRegistro(String texto) {
		final JPanel notiRegistro = new JPanel();
		BoxLayout layoutNotireg = new BoxLayout(notiRegistro, BoxLayout.PAGE_AXIS);
		notiRegistro.setLayout(layoutNotireg);
		
		JTextArea mensaje = new JTextArea();
		mensaje.append(texto);
		mensaje.setEditable(false);
		mensaje.setLineWrap(true);
		mensaje.setBackground(null);
		mensaje.setAlignmentX(LEFT_ALIGNMENT);
		notiRegistro.add(mensaje);
		
		VerRegistro = new JButton("Ver registro");
		VerRegistro.setActionCommand("botonVerRegistro");
		VerRegistro.setAlignmentX(Component.LEFT_ALIGNMENT);
		notiRegistro.add(VerRegistro);
		
		AprobarRegistro = new JButton("Aprobar registro");
		AprobarRegistro.setActionCommand("botonAprobarRegistro");
		AprobarRegistro.setAlignmentX(Component.LEFT_ALIGNMENT);
		notiRegistro.add(AprobarRegistro);
		
		RechazarRegistro = new JButton("Rechazar registro");
		RechazarRegistro.setActionCommand("botonRechazarRegistro");
		RechazarRegistro.setAlignmentX(Component.LEFT_ALIGNMENT);
		notiRegistro.add(RechazarRegistro);
		
		notiRegistro.add(Box.createRigidArea(new Dimension(0, 20)));
		
		notiRegistro.setVisible(true);
		this.add(notiRegistro);
	}
	
	public void addNotificacionAprobarProyecto(String texto) {
		final JPanel notiProye = new JPanel();
		BoxLayout layoutNotiproye = new BoxLayout(notiProye, BoxLayout.PAGE_AXIS);
		notiProye.setLayout(layoutNotiproye);
		
		JTextArea mensaje = new JTextArea();
		mensaje.append(texto);
		mensaje.setEditable(false);
		mensaje.setLineWrap(true);
		mensaje.setBackground(null);
		mensaje.setAlignmentX(LEFT_ALIGNMENT);
		notiProye.add(mensaje);
		
		VerProyecto = new JButton("Ver proyecto");
		VerProyecto.setActionCommand("botonVerProyecto");
		VerProyecto.setAlignmentX(LEFT_ALIGNMENT);
		notiProye.add(VerProyecto);
		
		AprobarProyecto = new JButton("Aprobar proyecto");
		AprobarProyecto.setActionCommand("botonAprobarProyecto");
		AprobarProyecto.setAlignmentX(LEFT_ALIGNMENT);
		notiProye.add(AprobarProyecto);
		
		RechazarProyecto = new JButton("Rechazar proyecto");
		RechazarProyecto.setActionCommand("botonRechazarProyecto");
		RechazarProyecto.setAlignmentX(LEFT_ALIGNMENT);
		notiProye.add(RechazarProyecto);
		
		notiProye.add(Box.createRigidArea(new Dimension(0, 20)));
		
		notiProye.setVisible(true);
		this.add(notiProye);
	}
	

	
	public void setControlNotificaciones(ActionListener c) {  
		IrProyecto.addActionListener(c);
		AprobarRegistro.addActionListener(c);
		AprobarProyecto.addActionListener(c);
		RechazarRegistro.addActionListener(c);
		RechazarProyecto.addActionListener(c);
		VerRegistro.addActionListener(c);
		VerProyecto.addActionListener(c);
	}
}