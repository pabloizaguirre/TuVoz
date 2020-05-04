package vista;


import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Clase de la vista CrearProyecto.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class CrearProyecto extends JPanel {
	
	private JLabel labelNuevo;
	private JLabel labelNombre;
	private JTextField jtfNombre;
	private JLabel labelDescripcion;
	private JTextArea jtfDescripcion;
	private JLabel labelPresupuesto;
	private JTextField jtfPresupuesto;
	private JLabel labelTipo;
	private JRadioButton opcioninfraestructura;
	private JRadioButton opcionsocial;
	private JButton botonSiguiente;
	private ButtonGroup grupoBotones;
	
	public CrearProyecto() {
		
		SpringLayout cLayout = new SpringLayout();
		setLayout(cLayout);
		
		this.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		
		labelNuevo = new JLabel("Nuevo proyecto");
		labelNuevo.setFont(new Font(labelNuevo.getFont().getName(), Font.PLAIN, labelNuevo.getFont().getSize()+20));
		
		SpringLayout pLayout = new SpringLayout();
		JPanel panelProyecto = new JPanel(pLayout);
		
		labelNombre = new JLabel(" Nombre del proyecto (25 caracteres): ");
		jtfNombre = new JTextField(17);
		
		labelDescripcion = new JLabel(" Descripcion del proyecto (500 caracteres): ");
		jtfDescripcion = new JTextArea();
		jtfDescripcion.setPreferredSize(new Dimension(200,100));
		jtfDescripcion.setBorder(jtfNombre.getBorder());
		jtfDescripcion.setLineWrap(true);
		jtfDescripcion.setWrapStyleWord(true);
		
		labelPresupuesto = new JLabel(" Presupuesto a solicitar: ");
		jtfPresupuesto = new JTextField(10);
		
		labelTipo = new JLabel(" Seleccione tipo de proyecto: ");
		grupoBotones = new ButtonGroup();
		opcioninfraestructura = new JRadioButton("Infraestructura");
		opcionsocial = new JRadioButton("Social");
		grupoBotones.add(opcionsocial);
		grupoBotones.add(opcioninfraestructura);
		
		JPanel panelTipo = new JPanel();
		panelTipo.add(opcionsocial);
		panelTipo.add(opcioninfraestructura);
		
		pLayout.putConstraint(BorderLayout.WEST, labelNombre, 20, BorderLayout.WEST, panelProyecto);
		pLayout.putConstraint(BorderLayout.EAST, jtfNombre, -20, BorderLayout.EAST, panelProyecto);
		
		pLayout.putConstraint(BorderLayout.WEST, labelDescripcion, 20, BorderLayout.WEST, panelProyecto);
		pLayout.putConstraint(BorderLayout.NORTH, labelDescripcion, 5, BorderLayout.SOUTH, jtfNombre);
		pLayout.putConstraint(BorderLayout.WEST, jtfDescripcion, 20, BorderLayout.EAST, labelDescripcion);
		pLayout.putConstraint(BorderLayout.NORTH, jtfDescripcion, 5, BorderLayout.SOUTH, jtfNombre);
		pLayout.putConstraint(BorderLayout.EAST, jtfDescripcion, -22, BorderLayout.EAST, panelProyecto);
		
		pLayout.putConstraint(BorderLayout.WEST, labelPresupuesto, 20, BorderLayout.WEST, panelProyecto);
		pLayout.putConstraint(BorderLayout.NORTH, labelPresupuesto, 10, BorderLayout.SOUTH, jtfDescripcion);
		pLayout.putConstraint(BorderLayout.EAST, jtfPresupuesto, -20, BorderLayout.EAST, panelProyecto);
		pLayout.putConstraint(BorderLayout.NORTH, jtfPresupuesto, 5, BorderLayout.SOUTH, jtfDescripcion);
		
		pLayout.putConstraint(BorderLayout.WEST, labelTipo, 20, BorderLayout.WEST, panelProyecto);
		pLayout.putConstraint(BorderLayout.NORTH, labelTipo, 5, BorderLayout.NORTH, panelTipo);
		pLayout.putConstraint(BorderLayout.EAST, panelTipo, -20, BorderLayout.EAST, panelProyecto);
		pLayout.putConstraint(BorderLayout.NORTH, panelTipo, 5, BorderLayout.SOUTH, jtfPresupuesto);
		
		
		panelProyecto.add(labelNombre);
		panelProyecto.add(jtfNombre);
		panelProyecto.add(labelDescripcion);
		panelProyecto.add(jtfDescripcion);
		panelProyecto.add(labelPresupuesto);
		panelProyecto.add(jtfPresupuesto);
		panelProyecto.add(labelTipo);
		panelProyecto.add(panelTipo);

		
		botonSiguiente = new JButton("Siguiente");
		
		cLayout.putConstraint(BorderLayout.NORTH, labelNuevo, 0, BorderLayout.NORTH, this);
		cLayout.putConstraint(BorderLayout.NORTH, panelProyecto, 8, BorderLayout.SOUTH, labelNuevo);
		cLayout.putConstraint(BorderLayout.EAST, panelProyecto, 0, BorderLayout.EAST, this);
		cLayout.putConstraint(BorderLayout.WEST, panelProyecto, 0, BorderLayout.WEST, this);
		cLayout.putConstraint(BorderLayout.SOUTH, panelProyecto, 200, BorderLayout.NORTH, panelProyecto);
		cLayout.putConstraint(BorderLayout.NORTH, botonSiguiente, 8, BorderLayout.SOUTH, panelProyecto);
		cLayout.putConstraint(BorderLayout.EAST, botonSiguiente, -20, BorderLayout.EAST, this);
		
		this.add(labelNuevo);	
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
	
	 /**
     * Metodo para limpiar los distintos campos de creación de proyecto
     * 
     */
	public void limpiarJtf() {
		jtfNombre.setText("");
		jtfDescripcion.setText("");
		jtfPresupuesto.setText("");
		grupoBotones.clearSelection();
		
	}

}
