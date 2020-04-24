package gui;

import java.awt.*;

import javax.swing.*;


public class CrearProyectoInfraestructura {
	public static void main (String args[]) {
		JFrame ventana = new JFrame("Crear proyecto");
		
		Container contenedor = ventana.getContentPane();
		SpringLayout cLayout = new SpringLayout();
		contenedor.setLayout(cLayout);
		
		
		JPanel barra = new BarraSuperior();
		barra.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel labelNuevo = new JLabel("Nuevo proyecto de infraestructura");
		
		JLabel labelExaminar = new JLabel("Inserte imagen ilustrativa del proyecto: ");
		JButton botonExaminar = new JButton("Examinar archivo");
		
		
		JPanel panelExaminar = new JPanel();
		panelExaminar.add(botonExaminar);
		
		
		
		JLabel labelDistritos = new JLabel("Seleccione los distritos afectados:");
		JCheckBox distrito1 = new JCheckBox("Distrito1");
		JCheckBox distrito2 = new JCheckBox("Distrito2");
		JCheckBox distrito3 = new JCheckBox("Distrito3");
		JCheckBox distrito4 = new JCheckBox("Distrito4");
		JPanel panelBotones = new JPanel();
		
		int i =0;
		while(i<5) {
			String s = "Distrito " +i;
			JCheckBox distrito = new JCheckBox(s);
			panelBotones.add(distrito);
			i++;
		}
		JPanel panelProyecto = new JPanel(new GridLayout(2,2));
		panelProyecto.add(labelExaminar);
		panelProyecto.add(panelExaminar);
		panelProyecto.add(labelDistritos);
		panelProyecto.add(panelBotones);
		JButton botonCrear = new JButton("Crear");

		JPanel panelCrear = new JPanel(new BorderLayout());
		
		panelCrear.add(barra, BorderLayout.NORTH);
		panelCrear.add(labelNuevo, BorderLayout.WEST);
		panelCrear.add(panelProyecto, BorderLayout.SOUTH);
		
		
		contenedor.add(panelCrear);
		
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.setSize(800,400);
		ventana.setVisible(true);
	}
}
