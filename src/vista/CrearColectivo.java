package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CrearColectivo extends JPanel{
	
	private JTextField jtfNombre;
	private JButton botonCrear;
	
	public CrearColectivo() {
		SpringLayout cLayout = new SpringLayout();
		setLayout(cLayout);
		
		JLabel labelNombre = new JLabel("  Introducir nombre del colectivo: ");
		jtfNombre = new JTextField(20);
		
		JPanel crearColectivo = new JPanel(new GridLayout(1,2,0,10));
		
		crearColectivo.add(labelNombre);
		crearColectivo.add(jtfNombre);
		
		
		botonCrear = new JButton("Crear");
		JPanel panelBoton = new JPanel();
		panelBoton.add(botonCrear,BorderLayout.SOUTH);
		
		
		cLayout.putConstraint(BorderLayout.NORTH, BarraSuperior.getBarraSuperior(), 0, BorderLayout.NORTH, this);
		cLayout.putConstraint(BorderLayout.NORTH, crearColectivo, 30, BorderLayout.NORTH, this);
		cLayout.putConstraint(BorderLayout.NORTH, panelBoton, 20, BorderLayout.NORTH, crearColectivo);
		
		
		add(BarraSuperior.getBarraSuperior());
		add(crearColectivo);
		add(panelBoton);
	
	}
}
