package modelo;
import java.util.*;
import java.io.*;

/**
 * Clase notificación de cambio de estado de proyecto.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class NotificacionProyectoEstado extends Notificacion {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Proyecto proyecto;

    public NotificacionProyectoEstado(Proyecto p, Usuario usuario) {
        super("El proyecto " + p.getTitulo() + " ha cambiado a estado: " + p.getEstado().toString(),usuario);
        proyecto = p;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

}