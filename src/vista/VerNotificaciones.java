package vista;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import modelo.Notificacion;
/**
 * Clase de la vista Ver Notificaciones.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class VerNotificaciones extends JPanel{
	
	private static int id=0;
	private HashMap<Integer, JPanel> listaNotificaciones = new HashMap<Integer, JPanel>();
	
	public VerNotificaciones(){
		BoxLayout notiLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		this.setLayout(notiLayout);
		
		JLabel intro = new JLabel ("Notificaciones");
		intro.setFont(new Font(intro.getFont().getName(), Font.PLAIN, intro.getFont().getSize()+20));
		intro.setAlignmentX(LEFT_ALIGNMENT);
		this.add(intro);
		this.add(Box.createRigidArea(new Dimension(0, 40)));
		this.add(Box.createHorizontalStrut(40));
		
    }
    
	public void addNotificacionCiudadanoProyecto(String texto, JButton boton) {
		final JPanel notiCiudadano = new JPanel();
		BoxLayout layoutNoticiu = new BoxLayout(notiCiudadano, BoxLayout.PAGE_AXIS);
		notiCiudadano.setLayout(layoutNoticiu);
		
		
		JTextArea mensaje = new JTextArea();
		mensaje.append(texto);
		mensaje.setEditable(false);
		mensaje.setLineWrap(true);
		mensaje.setBackground(null);
		mensaje.setAlignmentX(LEFT_ALIGNMENT);
		notiCiudadano.add(mensaje);
		
		JButton IrProyecto = boton;
		IrProyecto.setActionCommand(String.valueOf(id));
		IrProyecto.setAlignmentX(LEFT_ALIGNMENT);
		notiCiudadano.add(IrProyecto);
		
		notiCiudadano.setAlignmentX(LEFT_ALIGNMENT);
		notiCiudadano.add(Box.createRigidArea(new Dimension(0, 20)));	
		
		notiCiudadano.setVisible(true);
		this.add(notiCiudadano);
		
		listaNotificaciones.put(id, notiCiudadano);
		id+=1;
		}
	
	public void addNotificacionAprobarRegistro(String texto, JButton aprobar, JButton rechazar) {
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
		
		final JPanel botonesnotiRegistro = new JPanel();
		BoxLayout layoutbotonesNotireg = new BoxLayout(botonesnotiRegistro, BoxLayout.X_AXIS);
		botonesnotiRegistro.setLayout(layoutbotonesNotireg);
			
		JButton AprobarRegistro = aprobar;
		AprobarRegistro.setActionCommand(String.valueOf(id));
		botonesnotiRegistro.add(AprobarRegistro);
		
		JButton RechazarRegistro = rechazar;
		RechazarRegistro.setActionCommand(String.valueOf(id));
		botonesnotiRegistro.add(RechazarRegistro);
		
		botonesnotiRegistro.setAlignmentX(Component.LEFT_ALIGNMENT);
		notiRegistro.add(botonesnotiRegistro);
		
		notiRegistro.setAlignmentX(Component.LEFT_ALIGNMENT);
		notiRegistro.add(Box.createRigidArea(new Dimension(0, 20)));
		
		notiRegistro.setVisible(true);
		this.add(notiRegistro);
		
		listaNotificaciones.put(id, notiRegistro);
		id+=1;
	}
	
	public void addNotificacionAprobarProyecto(String texto, JButton ver, JButton aprobar, JButton rechazar) {
		final JPanel notiProye = new JPanel();
		BoxLayout layoutNotiproye = new BoxLayout(notiProye, BoxLayout.PAGE_AXIS);
		notiProye.setLayout(layoutNotiproye);
		
		JTextArea mensaje = new JTextArea();
		mensaje.append(texto);
		mensaje.setEditable(false);
		mensaje.setLineWrap(true);
		mensaje.setBackground(null);
		mensaje.setAlignmentX(Component.LEFT_ALIGNMENT);
		notiProye.add(mensaje);
		
		final JPanel botonesnotiProye = new JPanel();
		BoxLayout layoutbotonesNotiproye = new BoxLayout(botonesnotiProye, BoxLayout.X_AXIS);
		botonesnotiProye.setLayout(layoutbotonesNotiproye);
		
		JButton AprobarProyecto = new JButton("Aprobar proyecto");
		AprobarProyecto.setActionCommand(String.valueOf(id));
		botonesnotiProye.add(AprobarProyecto);
		
		JButton RechazarProyecto = new JButton("Rechazar proyecto");
		RechazarProyecto.setActionCommand(String.valueOf(id));
		botonesnotiProye.add(RechazarProyecto);
		
		JButton VerProyecto = new JButton("Ver proyecto");
		VerProyecto.setActionCommand(String.valueOf(id));
		botonesnotiProye.add(VerProyecto);
		
		botonesnotiProye.setAlignmentX(Component.LEFT_ALIGNMENT);
		notiProye.add(botonesnotiProye);
		
		notiProye.setAlignmentX(Component.LEFT_ALIGNMENT);
		notiProye.add(Box.createRigidArea(new Dimension(0, 20)));
		
		notiProye.setVisible(true);
		this.add(notiProye);
		
		listaNotificaciones.put(id, notiProye);
		id+=1;
	}
	
	
	/**
     * Metodo para borrar notificaciones de la vista
     * 
     */
	public void borrarNotificacion(int id) {
		this.remove(listaNotificaciones.get(id));
		listaNotificaciones.remove(id);
	}
	
	
	public void resetNoti() {
		for (int i = 0; i < id; ++i) {
			listaNotificaciones.remove(id);
		}
		id=0; 
	
		}
	
	
	
	
}
