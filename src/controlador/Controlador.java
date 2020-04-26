package controlador;

import modelo.*;
import vista.*;

public class Controlador {
	
	private ControlIrACrearColectivo contIrACrearColectivo;
	private ControlIrAMiPerfil contIrAMiPerfil;
	private ControlIrACrearProyecto contrIrACrearProyecto;
	private ControlCrearProyecto contrCrearProyecto;
	private ControlCrearProyectoSocial contrCrearProyectoSocial;
	private ControlCrearProyectoInfraestructura contrCrearProyectoInfraestructura;
	private ControlIrAHome contrIrAHome;
	private ControlExaminar contrExaminar;

	
	private Ventana frame;
	
	public Controlador(Ventana frame) {
		this.frame = frame;
		this.contIrACrearColectivo = new ControlIrACrearColectivo(frame);
		this.contrIrACrearProyecto = new ControlIrACrearProyecto(frame);
		this.contrCrearProyecto = new ControlCrearProyecto(frame);
		this.contrCrearProyectoSocial = new ControlCrearProyectoSocial(frame);
		this.contrCrearProyectoInfraestructura = new ControlCrearProyectoInfraestructura(frame);
		this.contIrAMiPerfil = new ControlIrAMiPerfil(frame);
		this.contrIrAHome = new ControlIrAHome(frame);
		this.contrExaminar = new ControlExaminar(frame);
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
	
	public ControlCrearProyecto getControlCrearProyecto() {
		return this.contrCrearProyecto;
	}
	public ControlCrearProyectoSocial getControlCrearProyectoSocial() {
		return this.contrCrearProyectoSocial;
	}
	public ControlCrearProyectoInfraestructura getControlCrearProyectoInfraestructura() {
		return this.contrCrearProyectoInfraestructura;
	}
	public ControlExaminar getControlExaminar() {
		return this.contrExaminar;
	}

}
