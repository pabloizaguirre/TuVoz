package vista;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
/**
 * Clase de la vista Mi Perfil.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class MiPerfilAdmin extends JPanel{
	
	private JButton cerrarSesion;
	private JButton botonReset;
	private JButton botonBloquear;
	private JButton botonDesbloquear;
	private JLabel titulo;
	
	private JTextField jtfUsuario;
	
	
	public MiPerfilAdmin() {
		SpringLayout cLayout = new SpringLayout();
		setLayout(cLayout);
		
		//Titulo de la ventana: HOME
		titulo = new JLabel("Mi Perfil");
		titulo.setFont(new Font(titulo.getFont().getName(), Font.PLAIN, titulo.getFont().getSize()+20));
		cLayout.putConstraint(BorderLayout.WEST, titulo, 20, BorderLayout.WEST, this);
		add(titulo);
		
		cerrarSesion = new JButton("Cerrar sesion");
		cLayout.putConstraint(BorderLayout.EAST, cerrarSesion, -40, BorderLayout.EAST, this);
		cerrarSesion.setActionCommand("cerrarSesion");
		add(cerrarSesion);
		
		botonReset = new JButton("Resetear aplicacion");
		cLayout.putConstraint(BorderLayout.EAST, botonReset, -5, BorderLayout.WEST, cerrarSesion);
		botonReset.setActionCommand("reset");
		add(botonReset);
		
		JLabel labelBloquear = new JLabel("Introduce el nombre del usuario o DNI para bloquear/desbloquear");
		jtfUsuario = new JTextField(20);
		
		botonBloquear = new JButton("Bloquear");
		botonBloquear.setActionCommand("bloquear");
		
		botonDesbloquear = new JButton("Desbloquear");
		botonDesbloquear.setActionCommand("desbloquear");
		
		cLayout.putConstraint(BorderLayout.WEST, labelBloquear, 40, BorderLayout.WEST, this);
		cLayout.putConstraint(BorderLayout.NORTH, labelBloquear, 40, BorderLayout.NORTH, this);

		cLayout.putConstraint(BorderLayout.WEST, jtfUsuario, 40, BorderLayout.WEST, this);
		cLayout.putConstraint(BorderLayout.NORTH, jtfUsuario, 10, BorderLayout.SOUTH, labelBloquear);
		
		cLayout.putConstraint(BorderLayout.WEST, botonBloquear, 40, BorderLayout.WEST, this);
		cLayout.putConstraint(BorderLayout.NORTH, botonBloquear, 10, BorderLayout.SOUTH, jtfUsuario);

		cLayout.putConstraint(BorderLayout.WEST, botonDesbloquear, 10, BorderLayout.EAST, botonBloquear);
		cLayout.putConstraint(BorderLayout.NORTH, botonDesbloquear, 10, BorderLayout.SOUTH, jtfUsuario);

		add(labelBloquear);
		add(jtfUsuario);
		add(botonBloquear);
		add(botonDesbloquear);

		
	}
	
	public void setControlador(ActionListener c) {
		cerrarSesion.addActionListener(c);
		botonReset.addActionListener(c);
		botonBloquear.addActionListener(c);
		botonDesbloquear.addActionListener(c);
	}
	
	public String getUsuario() {
		return jtfUsuario.getText();
	}
	
	public void limpiarJtf() {
		jtfUsuario.setText("");
	}
}