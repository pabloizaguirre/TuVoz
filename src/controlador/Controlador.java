package controlador;

import java.util.List;

import controlador.colectivo.crear.ControlCrearColectivo;
import controlador.interfaz.ControlBarraSuperior;
import controlador.interfaz.ControlHome;
import controlador.interfaz.ControlInicio;
import controlador.miperfil.ControlMiPerfil;
import controlador.miperfil.ControlMiPerfilAdmin;
import controlador.notificacion.ControlNotificaciones;
import controlador.proyecto.ControlApoyoMinimoProyecto;
import controlador.proyecto.ControlIrAProyecto;
import controlador.proyecto.crear.ControlCrearProyecto;
import controlador.proyecto.crear.ControlCrearProyectoInfraestructura;
import controlador.proyecto.crear.ControlCrearProyectoSocial;
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
	private ControlApoyoMinimoProyecto contrApoyoMinimoProyecto;
	private ControlNotificaciones contrNoti;
	private ControlMiPerfil contrMiPerfil;
	private ControlMiPerfilAdmin contrMiPerfilAdmin;

	private List<ControlIrAProyecto> contrIrAProyectos;
	
	private Ventana frame;
	
	public Controlador(Ventana frame) {
		this.frame = frame;
		this.contrCrearColectivo = new ControlCrearColectivo(frame, this);
		this.contrCrearProyecto = new ControlCrearProyecto(frame);
		this.contrCrearProyectoSocial = new ControlCrearProyectoSocial(frame, this);
		this.contrCrearProyectoInfraestructura = new ControlCrearProyectoInfraestructura(frame, this);
		this.contrBarraSuperior= new ControlBarraSuperior(frame, this);
		this.contrInicio = new ControlInicio(frame, this);
		this.contrApoyoMinimoProyecto = new ControlApoyoMinimoProyecto(frame);
		this.contrNoti = new ControlNotificaciones(frame);
		this.contrHome = new ControlHome(frame);
		this.contrMiPerfilAdmin = new ControlMiPerfilAdmin(frame);
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
	public ControlMiPerfilAdmin getControlMiPerfilAdmin() {
		return this.contrMiPerfilAdmin;
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
	public ControlApoyoMinimoProyecto getControlApoyoMinimoProyecto() {
		return this.contrApoyoMinimoProyecto;
	}
	public ControlNotificaciones getControlNotificaciones() {
		return this.contrNoti;
	}

}
