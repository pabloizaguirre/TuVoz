package controlador;

import modelo.*;
import vista.*;

public class Controlador {
	
	private ControlIrACrearColectivo contIrACrearColectivo;
	private ControlIrAMiPerfil contIrAMiPerfil;
	private ControlIrACrearProyecto contrIrACrearProyecto;
	private ControlIrACrearProyectoSocial contrIrACrearProyectoSocial;
	private ControlIrACrearProyectoInfraestructura contrIrACrearProyectoInfraestructura;
	private ControlIrAHome contrIrAHome;

	
	private Ventana frame;
	
	public Controlador(Ventana frame) {
		this.frame = frame;
		this.contIrACrearColectivo = new ControlIrACrearColectivo(frame);
		this.contrIrACrearProyecto = new ControlIrACrearProyecto(frame);
		this.contrIrACrearProyectoSocial = new ControlIrACrearProyectoSocial(frame);
		this.contrIrACrearProyectoInfraestructura = new ControlIrACrearProyectoInfraestructura(frame);
		this.contIrAMiPerfil = new ControlIrAMiPerfil(frame);
		this.contrIrAHome = new ControlIrAHome(frame);
	}

	public ControlIrACrearColectivo getControlIrACrearColectivo() {
		return this.contIrACrearColectivo;
	}
	
	public ControlIrAMiPerfil getControlIrAMiPerfil() {
		return this.contIrAMiPerfil;
	}
	
	public ControlIrAHome getControlIrAHome() {
		return this.contrIrAHome;
	}
	
	public ControlIrACrearProyecto getControlIrACrearProyecto() {
		return this.contrIrACrearProyecto;
	} 
	
	public ControlIrACrearProyectoSocial getControlIrACrearProyectoSocial() {
		return this.contrIrACrearProyectoSocial;
	}
	
	public ControlIrACrearProyectoInfraestructura getControlIrACrearProyectoInfraestructura() {
		return this.contrIrACrearProyectoInfraestructura;
	}

}
