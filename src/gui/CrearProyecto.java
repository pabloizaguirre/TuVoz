package gui;


import java.awt.*;

import javax.swing.*;


public class CrearProyecto {
	public static void main (String args[]) {
		JFrame window = new JFrame("Crear proyecto");
		
		Container container = window.getContentPane();
		container.setLayout(new FlowLayout());
		
		
		container.add(new BarraSuperior());
		JLabel labelNuevo = new JLabel("Nuevo proyecto");
		
		JLabel labelNombre = new JLabel("Nombre del proyecto: ");
		JTextField jtfNombre = new JTextField(20);
		
		
		JLabel labelDecripcion = new JLabel("Descripción del proyecto: ");
		JTextField jtfDescripcion = new JTextField(40);
		
		JLabel labelPresupuesto = new JLabel("Presupuesto a solicitar: ");
		JTextField jtfPresupuesto = new JTextField(10);
		
		JLabel labelTipo = new JLabel("Seleccione tipo de proyecto: ");
		ButtonGroup grupoBotones = new ButtonGroup();
		JRadioButton infraestructura = new JRadioButton("Infraestructura");
		JRadioButton social = new JRadioButton("Social");
		grupoBotones.add(social);
		grupoBotones.add(infraestructura);
		JButton botonSiguiente = new JButton("Siguiente");

	
		container.add(labelNuevo);
		container.add(labelNombre);
		container.add(jtfNombre);
		container.add(labelDecripcion);
		container.add(jtfDescripcion);
		container.add(labelPresupuesto);
		container.add(jtfPresupuesto);
		container.add(labelTipo);
		container.add(infraestructura);
		container.add(social);
		container.add(botonSiguiente);
		
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setSize(800,400);
		window.setVisible(true);
		
		}
}
