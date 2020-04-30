package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.Aplicacion;
import modelo.Ciudadano;
import modelo.Colectivo;
import modelo.Proyecto;

public class DetalleColectivo extends JPanel {
	
	private Colectivo col;
	private JLabel titulo = new JLabel("");
	private JButton botonUnirme;
	JPanel panelBotonUnirme;
	
	public DetalleColectivo(Colectivo colectivo) {
		SpringLayout cLayout = new SpringLayout();
		col = colectivo;
		
		this.titulo.setText(colectivo.getTitulo());
		
		titulo.setFont(new Font(titulo.getFont().getName(), Font.PLAIN, titulo.getFont().getSize()+20));
		
		
		panelBotonUnirme = new JPanel();
		
		cLayout.putConstraint(SpringLayout.WEST, titulo, 20, SpringLayout.WEST, this);
		cLayout.putConstraint(SpringLayout.NORTH, titulo, 20, SpringLayout.NORTH, this);

		cLayout.putConstraint(SpringLayout.WEST, panelBotonUnirme, 20, SpringLayout.EAST, titulo);

		add(titulo);
		add(panelBotonUnirme);
		
		//Panel con los proyectos
		final JPanel proyectos = new JPanel();
		BorderLayout proyectosLayout = new BorderLayout();
		proyectos.setLayout(proyectosLayout);
		JLabel labelProyectos = new JLabel("  Proyectos del colectivo: ");
		labelProyectos.setFont(new Font(labelProyectos.getFont().getName(), Font.PLAIN, labelProyectos.getFont().getSize()+5));
		
		JPanel listaProyectos = new JPanel();
		listaProyectos.setLayout(new FlowLayout(FlowLayout.LEFT));
	
		
		
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
		
		
		
		//panel con  subcolectivos:
		final JPanel colectivos = new JPanel();
		BorderLayout colectivosLayout = new BorderLayout();
		colectivos.setLayout(colectivosLayout);
		JLabel labelColectivos = new JLabel("  Subcolectivos: ");
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
			boton = new JButton(s); 
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
	
	public void setTitulo(String titulo) {
		this.titulo.setText(titulo);
	}
	
	
	
	public void setUnirme(Ciudadano ciudadano) {
		boolean esMiembro = getColectivo().esMiembro(ciudadano);

		if(esMiembro) {
			botonUnirme = new JButton("Ya eres miembro");
			botonUnirme.setEnabled(false);
		} else {
			botonUnirme= new JButton("Unirme");
		}
		botonUnirme.setActionCommand("unirme");
		panelBotonUnirme.add(botonUnirme);
	}
	
	public Colectivo getColectivo() {
		return this.col;
	}
	public void setControlador(ActionListener c) {
		if(botonUnirme!=null) {
			botonUnirme.addActionListener(c);
		}
		
	}
}

