package main;

import modelo.*;
import vista.*;

import javax.swing.UIManager;

import controlador.*;

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
