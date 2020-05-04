package vista.interfaz;

import javax.swing.*;

import vista.Ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;
/**
 * Clase de la vista Home.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class Home extends JPanel{
	
	private JButton botonAnadirProyecto;
	private JButton botonAnadirColectivo;
	private JButton botonApoyoProyecto;
	
	private JPanel listaProyectos;
	private JPanel listaColectivos;
	
	private static ImageIcon icon1 = Ventana.createImageIcon("src/icons/anadir120_fino.png", "IconoAnadir");
	
	
	public Home() {
		SpringLayout cLayout = new SpringLayout();
		setLayout(cLayout);
		
		//Titulo de la ventana: HOME
		JLabel titulo = new JLabel("Inicio");
		titulo.setFont(new Font(titulo.getFont().getName(), Font.PLAIN, titulo.getFont().getSize()+20));
		cLayout.putConstraint(BorderLayout.WEST, titulo, 20, BorderLayout.WEST, this);
		add(titulo);
		
		//Panel con los proyectos
		final JPanel proyectos = new JPanel();
		BorderLayout proyectosLayout = new BorderLayout();
		proyectos.setLayout(proyectosLayout);
		JLabel labelProyectos = new JLabel("  Proyectos: ");
		labelProyectos.setFont(new Font(labelProyectos.getFont().getName(), Font.PLAIN, labelProyectos.getFont().getSize()+5));
		
		listaProyectos = new JPanel();
		listaProyectos.setLayout(new FlowLayout(FlowLayout.LEFT));
		botonAnadirProyecto = new JButton(icon1);
		botonAnadirProyecto.setPreferredSize(new Dimension(120, 120));
		botonAnadirProyecto.setActionCommand("anadirProyecto");
		listaProyectos.add(botonAnadirProyecto);
		
		JScrollPane scroll = new JScrollPane(listaProyectos);
		scroll.setPreferredSize(new Dimension(700, 150));
		scroll.setBorder(null);
		
		proyectos.add(labelProyectos, BorderLayout.WEST);
		proyectos.add(scroll, BorderLayout.SOUTH);
		proyectos.setPreferredSize(new Dimension(700,200)); 
		
		botonApoyoProyecto = new JButton("Gestionar minimo de apoyos");
		botonApoyoProyecto.setActionCommand("apoyoProyecto");
		
		
		//añadir constraints del contenedor
		cLayout.putConstraint(BorderLayout.NORTH, proyectos, 15, BorderLayout.SOUTH, titulo);
		cLayout.putConstraint(BorderLayout.WEST, proyectos, 40, BorderLayout.WEST, this);
		cLayout.putConstraint(BorderLayout.EAST, proyectos, -40, BorderLayout.EAST, this);
		cLayout.putConstraint(BorderLayout.WEST, botonApoyoProyecto, 40, BorderLayout.WEST, this);
		cLayout.putConstraint(BorderLayout.NORTH,botonApoyoProyecto, 0, BorderLayout.SOUTH, proyectos);
		

		// a�adir componentes al contenedor
		add(proyectos);
		add(botonApoyoProyecto);
		
		//panel con mis colectivos:
		final JPanel colectivos = new JPanel();
		BorderLayout colectivosLayout = new BorderLayout();
		colectivos.setLayout(colectivosLayout);
		JLabel labelColectivos = new JLabel("  Colectivos: ");
		labelColectivos.setFont(new Font(labelColectivos.getFont().getName(), Font.PLAIN, labelColectivos.getFont().getSize()+5));
		
		listaColectivos = new JPanel();
		listaColectivos.setLayout(new FlowLayout(FlowLayout.LEFT));
		botonAnadirColectivo = new JButton(icon1);
		botonAnadirColectivo.setPreferredSize(new Dimension(120, 120));
		botonAnadirColectivo.setActionCommand("anadirColectivo");
		listaColectivos.add(botonAnadirColectivo);
		
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
     * Metodo para añadir un boton a la lista de botones de colectivo 
     * @param boton Boton que queremos añadir
     * 
     */
	public void addBotonColectivo(JButton boton) {
		boton.setPreferredSize(new Dimension(120, 120));
		listaColectivos.add(boton);
	}
	
	public void setControlador(ActionListener c) {  
		botonAnadirProyecto.addActionListener(c);
		botonAnadirColectivo.addActionListener(c);
		botonApoyoProyecto.addActionListener(c);
	}
	
	/**
	 * Desactiva los botones de añadir proyecto y colectivo.
	 */
	public void setAdminMode() {
		this.botonAnadirColectivo.setVisible(false);
		this.botonAnadirProyecto.setVisible(false);
		this.botonApoyoProyecto.setVisible(true);
	}
	
	/**
	 * Hace visibles los botones de añadir proyectos y colectivos.
	 */
	public void setCiudadanoMode() {
		this.botonAnadirColectivo.setVisible(true);
		this.botonAnadirProyecto.setVisible(true);
		this.botonApoyoProyecto.setVisible(false);

	}
	
	 /**
     * Metodo para resetear los botones de la vista Home
     * 
     */
	public void resetBotones() {
		listaProyectos.removeAll();
		botonAnadirProyecto = new JButton(icon1);
		botonAnadirProyecto.setPreferredSize(new Dimension(120, 120));
		botonAnadirProyecto.setActionCommand("anadirProyecto");
		listaProyectos.add(botonAnadirProyecto);
		
		listaColectivos.removeAll();
		botonAnadirColectivo = new JButton(icon1);
		botonAnadirColectivo.setPreferredSize(new Dimension(120, 120));
		botonAnadirColectivo.setActionCommand("anadirColectivo");
		listaColectivos.add(botonAnadirColectivo);
	}
}
