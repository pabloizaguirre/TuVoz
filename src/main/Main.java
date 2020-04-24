package main;

import modelo.*;
import vista.*;
import controlador.*;

public class Main {
	public static void main(String[] args) {
		Ventana frame = new Ventana();
		Controlador controlador = new Controlador(frame);
		frame.setControlador(controlador);
		frame.setVisible(true);
	}
}
