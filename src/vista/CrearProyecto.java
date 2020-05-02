package vista;


import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;


public class CrearProyecto extends JPanel {
	
	private JLabel labelNuevo;
	private JLabel labelNombre;
	private JTextField jtfNombre;
	private JLabel labelDescripcion;
	private JTextField jtfDescripcion;
	private JLabel labelPresupuesto;
	private JTextField jtfPresupuesto;
	private JLabel labelTipo;
	private JRadioButton opcioninfraestructura;
	private JRadioButton opcionsocial;
	private JButton botonSiguiente;
	
	public CrearProyecto() {
		
		SpringLayout cLayout = new SpringLayout();
		setLayout(cLayout);
		
		
		labelNuevo = new JLabel("Nuevo proyecto");
		
		JPanel panelNuevoProyecto = new JPanel();
		panelNuevoProyecto.add(labelNuevo);
		
		JPanel panelProyecto = new JPanel(new GridLayout(4,2));
		labelNombre = new JLabel(" Nombre del proyecto: ");
		jtfNombre = new JTextField(20);
		
		
		labelDescripcion = new JLabel(" Descripción del proyecto: ");
		jtfDescripcion = new JTextField(20);
		
		labelPresupuesto = new JLabel(" Presupuesto a solicitar: ");
		jtfPresupuesto = new JTextField(10);
		
		labelTipo = new JLabel(" Seleccione tipo de proyecto: ");
		ButtonGroup grupoBotones = new ButtonGroup();
		opcioninfraestructura = new JRadioButton("Infraestructura");
		opcionsocial = new JRadioButton("Social");
		grupoBotones.add(opcionsocial);
		grupoBotones.add(opcioninfraestructura);
		
		JPanel panelTipo = new JPanel();
		panelTipo.add(opcionsocial);
		panelTipo.add(opcioninfraestructura);
		
		panelProyecto.add(labelNombre);
		panelProyecto.add(jtfNombre);
		panelProyecto.add(labelDescripcion);
		panelProyecto.add(jtfDescripcion);
		panelProyecto.add(labelPresupuesto);
		panelProyecto.add(jtfPresupuesto);
		panelProyecto.add(labelTipo);
		panelProyecto.add(panelTipo);

		
		botonSiguiente = new JButton("Siguiente");
			
		cLayout.putConstraint(BorderLayout.NORTH, panelNuevoProyecto, 30, BorderLayout.NORTH, this);
		cLayout.putConstraint(BorderLayout.NORTH, panelProyecto, 8, BorderLayout.SOUTH, panelNuevoProyecto);
		cLayout.putConstraint(BorderLayout.NORTH, botonSiguiente, 8, BorderLayout.SOUTH, panelProyecto);
		
		this.add(panelNuevoProyecto);
		this.add(panelProyecto);
		this.add(botonSiguiente);
		}
	
	public void setControladorCrearProyecto(ActionListener c) {  
		botonSiguiente.addActionListener(c);
	}

	public String getTipoProyecto() {
		if(opcioninfraestructura.isSelected()) {
			return "infraestructura";
		}
		if(opcionsocial.isSelected()) {
			return "social";
		}
		return null;
	}

	public String getNombre() {
		return jtfNombre.getText();
	}
	public String getDescripcion() {
		return jtfDescripcion.getText();
	}
	public double getPresupuesto() {
		if(jtfPresupuesto.getText().equals("")) return -1.0;
		return Double.parseDouble(jtfPresupuesto.getText());
	}
}
