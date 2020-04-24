package controlador;

import modelo.*;
import vista.*;

public class Controlador {
	
	private ControlIrACrearColectivo contIrACrearColectivo;
	private Ventana frame;
	public Controlador(Ventana frame) {
		this.frame = frame;
		this.contIrACrearColectivo = new ControlIrACrearColectivo(frame);
	}

	public ControlIrACrearColectivo getControlIrACrearColectivo() {
		return this.contIrACrearColectivo;
	}

}
