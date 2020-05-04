package vista;


import java.awt.BorderLayout;
import java.awt.Color;
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
	private JLabel intro = new JLabel ("Notificaciones");
	private JPanel panelNotificaciones;
	
	public VerNotificaciones(){
		SpringLayout nLayout = new SpringLayout();
		this.setLayout(nLayout);
		panelNotificaciones = new JPanel();
		BoxLayout notiLayout = new BoxLayout(panelNotificaciones, BoxLayout.PAGE_AXIS);
		panelNotificaciones.setLayout(notiLayout);
		//panelNotificaciones.setPreferredSize(new Dimension(400,400));
		this.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		
		JScrollPane scroll = new JScrollPane(panelNotificaciones);
		scroll.setBorder(null);
		
		intro.setFont(new Font(intro.getFont().getName(), Font.PLAIN, intro.getFont().getSize()+20));
		
		nLayout.putConstraint(BorderLayout.NORTH, scroll, 20, BorderLayout.SOUTH, intro);
		nLayout.putConstraint(BorderLayout.SOUTH, scroll, -20, BorderLayout.SOUTH, this);
		nLayout.putConstraint(BorderLayout.WEST, scroll, 0, BorderLayout.WEST, this);
		nLayout.putConstraint(BorderLayout.EAST, scroll, 0, BorderLayout.EAST, this);
		
		this.add(intro);
		this.add(scroll);
    }
    
	public void addNotificacionCiudadanoProyecto(String texto, JButton boton) {
		final JPanel notiCiudadano = new JPanel();
		notiCiudadano.setBorder(BorderFactory.createMatteBorder(0, 0, 20, 0, intro.getBackground()));
		notiCiudadano.setBackground(Color.white);
		notiCiudadano.setSize(new Dimension(400,100));
		notiCiudadano.setMaximumSize(new Dimension(1000,100));
		notiCiudadano.setMinimumSize(new Dimension(100,100));
		
		BoxLayout layoutNoticiu = new BoxLayout(notiCiudadano, BoxLayout.PAGE_AXIS);
		notiCiudadano.setLayout(layoutNoticiu);
		
		
		JTextArea mensaje = new JTextArea();
		mensaje.append(texto);
		
		mensaje.setEditable(false);
		mensaje.setPreferredSize(new Dimension(400, 50));
		mensaje.setLineWrap(true);
		mensaje.setBackground(null);
		mensaje.setAlignmentX(LEFT_ALIGNMENT);
		notiCiudadano.add(mensaje);
		
		JButton IrProyecto = boton;
		IrProyecto.setActionCommand(String.valueOf(id));
		IrProyecto.setAlignmentX(LEFT_ALIGNMENT);
		notiCiudadano.add(IrProyecto);
		
		notiCiudadano.setAlignmentX(LEFT_ALIGNMENT);
		
		notiCiudadano.setVisible(true);
		panelNotificaciones.add(notiCiudadano);
		
		listaNotificaciones.put(id, notiCiudadano);
		id+=1;
		}
	
	public void addNotificacionAprobarRegistro(String texto, JButton aprobar, JButton rechazar) {
		final JPanel notiRegistro = new JPanel();
		notiRegistro.setBorder(BorderFactory.createMatteBorder(0, 0, 20, 0, intro.getBackground()));
		notiRegistro.setBackground(Color.white);
		notiRegistro.setSize(new Dimension(400,100));
		notiRegistro.setMaximumSize(new Dimension(1000,100));
		notiRegistro.setMinimumSize(new Dimension(100,100));
		
		BoxLayout layoutNotireg = new BoxLayout(notiRegistro, BoxLayout.PAGE_AXIS);
		notiRegistro.setLayout(layoutNotireg);
		
		JTextArea mensaje = new JTextArea();
		mensaje.append(texto);
		mensaje.setEditable(false);
		mensaje.setPreferredSize(new Dimension(400, 50));
		mensaje.setLineWrap(true);
		mensaje.setBackground(null);
		mensaje.setAlignmentX(LEFT_ALIGNMENT);
		notiRegistro.add(mensaje);
		
		final JPanel botonesnotiRegistro = new JPanel();
		botonesnotiRegistro.setBackground(Color.white);
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
		
		notiRegistro.setVisible(true);
		panelNotificaciones.add(notiRegistro);
		
		listaNotificaciones.put(id, notiRegistro);
		id+=1;
	}
	
	public void addNotificacionAprobarProyecto(String texto, JButton ver, JButton aprobar, JButton rechazar) {
		final JPanel notiProye = new JPanel();
		notiProye.setBorder(BorderFactory.createMatteBorder(0, 0, 20, 0, intro.getBackground()));
		notiProye.setBackground(Color.white);
		notiProye.setSize(new Dimension(400,100));
		notiProye.setMaximumSize(new Dimension(1000,100));
		notiProye.setMinimumSize(new Dimension(100,100));
		
		BoxLayout layoutNotiproye = new BoxLayout(notiProye, BoxLayout.PAGE_AXIS);
		notiProye.setLayout(layoutNotiproye);
		
		JTextArea mensaje = new JTextArea();
		mensaje.setText(texto);
		mensaje.setPreferredSize(new Dimension(400, 50));
		mensaje.setEditable(false);
		mensaje.setLineWrap(true);
		mensaje.setBackground(null);
		mensaje.setAlignmentX(LEFT_ALIGNMENT);
		
		notiProye.add(mensaje);
		
		final JPanel botonesnotiProye = new JPanel();
		BoxLayout layoutbotonesNotiproye = new BoxLayout(botonesnotiProye, BoxLayout.X_AXIS);
		botonesnotiProye.setLayout(layoutbotonesNotiproye);
		botonesnotiProye.setBackground(Color.white);
		
		JButton AprobarProyecto = aprobar;
		AprobarProyecto.setActionCommand(String.valueOf(id));
		botonesnotiProye.add(AprobarProyecto);
		
		JButton RechazarProyecto = rechazar;
		RechazarProyecto.setActionCommand(String.valueOf(id));
		botonesnotiProye.add(RechazarProyecto);
		
		JButton VerProyecto = ver;
		VerProyecto.setActionCommand(String.valueOf(id));
		botonesnotiProye.add(VerProyecto);
		
		botonesnotiProye.setAlignmentX(Component.LEFT_ALIGNMENT);
		notiProye.add(botonesnotiProye);
		
		notiProye.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		notiProye.setVisible(true);
		panelNotificaciones.add(notiProye);
		
		listaNotificaciones.put(id, notiProye);
		id+=1;
	}
	
	
	/**
     * Metodo para borrar notificaciones de la vista
     * 
     */
	public void borrarNotificacion(int id) {
		JPanel panel = listaNotificaciones.get(id);
		panel.setVisible(false);
		panelNotificaciones.remove(panel);
		listaNotificaciones.remove(id);
		this.validate();
	}
	
	/**
     * Metodo para vaciar la vista dejando solo el titulo
     * 
     */
	public void resetNoti() {
		panelNotificaciones.removeAll();
		
		listaNotificaciones = new HashMap<Integer, JPanel>();
		id=0; 
	
	}
	
	
	
	
}
