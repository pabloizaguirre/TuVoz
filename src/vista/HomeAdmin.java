package vista;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

public class HomeAdmin extends JPanel{
	
	private JButton botonApoyoProyecto;
	
	public HomeAdmin() {
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
		
		final JPanel listaProyectos = new JPanel();
		listaProyectos.setLayout(new FlowLayout(FlowLayout.LEFT));
		ImageIcon icon1 = Ventana.createImageIcon("src/icons/anadir120_fino.png", "IconoAnadir");

		JScrollPane scroll = new JScrollPane(listaProyectos);
		scroll.setPreferredSize(new Dimension(700, 150));
		scroll.setBorder(null);
		
		int i = 0;
		while (i < 15) {
			String s = "Proyecto " + i;
			i++;
			JButton boton = new JButton(s); 
			boton.setPreferredSize(new Dimension(120, 120));
			
			listaProyectos.add(boton); 
		}
		listaProyectos.setVisible(true); 
		
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
		cLayout.putConstraint(BorderLayout.NORTH,botonApoyoProyecto, 10, BorderLayout.SOUTH, proyectos);

		
		// a�adir componentes al contenedor
		add(botonApoyoProyecto);
		add(proyectos);
		
		
		
		//panel con mis colectivos:
		final JPanel ciudadanos = new JPanel();
		BorderLayout ciudadanosLayout = new BorderLayout();
		ciudadanos.setLayout(ciudadanosLayout);
		JLabel labelCiudadanos = new JLabel("  Ciudadanos pendientes de registro: ");
		labelCiudadanos.setFont(new Font(labelCiudadanos.getFont().getName(), Font.PLAIN, labelCiudadanos.getFont().getSize()+5));
		
		final JPanel listaCiudadanos = new JPanel();
		listaCiudadanos.setLayout(new FlowLayout(FlowLayout.LEFT));

		JScrollPane scrollC = new JScrollPane(listaCiudadanos);
		scrollC.setPreferredSize(new Dimension(700, 150));
		scrollC.setBorder(null);
	
		
		int j = 0;
		while (j < 5) {
			String s = "Ciudadano " + j;
			j++;
			JButton boton = new JButton(s); 
			boton.setPreferredSize(new Dimension(120, 120));
			
			listaCiudadanos.add(boton); 
		}
		listaCiudadanos.setVisible(true); 
		
		ciudadanos.add(labelCiudadanos, BorderLayout.WEST);
		ciudadanos.add(scrollC, BorderLayout.SOUTH);
		ciudadanos.setPreferredSize(new Dimension(700,200)); 
		
		//añadir constraints del contenedor
		cLayout.putConstraint(BorderLayout.NORTH, ciudadanos, 40, BorderLayout.SOUTH, proyectos);
		cLayout.putConstraint(BorderLayout.WEST, ciudadanos, 40, BorderLayout.WEST, this);
		cLayout.putConstraint(BorderLayout.EAST, ciudadanos, -40, BorderLayout.EAST, this);
		
		// a�adir componentes al contenedor
		add(ciudadanos);	
	}
	
	public void setControlHomeAdmin(ActionListener c) {  
		botonApoyoProyecto.addActionListener(c);
	}
	
}