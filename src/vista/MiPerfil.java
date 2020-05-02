package vista;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

public class MiPerfil extends JPanel{
	
	private JButton cerrarSesion;
	
	
	public MiPerfil() {
		SpringLayout cLayout = new SpringLayout();
		setLayout(cLayout);
		
		//Titulo de la ventana: HOME
		JLabel titulo = new JLabel("Mi Perfil");
		titulo.setFont(new Font(titulo.getFont().getName(), Font.PLAIN, titulo.getFont().getSize()+20));
		cLayout.putConstraint(BorderLayout.WEST, titulo, 20, BorderLayout.WEST, this);
		add(titulo);
		
		cerrarSesion = new JButton("Cerrar sesion");
		cLayout.putConstraint(BorderLayout.EAST, cerrarSesion, -40, BorderLayout.EAST, this);
		cerrarSesion.setActionCommand("cerrarSesion");
		add(cerrarSesion);
				
		//panel con los proyectos
		final JPanel proyectos = new JPanel();
		BorderLayout proyectosLayout = new BorderLayout();
		proyectos.setLayout(proyectosLayout);
		JLabel labelProyectos = new JLabel("  Mis proyectos propuestos: ");
		labelProyectos.setFont(new Font(labelProyectos.getFont().getName(), Font.PLAIN, labelProyectos.getFont().getSize()+5));

		final JPanel listaProyectos = new JPanel();
		listaProyectos.setLayout(new FlowLayout(FlowLayout.LEFT));

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
		JLabel labelColectivos = new JLabel("  Mis colectivos: ");
		labelColectivos.setFont(new Font(labelColectivos.getFont().getName(), Font.PLAIN, labelColectivos.getFont().getSize()+5));

		final JPanel listaColectivos = new JPanel();
		listaColectivos.setLayout(new FlowLayout(FlowLayout.LEFT));

		JScrollPane scrollC = new JScrollPane(listaColectivos);
		scrollC.setPreferredSize(new Dimension(700, 150));
		scrollC.setBorder(null);
		
		int j = 0;
		while (j < 5) {
			String s = "Colectivo " + j;
			j++;
			JButton boton = new JButton(s); 
			boton.setPreferredSize(new Dimension(120, 120));
			
			listaColectivos.add(boton); 
		}
		listaColectivos.setVisible(true); 
		
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
	
	public void setControlador(ActionListener c) {
		cerrarSesion.addActionListener(c);
	}
}
