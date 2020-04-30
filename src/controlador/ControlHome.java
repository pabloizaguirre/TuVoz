package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.*;

import vista.Home;
import vista.Ventana;

public class ControlHome implements ActionListener{
	private Home vista;
	private Ventana frame;
	
	private HashMap<JButton, Proyecto> proyectos = new HashMap<JButton, Proyecto>();
	
	public ControlHome(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaHome();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(proyectos.containsKey(source)) {
			JOptionPane.showMessageDialog(vista, proyectos.get(source).getTitulo());
		}
		
		
	}
	
	public void setBotonesProyectos() {
		JButton botonProyecto;
		for(Proyecto p:Aplicacion.getAplicacion().getListadoProyectos()) {
			botonProyecto = new JButton(p.getTitulo());
			botonProyecto.addActionListener(this);
			vista.addBotonProyecto(botonProyecto);
			proyectos.put(botonProyecto, p);
		}
	}
	
	public void addBotonProyecto(Proyecto p) {
		JButton botonProyecto = new JButton(p.getTitulo());
		botonProyecto.addActionListener(this);
		vista.addBotonProyecto(botonProyecto);
		proyectos.put(botonProyecto, p);
	}

}