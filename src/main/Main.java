package main;



public class Main {
	public static void main(String[] args) {
		Ventana frame = new Ventana();
		Proyecto modelo = new Proyecto();
		Controlador controlador = new Controlador(frame, modelo);
		frame.setControlador(controlador);
		frame.setVisible(true);
	}
}
