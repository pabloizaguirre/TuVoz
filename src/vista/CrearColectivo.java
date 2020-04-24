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
		
		
		JPanel panelPrincipal = new JPanel(new GridLayout(3,1,0,10));
		
		panelPrincipal.add(new BarraSuperior());
		panelPrincipal.add(crearColectivo);
		panelPrincipal.add(panelBoton);
		
		add(panelPrincipal);
	}
}
