package controlador;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import modelo.*;
import vista.*;

public class ControlExaminar implements ActionListener {
	
	private CrearProyectoInfraestructura vista;
    private Ventana frame;
    private ImageIcon imagen;
	
	
	public ControlExaminar(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getVistaCrearProyectoInfraestructura();
	}
	
	/**
	 * Cambia la vista a CrearProyectoSocial
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
        JFileChooser explorador = new JFileChooser();
        int seleccion = explorador.showOpenDialog(null);
        if(seleccion==JFileChooser.APPROVE_OPTION) {
        	File archivo = explorador.getSelectedFile();
        	String ruta = archivo.getAbsolutePath();
        	ControlCrearProyectoInfraestructura.setImagen(Ventana.createImageIcon(ruta, "Imagen del archivo"));
        }
	}
}
