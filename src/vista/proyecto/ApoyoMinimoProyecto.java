package vista.proyecto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.proyecto.ControlApoyoMinimoProyecto;

/**
 * Clase de la vista ApoyoMinimoProyecto.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class ApoyoMinimoProyecto extends JPanel {
	private JLabel labelTitulo;
	private JTextField jtfEntrada;
	private JButton botonAceptar;
	
	public ApoyoMinimoProyecto() {
		SpringLayout cLayout = new SpringLayout();
		setLayout(cLayout);
		
		labelTitulo = new JLabel("Introduce el nuevo numero de apoyos minimos para los proyectos");
		jtfEntrada = new JTextField(5);
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setActionCommand("aceptar");
		
		cLayout.putConstraint(BorderLayout.WEST, labelTitulo, 40, BorderLayout.WEST, this);
		cLayout.putConstraint(BorderLayout.NORTH, labelTitulo, 40, BorderLayout.NORTH, this);
		cLayout.putConstraint(BorderLayout.WEST, jtfEntrada, 40, BorderLayout.WEST, this);
		cLayout.putConstraint(BorderLayout.NORTH, jtfEntrada, 15, BorderLayout.SOUTH, labelTitulo);
		cLayout.putConstraint(BorderLayout.NORTH, botonAceptar, 15, BorderLayout.SOUTH, labelTitulo);
		cLayout.putConstraint(BorderLayout.WEST, botonAceptar, 20, BorderLayout.EAST, jtfEntrada);
		
		add(labelTitulo);
		add(jtfEntrada);
		add(botonAceptar);
	}
	
	public String getEntrada() {
		return jtfEntrada.getText();
	}
	
	public void setControlApoyoProyecto(ActionListener c) {  
		botonAceptar.addActionListener(c);
	}

}
