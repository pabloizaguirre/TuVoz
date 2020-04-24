package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CrearColectivo {
	
	public static void main (String args[]) {
	JFrame ventana = new JFrame("Crear colectivo");
	
	Container contenedor = ventana.getContentPane();
	SpringLayout cLayout = new SpringLayout();
	contenedor.setLayout(cLayout);
	
	
	
	JLabel labelNombre = new JLabel("  Introducir nombre del colectivo: ");
	JTextField jtfNombre = new JTextField(20);
	
	JPanel crearColectivo = new JPanel(new GridLayout(1,2,0,10));
	
	crearColectivo.add(labelNombre);
	crearColectivo.add(jtfNombre);
	
	
	JButton botonCrear = new JButton("Crear");
	JPanel panelBoton = new JPanel();
	panelBoton.add(botonCrear,BorderLayout.SOUTH);
	
	
	JPanel panelPrincipal = new JPanel(new GridLayout(3,1,0,10));
	
	panelPrincipal.add(new BarraSuperior());
	panelPrincipal.add(crearColectivo);
	panelPrincipal.add(panelBoton);
	
	contenedor.add(panelPrincipal);
	
	
	
	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	ventana.setSize(1920,1080);
	ventana.setVisible(true);
	
	}
}
