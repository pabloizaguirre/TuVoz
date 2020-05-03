package vista;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import modelo.*;
/**
 * Clase de la vista CrearProyectoSocial.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class CrearProyectoSocial extends JPanel {
	
	private JTextField jtfGrupoSocial;
	private JRadioButton nacional;
	private JRadioButton internacional;
	private ButtonGroup grupoBotones;
	private JLabel labelColectivos;
	private static JComboBox<String> comboColectivos;
	private JButton botonCrear;
	
	public CrearProyectoSocial() {
		
		
		SpringLayout cLayout = new SpringLayout();
		setLayout(cLayout);
		
		JLabel labelNuevo = new JLabel("Nuevo proyecto social");
		
		JLabel labelGrupoSocial = new JLabel("Grupo social: ");
		jtfGrupoSocial = new JTextField(20);
		
		JLabel labelAlcance = new JLabel("Seleccione ámbito del proyecto:");
		nacional = new JRadioButton("Nacional");
		internacional = new JRadioButton("Internacional");
		grupoBotones = new ButtonGroup();
		grupoBotones.add(nacional);
		grupoBotones.add(internacional);
		
		JPanel panelProyecto = new JPanel(new GridLayout(2,2));
		panelProyecto.add(labelGrupoSocial);
		panelProyecto.add(jtfGrupoSocial);
		panelProyecto.add(labelAlcance);
		JPanel panelBotones = new JPanel();
		panelBotones.add(nacional);
		panelBotones.add(internacional);
		panelProyecto.add(panelBotones);
		
		
		JPanel panelCrear = new JPanel(new BorderLayout());
		
		panelCrear.add(labelNuevo, BorderLayout.WEST);
		panelCrear.add(panelProyecto, BorderLayout.SOUTH);
		
		
		labelColectivos = new JLabel("Selecciona para crear proyecto de colectivo");
		comboColectivos = new JComboBox<String>();
		
		comboColectivos.addItem("No");
		
		
		JPanel panelColectivos = new JPanel();
		panelColectivos.add(labelColectivos);
		panelColectivos.add(comboColectivos);
		
		JPanel panelBoton = new JPanel(new BorderLayout());
		botonCrear = new JButton("Crear");
		panelBoton.add(botonCrear, BorderLayout.SOUTH);
		
		cLayout.putConstraint(SpringLayout.WEST, panelCrear, 40, SpringLayout.WEST, this);
		cLayout.putConstraint(SpringLayout.NORTH, panelCrear, 40, SpringLayout.NORTH, this);
		cLayout.putConstraint(SpringLayout.NORTH, panelColectivos, 10, SpringLayout.SOUTH, panelCrear);
		cLayout.putConstraint(SpringLayout.WEST, panelColectivos, 37, SpringLayout.WEST, this);
		cLayout.putConstraint(SpringLayout.WEST, panelBoton, 40, SpringLayout.WEST, this);
		cLayout.putConstraint(SpringLayout.NORTH, panelBoton, 10, SpringLayout.SOUTH, panelColectivos);
		
		add(panelCrear);
		add(panelColectivos);
		add(panelBoton);
		
		
		
	}
	
	public void setControladorCrearProyectoSocial(ActionListener c) {  
		botonCrear.addActionListener(c);
	}

	public String getGrupoSocial() {
		return jtfGrupoSocial.getText();
	}
	public String getTipoAlcance() {
		if(nacional.isSelected()) {
			return "nacional";
		}
		else if(internacional.isSelected()) {
			return "internacinal";
		}
		else {
			return "";
		}
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
     * Metodo para limpiar los distintos campos de creación de proyecto social
     * 
     */
	public void limpiarJtf() {
		jtfGrupoSocial.setText("");
		comboColectivos.setSelectedIndex(0);
		grupoBotones.clearSelection();
		
	}
	
}
