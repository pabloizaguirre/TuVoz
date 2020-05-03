package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Clase de la vista DetalleColectivo.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class DetalleColectivo extends JPanel {
	
	
	private JLabel titulo = new JLabel("");
	
	JPanel panelBotonUnirme;
	private JButton botonUnirme;
	
	private JPanel listaProyectos;
	private JPanel listaColectivos;
	
	private JLabel proyectosVacio;
	private JLabel colectivosVacio;
	
	public DetalleColectivo() {
		SpringLayout cLayout = new SpringLayout();
		this.setLayout(cLayout);
		
		titulo.setFont(new Font(titulo.getFont().getName(), Font.PLAIN, titulo.getFont().getSize()+20));
		
		cLayout.putConstraint(SpringLayout.WEST, titulo, 20, SpringLayout.WEST, this);
		add(titulo);

		panelBotonUnirme = new JPanel();
		cLayout.putConstraint(BorderLayout.NORTH, panelBotonUnirme, 5, BorderLayout.SOUTH, titulo);
		cLayout.putConstraint(BorderLayout.WEST, panelBotonUnirme, 20, BorderLayout.WEST, this);
		add(panelBotonUnirme);
		
		//Panel con los proyectos
		final JPanel proyectos = new JPanel();
		BorderLayout proyectosLayout = new BorderLayout();
		proyectos.setLayout(proyectosLayout);
		JLabel labelProyectos = new JLabel("  Proyectos del colectivo: ");
		labelProyectos.setFont(new Font(labelProyectos.getFont().getName(), Font.PLAIN, labelProyectos.getFont().getSize()+5));
		
		listaProyectos = new JPanel();
		listaProyectos.setLayout(new FlowLayout(FlowLayout.LEFT));
	
		JScrollPane scroll = new JScrollPane(listaProyectos);
		scroll.setPreferredSize(new Dimension(700, 150));
		scroll.setBorder(null);
		
		proyectos.add(labelProyectos, BorderLayout.WEST);
		proyectos.add(scroll, BorderLayout.SOUTH);
		proyectos.setPreferredSize(new Dimension(700,200)); 
		
		//añadir constraints del contenedor
		cLayout.putConstraint(BorderLayout.NORTH, proyectos, 0, BorderLayout.SOUTH, panelBotonUnirme);
		cLayout.putConstraint(BorderLayout.WEST, proyectos, 40, BorderLayout.WEST, this);
		cLayout.putConstraint(BorderLayout.EAST, proyectos, -40, BorderLayout.EAST, this);
		
		// a�adir componentes al contenedor
		add(proyectos);
		
		//panel con  subcolectivos:
		final JPanel colectivos = new JPanel();
		BorderLayout colectivosLayout = new BorderLayout();
		colectivos.setLayout(colectivosLayout);
		JLabel labelColectivos = new JLabel("  Subcolectivos: ");
		labelColectivos.setFont(new Font(labelColectivos.getFont().getName(), Font.PLAIN, labelColectivos.getFont().getSize()+5));
		
		listaColectivos = new JPanel();
		listaColectivos.setLayout(new FlowLayout(FlowLayout.LEFT));

		JScrollPane scrollC = new JScrollPane(listaColectivos);
		scrollC.setPreferredSize(new Dimension(700, 150));
		scrollC.setBorder(null);
		
		colectivos.add(labelColectivos, BorderLayout.WEST);
		colectivos.add(scrollC, BorderLayout.SOUTH);
		colectivos.setPreferredSize(new Dimension(700,200)); 
		
		//añadir constraints del contenedor
		cLayout.putConstraint(BorderLayout.NORTH, colectivos, 20, BorderLayout.SOUTH, proyectos);
		cLayout.putConstraint(BorderLayout.WEST, colectivos, 40, BorderLayout.WEST, this);
		cLayout.putConstraint(BorderLayout.EAST, colectivos, -40, BorderLayout.EAST, this);
		
		// a�adir componentes al contenedor
		add(colectivos);
	}
	
	public void setTitulo(String titulo) {
		this.titulo.setText(titulo);
	}
	
	/**
	 * Metodo para añadir un mensaje cuando el colectivo no haya creado proyectos
	 */
	public void setProyectosVacios() {
		this.proyectosVacio = new JLabel("El colectivo " + titulo.getText() + " todavia no ha creado ningún proyecto.");
		this.proyectosVacio.setFont(new Font(proyectosVacio.getFont().getName(), Font.ITALIC, proyectosVacio.getFont().getSize()));
		this.listaProyectos.add(Box.createRigidArea(new Dimension(10,120)));
		this.listaProyectos.add(proyectosVacio);
	}
	
	/**
	 * Metodo para añadir un mensaje cuando el colectio no tenga subcolectivos
	 */
	public void setColectivosVacios() {
		this.colectivosVacio = new JLabel("El colectivo " + titulo.getText() + " todavia no tiene ningún subcolectivo.");
		this.colectivosVacio.setFont(new Font(colectivosVacio.getFont().getName(), Font.ITALIC, colectivosVacio.getFont().getSize()));
		this.listaColectivos.add(Box.createRigidArea(new Dimension(10,120)));
		this.listaColectivos.add(colectivosVacio);
	}
	
	 /**
     * Metodo para añadir un boton a la lista de botones de proyectos 
     * @param boton Boton que queremos añadir
     * 
     */
	public void addBotonProyecto(JButton boton) {
		boton.setPreferredSize(new Dimension(120, 120));
		listaProyectos.add(boton);
	}
	 /**
     * Metodo para añadir un boton a la lista de botones de subcolectivos
     * @param boton Boton que queremos añadir
     * 
     */
	public void addBotonColectivo(JButton boton) {
		boton.setPreferredSize(new Dimension(120, 120));
		listaColectivos.add(boton);
	}
	
	 /**
     * Metodo para establecer los botones de la vista segun el usuario actual
     * 
     * @param esMiembro. Booleano que indica si el usuario actual (ciudadano) pertenece a dicho colectivo
     */
	public void setUnirme(boolean esMiembro) {
		if(esMiembro) {
			botonUnirme = new JButton("Ya eres miembro");
			botonUnirme.setEnabled(false);
		} else {
			botonUnirme= new JButton("Unirme al colectivo");
		}
		botonUnirme.setActionCommand("unirme");
		panelBotonUnirme.add(botonUnirme);
	}
	
	
	public void setControlador(ActionListener c) {
		if(botonUnirme!=null) {
			botonUnirme.addActionListener(c);
		}
	}
	public JButton getBotonUnirme() {
		return botonUnirme;
	}
	 /**
     * Metodo para resetear los botones de la vista de detalle colectivo
     * 
     */
	public void resetButtonPanel() {
		panelBotonUnirme.removeAll();
		
		if(botonUnirme!=null) {
			botonUnirme.setEnabled(true);
		}
	}
	
	/**
	 * metodo para resetear toda la ventana
	 */
	public void resetAll() {
		this.listaColectivos.removeAll();
		this.listaProyectos.removeAll();
		resetButtonPanel();
	}

}

