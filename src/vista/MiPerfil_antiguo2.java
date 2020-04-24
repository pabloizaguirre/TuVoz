package vista;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.File;


public class MiPerfil_antiguo2 {
	protected static ImageIcon createImageIcon(String path, String description) {
		if (new File(path).exists()) {
			return new ImageIcon(path, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		} 
	}

	public static void main(String[] args) {
		JFrame ventana = new JFrame("Mi GUI. Ejemplo 2");
		// obtener contenedor, asignar layout
		Container contenedor = ventana.getContentPane();
		SpringLayout cLayout = new SpringLayout();
		contenedor.setLayout(cLayout);
		
		// crear pantalla 1
		
		final JPanel proyectos = new JPanel();
		BorderLayout proyectosLayout = new BorderLayout();
		proyectos.setLayout(proyectosLayout);
		JLabel labelProyectos = new JLabel("  Mis proyectos propuestos: ");
		
		final JPanel listaProyectos = new JPanel();
		listaProyectos.setLayout(new FlowLayout(FlowLayout.LEFT));
		ImageIcon icon1 = createImageIcon("src/icons/anadir120_fino.png", "IconoAnadir");

		JScrollPane scroll = new JScrollPane(listaProyectos);
		scroll.setPreferredSize(new Dimension(700, 150));
		scroll.setBorder(null);
		
		JButton botonAnadir = new JButton(icon1);
		botonAnadir.setPreferredSize(new Dimension(120, 120));
		
		listaProyectos.add(botonAnadir);
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
		cLayout.putConstraint(BorderLayout.WEST, proyectos, 40, BorderLayout.WEST, contenedor);
		cLayout.putConstraint(BorderLayout.EAST, proyectos, -40, BorderLayout.EAST, contenedor);
		
		// a�adir componentes al contenedor
		contenedor.add(proyectos);
		
		
		
		//panel con mis colectivos:
		final JPanel colectivos = new JPanel();
		BorderLayout colectivosLayout = new BorderLayout();
		colectivos.setLayout(colectivosLayout);
		JLabel labelColectivos = new JLabel("  Mis colectivos: ");
		
		final JPanel listaColectivos = new JPanel();
		listaColectivos.setLayout(new FlowLayout(FlowLayout.LEFT));

		JScrollPane scrollC = new JScrollPane(listaColectivos);
		scrollC.setPreferredSize(new Dimension(700, 150));
		scrollC.setBorder(null);
		
		JButton botonAnadirColectivos = new JButton(icon1);
		botonAnadirColectivos.setPreferredSize(new Dimension(120, 120));
		
		listaColectivos.add(botonAnadirColectivos);
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
		cLayout.putConstraint(BorderLayout.WEST, colectivos, 40, BorderLayout.WEST, contenedor);
		cLayout.putConstraint(BorderLayout.EAST, colectivos, -40, BorderLayout.EAST, contenedor);
		
		// a�adir componentes al contenedor
		contenedor.add(colectivos);
		
		
		
		ventana.pack();
		
		// mostrar ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(1000,600);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);	
	}

}
