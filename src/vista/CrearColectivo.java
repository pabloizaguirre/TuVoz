package vista;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;

import modelo.Colectivo;

public class CrearColectivo extends JPanel{
	
	private JTextField jtfNombre;
	private JButton botonCrear;
	private static JComboBox<String> comboColectivos;
	
	public CrearColectivo() {
		SpringLayout cLayout = new SpringLayout();
		setLayout(cLayout);
		
		JLabel labelNombre = new JLabel("  Introducir nombre del colectivo: ");
		jtfNombre = new JTextField(20);
		
		JPanel crearColectivo = new JPanel(new GridLayout(2,2,0,10));
		
		JLabel labelColectivo = new JLabel("  Selecciona para crear como subcolectivo de otro existente: ");
		comboColectivos = new JComboBox<String>();
		
		comboColectivos.addItem("No");
		

		
		crearColectivo.add(labelNombre);
		crearColectivo.add(jtfNombre);
		crearColectivo.add(labelColectivo);
		crearColectivo.add(comboColectivos);
		
		botonCrear = new JButton("Crear");
		JPanel panelBoton = new JPanel();
		panelBoton.add(botonCrear,BorderLayout.SOUTH);
		
		cLayout.putConstraint(BorderLayout.NORTH, crearColectivo, 30, BorderLayout.NORTH, this);
		cLayout.putConstraint(BorderLayout.NORTH, panelBoton, 70, BorderLayout.NORTH, crearColectivo);
		
		
		add(crearColectivo);
		add(panelBoton);
	}
	
	public void setControladorBotonCrear(ActionListener c) {  
		botonCrear.addActionListener(c);
	}
	
	public String getNombre() {
		return jtfNombre.getText();
	}
	public static void addColectivos(List<Colectivo> list) {
		comboColectivos.removeAllItems();
		comboColectivos.addItem("No");
		
		for(Colectivo c : list) {
			comboColectivos.addItem(c.getTitulo());
		}
	}
	public String getColectivos() {
		return (String)comboColectivos.getSelectedItem();
	}
	public void limpiarJtf() {
		jtfNombre.setText("");
		comboColectivos.setSelectedIndex(0);
	}

}
