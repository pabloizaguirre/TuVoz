package controlador;

import java.util.List;

import modelo.*;
import vista.*;

public class Controlador {
	
	private ControlIrACrearColectivo contIrACrearColectivo;
	private ControlCrearColectivo contrCrearColectivo;
	private ControlIrAMiPerfil contIrAMiPerfil;
	private ControlIrACrearProyecto contrIrACrearProyecto;
	private ControlCrearProyecto contrCrearProyecto;
	private ControlCrearProyectoSocial contrCrearProyectoSocial;
	private ControlCrearProyectoInfraestructura contrCrearProyectoInfraestructura;
	private ControlIrAHome contrIrAHome;
	private ControlExaminar contrExaminar;
	private ControlIniciarSesion contrIniciarSesion;
	private ControlRegistrar contrRegistrar;
	private ControlApoyar contrApoyar;
	private ControlHome contrHome;

	private List<ControlIrAProyecto> contrIrAProyectos;
	
	private Ventana frame;
	
	public Controlador(Ventana frame) {
		this.frame = frame;
		this.contIrACrearColectivo = new ControlIrACrearColectivo(frame);
		this.contrCrearColectivo = new ControlCrearColectivo(frame);
		this.contrIrACrearProyecto = new ControlIrACrearProyecto(frame);
		this.contrCrearProyecto = new ControlCrearProyecto(frame);
		this.contrCrearProyectoSocial = new ControlCrearProyectoSocial(frame);
		this.contrCrearProyectoInfraestructura = new ControlCrearProyectoInfraestructura(frame);
		this.contIrAMiPerfil = new ControlIrAMiPerfil(frame);
		this.contrIrAHome = new ControlIrAHome(frame);
		this.contrExaminar = new ControlExaminar(frame);
		this.contrIniciarSesion = new ControlIniciarSesion(frame);
		this.contrRegistrar = new ControlRegistrar(frame);
		this.contrApoyar = new ControlApoyar(frame, null);
		
		// Establecer Home:
		this.contrHome = new ControlHome(frame);
	}
	
	public ControlApoyar getControlApoyar() {
		return this.contrApoyar;
	}

	public ControlIrACrearColectivo getControlIrACrearColectivo() {
		return this.contIrACrearColectivo;
	}
	public ControlCrearColectivo getControlCrearColectivo() {
		return this.contrCrearColectivo;
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
	public ControlIniciarSesion getControlIniciarSesion() {
		return this.contrIniciarSesion;
	}
	public ControlRegistrar getControlRegistrar() {
		return this.contrRegistrar;
	}
	public ControlHome getControlHome() {
		return this.contrHome;
	}

}
