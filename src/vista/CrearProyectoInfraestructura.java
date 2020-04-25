package vista;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;


public class CrearProyectoInfraestructura extends JPanel {
	
	private JLabel labelNuevo;
	private JLabel labelExaminar;
	private JButton botonExaminar;
	private JLabel labelDistritos;
	private JButton botonCrear;
	
	
	public CrearProyectoInfraestructura() {
		SpringLayout cLayout = new SpringLayout();
		setLayout(cLayout);
		
		
		labelNuevo = new JLabel("Nuevo proyecto de infraestructura");
		
		labelExaminar = new JLabel("Inserte imagen ilustrativa del proyecto: ");
		botonExaminar = new JButton("Examinar archivo");
		
		
		JPanel panelExaminar = new JPanel();
		panelExaminar.add(botonExaminar);
		
		
		labelDistritos = new JLabel("Seleccione los distritos afectados:");
		JPanel panelBotones = new JPanel();
		
		int i =0;
		while(i<5) {
			String s = "Distrito " +i;
			JCheckBox distrito = new JCheckBox(s);
			panelBotones.add(distrito);
			i++;
		}
		JPanel panelProyecto = new JPanel(new GridLayout(2,2,2,2));
		panelProyecto.add(labelExaminar);
		panelProyecto.add(panelExaminar);
		panelProyecto.add(labelDistritos);
		panelProyecto.add(panelBotones);
		
		botonCrear = new JButton("Crear");

		cLayout.putConstraint(BorderLayout.NORTH, labelNuevo, 40, BorderLayout.NORTH, this);
		cLayout.putConstraint(BorderLayout.NORTH, panelProyecto, 15, BorderLayout.SOUTH, labelNuevo);
		cLayout.putConstraint(BorderLayout.NORTH, botonCrear, 15, BorderLayout.SOUTH, panelProyecto);


		
		add(labelNuevo);
		add(panelProyecto);
		add(botonCrear);

	}
	
	public void setControladorCrearProyectoInfraestructura(ActionListener c) {  
		botonCrear.addActionListener(c);
	}
	
}
