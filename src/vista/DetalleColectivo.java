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
import modelo.Usuario;
/**
 * Clase de la vista DetalleColectivo.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class DetalleColectivo extends JPanel {
	
	
	private JLabel titulo = new JLabel("");
	private JButton botonUnirme;
	JPanel panelBotonUnirme;
	
	public DetalleColectivo() {
		SpringLayout cLayout = new SpringLayout();
		
		
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

}

