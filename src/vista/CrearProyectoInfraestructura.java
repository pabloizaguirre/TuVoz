package vista;

import java.awt.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import modelo.*;
/**
 * Clase de la vista CrearProyectoInfraestructura.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class CrearProyectoInfraestructura extends JPanel {
	
	private JLabel labelNuevo;
	private JLabel labelExaminar;
	private JButton botonExaminar;
	private JLabel labelDistritos;
	private JLabel labelColectivos;
	private static JComboBox<String> comboColectivos;
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
		botonExaminar.setActionCommand("examinar");
		
		
		JPanel panelExaminar = new JPanel();
		panelExaminar.add(botonExaminar);
		
		
		
		labelDistritos = new JLabel("Seleccione los distritos afectados:");
		JPanel panelBotones = new JPanel();
		


		distrito1 = new JCheckBox("Distrito1");
	 	distrito2 = new JCheckBox("Distrito2");
		distrito3 = new JCheckBox("Distrito3");


		panelBotones.add(distrito1);
		panelBotones.add(distrito2);
		panelBotones.add(distrito3);
		
		
		labelColectivos = new JLabel("Selecciona para crear proyecto de colectivo");
		comboColectivos = new JComboBox<String>();
		
		comboColectivos.addItem("No");
	
		
		JPanel panelProyecto = new JPanel(new GridLayout(3,2,2,2));
		panelProyecto.add(labelExaminar);
		panelProyecto.add(panelExaminar);
		panelProyecto.add(labelDistritos);
		panelProyecto.add(panelBotones);
		panelProyecto.add(labelColectivos);
		panelProyecto.add(comboColectivos);
		
		botonCrear = new JButton("Crear");
		botonCrear.setActionCommand("crear");

		cLayout.putConstraint(SpringLayout.NORTH, labelNuevo, 40, SpringLayout.NORTH, this);
		cLayout.putConstraint(SpringLayout.WEST, labelNuevo, 40, SpringLayout.WEST, this);
		cLayout.putConstraint(SpringLayout.NORTH, panelProyecto, 15, SpringLayout.SOUTH, labelNuevo);
		cLayout.putConstraint(SpringLayout.WEST, panelProyecto, 40, SpringLayout.WEST, this);
		cLayout.putConstraint(SpringLayout.WEST, botonCrear, 40, SpringLayout.WEST, this);
		cLayout.putConstraint(SpringLayout.NORTH, botonCrear, 15, SpringLayout.SOUTH, panelProyecto);


		
		add(labelNuevo);
		add(panelProyecto);
		add(botonCrear);

	}
	
	public void setControladorCrearProyectoInfraestructura(ActionListener c) {  
		botonCrear.addActionListener(c);
		botonExaminar.addActionListener(c);
	}


	public ArrayList<Distrito> getDistritos() {
		ArrayList<Distrito> distritos = new ArrayList<Distrito>();
		
		if(distrito1.isSelected()) distritos.add(Distrito.CENTRO);
		if(distrito2.isSelected()) distritos.add(Distrito.CHAMARTIN);
		if(distrito3.isSelected()) distritos.add(Distrito.RETIRO);
		return distritos;
	}

	public String getColectivos() {
		return (String)comboColectivos.getSelectedItem();
	}
	 /**
     * Método para añadir los colectivos que representa el ciudadano actual al combo box
     * para crear el nuevo proyecto como proyecto de un colectivo
     * 
     *@param list Lista de colectivos que representa el ciudadano
     * 
     */
	public static void addColectivos(List<Colectivo> list) {
		comboColectivos.removeAllItems();
		comboColectivos.addItem("No");
		for(Colectivo c : list) {
			comboColectivos.addItem(c.getTitulo());
		}
	}
	 /**
     * Metodo para limpiar los distintos campos de creación de proyecto de infraestructura
     * 
     */
	public void limpiar() {
		distrito1.setSelected(false);
		comboColectivos.setSelectedIndex(0);
	}
	
}
