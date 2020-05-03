package controlador;

import java.util.List;

import modelo.*;
import vista.*;


/**
 * Clase Controlador.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */


public class Controlador {
	
	private ControlCrearColectivo contrCrearColectivo;
	private ControlBarraSuperior contrBarraSuperior;
	private ControlCrearProyecto contrCrearProyecto;
	private ControlCrearProyectoSocial contrCrearProyectoSocial;
	private ControlCrearProyectoInfraestructura contrCrearProyectoInfraestructura;
	private ControlInicio contrInicio;
	private ControlHome contrHome;
	private ControlHomeAdmin contrHomeAdmin;
	private ControlApoyoMinimoProyecto contrApoyoMinimoProyecto;
	private ControlNotificaciones contrNoti;
	private ControlMiPerfil contrMiPerfil;

	private List<ControlIrAProyecto> contrIrAProyectos;
	
	private Ventana frame;
	
	public Controlador(Ventana frame) {
		this.frame = frame;
		this.contrCrearColectivo = new ControlCrearColectivo(frame, this);
		this.contrCrearProyecto = new ControlCrearProyecto(frame);
		this.contrCrearProyectoSocial = new ControlCrearProyectoSocial(frame, this);
		this.contrCrearProyectoInfraestructura = new ControlCrearProyectoInfraestructura(frame, this);
		this.contrBarraSuperior= new ControlBarraSuperior(frame);
		this.contrInicio = new ControlInicio(frame, this);
		this.contrApoyoMinimoProyecto = new ControlApoyoMinimoProyecto(frame);
		this.contrNoti = new ControlNotificaciones(frame);
		this.contrHome = new ControlHome(frame);
		this.contrHomeAdmin = new ControlHomeAdmin(frame);
		this.contrMiPerfil = new ControlMiPerfil(frame);
	}
	
	

	
	public ControlCrearColectivo getControlCrearColectivo() {
		return this.contrCrearColectivo;
	}
	
	public ControlBarraSuperior getControlBarraSuperior() {
		return this.contrBarraSuperior;
	}
	
	public ControlMiPerfil getControlMiPerfil() {
		return this.contrMiPerfil;
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
	public ControlInicio getControlInicio() {
		return this.contrInicio;
	}
	public ControlHome getControlHome() {
		return this.contrHome;
	}
	public ControlHomeAdmin getControlHomeAdmin() {
		return this.contrHomeAdmin;
	}
	public ControlApoyoMinimoProyecto getControlApoyoMinimoProyecto() {
		return this.contrApoyoMinimoProyecto;
	}
	public ControlNotificaciones getControlNotificaciones() {
		return this.contrNoti;
	}

}
