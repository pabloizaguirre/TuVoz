package vista;

import java.awt.*;

import javax.swing.*;


public class CrearProyectoInfraestructura {
	public static void main (String args[]) {
		JFrame window = new JFrame("Crear proyecto");
		
		Container container = window.getContentPane();
		container.setLayout(new FlowLayout());
		
		
		JButton botonHome = new JButton("Home");
		JTextField busqueda = new JTextField(15);
		JButton botonBusqueda = new JButton("Busqueda");
		JButton notificaciones = new JButton("Notificaciones");
		JButton miPerfil = new JButton("Mi Perfil");
		
		JLabel labelNuevo = new JLabel("Nuevo proyecto de infraestructura");
		
		JLabel labelExaminar = new JLabel("Inserte imagen ilustrativa del proyecto: ");
		JButton botonExaminar = new JButton("Examinar archivo");
		
		JLabel labelDistritos = new JLabel("Seleccione los distritos afectados:");
		JCheckBox distrito1 = new JCheckBox("Distrito1");
		JCheckBox distrito2 = new JCheckBox("Distrito2");
		JCheckBox distrito3 = new JCheckBox("Distrito3");
		JCheckBox distrito4 = new JCheckBox("Distrito4");
		
		JButton botonCrear = new JButton("Crear");



		
		
		
		
		
		container.add(botonHome);
		container.add(busqueda);
		container.add(botonBusqueda);
		container.add(notificaciones);
		container.add(miPerfil);
		container.add(labelNuevo);
		container.add(labelExaminar);
		container.add(botonExaminar);
		container.add(labelDistritos);
		container.add(distrito1);
		container.add(distrito2);
		container.add(distrito3);
		container.add(distrito4);
		container.add(botonCrear);
		
		
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setSize(800,400);
		window.setVisible(true);
	}
}
