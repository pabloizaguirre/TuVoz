package controlador;

import modelo.*;
import vista.*;

public class Controlador {
	
	private ControlIrACrearColectivo contIrACrearColectivo;
	private ControlIrAMiPerfil contIrAMiPerfil;
	private Ventana frame;
	
	public Controlador(Ventana frame) {
		this.frame = frame;
		this.contIrACrearColectivo = new ControlIrACrearColectivo(frame);
		this.contIrAMiPerfil = new ControlIrAMiPerfil(frame);
	}

	public ControlIrACrearColectivo getControlIrACrearColectivo() {
		return this.contIrACrearColectivo;
	}
	
	public ControlIrAMiPerfil getControlIrAMiPerfil() {
		return this.contIrAMiPerfil;
	}

}
