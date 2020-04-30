package vista;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;

public class Home extends JPanel{
	
	private JButton botonAnadirProyecto;
	private JButton botonAnadirColectivo;
	
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
		listaProyectos.add(botonAnadirProyecto);
		
		
		JScrollPane scroll = new JScrollPane(listaProyectos);
		scroll.setPreferredSize(new Dimension(700, 150));
		scroll.setBorder(null);
		
		JButton boton;
		
		proyectos.add(labelProyectos, BorderLayout.WEST);
		proyectos.add(scroll, BorderLayout.SOUTH);
		proyectos.setPreferredSize(new Dimension(700,200)); 
		
		//añadir constraints del contenedor
		cLayout.putConstraint(BorderLayout.NORTH, proyectos, 15, BorderLayout.SOUTH, titulo);
		cLayout.putConstraint(BorderLayout.WEST, proyectos, 40, BorderLayout.WEST, this);
		cLayout.putConstraint(BorderLayout.EAST, proyectos, -40, BorderLayout.EAST, this);
		
		// a�adir componentes al contenedor
		add(proyectos);
		
		
		
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
	
	public void addBotonProyecto(JButton boton) {
		boton.setPreferredSize(new Dimension(120, 120));
		listaProyectos.add(boton);
	}
	
	public void addBotonColectivo(JButton boton) {
		boton.setPreferredSize(new Dimension(120, 120));
		listaColectivos.add(boton);
	}
	
	public void setControladorAnadirProyecto(ActionListener c) {  
		botonAnadirProyecto.addActionListener(c);
	}
	
	public void setControladorAnadirColectivo(ActionListener c) {  
		botonAnadirColectivo.addActionListener(c);
	}
}
