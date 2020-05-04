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
public class NotificacionProyectoNuevo extends Notificacion {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Proyecto proyecto;

    public NotificacionProyectoNuevo(Proyecto p, Usuario usuario) {
        super("El proyecto " + p.getTitulo() + " esta pendiente de aprobacion",usuario);
        proyecto = p;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

}