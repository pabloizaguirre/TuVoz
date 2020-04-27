package vista;

import java.awt.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import modelo.Distrito;

public class CrearProyectoInfraestructura extends JPanel {
	
	private JLabel labelNuevo;
	private JLabel labelExaminar;
	private JButton botonExaminar;
	private JLabel labelDistritos;
	private JButton botonCrear;
	JCheckBox distrito1;
	JCheckBox distrito2;
	JCheckBox distrito3;
	
	
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

		distrito1 = new JCheckBox("Distrito1");
	 	distrito2 = new JCheckBox("Distrito2");
		distrito3 = new JCheckBox("Distrito3");

		panelBotones.add(distrito1);
		panelBotones.add(distrito2);
		panelBotones.add(distrito3);

		
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

	public void setControladorExaminar(ActionListener c) {
		botonExaminar.addActionListener(c);
	}

	public ArrayList<Distrito> getDistritos() {
		ArrayList<Distrito> distritos = new ArrayList<Distrito>();
		
		if(distrito1.isSelected()) distritos.add(Distrito.CENTRO);
		if(distrito2.isSelected()) distritos.add(Distrito.CHAMARTIN);
		if(distrito3.isSelected()) distritos.add(Distrito.RETIRO);
		return distritos;
	}
	
}
