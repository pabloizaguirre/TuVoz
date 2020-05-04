package main;

import modelo.*;
import modelo.aplicacion.Aplicacion;
import vista.*;

import javax.swing.UIManager;

import controlador.*;

/**
 * Clase del main.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e){
		}
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (Exception e){
		}
		Aplicacion.cargarAplicacion();
		Ventana frame = new Ventana();
		Controlador controlador = new Controlador(frame);
		frame.setControlador(controlador);
		frame.setVisible(true);
	}
}
