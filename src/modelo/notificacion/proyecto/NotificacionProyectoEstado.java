package modelo.notificacion.proyecto;
import java.util.*;

import modelo.notificacion.Notificacion;
import modelo.proyecto.Proyecto;
import modelo.usuario.Usuario;

import java.io.*;

/**
 * Clase notificación de cambio de estado de proyecto.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class NotificacionProyectoEstado extends Notificacion {
    
	private static final long serialVersionUID = 1L;
	private Proyecto proyecto;
	
	public NotificacionProyectoEstado(Proyecto p, Usuario usuario, String mensaje) {
		super("El proyecto " + p.getTitulo() + " ha sido rechazado debido a: " + mensaje, usuario);
		proyecto = p;
	}

    public NotificacionProyectoEstado(Proyecto p, Usuario usuario) {
        super("El proyecto " + p.getTitulo() + " ha cambiado a estado: " + p.consultarEstadoProyecto().toString(),usuario);
        proyecto = p;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

}